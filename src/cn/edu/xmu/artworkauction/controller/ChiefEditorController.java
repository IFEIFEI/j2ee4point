package cn.edu.xmu.artworkauction.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.edu.xmu.artworkauction.service.ChiefEditorService;
import cn.edu.xmu.artworkauction.service.EditorService;

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
}
