package cn.edu.xmu.artworkauction.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.swing.text.html.HTML;

import cn.edu.xmu.artworkauction.dao.ArtNewsDao;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;

/*
 * EditorServiceImpl
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
public class EditorServiceImpl implements EditorService
{
	private ArtNewsDao artNewsDao;
	@Resource(name="ArtNewsDao")
	public void setUserDAO(ArtNewsDao artNewsDao)
	{
		this.artNewsDao=artNewsDao;
	}
	@Override
	public void saveDraft(String title,String article,Date createtime,Date edittime,Integer checked,Integer checkedout,Editor editor ,String type)
	{
		if(artNewsDao.isExistByTitle(title))
		{
			ArtNews artNews=artNewsDao.getArtNewsByTitle(title).get(0);
			artNews.setEdittime(new Date());
			artNews.setType(type);
			artNewsDao.saveArtNews(artNews);
		}
		else
		{
			ArtNews artNews=new ArtNews(title,article,createtime,edittime,checked,checkedout,editor);
			artNews.setType(type);
			artNewsDao.addArtNews(artNews);
		}
	}
	@Override
	public void submit(String title, String article, Date createtime, Date edittime, Integer checked, Integer checkedout,
			Editor editor,String type) 
	{
		ArtNews artNews=new ArtNews(title,article,createtime,edittime,checked,checkedout,editor);
		artNews.setType(type);
		artNewsDao.addArtNews(artNews);
	}
	@Override
	public List<ArtNews> getDraft(Editor editor) 
	{
		List<ArtNews> draftlist=artNewsDao
				.getUnCheckedArtNews(2)
				.stream()
				.filter(e->e.getEditor().getId()==editor.getId())
				.collect(Collectors.toList());
		return draftlist;
	}
	
}
