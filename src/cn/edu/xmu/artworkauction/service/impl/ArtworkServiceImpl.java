package cn.edu.xmu.artworkauction.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.dao.ArtworkDAO;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.service.ArtworkService;

@Service
public class ArtworkServiceImpl implements ArtworkService
{
	private ArtworkDAO artworkDAO;
	@Resource(name="artworkDAO")
	public void setArtworkDAO(ArtworkDAO artworkDAO) 
	{
		this.artworkDAO = artworkDAO;
	}
	
	@Override
	public List<Artwork> getAllArtwork()
	{
		return artworkDAO.getAllArtwork();
	}

}
