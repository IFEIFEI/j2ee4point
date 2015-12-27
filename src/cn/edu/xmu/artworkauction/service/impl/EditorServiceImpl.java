package cn.edu.xmu.artworkauction.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.swing.text.html.HTML;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.dao.ArtNewsDAO;
import cn.edu.xmu.artworkauction.dao.EditorDAO;

import org.springframework.transaction.annotation.Transactional;
import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.artworkauction.utils.Constants;

/**
 * 
 * @author  Dany ifeifei@stu.xmu.edu.cn</br>
 * Modified By XiaWenSheng 12/26
 */
@Transactional
@Service("editorService")
public class EditorServiceImpl implements EditorService
{
    private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private EditorDAO editorDAO;
	@Resource(name="editorDAO")
	public void setEditorDAO(EditorDAO editorDAO) {
		this.editorDAO=editorDAO;
	}
	@Override
	public ArtNews saveDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,
			String type,String startTime,String endTime,String imageURL,String summary,String order,String columnID,String position)
	{
		ArtNewsContent artNewsContent=new ArtNewsContent();
		artNewsContent.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    try {
			Date startDate = sdf.parse(startTime);
			Date endDate = sdf.parse(endTime);
			if(startDate.after(endDate)) {
				Date cal=startDate;
	            startDate=endDate;
	            endDate=cal;
			}
			long sl=startDate.getTime();
	        long el=endDate.getTime();       
	        long ei=el-sl;           
	        int interval= (int)(ei/(1000*60*60*24));
	        List<DateAndPosition> dateAndPositionList=new ArrayList<DateAndPosition>();
	        ArtNews artNews=new ArtNews(title, createTime, editTime, state, editor,
	    			 type, summary, imageURL);
	        for(int i=0;i<interval;i++) {
	        	startDate.setDate(startDate.getDate()+i);
	        	Date startDate1=new Date(startDate.getYear(),startDate.getMonth(),startDate.getDate());
	        	DateAndPosition dateAndPosition=new DateAndPosition(
	        			startDate1,position,columnID,order);
	        	dateAndPositionList.add(dateAndPosition);
	         }
	        return editorDAO.saveDraft(artNews, artNewsContent,dateAndPositionList);
	       
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
	}
	@Override
	public ArtNews submitDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,
			String type,String startTime,String endTime,String imageURL,String summary,String order,String columnID,String position) {
		ArtNewsContent artNewsContent=new ArtNewsContent();
		artNewsContent.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	    try {
			Date startDate = sdf.parse(startTime);
			Date endDate = sdf.parse(endTime);
			if(startDate.after(endDate)) {
				Date cal=startDate;
	            startDate=endDate;
	            endDate=cal;
			}
			long sl=startDate.getTime();
	        long el=endDate.getTime();       
	        long ei=el-sl;           
	        int interval= (int)(ei/(1000*60*60*24));
	        List<DateAndPosition> dateAndPositionList=new ArrayList<DateAndPosition>();
	        ArtNews artNews=new ArtNews(title, createTime, editTime, state, editor,
	    			 type, summary, imageURL);
	        for(int i=0;i<interval;i++) {
	        	startDate.setDate(startDate.getDate()+i);
	        	Date startDate1=new Date(startDate.getYear(),startDate.getMonth(),startDate.getDate());
	        	DateAndPosition dateAndPosition=new DateAndPosition(
	        			startDate1,position,columnID,order);
	        	dateAndPositionList.add(dateAndPosition);
	         }
	        return editorDAO.submitDraft(artNews, artNewsContent,dateAndPositionList);
	       
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
	}

	public List<ArtNews> getAllDraftByEditor(Editor editor) {
		return editorDAO.getAllDraftByEditor(editor);
	}
	@Override
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		return editorDAO.getAllApprovedArtNewsByEditor(editor);
	}
	@Override
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		return editorDAO.getAllDisApprovedArtNewsByEditor(editor);
	}
	@Override
	public List<ArtNews> getAllCommittedArtNewsByEditor(Editor editor) {
		// TODO Auto-generated method stub
		return editorDAO.getAllCommittedArtNewsByEditor(editor);
	}
	@Override
	public Map getArtNewsAllDetailById(String artNewsId) {
		// TODO Auto-generated method stub
		return editorDAO.getArtNewsAllDetailById(artNewsId);
	}
	@Override
	public void updateDraft(ArtNews artNews, String title, String type, String summary, String content, String state) {
		// TODO Auto-generated method stub
		 editorDAO.updateDraft(artNews,title,type,summary,content,state);
	}	
}
