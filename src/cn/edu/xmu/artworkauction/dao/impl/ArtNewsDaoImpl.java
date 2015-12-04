package cn.edu.xmu.artworkauction.dao.impl;

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

import cn.edu.xmu.artworkauction.dao.ArtNewsDao;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.User;

/*
 * ArtNewsDaoimpl
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
@Repository("ArtNewsDao")
public class ArtNewsDaoImpl implements ArtNewsDao
{
	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<ArtNews> getAllArtNews() throws Exception
	{
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=(Transaction) session.beginTransaction();
		String hqlselect="select a from ArtNews";
		List<ArtNews> aList=session.createQuery(hqlselect).list();
		tx.commit();
		return aList;
		
	}
	@Override
	public void addArtNews(ArtNews artNews)
	{
		sessionFactory.getCurrentSession().persist(artNews);
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
	@Override
	public ArtNews getArtNewsById(Integer id)
	{
		String hql="from ArtNews a where a.id=?";
		return (ArtNews)sessionFactory.getCurrentSession().createQuery(hql).setString(0, id.toString()).uniqueResult();
	}
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
	public List<ArtNews> getUnCheckedArtNews()
	{
		String hql="form ArtNews a where a.checked=0";
		return (List<ArtNews>)sessionFactory.getCurrentSession().createQuery(hql).list();
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
}
