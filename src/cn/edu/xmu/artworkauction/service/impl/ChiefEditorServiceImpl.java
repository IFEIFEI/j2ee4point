package cn.edu.xmu.artworkauction.service.impl;
import java.util.Date;
/**
 * modified by XiaWenSheng 12/12
 * */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.javafx.collections.MappingChange.Map;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.dao.ChiefEditorDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.service.ChiefEditorService;
import cn.edu.xmu.artworkauction.utils.Constants;
@Transactional
@Service("chiefEditorService")
public class ChiefEditorServiceImpl implements ChiefEditorService
{
	private ChiefEditorDAO chiefEditorDAO;
	@Resource(name="chiefEditorDAO")
	public void setChiefEditorDAO(ChiefEditorDAO chiefEditorDAO)
	{
		this.chiefEditorDAO=chiefEditorDAO;
	}
	private ArtNewsDAO artNewsDAO;
	@Resource(name="artNewsDAO")
	public void setArtNewsDAO(ArtNewsDAO artNewsDAO)
	{
		this.artNewsDAO=artNewsDAO;
	}
	/*
	@Override
	public List<ArtNews> getUncheckedArtNews()
	{
		ArtNews artNews=new ArtNews();
		Date data=new Date();
		System.out.println(data);
		artNews.setCreateTime(data);
		System.out.println(artNews.getCreateTime());
		artNewsDAO.saveArtNews(artNews);
		return artNewsDAO.getUnCheckedArtNews();
	}
	@Override
	public void savaCheckedArtNews(List<ArtNews> artNewslist,ChiefEditor chiefEditor)
	{
		artNewslist.stream()
				.map(a->{a.setChiefEditor(chiefEditor);return a;})
				.forEach(a->artNewsDAO.saveArtNews(a));
	}
	@Override
	public void printTest() 
	{		
		artNewsDAO.test();
	}
	@Override
	public void saveArtNewsState(Integer artNewsId, String state, ChiefEditor chiefEditor) 
	{
		ArtNews artNews=artNewsDAO.getArtNewsById(artNewsId);
		artNews.setState(state);
		artNews.setChiefEditor(chiefEditor);
		artNewsDAO.saveArtNews(artNews);		
	}
	@Override
	public List<ArtNews> getMyCheckedHistory(ChiefEditor chiefEditor) 
	{
		return artNewsDAO.getHistoryArtNewsByChiefEditor(chiefEditor);
	}
	*/
	@Override
	public void approveArtNews(ArtNews artNews, String title, String type, String summary, String content) {
		// TODO Auto-generated method stub
		artNews.setState(Constants.APPROVED);
		artNews.setSummary(summary);
		artNews.setType(type);
		artNews.setTitle(title);
		chiefEditorDAO.approveArtNews(artNews);
	}
	@Override
	public void disapproveArtNews(ArtNews artNews) {
		// TODO Auto-generated method stub
		artNews.setState(Constants.DISAPPROVED);
		chiefEditorDAO.disapproveArtNews(artNews);
	}
	@Override
	public List<ArtNews> getArtNewsByChiefEditor(ChiefEditor chiefEditor) {
		// TODO Auto-generated method stub
		return chiefEditorDAO.getArtNewsByChiefEditor(chiefEditor);
	}
}
