/**
 * 
 */
package cn.edu.xmu.artworkauction.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.UserService;

/**
 * @author Y
 *
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
    private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private UserDAO userDAO;

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}
	
	//更改用户的信息
	@Override
	public User updateUserInfo(User user,String email,String userName,String phoneNumber,String imageURL)
	{
		// TODO Auto-generated method stub
		user=userDAO.userUpdate(user, email, userName, phoneNumber,imageURL);
		return user;
	}

	//更新用户的地址
	@Override
	public User updateUserAddress(User user, Address address) {
		// TODO Auto-generated method stub
		user=userDAO.userUpdateAddress(user, address);
		return user;
	}
}