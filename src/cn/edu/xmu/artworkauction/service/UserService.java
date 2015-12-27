/**
 * 
 */
package cn.edu.xmu.artworkauction.service;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Address;
/**
 * @author Yu
 *
 */

public interface UserService {
	//对用户信息进行更新
	public User updateUserInfo(User user,String email,String userName,String phoneNumber,String imageURL);
	public User updateUserAddress(User user,Address address);
}
