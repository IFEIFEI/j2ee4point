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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/artistUpdateInfo")
	public ModelAndView artistUpdateInfo(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
  
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("phoneNumber");
		String education=request.getParameter("education");
		String description=request.getParameter("description");
		String imageURL=request.getParameter("imageURL");
		
		artistService.updateArtistInfo(artist, userName, email, phoneNumber, education, description, imageURL);
		
		ModelAndView modelAndView=new ModelAndView("artistCenter");
		
       //不是很清楚有没有 artist 这个Attribute
		model.addAttribute("user", artist);
		request.getSession().setAttribute("user", artist);
		return modelAndView;
	}
	
	
	//查询艺术家的个人信息
	@RequestMapping("/artistGetInfo")
	public ModelAndView artistGetInfo(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
		ModelAndView modelAndView =new ModelAndView("artistCenter");
		//不是很清楚有没有 artist 这个Attribute
		request.getSession().setAttribute("user", artist);
		return modelAndView;
	}
	
	//查询艺术家的地址信息
	@RequestMapping("/artistGetAddress")
	public ModelAndView userGetAddress(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
		Address address=artist.getAddresses().get(0);
		ModelAndView modelAndView =new ModelAndView("artistAddress");
		modelAndView.addObject("address", address);
		return modelAndView;
	}
	
	//获取所有的购买订单
	@RequestMapping("/artistGetAllOrder")
	public ModelAndView artistGetAllOrder(HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("user");
		List<Order> orderList=orderService.findAllOrderByUser(user);
		ModelAndView modelAndView =new ModelAndView("artistRecord");
		modelAndView.addObject("orderList", orderList);
		return modelAndView;
	}
	
	//获取全部的艺术品
	@RequestMapping("/artistGetAllArtwork")
	public ModelAndView artistGetAllArtwork(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
		List<Artwork> artworkList=artist.getShop().getArtworks();
		ModelAndView modelAndView =new ModelAndView("artistArtwork");
		modelAndView.addObject("artworkList", artworkList);
		return modelAndView;
	}
	
	//更新艺术家的地址信息
	@RequestMapping("/artistUpdateAddress")
	public ModelAndView artistUpdateAddress(HttpServletRequest request,Model model){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
  
		String country=request.getParameter("country");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String detailedAddress=request.getParameter("detailedAddress");
		
		Address address=new Address(country,province,city,detailedAddress);
		
		artistService.updateArtistAddress(artist, address);
		ModelAndView modelAndView=new ModelAndView("artistAddress");
		
       //不是很清楚有没有 artist 这个Attribute
		model.addAttribute("user", artist);
		request.getSession().setAttribute("user", artist);
		return modelAndView;
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
			
	    //不是很清楚有没有 artist 这个Attribute
		model.addAttribute("user", artist);
		request.getSession().setAttribute("user", artist);
		return modelAndView;
	}
}
