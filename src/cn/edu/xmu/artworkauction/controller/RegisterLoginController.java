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

import cn.edu.xmu.artworkauction.entity.Admin;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.ServiceAdmin;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.UserAdmin;
import cn.edu.xmu.artworkauction.service.SecureService;

/**
 * @author Administrator
 *
 */
@Controller
public class RegisterLoginController {

	@Resource
	private SecureService secureService;
	
	private User user;
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,Model model){
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		ModelAndView modelAndView=new ModelAndView("user");
		user=secureService.userRegister(email, userName, phoneNumber, password);
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
		if(user==null)
		{
			modelAndView =new ModelAndView("index");
			return modelAndView;
		}
		else 
			modelAndView =new ModelAndView(user.getUserType());
		/*
		if(user.getUserType().equals("artist")){
			Artist artist=(Artist)user;
			//modelAndView.addObject(artist);
			request.getSession().setAttribute("artist", artist);
			return modelAndView;
		}
		*/
		//modelAndView.addObject(user);
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
	
<<<<<<< HEAD
	private Admin admin;
=======
>>>>>>> c77741e062caf1ee0eae193487ee385b7aedde43
	@RequestMapping ("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request) {
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
<<<<<<< HEAD
		ModelAndView modelAndView=new ModelAndView("Admin/admin_main");
		admin=secureService.adminLogin(adminName, password);
		modelAndView.addObject(admin);
=======
		Admin admin=secureService.adminLogin(adminName, password);
		ModelAndView modelAndView ;
		if(admin==null) {
			modelAndView=new ModelAndView("adminLogin");
		}
		else
			modelAndView=new ModelAndView(admin.getAdminType());
		/*
		if(admin.getAdminType().equals("editor")) {
			Editor editor=(Editor)admin;
			request.getSession().setAttribute("editor", editor);
		}
		else if(admin.getAdminType().equals("chiefEditor")) {
			ChiefEditor chiefEditor=(ChiefEditor)admin;
			request.getSession().setAttribute("chiefEditor", chiefEditor);
		}
		else if(admin.getAdminType().equals("userEditor")) {
			UserAdmin userAdmin =(UserAdmin)admin;
			request.getSession().setAttribute("userAdmin",userAdmin);
		}
		else {
			ServiceAdmin serviceAdmin=(ServiceAdmin)admin;
			request.getSession().setAttribute("serviceAdmin", serviceAdmin);
		}
		*/
>>>>>>> c77741e062caf1ee0eae193487ee385b7aedde43
		request.getSession().setAttribute("admin", admin);
		return modelAndView;
	}
}
