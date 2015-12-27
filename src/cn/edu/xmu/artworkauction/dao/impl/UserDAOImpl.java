/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author XiaWenSheng
 *
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User userRegister(String email, String userName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		if(checkEmailUnique(email)&&checkUserNameUnique(userName))
		{
			User user=new User(email,userName,phoneNumber,password);
			saveUser(user);
			return user;
		}
		else
			return null;
	}

    //对用户信息进行更新
    @Override
    public User userUpdate(User user,String email,String userName,String phoneNumber,String imageURL)
    { 	
    	if(checkEmailUnique(email))
    	{
    		if(checkUserNameUnique(userName)){
    			user.updateUserInfo(email,userName,phoneNumber,imageURL);
    			//updateUser(user);
    			sessionFactory.getCurrentSession().merge(user);
    			sessionFactory.getCurrentSession().flush();
    			return user;
    		}
    		else
    			return null;
    	}
    	return null;
    }
    
    @Override
	public User userUpdateAddress(User user, Address address) {
    	//首先默认住址只有一个
    	List<Address> list = new  LinkedList<Address>();
    	list.add(address);
    	user.setAddresses(list);
    	user.getAddresses().add(address);
    	updateAddress(address);
    	return user;
	}
    
    


	@Override
	public boolean checkUserNameUnique(String userName) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@HQL_CheckUserNameUnique");
		query.setString(0, userName);
		User user=(User)query.uniqueResult();
		return user==null;
	}

	@Override
	public boolean checkEmailUnique(String email){
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@HQL_CheckEmailUnique");
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		return user==null;
	}
	
	@Override
	public User findUserByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@HQL_FindUserByUserNameAndPassword");
		query.setString(0, userName);
		query.setString(1, password);
		User user=(User)query.uniqueResult();
		if(user.getUserType().equals("artist")){
			user=(Artist)user;
		}
		return user;
	}

	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@HQL_FindUserByEmailAndPassword");
		query.setString(0, email);
		query.setString(1, password);
		User user=(User)query.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		saveUser(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void addAddress(Address address) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(address);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(address);
	}

	@Override
	public User getUserById(Integer userId) {
		return (User) sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getUserById")
				.setInteger(0, userId)
				.uniqueResult();
	}

	
	
	
}
