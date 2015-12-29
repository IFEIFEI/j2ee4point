package cn.edu.xmu.artworkauction.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.utils.Constants;
import sun.misc.CEFormatException;

/**
 * The class ArtNewsDAOImpl implements the class {@link ArtNewsDAO}
 * @author Dany ifeifei@stu.xmu.edu.cn<br>
 * @version 2.0<br>
 * Modified By XiaWenSheng 12/26
 */

@Repository("artNewsDAO")
public class ArtNewsDAOImpl implements ArtNewsDAO
{
	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * The method getArtNewsById is to get the artNews from database 
	 * according the id.
	 * @param artNewsId
	 * @return artNews
	 */
	@Override
	public ArtNews getArtNewsById(String  artNewsId) {
		Integer id=Integer.parseInt(artNewsId);
		return (ArtNews)sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_GetArtNewsById").setParameter("id", id).uniqueResult();
	}
	/**
	 * The method getArtNewsByTitle is to get the artNews by title.
	 * @param title
	 * @return artNews
	 */
	@Override
	public ArtNews getArtNewsByTitle(String title) {
		return (ArtNews)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsByTitle").setString(0, title).uniqueResult();
	}
	/**
	 * The method getArtNewsByType is to get the artNewsList according the type.
	 * @param type
	 * @return the list which element is artNews
	 */
	@Override
	public List<ArtNews> getArtNewsByType(String type) {
		return (List<ArtNews>)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsByType").setString(0, type).list();
	}
	/**
	 * The method isExistByTitle is to check the artNews is existing or not.
	 * @param title
	 * @return boolean
	 */
	@Override
	public boolean isExistByTitle(String title) {
		String hql="from ArtNews a where a.title=?";
		return 	sessionFactory.getCurrentSession().createQuery(hql).setString(0, title).uniqueResult()!=null;
	}
	/**
	 * The method getTodayArtNews is to get today's artNews.
	 * @param columnID
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getTodayArtNews(String columnID) {
		// TODO Auto-generated method stub
		Date today=new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		Query query=sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetTodayArtNews");
		query.setParameter("Today", today);
		query.setParameter("columnId", columnID);
		query.setParameter("state", Constants.APPROVED);
		query.setParameter("type", "article");
		List<ArtNews> artNews = (List<ArtNews>)query.list();
		List<ArtNews> ads = getTodayAdvertisement(columnID);
		return ArtNews.mixArtNewsAndAdvertisement(artNews, ads);
	}
	/**
	 * The method is to get today's advertisement.
	 * @param columnID
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getTodayAdvertisement(String columnID) {
		// TODO Auto-generated method stub
		Date today=new Date();
		today.setHours(0);
		today.setMinutes(0);
		today.setSeconds(0);
		Query query=sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetTodayArtNews");
		query.setParameter("Today", today);
		query.setParameter("columnId", columnID);
		query.setParameter("state", Constants.APPROVED);
		query.setParameter("type", "ads");
		return (List<ArtNews>)query.list();
	}
	public List<ArtNews> getHistoryArtNewsByEditor(Editor editor) {
		return (List<ArtNews>) sessionFactory
				.getCurrentSession()
				.getNamedQuery("HQL_GetArtNewsByEditor")
				.setEntity(0, editor)
				.list();
	}

	/**
	 * The method getArtNewsDetailById is to get the artNews all detail by id.
	 * @param artNewsId
	 * @return map
	 */
	@Override
	public Map getArtNewsDetailById(String artNewsId) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		Integer artnewsId=Integer.parseInt(artNewsId);
		Query query=sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsDetailById").setParameter("id", artnewsId);
		ArtNews artNews=(ArtNews)query.uniqueResult();
		ArtNewsContent artNewsContent=artNews.getArtNewsContent();
		map.put("artNews", artNews);
		map.put("artNewsContent", artNewsContent);
		return map;
	}
	/**
	 * The method deleteArtNewsById is to delete the artNews by id.
	 * @param artNewsId
	 * @return string
	 */
	@Override
	public String deleteArtNewsById(String artNewsId) {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(artNewsId);
		ArtNews artNews=(ArtNews)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsDetailById").setParameter("id", id).uniqueResult();
		sessionFactory.getCurrentSession().delete(artNews);
		return "SUCCESS";	
	}
	/**
	 * The method getArtNewsByState is to get the artNews by state.
	 * @param state
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getArtNewsByState(String state) {
		// TODO Auto-generated method stub
		return (List<ArtNews>)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsByState").setParameter("state", state).list();
	}	
}
