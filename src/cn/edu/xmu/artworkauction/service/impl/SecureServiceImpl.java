/**
 * 
 */
package cn.edu.xmu.artworkauction.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.SecureService;

/**
 * @author XiaWenSheng
 *
 */
@Transactional
@Service("secureService")
public class SecureServiceImpl implements SecureService{
	
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
	
	@Override
	public User userRegister(String email, String userName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		//sessionFactory.getCurrentSession().beginTransaction();
		User user=userDAO.userRegister(email, userName, phoneNumber, password);
		//sessionFactory.getCurrentSession().getTransaction().commit();
		return user;
	}
	@Override
	public User userLoginByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		return userDAO.findUserByUserNameAndPassword(userName, password);
	}
	@Override
	public User userLoginByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return userDAO.findUserByEmailAndPassword(email, password);
	}
}