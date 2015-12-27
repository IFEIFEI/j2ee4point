/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.EditorDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.utils.Constants;

/**
 * @author XiaWenSheng
 *
 */
@Repository("editorDAO")
public class EditorDAOImpl implements EditorDAO{
	private SessionFactory sessionFactory;	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public ArtNews submitDraft(ArtNews artNews,ArtNewsContent artNewsContent,
			List<DateAndPosition> dateAndPositionList) {
		// TODO Auto-generated method stub
		artNews.setState(Constants.UNDERAPPROVAL);
		artNews.setArtNewsContent(artNewsContent);
		for(int i=0;i<dateAndPositionList.size();i++) {
			dateAndPositionList.get(i).setArtNews(artNews);
			sessionFactory.getCurrentSession().saveOrUpdate(dateAndPositionList.get(i));
		}
		artNews.setDateAndPositions(dateAndPositionList);
		sessionFactory.getCurrentSession().merge(artNews);
		sessionFactory.getCurrentSession().merge(artNewsContent);
		return artNews;
	}

	@Override
	public ArtNews saveDraft(ArtNews artNews,ArtNewsContent artNewsContent,
			List<DateAndPosition> dateAndPositionList) {
		// TODO Auto-generated method stub
		artNews.setArtNewsContent(artNewsContent);
		artNews.setState(Constants.UNCOMMITTED);
		for(int i=0;i<dateAndPositionList.size();i++) {
			dateAndPositionList.get(i).setArtNews(artNews);
			sessionFactory.getCurrentSession().saveOrUpdate(dateAndPositionList.get(i));
		}
		artNews.setDateAndPositions(dateAndPositionList);
		sessionFactory.getCurrentSession().merge(artNews);
		sessionFactory.getCurrentSession().merge(artNewsContent);
		return artNews;
	}

	@Override
	public List<ArtNews> getAllDraftByEditor(Editor editor) {
		// TODO Auto-generated method stub	
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllDraftByEditor");
		query.setEntity("editor", editor);
		query.setParameter("state",Constants.UNCOMMITTED);
		return (List<ArtNews>)query.list();
	}
	@Override
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllApprovedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.APPROVED);
		return (List<ArtNews>)query.list();
	}
	@Override
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllApprovedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.DISAPPROVED);
		return (List<ArtNews>)query.list();
	}
	@Override
	public List<ArtNews> getAllCommittedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllCommittedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.UNCOMMITTED);
		return (List<ArtNews>)query.list();
	}	
	@Override
	public Map getArtNewsAllDetailById(String artNewsId) {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(artNewsId);
		ArtNews artNews=(ArtNews)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsDetailById").setParameter("id", id).uniqueResult();
		List<DateAndPosition> dateAndPositionList=(List<DateAndPosition>)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetDateAndPositionListByArtNews").setEntity("artNews", artNews).list();
		ArtNewsContent artNewsContent=artNews.getArtNewsContent();
		Map map=new HashMap();
		map.put("artNews", artNews);
		map.put("artNewsContent", artNewsContent);
		map.put("dateAndPositionList", dateAndPositionList);
		return map;
	}
	@Override
	public void updateDraft(ArtNews artNews, String title, String type, String summary, String content, String state) {
		// TODO Auto-generated method stub
		artNews.getArtNewsContent().setContent(content);
		artNews.setEditTime(new Date());
		artNews.setState(state);
		artNews.setSummary(summary);
		artNews.setTitle(title);
		artNews.setType(type);
		sessionFactory.getCurrentSession().merge(artNews);
	}
}
