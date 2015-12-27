/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import java.util.List;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.ArtNewsContent;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.DateAndPosition;

/**
 * @author XiaWenSheng 
 *
 */
public interface ChiefEditorDAO {
	public void approveArtNews(ArtNews artNews);
	public void disapproveArtNews(ArtNews artNews);
	public List<ArtNews> getUnderApprovalArtNews();
	public List<ArtNews> getArtNewsByChiefEditor(ChiefEditor chiefEditor);
} 
