package cn.edu.xmu.artworkauction.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.service.ArtworkService;
import cn.edu.xmu.artworkauction.service.impl.ArtworkServiceImpl;

@Controller
public class ArtWorkController 
{
	@Resource
	ArtworkService artworkServiceImpl;
	
	private List<Artwork> allArtworkList;
	
	@RequestMapping("/getArtwork")
	public ModelAndView getArtWork(HttpServletRequest request,Model model)
	{
		List<Artwork> aList=artworkServiceImpl.getAllArtwork();
		allArtworkList=aList;
		request.getSession().setAttribute("allArtworkList", aList);
		ModelAndView modelAndView=new ModelAndView("/artwork");
		return modelAndView;
	}
	
	//--------------
	//以下逻辑处理错误~~~
	@ResponseBody
	@RequestMapping("/getArtworkByType")
	public String getArtWorkByType(HttpServletRequest request)
	{
		String type=request.getParameter("type");
		List<Artwork> aList=allArtworkList.stream()
				.filter(a->a.getType().equals(type))
				.collect(Collectors.toList());
		System.out.println(aList);
		request.getSession().setAttribute("allArtworkList", aList);
		JSONObject root=new JSONObject();
		root.put("data","1");
		return root.toString();
	}
	
	@ResponseBody
	@RequestMapping("/getArtworkByPrice")
	public String getArtWorkByPrice(HttpServletRequest request)
	{
		String type=request.getParameter("type");
		List<Artwork> aList=allArtworkList.stream()
				.filter(a->a.getType().equals(type))
				.collect(Collectors.toList());
		System.out.println(aList);
		request.getSession().setAttribute("allArtworkList", aList);
		JSONObject root=new JSONObject();
		root.put("data","1");
		return root.toString();
	}
	
}
