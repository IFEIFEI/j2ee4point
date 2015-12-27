/**
 * 
 */
package cn.edu.xmu.artworkauction.service;

import java.util.List;

import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author Yu
 *
 */

public interface OrderService {
	public List<Order> findAllOrderByUser(User user);
}
