/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.SecureService;

/**
 * @author XiaWenSheng
 *
 */
@Controller
public class RegisterLoginController {

	@Resource
	private SecureService secureService;
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,Model model){
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		User user=secureService.userRegister(email, userName, phoneNumber, password);
		ModelAndView modelAndView=new ModelAndView("userCenter");
		model.addAttribute("user", user);
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
	
	@RequestMapping ("/userLoginByUserName")
	public ModelAndView userLoginByUserName(HttpServletRequest request)
	{
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=secureService.userLoginByUserName(userName, password);
		ModelAndView modelAndView;
		request.getSession().setAttribute("user", user);
		switch (user.getUserType()) 
		{
		case "chiefEditor":
			modelAndView =new ModelAndView("forward:getCheckPendingList");
			break;
		case "editor":
			modelAndView =new ModelAndView("Editor/editArtNews");
			break;
		case "artist":
			modelAndView =new ModelAndView("artistCenter");
			break;
		default:
			modelAndView =new ModelAndView("index");	
		}
		return modelAndView;
	}
	
	@RequestMapping("/artistRegister")
	public ModelAndView artistRegister(HttpServletRequest request,Model model){
		String realName=request.getParameter("realname");
		String IDNumber=request.getParameter("IDNumber");
		String userName=request.getParameter("userName");
		String email=request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		String country=null;
		String education=null;
		String description=null;
		
		if(request.getParameter("country")!=null)
		{
			country=request.getParameter("country");
		}
		
		
		if(request.getParameter("education")!=null)
		{
			education=request.getParameter("education");
		}
		
		
		if(request.getParameter("description")!=null)
		{
		    description=request.getParameter("description");
		}
		
		
		Artist artist=secureService.artistRegister(realName,IDNumber,userName,email,phoneNumber,password,country,education,description);
		//返回页面
		ModelAndView modelAndView=new ModelAndView("artistCenter");
		model.addAttribute("user",artist);
		request.getSession().setAttribute("user", artist);
		return modelAndView;
	}
	
	
	
	
}
