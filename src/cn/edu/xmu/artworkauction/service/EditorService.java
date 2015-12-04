package cn.edu.xmu.artworkauction.service;

import javax.swing.text.html.HTML;

import cn.edu.xmu.artworkauction.entity.ArtNews;
import cn.edu.xmu.artworkauction.entity.Editor;
import java.util.Date;
import java.util.List;

/*
 * EditorService
 * @author Dany ifeifei@stu.xmu.edu.cn
 */
public interface EditorService 
{
	public void saveDraft(String title,String article,Date createtime,Date edittime,Integer checked,Integer checkedout,Editor editor ,String type);
	public List<ArtNews> getDraft(Editor editor);
	public void submit(String title,String article,Date createtime,Date edittime,Integer checked,Integer checkedout,Editor editor,String type);

}
