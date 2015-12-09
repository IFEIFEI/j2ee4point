package cn.edu.xmu.artworkauction.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.entity.ArtNews;

/*
 *  ArtNewsDAO 
 *  @author Dany ifeifei@stu.xmu.edu.cn
 *  Modified By XiaWenSheng
 */
@Repository
public interface ArtNewsDAO 
{
	public List<ArtNews> getAllArtNews() throws Exception;
	public void addArtNews(ArtNews artNews);
	public void saveArtNews(ArtNews artNews);
	public void deleteArtNews(ArtNews artNews);
	//public ArtNews getArtNewsById(Integer id);
	public List<ArtNews> getArtNewsByTitle(String title);
	public List<ArtNews> getArtNewsByType(String type);
	public List<ArtNews> getCheckedArtNews();
	public List<ArtNews> getUnCheckedArtNews(Integer lev);
	public List<ArtNews> getCheckedoutArtNews();
	public List<ArtNews> getUnCheckedoutArtNews();
	public List<ArtNews> getArtNewsByData(Date data);
	public boolean isExistByTitle(String title);
}
