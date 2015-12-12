package cn.edu.xmu.artworkauction.service;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import java.util.Date;
import java.util.List;

/**
 * EditorService
 * @author Dany ifeifei@stu.xmu.edu.cn
 * Modified 
 */
public interface EditorService 
{
	public ArtNews saveDraft(String title,String article,Date createtime,Date edittime,String state,Editor editor ,String type);
	public List<ArtNews> getDraft(Editor editor);
	public void submit(String title,String article,Date createtime,Date edittime,String state,Editor editor,String type);

}
