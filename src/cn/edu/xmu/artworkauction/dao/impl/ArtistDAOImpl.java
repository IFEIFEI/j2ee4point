/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.ArtistDAO;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author XiaWenSheng
 *
 */
@SuppressWarnings("unused")
@Repository("artistDAO")
public class ArtistDAOImpl implements ArtistDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Artist applyToBeArtist(User user,String IDNumber) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

}
