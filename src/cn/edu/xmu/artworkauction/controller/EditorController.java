package cn.edu.xmu.artworkauction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTML;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.config.*;

/*
 * EditorController 采编人员的控制器
 * @author Dany ifeifei@stu.xmu.edu.cn
 */

@Controller
public class EditorController 
{
	private Editor editor;
	private EditorService editorService;
	@RequestMapping("/saveDraft")
	public void saveDraft(HttpServletRequest request)
	{
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String article=request.getParameter("article");
		Integer checked=2;
		Integer checkedout=0;
		request.getSession().getAttribute("editor");
		editorService.saveDraft(title, article,new Date(),new Date(), checked,checkedout, editor,type);
	}
	@RequestMapping("/submitNews")
	public void submitNews(HttpServletRequest request)
	{
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String article=request.getParameter("article");
		Integer checked=0;
		Integer checkedout=0;
		request.getSession().getAttribute("editor");
		editorService.submit(title, article,new Date(),new Date(), checked,checkedout, editor,type);
	}
}
