/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import java.util.List;
import java.util.Map;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;
import cn.edu.xmu.artworkauction.entity.Editor;

/**
 * The interface EditorDAO contains the methods which are
 * about the Editor and is inherited by the class {@link EditorDAO}.
 * @author XiaWenSheng
 *
 */
public interface EditorDAO {
	public ArtNews submitDraft(ArtNews artNews,ArtNewsContent artNewsContent,
			List<DateAndPosition> dateAndPositionList);
	public ArtNews saveDraft(ArtNews artNews,ArtNewsContent artNewsContent,
			List<DateAndPosition> dateAndPositionList);
	public List<ArtNews> getAllDraftByEditor(Editor editor);
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllCommittedArtNewsByEditor(Editor editor);
	public Map getArtNewsAllDetailById(String artNewsId);
	public void updateDraft(ArtNews artNews,String title,String type,String summary,String content,String state);
	public List<ArtNews> getAllUnderApprovalArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllCheckedArtNewsByEditor(Editor editor); 
}
