package cn.edu.xmu.artworkauction.dao;

import java.util.List;

import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;


/**OrderDAO deal with all the things about order
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1223_1.0.0
 *
 */

public interface OrderDAO 
{
	public List<Order> getAllOrder();
	public void addOrder(Order order);
	public void saveOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
	public Order getOrderById(Integer id);
	public List<Order> getAllUncheckedOrder();
	public List<Order> findAllOrderByUser(User user);
}

