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
import cn.edu.xmu.artworkauction.service.ChiefEditorService;
import cn.edu.xmu.artworkauction.service.EditorService;
import javafx.scene.chart.PieChart.Data;

/**
 * @ChiefEditorController
 * @author Dany ifeifei@stu.xmu.edu.cn
 * */
@Controller
public class ChiefEditorController 
{
	@Resource
	private ChiefEditorService chiefEditorServiceImpl;
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
	}
	/*
	 * @checkArtNews JSON
	 * @param artNewsId
	 * @param state
	 * @session chiefEditor
	 */
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
}
