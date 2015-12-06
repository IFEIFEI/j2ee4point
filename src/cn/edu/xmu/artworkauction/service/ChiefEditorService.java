package cn.edu.xmu.artworkauction.service;

import java.util.List;

import javax.annotation.Resource;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;

public interface ChiefEditorService 
{
	public List<ArtNews> getUncheckedArtNews();
	public void savaCheckedArtNews(List<ArtNews> artNewslist,ChiefEditor chiefEditor);
}
