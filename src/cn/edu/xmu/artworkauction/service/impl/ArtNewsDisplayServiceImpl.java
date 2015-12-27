package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;
import java.util.Map;

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
		return artNewsDAO.getTodayArtNews(columnId);
	}
	@Override
	public List<ArtNews> getTodayAdvertisement(String columnId) {
		// TODO Auto-generated method stub
		return artNewsDAO.getTodayAdvertisement(columnId);
	}
	@Override
	public Map getArtNewsDetailById(String artNewsId) {
		// TODO Auto-generated method stub
		return artNewsDAO.getArtNewsDetailById(artNewsId);
	}
	@Override
	public String deleteArtNewsById(String artNewsId) {
		// TODO Auto-generated method stub
		return artNewsDAO.deleteArtNewsById(artNewsId);
	}
	@Override
	public ArtNews getArtNewsById(String artNewsId) {
		// TODO Auto-generated method stub
		return artNewsDAO.getArtNewsById(artNewsId);
	}
	@Override
	public List<ArtNews> getArtNewsByState(String state) {
		// TODO Auto-generated method stub
		return artNewsDAO.getArtNewsByState(state);
	}

	
}
