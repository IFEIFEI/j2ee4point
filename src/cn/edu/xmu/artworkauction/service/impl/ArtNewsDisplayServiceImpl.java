package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.service.ArtNewsDisplayService;

@Service
public class ArtNewsDisplayServiceImpl implements ArtNewsDisplayService
{

	private ArtNewsDAO artNewsDAO;
	@Resource(name="artNewsDAO")
	public void setArtNewsDAO(ArtNewsDAO artNewsDAO) 
	{
		this.artNewsDAO = artNewsDAO;
	}
	@Override
	public List<ArtNews> getTodayNews() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
