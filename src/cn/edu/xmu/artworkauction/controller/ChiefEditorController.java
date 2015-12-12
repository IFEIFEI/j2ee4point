package cn.edu.xmu.artworkauction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ChiefEditorController
 * @author Dany ifeifei@stu.xmu.edu.cn
 * */
@Controller
public class ChiefEditorController 
{
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
		return root.toString();
	}
}
