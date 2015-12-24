/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import cn.edu.xmu.artworkauction.service.ArtistService;
import cn.edu.xmu.artworkauction.service.OrderService;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.Artwork;
import cn.edu.xmu.artworkauction.entity.Order;
import cn.edu.xmu.artworkauction.entity.User;



/**
 * @author Yu
 *
 */
@Controller
public class ArtistController {

	@Resource
	private ArtistService artistService;
	@Resource
	private OrderService orderService;
	
	@ResponseBody
	@RequestMapping("/artistUpdateInfo")
	public String artistUpdateInfo(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			String email=request.getParameter("email");
			String userName=request.getParameter("userName");
			String phoneNumber=request.getParameter("phoneNumber");
			String education=request.getParameter("education");
			String description=request.getParameter("description");
			String imageURL=request.getParameter("imageURL");
			
			artistService.updateArtistInfo(artist, userName, email, phoneNumber, education, description, imageURL);
			
			request.getSession().setAttribute("user", artist);
			
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
	
	
	//查询艺术家的个人信息
	@ResponseBody
	@RequestMapping("/artistGetInfo")
	public String artistGetInfo(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			request.getSession().setAttribute("user", artist);
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
	
	//查询艺术家的地址信息
	@ResponseBody
	@RequestMapping("/artistGetAddress")
	public String userGetAddress(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			Address address=artist.getAddresses().get(0);
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
	
	//获取所有的购买订单
	@RequestMapping("/artistGetAllOrder")
	public ModelAndView artistGetAllOrder(HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("user");
		List<Order> orderList=orderService.findAllOrderByUser(user);
		request.getSession().setAttribute("orderList", orderList);
		ModelAndView modelAndView =new ModelAndView("");
		return modelAndView;
	}
	
	//获取全部的艺术品
	@RequestMapping("/artistGetAllArtwork")
	public ModelAndView artistGetAllArtwork(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
		List<Artwork> artworkList=artist.getShop().getArtworks();
		request.getSession().setAttribute("artworkList", artworkList);
		
		ModelAndView modelAndView =new ModelAndView("");
		modelAndView.addObject("artworkList", artworkList);
		return modelAndView;
	}
	
	//更新艺术家的地址信息
	@ResponseBody
	@RequestMapping("/artistUpdateAddress")
	public String artistUpdateAddress(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			String country=request.getParameter("country");
			String province=request.getParameter("province");
			String city=request.getParameter("city");
			String detailedAddress=request.getParameter("detailedAddress");
			
			Address address=new Address(country,province,city,detailedAddress);
			
			artistService.updateArtistAddress(artist, address);
			request.getSession().setAttribute("user", artist);
			
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
	
	//艺术家上传艺术品
	@RequestMapping("/artistAddartwork")
	public ModelAndView artistAddartwork(HttpServletRequest request,Model model) throws ParseException{
			
		Artist artist=(Artist)request.getSession().getAttribute("user");
	  
		String name=request.getParameter("name");
		String theme=request.getParameter("theme");
		Double price=Double.valueOf(request.getParameter("price"));
		String type=request.getParameter("type");
		String material=request.getParameter("material");
		String size=request.getParameter("size");
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		Date createTime=formatter.parse(request.getParameter("createTime"));
		
		String imageUrl=request.getParameter("imageUrl");
		String description=request.getParameter("description");
		
		Artwork artwork=new Artwork(artist.getRealName(),name,theme,price,type,material,size,createTime,imageUrl,description);
		
		artistService.addArtwork(artist, artwork);
		ModelAndView modelAndView=new ModelAndView("artistArtwork");
		return modelAndView;
	}
}
