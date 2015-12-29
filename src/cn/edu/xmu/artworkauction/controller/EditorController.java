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
import cn.edu.xmu.artworkauction.utils.Login;

/**
 * The class EditorController  is to receive the requests 
 * which are sended from the editor's pages and invokes
 * the class {@link ArtNewsDisplayService}'s methods and the 
 * class {@link EditorService}'s methods.
 * @author Dany ifeifei@stu.xmu.edu.cn<br>
 * @version 2.0<br>
 * Modified By XiaWenSheng 12/26
 */
@Controller
public class EditorController 
{
	@Resource
	private ArtNewsDisplayService artNewsDisplayService;
	@Resource
	private EditorService editorService;
	/**
	 * The method saveDraft is to save the draft which are edited by
	 * the editor.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("/saveDraft")
	public ModelAndView saveDraft(HttpServletRequest request)
	{ 
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String datehour=dateformat.format(new Date());
        String logoPathDir = "/ArtNews/image/upload/"
                + datehour;
        String imageURL="ArtNews/image/upload/"+datehour+"/";
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        File logoSaveFile = new File(logoRealPathDir);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        MultipartFile multipartFile = multipartRequest.getFile("thefile");
        String suffix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf("."));
        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
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
		ModelAndView modelAndView=new ModelAndView("Editor/artNewsPreview");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		return modelAndView;
	}
	/**
	 * The method submitDraft is to submit the draft which are edited by the editor.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("/submitDraft")
	public ModelAndView submitDraft(HttpServletRequest request) {
		String title=request.getParameter("title");
		String type=request.getParameter("Advertorialtype");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
        String datehour=dateformat.format(new Date());
        String logoPathDir = "/ArtNews/image/upload/"
                + datehour;
        String imageURL="ArtNews/image/upload/"+datehour+"/";
        String logoRealPathDir = request.getSession().getServletContext()
                .getRealPath(logoPathDir);
        File logoSaveFile = new File(logoRealPathDir);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        MultipartFile multipartFile = multipartRequest.getFile("thefile");
        String suffix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf("."));
        String logImageName = UUID.randomUUID().toString() + suffix;// 构建文件名称
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
		ModelAndView modelAndView=new ModelAndView("Editor/artNewsPreview");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		return modelAndView;
	}
	/**
	 * The method getAllDraftByEditor is to get all the draft from 
	 * database and return the draftList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllDraftByEditor")
	public ModelAndView getAllDraftByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDraftByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getAllApprovedArtNewsByEditor is to  get all the
	 * artNews which are approved by the chiefEditor from the database and
	 * return the draftList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllApprovedArtNewsByEditor")
	public ModelAndView getAllApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getAllDisApprovedArtNewsByEditor is to get all the
	 * artNews which are disapproved by the chiefEditor from the database and
	 * return the draftList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllDisApprovedArtNewsByEditor")
	public ModelAndView getAllDisApprovedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllDisApprovedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/draftList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getAllCommittedArtNewsByEditor is to get all committed
	 * artNews from database and return the submitHistoryList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllCommittedArtNewsByEditor")
	public ModelAndView getAllCommittedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllCommittedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/submitHistoryList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getArtNewsAllDetailByArtNewsId is to get the artNews all detail info
	 * which include the artNewsContent and the artNews's dateAndPositionList and
	 * return the updateArteNewsList page
	 * @param request
	 * @return modelAndView
	 */
	@Login
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
	/**
	 * The method editArtNews is to return the editArtNews page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("editArtNews")
	public ModelAndView editArtNews(HttpServletRequest request) {
		ModelAndView modelAndView =new ModelAndView("Editor/editArtNews");
		return modelAndView;
	}
	/**
	 * The method updateDraft is to update the draft which are saved in the database
	 * and return the draftList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
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
	/**
	 * The method editorIndex is to return the editorIndex page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("editorIndex")
	public ModelAndView editorIndex(HttpServletRequest request) {
		return new ModelAndView("Editor/editorIndex");
	}
	/**
	 * The method editNewArticle is to return the editArtNews page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("editNewArticle")
	public ModelAndView editNewArticle(HttpServletRequest request) {
		return new ModelAndView("Editor/editArtNews");
	}
	/**
	 * The method getAllUnderApprovalArtNewsByEditor is to get all the 
	 * artNews which hasn't been checked by the editor and return the 
	 * underApprovalArtNewsList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllUnderApprovalArtNewsByEditor")
	public ModelAndView getAllUnderApprovalArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllUnderApprovalArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/underApprovalArtNewsList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method getAllUnderApprovalArtNewsByEditor is to get all the 
	 * artNews which has been checked by the editor and return the 
	 * underApprovalArtNewsList page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("getAllCheckedArtNewsByEditor")
	public ModelAndView getAllCheckedArtNewsByEditor(HttpServletRequest request) {
		Editor editor=(Editor)request.getSession().getAttribute("user");
		List<ArtNews> artNewsList=editorService.getAllCheckedArtNewsByEditor(editor);
		ModelAndView modelAndView =new ModelAndView("Editor/checkedArtNewsList");
		modelAndView.addObject("draftList", artNewsList);
		return modelAndView;
	}
	/**
	 * The method previedArtNews is to preview the artNews and return the 
	 * artNewsPreview page.
	 * @param request
	 * @return modelAndView
	 */
	@Login
	@RequestMapping("artNewsPreviewByArtNewsId")
	public ModelAndView previewArtNews(HttpServletRequest request) {
		String artNewsId=request.getParameter("artNewsId");
		Map map=editorService.getArtNewsAllDetailById(artNewsId);
		ArtNewsContent artNewsContent=(ArtNewsContent)map.get("artNewsContent");
		ArtNews artNews=(ArtNews)map.get("artNews");
		List<DateAndPosition> dateAndPositionList=(List<DateAndPosition>)map.get("dateAndPositionList");
		User user=(User)request.getSession().getAttribute("user");
		ModelAndView modelAndView;
		if(user.getUserType().equals("editor"))
			modelAndView =new ModelAndView("Editor/artNewsPreview");
		else
			modelAndView=new ModelAndView("ChiefEditor/artNewsPreview");
		modelAndView.addObject("artNews", artNews);
		modelAndView.addObject("artNewsContent", artNewsContent);
		modelAndView.addObject("dateAndPositionList", dateAndPositionList);
		return modelAndView;
		
	}
	
}
