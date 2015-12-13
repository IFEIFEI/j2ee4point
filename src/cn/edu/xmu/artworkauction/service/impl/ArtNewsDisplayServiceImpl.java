package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.service.ArtNewsDisplayService;
@Transactional
@Service("artNewsDisplayService")
public class ArtNewsDisplayServiceImpl implements ArtNewsDisplayService
{
	private ArtNewsDAO artNewsDAO;
	@Resource(name="artNewsDAO")
	public void setArtNewsDAO(ArtNewsDAO artNewsDAO) {
		this.artNewsDAO = artNewsDAO;
	}
	@Override
	public List<ArtNews> getTodayArtNews(String columnId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ArtNews> getTodayAdvertisement(String columnId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
