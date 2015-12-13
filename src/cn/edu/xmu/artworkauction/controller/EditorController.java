package cn.edu.xmu.artworkauction.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
 * Modified By XiaWenSheng 12/13
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
		String content=request.getParameter("ueditor");
		Editor editor=(Editor)request.getSession().getAttribute("user");
		ArtNews artNews= editorService.saveDraft(title, content,new Date(),new Date(), Constants.UNCOMMITTED, editor,type);
		request.getSession().setAttribute("artNews", artNews);
		ModelAndView modelAndView=new ModelAndView("editor");
		return modelAndView;
	}
	@RequestMapping("/submitDraft")
	public ModelAndView submitDraft(HttpServletRequest request) {
		String title=request.getParameter("title");
		String type=request.getParameter("type");
		String content=request.getParameter("article");
		Editor editor=(Editor)request.getSession().getAttribute("user");
		Date createTime=((ArtNews)request.getSession().getAttribute("artNews")).getCreateTime();
		ArtNews artNews=editorService.submitDraft(title, content, createTime, new Date(),Constants.UNDERAPPROVAL, editor, type);
		request.getSession().setAttribute("artNews", artNews);
		return new ModelAndView("editor");
	}
	@RequestMapping("getAllDraftByEditor")
	public ModelAndView getAllDraftByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDraftByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getAllApprovedArtNewsByEditor")
	public ModelAndView getAllApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("draftList");
		modelAndView.addObject("approvedArtNewsList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getAllDisApprovedArtNewsByEditor")
	public ModelAndView getAllDisApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDisApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("draftList");
		modelAndView.addObject("approvedArtNewsList", artNewsList);
		return modelAndView;
	}
}
