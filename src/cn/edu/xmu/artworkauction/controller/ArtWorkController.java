package cn.edu.xmu.artworkauction.controller;

import java.math.BigDecimal;
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
		if(allArtworkList==null)
		{
			List<Artwork> aList=artworkServiceImpl.getAllArtwork();
			allArtworkList=aList;
			request.getSession().setAttribute("allArtworkList", aList);
		}
		ModelAndView modelAndView=new ModelAndView("/artworks");
		return modelAndView;
	}
	
	@RequestMapping("/getArtworkByType")
	public ModelAndView getArtWorkByType(HttpServletRequest request)
	{
		String kind=request.getParameter("kind");
		String price=request.getParameter("price");
		String size=request.getParameter("size");
		String years=request.getParameter("years");
		System.out.println(kind+price);
		List<Artwork> aList=allArtworkList.stream()
				.filter(a->{
					boolean kindflag=true;
					if(!kind.equals("ALL")&&a.getType()!=null)
						kindflag=a.getType().equals(kind);
					boolean priceflag=true;
					if(!price.equals("ALL")&&a.getPrice()!=null)
					{
						boolean lowFlag=true;
						boolean highFlag=true;
						String[] prices=price.split("-");
						if(!prices[0].equals("~"))
							lowFlag=a.getPrice()>(Integer.parseInt(prices[1])*1000);
						if(!prices[2].equals("~"))
							highFlag=a.getPrice()<(Integer.parseInt(prices[1])*1000);
						priceflag=lowFlag&&highFlag;
					}
					boolean sizeFlag=true;
					//TODO: have a judgement about how the size is
					boolean yearsFlag=true;
					//TODO: have the artwork have the year?
					
					return kindflag&&priceflag&&sizeFlag&&yearsFlag;
				})
				.collect(Collectors.toList());
		System.out.println(aList);
		request.getSession().setAttribute("allArtworkList", aList);
		ModelAndView modelAndView=new ModelAndView("/artworks");
		return modelAndView;
	}
	
	@RequestMapping("/singleArtwork")
	public ModelAndView singleArtwork(HttpServletRequest request,Model model)
	{
		String artworkId=request.getParameter("id");
		Artwork singleArtwork=allArtworkList.stream()
				.filter(a->a.getId()==Integer.parseInt(artworkId))
				.collect(Collectors.toList())
				.get(0);
		//System.out.println(singleArtwork.getPrice());
		request.getSession().setAttribute("singleArtwork", singleArtwork);
		System.out.println(artworkId);
		ModelAndView modelAndView=new ModelAndView("singleArtwork");
		return modelAndView;
	}
	
}
