package cn.edu.xmu.artworkauction.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.artworkauction.utils.Constants;

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
	private EditorService editorService;
	@RequestMapping("/saveDraft")
	public ModelAndView saveDraft(HttpServletRequest request)
	{

		String title=request.getParameter("title");
		String type=request.getParameter("type");
		
		String article=request.getParameter("editor");
		Editor editor=new Editor();
		editor.setUserName("Xia");
		//request.getSession().getAttribute("editor");
		ArtNews artNews= editorService.saveDraft(title, article,new Date(),new Date(), Constants.UNCOMMITTED, editor,type);
		ModelAndView modelAndView=new ModelAndView("draftTest");
		modelAndView.addObject("artNews", artNews); 
		return modelAndView;
	}
	@RequestMapping("/submitNews")
	public void submitNews(HttpServletRequest request)
	{
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String article=request.getParameter("article");
		request.getSession().getAttribute("editor");
		editorService.submit(title, article,new Date(),new Date(), Constants.UNDERAPPROVAL, editor,type);
	}
}
