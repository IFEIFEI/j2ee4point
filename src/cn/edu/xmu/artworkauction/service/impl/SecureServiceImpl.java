/**
 * 
 */
package cn.edu.xmu.artworkauction.service.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.dao.ArtistDAO;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Artist;
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
	private ArtistDAO artistDAO;

	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}

	@Resource(name="artistDAO")
	public void setArtistDAO(ArtistDAO artistDAO){
		this.artistDAO=artistDAO;
	}	
	
	@Override
	public User userRegister(String email, String userName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		//sessionFactory.getCurrentSession().beginTransaction();
		User user=userDAO.userRegister(email, userName, phoneNumber, password);
		//sessionFactory.getCurrentSession().getTransaction().commit();
		return user;
	}

    //艺术家进行注册
    @Override
	public Artist artistRegister(String realname,String IDNumber,String userName,String email,String phoneNumber,String password,String country,String education,String description){
		Artist artist=artistDAO.toBeArtist(realname,IDNumber,userName,email,phoneNumber,password,country,education,description);
		return artist;
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