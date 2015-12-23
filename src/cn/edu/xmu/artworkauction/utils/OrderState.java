package cn.edu.xmu.artworkauction.utils;

/**OrderState for Order.state to mark the order state
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1223_1.0.0
 *
 */

public interface OrderState {
	//订单未被审查
	public static final Integer unChecked=0;
	//订单审查通过
	public static final Integer approved=1;
	//订单审查不通过
	public static final Integer disApproved=2;
}
