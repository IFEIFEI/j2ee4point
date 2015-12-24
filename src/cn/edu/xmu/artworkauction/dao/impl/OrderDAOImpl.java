package cn.edu.xmu.artworkauction.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.OrderDAO;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;

/**OrderDAOImpl deal with all the things about order
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1223_1.0.0
 *
 */

@Repository("orderDAO")
public class OrderDAOImpl implements OrderDAO
{
private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Order> getAllOrder() {
		return (List<Order>)sessionFactory.getCurrentSession()
			.getNamedQuery("@HQL_GetAllOrder")
			.list();
	}

	@Override
	public void addOrder(Order order) {
		sessionFactory.getCurrentSession()
		.save(order);
	}

	@Override
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession()
		.saveOrUpdate(order);
	}

	@Override
	public void updateOrder(Order order) {
		sessionFactory.getCurrentSession()
		.update(order);
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//查询所有的订单
	@Override
	public List<Order> findAllOrderByUser(User user) {
	    // TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@HQL_getOrderByUser");
		query.setLong(0, user.getId());
		List<Order> orderList=(List<Order>)query.uniqueResult();
		return orderList;
	}
}
