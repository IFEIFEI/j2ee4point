/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artist;

/**
 * @author XiaWenSheng
 *
 */
public interface UserDAO {
	
	public User userRegister(String email,String userName,String phoneNumber,String password);
	public User userUpdate(User user,String email,String userName,String phoneNumber,String ImgaeURL);
	public User userUpdateAddress(User user,Address address);
	public boolean checkUserNameUnique(String userName);
	public boolean checkEmailUnique(String email);
	public User findUserByUserNameAndPassword(String userName,String password);
	public User findUserByEmailAndPassword(String email,String password);
	
	public void saveUser(User user);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	
	public void saveAddress(Address address);
	public void addAddress(Address address);
	public void deleteAddress(Address address);
	public void updateAddress(Address address);
	
	public User getUserById(Integer userId);
	
}