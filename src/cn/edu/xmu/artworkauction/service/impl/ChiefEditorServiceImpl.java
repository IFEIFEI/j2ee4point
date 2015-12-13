package cn.edu.xmu.artworkauction.service.impl;
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
@Transactional
@Service("chiefEditorService")
public class ChiefEditorServiceImpl implements ChiefEditorService
{
	private ArtNewsDAO artNewsDAO;
	@Resource(name="artNewsDAO")
	public void setArtNewsDAO(ArtNewsDAO artNewsDAO)
	{
		this.artNewsDAO=artNewsDAO;
	}
	@Override
	public List<ArtNews> getUncheckedArtNews()
	{
		return artNewsDAO.getUnCheckedArtNews(0);
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
}
