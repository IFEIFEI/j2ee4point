package cn.edu.xmu.artworkauction.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.Editor;

/**
 *  The interface ArtNewsDAO  contains the method's about
 *  the artNews and is inherited by the {@link ArtNewDAOImpl}.
 *  @author Dany ifeifei@stu.xmu.edu.cn<br>
 *  @version 2<br>
 *  Modified By XiaWenSheng 12/26
 */
public interface ArtNewsDAO 
{
	public ArtNews getArtNewsById(String artNewsId);
	public ArtNews getArtNewsByTitle(String title);
	public List<ArtNews> getArtNewsByType(String type);
	public List<ArtNews> getHistoryArtNewsByEditor(Editor editor);
	public boolean isExistByTitle(String title);
	public List<ArtNews> getTodayArtNews(String columnID);
	public List<ArtNews> getTodayAdvertisement(String columnID);
	public Map getArtNewsDetailById(String artNewsId);
	public String deleteArtNewsById(String artNewsId);
	public List<ArtNews> getArtNewsByState(String state);
}

