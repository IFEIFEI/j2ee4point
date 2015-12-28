/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.ArtistDAO;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.utils.shopMaxUploadNumber;

/**
 * @author XiaWenSheng
 *
 */
@Repository("artistDAO")
public class ArtistDAOImpl implements ArtistDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
    
    //注册需要 真实姓名，邮箱，手机，密码，身份证号，国籍，教育
	@Override
	public Artist toBeArtist(String realname,String IDNumber,String userName,String email,String phoneNumber,String password,String country,String education,String description)
	{

		// TODO Auto-generated method stub
		if(checkIDNumberUnique(IDNumber))
		{
            if(checkEmailUnique(email))
            {
            	if(checkUserNameUnique(userName))
            	{
            		Artist artist=new Artist(realname,IDNumber,userName,email,phoneNumber,password,country,education,description);
            		addArtist(artist);
            		return artist;
            	}
            	else
            		return null;//如果用户名不唯一，需要进行提醒
            }
            else
            	return null;//如果邮箱不唯一，需要进行提醒
		}
		
		return null;//如果身份证已存在，需要进行提醒
	}

	//artist更新
	@Override
	public Artist artistUpdate(Artist artist,String userName,String email,String phoneNumber,String education,String description,String imageURL){
		// TODO Auto-generated method stub
		if(checkEmailUnique(email))
            {
            	if(checkUserNameUnique(userName))
            	{
            		artist.updateArtist(userName,email,phoneNumber,education,description,imageURL);
            		updateArtist(artist);
            		return artist;
            	}
            	else
            		return null;//如果用户名不唯一，需要进行提醒
            }
            else
            	return null;//如果邮箱不唯一，需要进行提醒
	}
	
	//更新艺术家的地址
	@Override
	public Artist artistUpdateAddress(Artist artist, Address address) {
		List<Address> list = new  ArrayList<>();
    	list.add(address);
		artist.setAddresses(list);
		//sessionFactory.getCurrentSession().saveOrUpdate(artist);
		updateArtist(artist);
		return artist;
	}
	
	//艺术家上传产品
	@Override
	public Artist addArtwork(Artist artist, Artwork artwork) {
		// TODO Auto-generated method stub
		if(checkShopNumber(artist)){
			artist.getShop().getArtworks().add(artwork);
			addartwork(artwork);
			return artist;
		}
		else
		{
			//如果数量达到上限，需要进行提示
			return null;
		}
	}
	
	
	//检验当前艺术家的艺术品数量，如果达到上限，不能进行上传
	@Override
	public boolean checkShopNumber(Artist artist) {
		// TODO Auto-generated method stub
		
		if(artist.getShop().getArtworks().size()< shopMaxUploadNumber.maxUploadNumber)
		{
			return true;
		}
		else
			return false;
	}
	

	@Override
	public boolean checkIDNumberUnique(String IDNumber){
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@HQL_CheckArtistIDNumberUnique");
		query.setString(0, IDNumber);
		Artist artist=(Artist)query.uniqueResult();
		return artist==null;
	}

	@Override
	public boolean checkUserNameUnique(String userName) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@HQL_CheckUserNameUnique");
		query.setString(0, userName);
		Artist artist=(Artist)query.uniqueResult();
		return artist==null;
	}

	@Override
	public boolean checkEmailUnique(String email){
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@HQL_CheckEmailUnique");
		query.setString(0, email);
		Artist artist=(Artist)query.uniqueResult();
		return artist==null;
	}


	@Override
	public void addArtist(Artist artist)
	{
		sessionFactory.getCurrentSession().save(artist);
	}
	@Override
	public void saveArtist(Artist artist)
	{
		sessionFactory.getCurrentSession().save(artist);
	}
	@Override
	public void deleteArtist(Artist artist)
	{
		sessionFactory.getCurrentSession().delete(artist);
	}

	@Override
	public void updateArtist(Artist artist)
	{
		sessionFactory.getCurrentSession().update(artist);
	}

	@Override
	public void addartwork(Artwork artwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(artwork);
	}

	@Override
	public void saveArtwork(Artwork artwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(artwork);
	}

	@Override
	public void deleteArtwork(Artwork artwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(artwork);
	}

	@Override
	public void updateArtwork(Artwork artwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(artwork);
	}

	@Override
	public Artist getArtistById(Integer artistId) {
		return (Artist) sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtistById")
				.setInteger(0, artistId)
				.uniqueResult();
	}

	@Override
	public List<Artist> getAllArtist() 
	{
		return (List<Artist>)sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getAllArtist")
				.list();
	}

	
	
}
