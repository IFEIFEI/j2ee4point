package cn.edu.xmu.artworkauction.service.impl;

import java.util.Date;
import java.util.List;
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
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.service.EditorService;
import cn.edu.xmu.artworkauction.utils.Constants;

/**
 * EditorServiceImpl
 * @author  Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng 12/13
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
	public ArtNews saveDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,String type)
	{
		return editorDAO.saveDraft(new ArtNews(title,content,createTime,editTime,state,editor,type));
	}
	@Override
	public ArtNews submitDraft(String title, String article, Date createTime, Date editTime, String state,
			Editor editor,String type) {
		return editorDAO.submitDraft(new ArtNews(title,article,createTime,editTime,state,editor,type));
	}
	/*
	@Override
	public List<ArtNews> getDraft(Editor editor) 
	{
		List<ArtNews> draftlist=artNewsDAO
				.getUnCheckedArtNews()
				.stream()
				.filter(e->e.getEditor().getId()==editor.getId())
				.collect(Collectors.toList());
		return draftlist;
	}
	*/
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
	
}
