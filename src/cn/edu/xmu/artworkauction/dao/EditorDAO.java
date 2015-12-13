/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import java.util.List;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;

/**
 * @author XiaWenSheng
 *
 */
public interface EditorDAO {
	public ArtNews submitDraft(ArtNews artNews);
	public ArtNews saveDraft(ArtNews artNews);
	public List<ArtNews> getAllDraftByEditor(Editor editor);
	public List<ArtNews> getAllApprovedArtNewsByEditor(Editor editor);
	public List<ArtNews> getAllDisApprovedArtNewsByEditor(Editor editor);
}
