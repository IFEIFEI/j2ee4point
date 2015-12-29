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
 * The class EditorDAOImpl implements the class {@link EditorDAO} and
 * contains the methods about the editor.
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
	/**
	 * The method submitDraft is to submit the draft.
	 * @param artNews
	 * @param artNewsContent
	 * @param dateAndPositionList
	 * @return artNews 
	 */
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

	/**
	 * The method saveDraft is to save the draft.
	 * @param artNews
	 * @param artNewsContent
	 * @param dateAndPositionList
	 * @return artNews 
	 */
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
	/**
	 * The method getAllDraftByEditor is to get all the draft by editor
	 * @param editor
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getAllDraftByEditor(Editor editor) {
		// TODO Auto-generated method stub	
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllDraftByEditor");
		query.setEntity("editor", editor);
		query.setParameter("state",Constants.UNCOMMITTED);
		return (List<ArtNews>)query.list();
	}
	/**
	 * The method getAllApprovedArtNewsByEditor is to get all approved artNews by editor.
	 * @param editor
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllApprovedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.APPROVED);
		return (List<ArtNews>)query.list();
	}
	/**
	 * The method getAllDisApprovedArtNewsByEditor is to get all disapproved artNews.
	 * @param editor
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllApprovedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.DISAPPROVED);
		return (List<ArtNews>)query.list();
	}
	/**
	 * The method getAllCommitedArtNewsByEditor is to get all committed artNews.
	 * @param editor
	 * @return list
	 */
	@Override
	public List<ArtNews> getAllCommittedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllCommittedArtNewsByEditor");
		query.setEntity("editor", editor);
		query.setString("state", Constants.UNCOMMITTED);
		return (List<ArtNews>)query.list();
	}	
	/**
	 * The method getArtNewsAllDetailById is to get artNews all detail by id.
	 * @param artNewsId
	 * @return map
	 */
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
	/**
	 * The method updateDraft is to update the draft
	 * @param artNews
	 * @param title
	 * @param type
	 * @param summary
	 */
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
	/**
	 * The method getAllUnderApprovalArtNewsByEditor is to get all under approval artNews
	 * @param editor
	 * @param list
	 */
	@Override
	public List<ArtNews> getAllUnderApprovalArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllDraftByEditor");
		query.setEntity("editor", editor);
		query.setParameter("state",Constants.UNDERAPPROVAL);
		return (List<ArtNews>)query.list();
	}
	/**
	 * The method is to getAllCheckedArtNewsByEditor is to get all checked artNews by editor.
	 * @param editor
	 * @return list
	 */
	@Override
	public List<ArtNews> getAllCheckedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		Query query= sessionFactory.getCurrentSession().getNamedQuery("@HQL_GetAllCheckedArtNewsListByEditor");
		query.setEntity("editor", editor);
		query.setParameter("state1",Constants.APPROVED);
		query.setParameter("state2", Constants.DISAPPROVED);
		return (List<ArtNews>)query.list();
	}
}
