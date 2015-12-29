package cn.edu.xmu.artworkauction.service;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
/**
 * EditorService
 * @author Dany ifeifei@stu.xmu.edu.cn
 * Modified By XiaWenSheng 12/26
 */
public interface EditorService 
{
	public ArtNews saveDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,
			String type,String startTime,String endTime,String imageURL,String summary,String order,String columnID,String position);
	public List<ArtNews> getAllDraftByEditor(Editor editor);
	public ArtNews submitDraft(String title,String content,Date createTime,Date editTime,String state,Editor editor ,
			String type,String startTime,String endTime,String imageURL,String summary,String order,String columnID,String position);
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllCommittedArtNewsByEditor(Editor editor);
	public Map getArtNewsAllDetailById(String artNewsId);
	public void updateDraft(ArtNews artNews,String title,String type,String summary,String content,String state);
	public List<ArtNews> getAllUnderApprovalArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllCheckedArtNewsByEditor(Editor editor);
}
