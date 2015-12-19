package cn.edu.xmu.artworkauction.service;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
/**
 * EditorService
 * @author Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng 12/13
 */
public interface EditorService 
{
	public ArtNews saveDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,String type);
	public List<ArtNews> getAllDraftByEditor(Editor editor);
	public ArtNews submitDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor,String type);
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor);
}
