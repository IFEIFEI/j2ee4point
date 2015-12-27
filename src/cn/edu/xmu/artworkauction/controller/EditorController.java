package cn.edu.xmu.artworkauction.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.ArtNewsDisplayService;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.artworkauction.utils.Constants;

/**
 * EditorController 
 * @author Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng 12/26
 */

@Controller
public class EditorController 
{
	@Resource
	private ArtNewsDisplayService artNewsDisplayService;
	@Resource
	private EditorService editorService;
	@RequestMapping("/saveDraft")
	public ModelAndView saveDraft(HttpServletRequest request)
	{
		//get the startTime and the endTime and  
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        String datehour=dateformat.format(new Date());
        String logoPathDir = "/ArtNews/image/upload/"
                + datehour;
        String imageURL="ArtNews/image/upload/"+datehour+"/";
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
        imageURL+=logImageName;
        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String summary=request.getParameter("adv_dis");
		String startTime=request.getParameter("startDate");
		String endTime=request.getParameter("endDate");
		String position=request.getParameter("position");
		String priority=request.getParameter("article_pos");
		String content=request.getParameter("ueditor");
		Editor editor=(Editor)request.getSession().getAttribute("user");
		String columnID=request.getParameter("columnID");
		ArtNews artNews=editorService.saveDraft(title, content, new Date(), new Date(), Constants.UNCOMMITTED, editor, type, startTime, endTime,
				imageURL, summary, priority, columnID,position);
		ArtNewsContent artNewsContent=artNews.getArtNewsContent();
		ModelAndView modelAndView=new ModelAndView("Editor/preview");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		return modelAndView;
	}
	@RequestMapping("/submitDraft")
	public ModelAndView submitDraft(HttpServletRequest request) {
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        /** 构建文件保存的目录* */
        String datehour=dateformat.format(new Date());
        String logoPathDir = "/ArtNews/image/upload/"
                + datehour;
        String imageURL="ArtNews/image/upload/"+datehour+"/";
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
        imageURL+=logImageName;
        try {
            multipartFile.transferTo(file);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		String summary=request.getParameter("adv_dis");
		String startTime=request.getParameter("startDate");
		String endTime=request.getParameter("endDate");
		String position=request.getParameter("position");
		String priority=request.getParameter("article_pos");
		String content=request.getParameter("ueditor");
		Editor editor=(Editor)request.getSession().getAttribute("user");
		String columnID=request.getParameter("columnID");
		ArtNews artNews=editorService.submitDraft(title, content, new Date(), new Date(), Constants.UNCOMMITTED, editor, type, startTime, endTime,
				imageURL, summary, priority, columnID,position);
		ArtNewsContent artNewsContent=artNews.getArtNewsContent();
		ModelAndView modelAndView=new ModelAndView("Editor/preview");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		return modelAndView;
	}
	@RequestMapping("getAllDraftByEditor")
	public ModelAndView getAllDraftByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDraftByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getAllApprovedArtNewsByEditor")
	public ModelAndView getAllApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getAllDisApprovedArtNewsByEditor")
	public ModelAndView getAllDisApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDisApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getAllCommittedArtNewsByEditor")
	public ModelAndView getAllCommittedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllCommittedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/submitHistoryList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	
	@RequestMapping("getArtNewsAllDetailByArtNewsId")
	public ModelAndView getArtNewsAllDetailByArtNewsId(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		Map map=editorService.getArtNewsAllDetailById(artNewsId);
		ArtNewsContent artNewsContent=(ArtNewsContent)map.get("artNewsContent");
		ArtNews artNews=(ArtNews)map.get("artNews");
		List<DateAndPosition> dateAndPositionList=(List<DateAndPosition>)map.get("dateAndPositionList");
		User user=(User)request.getSession().getAttribute("user");
		ModelAndView modelAndView;
		if(user.getUserType().equals("editor"))
			modelAndView =new ModelAndView("Editor/updateArtNews");
		else
			modelAndView=new ModelAndView("ChiefEditor/auditArtNews");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		modelAndView.addObject("dateAndPositionList", dateAndPositionList);
		return modelAndView;
	}
	
	@RequestMapping("editArtNews")
	public ModelAndView editArtNews(HttpServletRequest request) {
		ModelAndView modelAndView =new ModelAndView("Editor/editArtNews");
		return modelAndView;
	}
	
	@RequestMapping("updateDraft")
	public ModelAndView updateDraft(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		String summary=request.getParameter("adv_dis");
		String content=request.getParameter("ueditor");
		String state=request.getParameter("state");
		ArtNews artNews=artNewsDisplayService.getArtNewsById(artNewsId);
		editorService.updateDraft(artNews,title,type,summary,content,state);
		ModelAndView modelAndView =new ModelAndView("forward:getAllDraftByEditor");
		return modelAndView;
	}
}
