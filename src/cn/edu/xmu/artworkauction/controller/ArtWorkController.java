package cn.edu.xmu.artworkauction.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtWorkController 
{
	@RequestMapping("/getArtwork")
	public ModelAndView getArtWork(HttpServletRequest request,Model model)
	{
		System.out.println("Hello");
		ModelAndView modelAndView=new ModelAndView("/artwork");
		return modelAndView;
	}
}
