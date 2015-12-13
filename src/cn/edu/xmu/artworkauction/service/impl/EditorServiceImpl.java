package cn.edu.xmu.artworkauction.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.swing.text.html.HTML;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import org.springframework.transaction.annotation.Transactional;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;

/**
 * EditorServiceImpl
 * @author  Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng
 */
@Transactional
@Service("editorService")
public class EditorServiceImpl implements EditorService
{
	private ArtNewsDAO artNewsDAO;
	@Resource(name="artNewsDAO")
	public void setArtNewsDAO(ArtNewsDAO artNewsDAO)
	{
		this.artNewsDAO=artNewsDAO;
	}
	@Override
	public ArtNews saveDraft(String title,String article,Date createtime,Date edittime,String state,Editor editor ,String type)
	{
		/*
		if(artNewsDAO.isExistByTitle(title))
		{
			
			ArtNews artNews=artNewsDAO.getArtNewsByTitle(title).get(0);
			artNews.setEditTime(new Date());
			artNews.setType(type);
			artNewsDAO.saveArtNews(artNews);
		}
		else
		{*/
			ArtNews artNews=new ArtNews(title,article,createtime,edittime,state,editor);
			artNews.setType(type);
			artNewsDAO.addArtNews(artNews);
			return artNews;
		//}
	}
	@Override
	public void submit(String title, String article, Date createtime, Date edittime, String state,
			Editor editor,String type) 
	{
		ArtNews artNews=new ArtNews(title,article,createtime,edittime,state,editor);
		artNews.setType(type);
		System.out.println(artNews);
		artNewsDAO.addArtNews(artNews);
	}
	@Override
	public List<ArtNews> getDraft(Editor editor) 
	{
		List<ArtNews> draftlist=artNewsDAO
				.getUnCheckedArtNews()
				.stream()
				.filter(e->e.getEditor().getId()==editor.getId())
				.collect(Collectors.toList());
		return draftlist;
	}
	
}
