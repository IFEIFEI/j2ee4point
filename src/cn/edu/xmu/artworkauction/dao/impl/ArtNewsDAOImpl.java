package cn.edu.xmu.artworkauction.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * ArtNewsDaoimpl
 * @author Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng
 */
@Repository("artNewsDAO")
public class ArtNewsDAOImpl implements ArtNewsDAO
{
	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	//transaction part should use AOP  
	public List<ArtNews> getAllArtNews() throws Exception
	{
		Session session=sessionFactory.getCurrentSession();
		//
		Transaction tx=(Transaction) session.beginTransaction();
		//
		String hqlselect="select a from ArtNews";
		List<ArtNews> aList=session.createQuery(hqlselect).list();
		//
		tx.commit();
		//
		return aList;
		
	}
	@Override
	public void addArtNews(ArtNews artNews)
	{
		Editor editor=(Editor)sessionFactory.getCurrentSession().createQuery("from Editor").uniqueResult();
		System.out.println(editor.getAdminName());
		artNews.setEditor(editor);
		org.hibernate.Transaction tx=sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().persist(artNews);
		editor.setAdminName("珊珊");
		sessionFactory.getCurrentSession().persist(editor);
		tx.commit();
		artNews=(ArtNews)sessionFactory.getCurrentSession().createQuery("from ArtNews").uniqueResult();
		System.out.println(artNews.getArticle());
		System.out.println("save artNews");
	}
	@Override
	public void saveArtNews(ArtNews artNews)
	{
		sessionFactory.getCurrentSession().save(artNews);
	}
	@Override
	public void deleteArtNews(ArtNews artNews)
	{
		sessionFactory.getCurrentSession().delete(artNews);
	}
	/*who can use this function?
	@Override
	public ArtNews getArtNewsById(Integer id)
	{
		String hql="from ArtNews a where a.id=?";
		return (ArtNews)sessionFactory.getCurrentSession().createQuery(hql).setString(0, id.toString()).uniqueResult();
	}
	*/
	@Override
	public List<ArtNews> getArtNewsByTitle(String title)
	{
		String hql="from ArtNews a where a.title=?";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).setString(0, title).list();
	}
	@Override
	public List<ArtNews> getArtNewsByType(String type)
	{
		String hql="form ArtNews a where a.type=?";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).setString(0, type).list();
	}
	@Override
	public List<ArtNews> getCheckedArtNews()
	{
		String hql="form ArtNews a where a.checked=1";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public List<ArtNews> getUnCheckedArtNews(Integer lev)
	{
		String hql="form ArtNews a where a.checked=?";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).setString(0,lev.toString()).list();
	}
	@Override
	public List<ArtNews> getCheckedoutArtNews()
	{
		String hql="form ArtNews a where a.checkedout=1";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public List<ArtNews> getUnCheckedoutArtNews()
	{
		String hql="form ArtNews a where a.checkedout=0";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ArtNews> getArtNewsByData(Date data)
	{
		String hql="form ArtNews a where a.launchTime=?";
		return (List<ArtNews>)sessionFactory
				.getCurrentSession()
				.createQuery(hql)
				.setString(0, data.toString())
				.list();
	}
	@Override
	public boolean isExistByTitle(String title)
	{
		String hql="form ArtNews a where a.title=?";
		return 	sessionFactory
				.getCurrentSession()
				.createQuery(hql)
				.setString(0, title)
				.list()!=null;
	}
	@Override
	public List<ArtNews> getHistoryArtNewsByEditor(Editor editor)
	{
		//TODO:此处的hql代码不确定，有问题
		String hql="form ArtNews a inner join Editor e where e.adminName=?";
		return (List<ArtNews>) sessionFactory
				.getCurrentSession()
				.createQuery(hql)
				.setString(0, editor.getAdminName())
				.list();
	}
}
