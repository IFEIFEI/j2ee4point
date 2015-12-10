package cn.edu.xmu.artworkauction.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;

/**
 * EditorController 
 * @author Dany ifeifei@stu.xmu.edu.cn
 *
 */

@Controller
public class EditorController 
{
	private Editor editor;
	@Resource
	private EditorService editorServiceImpl;
	@RequestMapping("/saveDraft")
	public void saveDraft(HttpServletRequest request)
	{
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String article=request.getParameter("article");
		Integer checked=2;
		Integer checkedout=0;
		request.getSession().getAttribute("editor");
		editorServiceImpl.saveDraft(title, article,new Date(),new Date(), checked,checkedout, editor,type);
	}
	@RequestMapping("/submitNews")
	public void submitNews(HttpServletRequest request)
	{
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String article=request.getParameter("article");
		Integer checked=0;
		Integer checkedout=0;
		//editor=(Editor)request.getSession().getAttribute("editor");
		editor=new Editor();
		editorServiceImpl.submit(title, article,new Date(),new Date(), checked,checkedout, editor,type);
	}
}
