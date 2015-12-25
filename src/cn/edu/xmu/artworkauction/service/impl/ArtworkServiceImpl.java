package cn.edu.xmu.artworkauction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.ArtworkDAO;
import cn.edu.xmu.artworkauction.dao.OrderDAO;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.OrderLineItem;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.ArtworkService;
import cn.edu.xmu.artworkauction.utils.OrderState;

/** ArtworkServiceImpl deal with all the things about order
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1215_1.0.0
 *
 */

@Transactional
@Service
public class ArtworkServiceImpl implements ArtworkService
{
	private ArtworkDAO artworkDAO;
	private OrderDAO orderDAO;
	
	@Resource(name="artworkDAO")
	public void setArtworkDAO(ArtworkDAO artworkDAO) 
	{
		this.artworkDAO = artworkDAO;
	}
	
	@Resource(name="orderDAO")
	public void setOrderDAO(OrderDAO orderDAO) 
	{
		this.orderDAO = orderDAO;
	}
	
	@Override
	public List<Artwork> getAllArtwork()
	{
		return artworkDAO.getAllArtwork();
	}

	@Override
	public Artwork getSingelArtwork(Integer id) 
	{
		return artworkDAO.getArtworkById(id);
	}

	@Override
	public void addNewOrder(HashMap<String, Integer> shopList,User user) 
	{
		Order newOrder=new Order();
		newOrder.setOrderDate(new Date());
		newOrder.setUser(user);
		newOrder.setState(OrderState.unChecked);
		String dString=UUID.randomUUID().toString().replace("-","");
		newOrder.setOrderLineNum(dString);
		List<OrderLineItem> orderLineItems=new ArrayList<>();
		Iterator iter = shopList.entrySet().iterator();
		while (iter.hasNext()) 
		{
			Map.Entry entry = (Map.Entry) iter.next();
			String key = (String) entry.getKey();
			Integer val =(Integer) entry.getValue();
			OrderLineItem newOrderLineItem=new OrderLineItem();
			newOrderLineItem.setArtwork(artworkDAO.getArtworkById(Integer.parseInt(key)));
			newOrderLineItem.setNumber(val);
			orderLineItems.add(newOrderLineItem);
		}
		newOrder.setOrderLineItems(orderLineItems);
		orderDAO.saveOrder(newOrder);
	}

}
