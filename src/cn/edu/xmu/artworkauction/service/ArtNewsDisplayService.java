package cn.edu.xmu.artworkauction.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import javafx.scene.chart.PieChart.Data;

public interface ArtNewsDisplayService 
{
	public ArtNews getArtNewsById(String artNewsId);
	public List<ArtNews> getTodayArtNews(String columnId);
	public List<ArtNews> getTodayAdvertisement(String columnId);
	public Map getArtNewsDetailById(String artNewsId);
	public String deleteArtNewsById(String artNewsId);
	public List<ArtNews> getArtNewsByState(String state);
}
