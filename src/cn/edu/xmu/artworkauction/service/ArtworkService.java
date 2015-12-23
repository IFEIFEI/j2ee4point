package cn.edu.xmu.artworkauction.service;

import java.util.HashMap;
import java.util.List;

import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.User;

public interface ArtworkService
{
	public List<Artwork> getAllArtwork();
	public Artwork getSingelArtwork(Integer id);
	public void addNewOrder(HashMap<String, Integer> shopList,User user);
}
