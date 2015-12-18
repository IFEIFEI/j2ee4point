package cn.edu.xmu.artworkauction.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@Repository("artNewsDAO")
public class ArtworkDAOImpl implements ArtworkDAO
{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Artwork> getAllArtwork() throws Exception 
	{
		
		return null;
	}

	@Override
	public void addArtwork(Artwork artwork) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveArtNews(Artwork artwork) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArtNews(Artwork artwork) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArtNews(Artwork artwork) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Artwork getArtworkById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByArtist(Artist artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByMaterial(String material) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkBySize(String size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByCreateTime(Date createTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByTheme(String theme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByShop(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artwork> getArtworkByPrice(BigDecimal low, BigDecimal high) {
		// TODO Auto-generated method stub
		return null;
	}

}
