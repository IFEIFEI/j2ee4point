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
import java.util.stream.Collectors;

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

import cn.edu.xmu.artworkauction.service.ArtistService;
import cn.edu.xmu.artworkauction.service.ArtworkService;
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
	@Resource
	private ArtworkService artworkService;

	@RequestMapping("/artistUpdateInfo")
	public ModelAndView artistUpdateInfo(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			String email=request.getParameter("email");
			String userName=request.getParameter("userName");
			String phoneNumber=request.getParameter("phoneNumber");
			String education=request.getParameter("education");
			String description=request.getParameter("description");
			
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
	        /** 构建文件保存的目录* */
	        String logoPathDir = "/artist/image/upload/"
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
			
			artistService.updateArtistInfo(artist, userName, email, phoneNumber, education, description, imageURL);
			
			request.getSession().setAttribute("user", artist);
			
			return new ModelAndView("artistCenter");
		}
		return new ModelAndView("artistCenter");
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
	@RequestMapping("/artistGetAddress")
	public ModelAndView userGetAddress(HttpServletRequest request,HttpServletResponse response){
		
		Artist artist=(Artist)request.getSession().getAttribute("user");
		
		if(artist!=null)
		{
			List<Address> addresses=artist.getAddresses();
			Address address=addresses.isEmpty()?null:addresses.get(0);
			request.getSession().setAttribute("address", address);
			return new ModelAndView("artistAddress");
		}
		else
		{
			return new ModelAndView("login");
		}
	}
	
	//获取所有的购买订单
	@RequestMapping("/artistGetAllOrder")
	public ModelAndView artistGetAllOrder(HttpServletRequest request,Model model){
		User user=(User)request.getSession().getAttribute("user");
		List<Order> orderList=orderService.findAllOrderByUser(user);
		request.getSession().setAttribute("orderList", orderList);
		ModelAndView modelAndView =new ModelAndView("artistRecord");
		return modelAndView;
	}
	
	//获取全部的艺术品
	@RequestMapping("/artistGetAllArtwork")
	public ModelAndView artistGetAllArtwork(HttpServletRequest request,Model model){
		Artist artist=(Artist)request.getSession().getAttribute("user");
		List<Artwork> artworkList=(artworkService.getAllArtworkByArtist(artist.getId().toString()))
				.stream()
				.filter(a->a.getInventory()!=0)
				.collect(Collectors.toList());
		request.getSession().setAttribute("artworkList", artworkList);
		
		ModelAndView modelAndView =new ModelAndView("artistArtwork");
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
			
			Address address=artist.getAddresses().isEmpty()?new Address():artist.getAddresses().get(0);
			address.setUser(artist);
			address.setCountry(country);
			address.setProvince(province);
			address.setCity(city);
			address.setDetailedAddress(detailedAddress);			
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
        
		String description=request.getParameter("description");
		
		Artwork artwork=new Artwork(artist.getRealName(),name,theme,price,type,material,size,createTime,imageURL,description);
		
		artistService.addArtwork(artist, artwork);
		ModelAndView modelAndView=new ModelAndView("artistArtwork");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("deleteMyArtwork")
	public String deleteMyArtwork(HttpServletRequest request)
	{
		List<Artwork> artworks;
		String artworkId=request.getParameter("artworkId");
		System.out.println(artworkId);
		artworks=((List<Artwork>)request.getSession()
				.getAttribute("artworkList"))
				.stream()
				.filter(a->a.getId()!=Integer.parseInt(artworkId))
				.collect(Collectors.toList());
		request.getSession().setAttribute("artworkList", artworks);	
		JSONObject root=new JSONObject();
		if(artistService.deleteOneArtwork(artworkId))
		{
			root.put("state", "1");
			return root.toString();
		}
		root.put("state", "0");
		return root.toString();
	}
}
