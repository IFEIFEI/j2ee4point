/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.service.UserService;
import cn.edu.xmu.artworkauction.service.OrderService;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Address;

/**
 * @author  Yu
 *
 */
@Controller
public class UserController {

	@Resource
	private UserService userService;
	@Resource
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping("/userUpdateInfo")
	public String userUpdateInfo(HttpServletRequest request,HttpServletResponse response){
		
		User user=(User)request.getSession().getAttribute("user");
		
		//如果用户已经登录
		if(user!=null)
		{
			String email=request.getParameter("email");
			String userName=request.getParameter("userName");
			String phoneNumber=request.getParameter("phoneNumber");
			JSONObject data=new JSONObject();
			userService.updateUserInfo(user, email, userName, phoneNumber);
			request.getSession().setAttribute("user", user);
			data.put("state",1);
			return data.toString();	
		}
		else
		{
			JSONObject data=new JSONObject();
			data.put("state",0);
			data.put("url","userLoginByUserName");
			return data.toString();
		}	
	}
	
	@ResponseBody
	@RequestMapping("/userUpdateAddress")
	public String userUpdateAddress(HttpServletRequest request,HttpServletResponse response){
		
		User user=(User)request.getSession().getAttribute("user");
		
		if(user!=null)
		{
			String country=request.getParameter("country");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String detailedAddress=request.getParameter("detailedAddress");
			
			Address address=new Address(country,province,city,detailedAddress);
			
			userService.updateUserAddress(user, address);
			request.getSession().setAttribute("user", user);
			
			JSONObject data=new JSONObject();
			data.put("state",1);
			return data.toString();
		}
		else
		{
			JSONObject data=new JSONObject();
			data.put("state",0);
			data.put("url","userLoginByUserName");
			return data.toString();
		}
	}
	
	//查询自己所有的购买记录
	@ResponseBody
	@RequestMapping("/userGetAllOrder")
	public String userGetAllOrder(HttpServletRequest request,HttpServletResponse response){
		
		User user=(User)request.getSession().getAttribute("user");
		//如果已登录
		if(user!=null)
		{
			List<Order> orderList=orderService.findAllOrderByUser(user);
			request.getSession().setAttribute("orderList", orderList);
			
			JSONObject data=new JSONObject();
			data.put("state",1);
			return data.toString();
		}
		else
		{
			JSONObject data=new JSONObject();
			data.put("state",0);
			data.put("url","userLoginByUserName");
			return data.toString();
		}
	}
	
	//查询用户的具体信息
	@ResponseBody
	@RequestMapping("/userGetInfo")
	public String userGetInfo(HttpServletRequest request,HttpServletResponse response){
		User user=(User)request.getSession().getAttribute("user");
		
		if(user!=null)
		{
			request.getSession().setAttribute("user", user);
			
			JSONObject data=new JSONObject();
			data.put("state",1);
			return data.toString();
		}
		else
		{
			JSONObject data=new JSONObject();
			data.put("state",0);
			data.put("url","userLoginByUserName");
			return data.toString();
		}
	}
	
	//查询用户的地址信息
	@ResponseBody
	@RequestMapping("/userGetAddress")
	public String userGetAddress(HttpServletRequest request,HttpServletResponse response){
		
		User user=(User)request.getSession().getAttribute("user");
		
		if(user!=null)
		{
			Address address=user.getAddresses().get(0);
			request.getSession().setAttribute("address", address);
			
			JSONObject data=new JSONObject();
			data.put("state",1);
			return data.toString();
		}
		else
		{
			JSONObject data=new JSONObject();
			data.put("state",0);
			data.put("url","userLoginByUserName");
			return data.toString();
		}

	}
}
