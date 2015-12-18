package cn.edu.xmu.artworkauction.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.Shop;

/** artworkDao interface
 * 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * @version D-1218_1.0.0 
 */
public interface ArtworkDAO 
{
	public List<Artwork> getAllArtwork() throws Exception;
	public void addArtwork(Artwork artwork);
	public void saveArtNews(Artwork artwork);
	public void updateArtNews(Artwork artwork);
	public void deleteArtNews(Artwork artwork);
	public Artwork getArtworkById(Integer id);
	public List<Artwork> getArtworkByArtist(Artist artist);
	public List<Artwork> getArtworkByMaterial(String material);
	public List<Artwork> getArtworkBySize(String size);
	public List<Artwork> getArtworkByCreateTime(Date createTime);
	public List<Artwork> getArtworkByDescription(String description);
	public List<Artwork> getArtworkByType(String type);
	public List<Artwork> getArtworkByTheme(String theme);
	public List<Artwork> getArtworkByShop(Shop shop);
	public List<Artwork> getArtworkByPrice(BigDecimal low,BigDecimal high);
}
