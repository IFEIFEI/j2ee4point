/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.service.ArtNewsDisplayService;

/**
 * The class ArtNewsController is to receive the requests which are 
 *  about the artNews and invokes the class {@link ArtNewsDisplayService}' methods.
 * @author XiaWenSheng
 */
@Controller
public class ArtNewsController {
	@Resource
	private ArtNewsDisplayService artNewsDisplayService;
	
	/**
	 * The method getTodayArtNews is to get the today's artNews from database.
	 * @param request
	 * @return modelAndView
	 */
	@RequestMapping("getTodayArtNews")
	public ModelAndView getTodayArtNews(HttpServletRequest request) {
		String columnID=request.getParameter("columnID");
		List<ArtNews> artNewsList=artNewsDisplayService.getTodayArtNews(columnID);
		ModelAndView modelAndView=new ModelAndView("ArtNews/"+columnID+"NewsList");
		modelAndView.addObject("artNewsList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getArtNewsDetailById is to get the artNews and the artNewsContent from
	 * database by artNewsId which is sended from the page.
	 * @param request
	 * @return modelAndView
	 */
	@RequestMapping("getArtNewsDetailById")
	public ModelAndView getArtNewsDetailById(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		Map map=artNewsDisplayService.getArtNewsDetailById(artNewsId);
		ArtNewsContent artNewsContent=(ArtNewsContent)map.get("artNewsContent");
		ArtNews artNews=(ArtNews)map.get("artNews");
		ModelAndView modelAndView=new ModelAndView("ArtNews/artNewsDetail");
		modelAndView.addObject("artNews",artNews);
		modelAndView.addObject("artNewsContent",artNewsContent);
		return modelAndView;
	}
	
	/**
	 * The method deleteArtNewsDetailById is to delete the artNews and the artNewsContent
	 * and the dateAndPosition which are associated with the artNews by the artNewsId. 
	 * @param request
	 * @return modelAndView
	 */
	@RequestMapping("deleteArtNewsById")
	public ModelAndView deleteArtNewDetailById(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		artNewsDisplayService.deleteArtNewsById(artNewsId);
		ModelAndView modelAndView=new ModelAndView("index");
		return modelAndView;
	}
}
