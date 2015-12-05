package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sun.javafx.collections.MappingChange.Map;

import cn.edu.xmu.artworkauction.dao.ArtNewsDao;
import cn.edu.xmu.artworkauction.dao.ChiefEditorDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.service.ChiefEditorService;

public class ChiefEditorServiceImpl implements ChiefEditorService
{
	private ArtNewsDao artNewsDao;
	@Resource(name="ArtNewsDao")
	public void setUserDAO(ArtNewsDao artNewsDao)
	{
		this.artNewsDao=artNewsDao;
	}
	@Override
	public List<ArtNews> getUncheckedArtNews()
	{
		return artNewsDao.getUnCheckedArtNews(0);
	}
	@Override
	public void savaCheckedArtNews(List<ArtNews> artNewslist,ChiefEditor chiefEditor)
	{
		artNewslist.stream()
				.map(a->{a.setChiefeditor(chiefEditor);return a;})
				.forEach(a->artNewsDao.saveArtNews(a));
	}
}
