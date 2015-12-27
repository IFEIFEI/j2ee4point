package cn.edu.xmu.artworkauction.dao.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import cn.edu.xmu.artworkauction.dao.ArtworkDAO;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.Shop;

/**artNewsDaoImpl deal with all the things about artwork
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1218_1.0.0
 *
 */
@Repository("artworkDAO")
public class ArtworkDAOImpl implements ArtworkDAO
{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Artwork> getAllArtwork()
	{	
		
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getAllArtwork")
				.list();
	}

	@Override
	public void addArtwork(Artwork artwork) 
	{
		sessionFactory.getCurrentSession()
			.save(artwork);
	}

	@Override
	public void saveArtNews(Artwork artwork) 
	{
		sessionFactory.getCurrentSession()
			.saveOrUpdate(artwork);
	}

	@Override
	public void updateArtNews(Artwork artwork) 
	{
		sessionFactory.getCurrentSession()
			.update(sessionFactory);
		
	}

	@Override
	public void deleteArtNews(Artwork artwork) 
	{
		sessionFactory.getCurrentSession()
			.delete(artwork);
	}

	@Override
	public Artwork getArtworkById(Integer id) 
	{
		return (Artwork) sessionFactory.getCurrentSession()
										.getNamedQuery("@HQL_getArtworkById")
										.setInteger(0, id)
										.uniqueResult();
	}

	@Override
	public List<Artwork> getArtworkByArtist(Artist artist) 
	{
		return sessionFactory.getCurrentSession()
						.getNamedQuery("@HQL_getArtworkByArtist")
						.setEntity(0, artist)
						.list();
				
	}

	@Override
	public List<Artwork> getArtworkByMaterial(String material) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByMaterial")
				.setString(0, material)
				.list();
	}

	@Override
	public List<Artwork> getArtworkBySize(String size) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkBySize")
				.setString(0, size)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByCreateTime(Date createTime) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("HQL_getArtworkByCreateTime")
				.setDate(0, createTime)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByDescription(String description)
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByDescription")
				.setString(0, description)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByType(String type) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByType")
				.setString(0, type)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByTheme(String theme) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByTheme")
				.setString(0, theme)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByShop(Shop shop) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByShop")
				.setEntity(0, shop)
				.list();
	}

	@Override
	public List<Artwork> getArtworkByPrice(Double low, Double high) 
	{
		return sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_getArtworkByPrice")
				.setDouble(0, low)
				.setDouble(0, high)
				.list();
	}

	@Override
	public void artworkSaleOff(String artworkId) {
		((Artwork) sessionFactory.getCurrentSession()
			.getNamedQuery("@HQL_getArtworkById")
			.setInteger(0, Integer.parseInt(artworkId))
			.uniqueResult()).setInventory(0);
	}

}
