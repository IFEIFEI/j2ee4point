package cn.edu.xmu.artworkauction.service;

import java.util.List;

import cn.edu.xmu.artworkauction.entity.Artwork;

public interface ArtworkService
{
	public List<Artwork> getAllArtwork();
	public Artwork getSingelArtwork(Integer id);
}
