/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.EditorDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
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
	public ArtNews submitDraft(ArtNews artNews) {
		// TODO Auto-generated method stub
		artNews.setState(Constants.UNDERAPPROVAL);
		sessionFactory.getCurrentSession().merge(artNews);
		return artNews;
	}

	@Override
	public ArtNews saveDraft(ArtNews artNews) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(artNews);
		return artNews;
	}

	@Override
	public List<ArtNews> getAllDraftByEditor(Editor editor) {
		// TODO Auto-generated method stub	
		editor=sessionFactory.getCurrentSession().load(Editor.class, editor.getId());
		return (List<ArtNews>)sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetAllDraftByEditor").setEntity("editor", editor);
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
	
	
	
}
