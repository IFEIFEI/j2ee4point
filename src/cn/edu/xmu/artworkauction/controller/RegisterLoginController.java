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
		ModelAndView modelAndView=new ModelAndView("userindex");
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
		if(user.getUserType().equals("user"))
			modelAndView=new ModelAndView("index");
		else if(user.getUserType().equals("editor"))
			modelAndView =new ModelAndView("Editor/editArtNews");
		else
			modelAndView =new ModelAndView("forward:getCheckPendingList");
		return modelAndView;
	}
}
