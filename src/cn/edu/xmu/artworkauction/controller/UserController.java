/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import cn.edu.xmu.artworkauction.service.UserService;
import cn.edu.xmu.artworkauction.service.OrderService;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artist;

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
	
	@RequestMapping("/userUpdateInfo")
	public ModelAndView userUpdateInfo(HttpServletRequest request,Model model){
		
		User user=(User)request.getSession().getAttribute("user");
		

		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("phoneNumber");
			
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
	        /** 构建文件保存的目录* */
	        String logoPathDir = "/Artnews/image/upload/"
	                + dateformat.format(new Date());
	        /** 得到文件保存目录的真实路径* */
	        String logoRealPathDir = request.getSession().getServletContext()
	                .getRealPath(logoPathDir);
	        /** 根据真实路径创建目录* */
	        File logoSaveFile = new File(logoRealPathDir);
	        if (!logoSaveFile.exists())
	            logoSaveFile.mkdirs();
	        /** 页面控件的文件流* */
	        MultipartFile multipartFile = multipartRequest.getFile("thefile");
	        /** 获取文件的后缀* */
	        String suffix = multipartFile.getOriginalFilename().substring(
	                multipartFile.getOriginalFilename().lastIndexOf("."));
	        /** 使用UUID生成文件名称* */
	        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
	        
	        /** 拼成完整的文件保存路径加文件* */
	        String imageURL1 = logoRealPathDir + File.separator + logImageName;
	        File file = new File(imageURL1);
	        String imageURL=logoRealPathDir+logImageName;
	        try {
	            multipartFile.transferTo(file);
	        } catch (IllegalStateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			userService.updateUserInfo(user, email, userName, phoneNumber,imageURL);
			request.getSession().setAttribute("user", user);
			
			ModelAndView modelAndView;
			modelAndView=new ModelAndView("userCenter");
			model.addAttribute("user", user);
			return modelAndView;
			
	}
	
	@ResponseBody
	@RequestMapping("/userUpdateAddress")
	public String userUpdateAddress(HttpServletRequest request,Model model){
		
		User user=(User)request.getSession().getAttribute("user");
		
			String country=request.getParameter("country");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String detailedAddress=request.getParameter("detailedAddress");
			
			Address address=user.getAddresses().isEmpty()?new Address():user.getAddresses().get(0);
			address.setCountry(country);
			address.setProvince(province);
			address.setCity(city);
			address.setDetailedAddress(detailedAddress);
			address.setUser(user);
			
			userService.updateUserAddress(user, address);
			request.getSession().setAttribute("user", user);
			
			JSONObject data=new JSONObject();
			data.put("state",1);
			return data.toString();
		
	}
	
	//查询自己所有的购买记录
	@RequestMapping("/userGetAllOrder")
	public ModelAndView userGetAllOrder(HttpServletRequest request,Model model){
		
		User user=(User)request.getSession().getAttribute("user");
		
			List<Order> orderList=orderService.findAllOrderByUser(user);
			request.getSession().setAttribute("orderList", orderList);
			
			ModelAndView modelAndView;
			modelAndView=new ModelAndView("userRecord");
			return modelAndView;
		
	}
	
	//查询用户的具体信息
	@RequestMapping("/userGetInfo")
	public ModelAndView userGetInfo(HttpServletRequest request,Model model){
		
		User user=(User)request.getSession().getAttribute("user");
		
		request.getSession().setAttribute("user", user);
			
		ModelAndView modelAndView;
		modelAndView=new ModelAndView("userCenter");
		return modelAndView;
	}
	
	//查询用户的地址信息
	@RequestMapping("/userGetAddress")
	public ModelAndView userGetAddress(HttpServletRequest request,HttpServletResponse response){
		
		User user=(User)request.getSession().getAttribute("user");
		
		if(user!=null)
		{
		
			Address address;
			
			if(user.getAddresses()!=null)
			{
				address=user.getAddresses().get(0);
				request.getSession().setAttribute("address", address);
				ModelAndView modelAndView;
				modelAndView=new ModelAndView("userAddress");
				return modelAndView;
			}
			else 
			{
				request.getSession().setAttribute("address", null);
				ModelAndView modelAndView;
				modelAndView=new ModelAndView("userAddress");
				return modelAndView;
			}
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	
}
