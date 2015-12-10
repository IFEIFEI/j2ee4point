package cn.edu.xmu.artworkauction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import javafx.scene.chart.PieChart.Data;

@Service
public interface ArtNewsDisplayService 
{
	public List<ArtNews> getTodayNews();
}
