package cn.edu.xmu.artworkauction.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.ArtNewsDisplayService;
import cn.edu.xmu.artworkauction.service.ChiefEditorService;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.artworkauction.utils.Constants;
import javafx.scene.chart.PieChart.Data;

/**
 * The class ChiefEditorController is to receive requests 
 * which are sended from the chiefEditor's pages and 
 * invokes the class {@link ChiefEditorService}'s methods and the 
 * class {@link ArtNewsDisplayService}'s methods. 
 * @author XiaWenSheng
 * 
 * */
@Controller
public class ChiefEditorController 
{
	@Resource
	private ChiefEditorService chiefEditorService;
	
	@Resource
	private ArtNewsDisplayService artNewsDisplayService;
	/*
	@ResponseBody
	@RequestMapping("/jstest")
	public String test(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("successed to receive the ajax json");
		String title=request.getParameter("jstest");
		JSONObject root=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		root.put("title", "title");
		root.put("article", "article");
		root.put("type", "type");
		System.out.println(title);
		System.out.println(root);
		chiefEditorServiceImpl.printTest();
		return root.toString();
	}
	@RequestMapping("getCheckPendingList")
	public ModelAndView getCheckPendingList(HttpServletRequest request,Model model)
	{
		List<ArtNews> artNewsList=chiefEditorServiceImpl.getUncheckedArtNews();
		request.getSession().setAttribute("CheckPendingList", artNewsList);
		ModelAndView modelAndView =new ModelAndView("ChiefEditor/ChiefEditor-CheckPendingList");
		return modelAndView;
	}
	@RequestMapping("getHistoryList")
	public void getHistoryList(HttpServletRequest request)
	{
		ChiefEditor chiefEditor=(ChiefEditor)request.getAttribute("chiefEditor");
		List<ArtNews> artNewsList=chiefEditorServiceImpl.getMyCheckedHistory(chiefEditor);	
		request.getSession().setAttribute("CheckedAdvList", artNewsList);
	}*/
	/*
	 * @checkArtNews JSON
	 * @param artNewsId
	 * @param state
	 * @session chiefEditor
	 */
	/*
	@ResponseBody
	@RequestMapping("checkArtNews")
	public String checkArtNews(HttpServletRequest request,HttpServletResponse response)
	{
		String artNewsId=request.getParameter("artNewsId");
		String state=request.getParameter("statw");
		ChiefEditor chiefEditor=(ChiefEditor)request.getAttribute("chiefEditor");
		if(chiefEditor!=null)
		{
			JSONObject data=new JSONObject();
			chiefEditorServiceImpl.saveArtNewsState(Integer.parseInt(artNewsId), state, chiefEditor);
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
	*/
	/**
	 * The method approveArtNews is to approve the artNews
	 * (may be change the artNews's content)so that the artNews's
	 * state will change from "underApproval" to "approved". 
	 * @param request
	 * @return modelAndView
	 */
	@RequestMapping("approveArtNews")
	public ModelAndView approveArtNews(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		String summary=request.getParameter("adv_dis");
		String content=request.getParameter("ueditor");
		ArtNews artNews=artNewsDisplayService.getArtNewsById(artNewsId);
		ChiefEditor chiefEditor=(ChiefEditor)request.getSession().getAttribute("user");
		artNews.setChiefEditor(chiefEditor);
		chiefEditorService.approveArtNews(artNews, title, type, summary, content);
		ModelAndView modelAndView=getCheckPendingList(request);
		return modelAndView;
	}
	/**
	 * The method disapproveArtNews is to disapprove the artNews
	 * so that the artNews's state is changed from "underApproval"
	 * to "disapproved" and the editor can edit it again. 
	 * @param request
	 * @return modelAndView
	 */
	@RequestMapping("disapproveArtNews")
	public ModelAndView disapproveArtNews(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		ArtNews artNews=artNewsDisplayService.getArtNewsById(artNewsId);
		ChiefEditor chiefEditor=(ChiefEditor)request.getSession().getAttribute("user");
		artNews.setChiefEditor(chiefEditor);
		chiefEditorService.disapproveArtNews(artNews);
		ModelAndView modelAndView=getCheckPendingList(request);
		return modelAndView;
	}
	/**
	 * The method 
	 * @param request
	 * @return
	 */
	@RequestMapping("getCheckPendingList")
	public ModelAndView getCheckPendingList(HttpServletRequest request) {
		List<ArtNews> artNewsList=artNewsDisplayService.
				getArtNewsByState(Constants.UNDERAPPROVAL);
		ModelAndView modelAndView =new ModelAndView("ChiefEditor/checkpendingList");
		modelAndView.addObject("checkpendingList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getArtNewsByChiefEditor")
	public ModelAndView getArtNewsByChiefEditor(HttpServletRequest request) {
		ChiefEditor chiefEditor=(ChiefEditor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=chiefEditorService.getArtNewsByChiefEditor(chiefEditor);
		ModelAndView modelAndView=new ModelAndView("ChiefEditor/auditArtNewsHistoryList");
		modelAndView.addObject("artNewsList",artNewsList);
		return modelAndView;
	}
}
