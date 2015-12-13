package cn.edu.xmu.artworkauction.entity;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.edu.xmu.artworkauction.utils.Constants;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *  ArtNews
 *  @author Dany ifeifei@stu.xmu.edu.cn
 *   Modified by XiaWenSheng  12/12
 */

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_artnews")
@NamedQueries(
		{ 
			@NamedQuery(name = "@HQL_GetArtNewsByType", 
			query = "from ArtNews a where a.type=?"),
			@NamedQuery(name = "@HQL_GetArtNewsByTitle", 
			query = "from ArtNews a where a.title=?"),
			@NamedQuery(name = "@HQL_GetAllArtNews", 
			query = "from ArtNews"),
			@NamedQuery(name="@HQL_GetAllDraftByEditor",
			query = "from ArtNews a Where a.editor=:editor"),
			@NamedQuery(name="@HQl_GetArtNewsById",
			query="from ArtNews a where a.id=?"),
			@NamedQuery(name="@HQL_GetAllApprovedArtNewsByEditor",
			query = "from ArtNews a where a.editor=:ediitor and a.state=:state"),
			@NamedQuery(name="@HQL_GetAllDisApprovedArtNewsByEditor",
			query = "from ArtNews a where a.editor=:ediitor and a.state=:state"),
			@NamedQuery(name="@HQL_GetTodayArtNews",
			query="select a from DateAndPosition dp inner join dp.artNews a where dp.publishDate "
					+ "between :startTime and :endTime and dp.columnID=:columnId order by cast(dp.position as integer) asc"),
			@NamedQuery(name="@HQL_GetArtNewsByState",query="from ArtNews a where a.state=?"),

		})
public class ArtNews implements java.io.Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8323156141033933840L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column
	private String content;
	
	@Column
	private String type;
	
	@Column
	private Date createTime;
	
	@Column
	private Date editTime;
	
    @Column
    private String state;
	
    @OneToMany(mappedBy = "artNews", targetEntity = DateAndPosition.class,
            cascade = CascadeType.ALL)
    private List<DateAndPosition> dateAndPositions;
    
	@ManyToOne(targetEntity=Editor.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="editor_id")
	private Editor editor;
	
	@ManyToOne(targetEntity=ChiefEditor.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="chiefEditor_id")
	private ChiefEditor chiefEditor;
	
	public ArtNews(String title,String article,Date createTime,Date editTime,String state,Editor editor,String type){}
	public ArtNews(String title,String article,Date createTime,Date editTime,String state,Editor editor)
    {
		setTitle(title);
		setContent(article);
		setCreateTime(createTime);
		setEditTime(editTime);
		setEditor(editor);
		setType(type);
	}
	public ArtNews(){}	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content=content;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreateTime(Date createtime)
	{
		this.createTime=createtime;
	}
	
	public Date getEditTime() {
		return this.editTime;
	}
	public void setEditTime(Date editTime)
	{
		this.editTime=editTime;
	}
	
	public Editor getEditor() {
		return this.editor;
	}
	public void setEditor(Editor editor) {
		this.editor=editor;
	}
	
	public Editor getChiefEditor() {
		return this.editor;
	}
	public void setChiefEditor(ChiefEditor chiefEditor) {
		this.chiefEditor=chiefEditor;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	
	public List<DateAndPosition> getDateAndPositions() {
		return dateAndPositions;
	}
	public void setDateAndPositions(List<DateAndPosition> dateAndPositions) {
		this.dateAndPositions=dateAndPositions;
	}
}
