/**
 * 
 */
package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.OrderDAO;
import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.OrderService;

/**
 * @author Y
 *
 */
@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
    private SessionFactory sessionFactory;
    
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private OrderDAO orderDAO;
	private UserDAO userDAO;

	@Resource(name="orderDAO")
	public void setOrderDAO(OrderDAO orderDAO){
		this.orderDAO=orderDAO;
	}
	
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
    //查询用户的所有订单
	@Override
	public List<Order> findAllOrderByUser(User user) {
		// TODO Auto-generated method stub
		List<Order> list=orderDAO.findAllOrderByUser(userDAO.getUserById(user.getId()));
		System.out.println(list.get(0).getOrderLineItems().get(0).toString());
		return list;
	}
}