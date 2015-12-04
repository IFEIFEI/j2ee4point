package cn.edu.xmu.artworkauction.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.text.html.HTML;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javafx.scene.chart.PieChart.Data;

/*
 *  ArtNews
 *  @author Dany ifeifei@stu.xmu.edu.cn
 */

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_artnews")
public class ArtNews implements java.io.Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8323156141033933840L;
	@Id
	@GenericGenerator(name="id",strategy="hilo")
	@GeneratedValue(generator="id")
	private Integer id;
	@Column(name="title")
	private String title;
	@Column
	private HTML article;
	@Column
	private String type;
	@Column
	private Data createtime;
	@Column
	private Data edittime;
	@Column
	private Integer checked;
	@Column
	private Integer checkedout;
	@ManyToOne(targetEntity=Editor.class)
	@JoinColumn(name="id",nullable=false)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Editor editor;
	@ManyToOne(targetEntity=ChiefEditor.class)
	@JoinColumn(name="id",nullable=true)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private ChiefEditor chiefEditor;
	
	public ArtNews(String title,HTML article,Data createtime,Data edittime,Integer checked,Integer checkedout,Editor editor)
	{
		
	}
	public ArtNews()
	{
		
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTile(String title)
	{
		this.title=title;
	}
	public HTML getArticle()
	{
		return this.article;
	}
	public void setArticle(HTML article)
	{
		this.article=article;
	}
	public String getType()
	{
		return this.type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	public Data getCreatetime()
	{
		return this.createtime;
	}
	public void setCreatetime(Data createtime)
	{
		this.createtime=createtime;
	}
	public Data getEdittime()
	{
		return this.edittime;
	}
	public void setEdittime(Data edittime)
	{
		this.edittime=edittime;
	}
	public Integer getChecked()
	{
		return checked;
	}
	public void setChecked(Integer checked)
	{
		this.checked=checked;	
	}
	public Editor getEditor()
	{
		return this.editor;
	}
	public void setEditor(Editor editor)
	{
		this.editor=editor;
	}
	public Editor getChiefeditor()
	{
		return this.editor;
	}
	public void setChiefeditor(ChiefEditor ceditor)
	{
		this.chiefEditor=ceditor;
	}
}
