/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.ChiefEditorDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.utils.Constants;

/**
 * The class ChiefEditorDAOImpl implements the class {@link ChiefEditorDAO} 
 * and contains the methods about the chiefEditor.
 * @author XiaWenSheng
 *
 */
@Repository("chiefEditorDAO")
public class ChiefEditorDAOImpl implements ChiefEditorDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * The method approveArtNews is to approve the artNews.
	 * @param artNews
	 * @return
	 */
	@Override
	public void approveArtNews(ArtNews artNews) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(artNews);
	}

	/**
	 * The method disapproveArtNews is to disapprove the artNews.
	 * @param artNews
	 */
	@Override
	public void disapproveArtNews(ArtNews artNews) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(artNews);
	}

	/**
	 * The method getUnderApprovalArtNews is to get the under approval artNews.
	 * @return the list which element is artNews
	 */
	@Override
	public List<ArtNews> getUnderApprovalArtNews() {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().
				getNamedQuery("@HQL_GetArtNewsByState").setParameter("state", Constants.UNDERAPPROVAL);
		return (List<ArtNews>)query.list();
	}

	/**
	 * The method getArtNewsByChiefEditor is to get all the history record.
	 * @param chiefEditor
	 * @return list which element is artNews
	 */
	@Override
	public List<ArtNews> getArtNewsByChiefEditor(ChiefEditor chiefEditor) {
		return (List<ArtNews>) sessionFactory.getCurrentSession()
				.getNamedQuery("@HQL_GetArtNewsByChiefEditor").setEntity("chiefEditor", chiefEditor)
				.list();
	}	
}
