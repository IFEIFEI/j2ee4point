package cn.edu.xmu.artworkauction.entity;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import cn.edu.xmu.artworkauction.utils.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  The class ArtNews
 *  @author Dany ifeifei@stu.xmu.edu.cn<br>
 *  @version 2.0<br>
 *   Modified by XiaWenSheng  12/15
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
			@NamedQuery(name="@HQL_GetArtNewsById",
			query="from ArtNews a where a.id=:id"),
			@NamedQuery(name="@HQL_GetArtNewsByState",
			query="from ArtNews a where a.state=:state"),
			@NamedQuery(name="@HQL_GetArtNewsByChiefEditor",
			query="from ArtNews a where a.chiefEditor=:chiefEditor"),
			@NamedQuery(name="@HQL_GetArtNewsByEditor",
			query="from ArtNews a where a.editor=?"),
			@NamedQuery(name="@HQL_GetAllDraftByEditor",
			query = "from ArtNews a Where a.editor=:editor and a.state=:state"),
			@NamedQuery(name="@HQL_GetAllApprovedArtNewsByEditor",
			query = "from ArtNews a where a.editor=:editor and a.state=:state"),
			@NamedQuery(name="@HQL_GetAllDisApprovedArtNewsByEditor",
			query = "from ArtNews a where a.editor=:editor and a.state=:state"),
			@NamedQuery(name="@HQL_GetTodayArtNews",
			query="select a from DateAndPosition dp inner join dp.artNews a where dp.publishDate "
					+ "=:Today and dp.columnID=:columnId and a.state=:state and a.type=:type order by priority asc"),
			@NamedQuery(name="@HQL_GetArtNewsDetailById",
			query="from ArtNews a where a.id=:id"),
			@NamedQuery(name="@HQL_GetAllCommittedArtNewsByEditor",
			query="from ArtNews a where a.editor=:editor and a.state !=:state"),
			@NamedQuery(name="@HQL_GetAllCheckedArtNewsListByEditor",
			query="from ArtNews a where a.editor=:editor and a.state=:state1 or a.state=:state2"),
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
	private String type;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date createTime;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date editTime;
	
    @Column
    private String state;
	    
	@ManyToOne(targetEntity=Editor.class)
	@JoinColumn(name="editor_id")
	private Editor editor;
	
	@ManyToOne(targetEntity=ChiefEditor.class)
	@JoinColumn(name="chiefEditor_id")
	private ChiefEditor chiefEditor;
	
	@OneToMany(mappedBy = "artNews", targetEntity = DateAndPosition.class,cascade={CascadeType.REMOVE})
    private List<DateAndPosition> dateAndPositions;//=new ArrayList<DateAndPosition>();
	
	@OneToOne(targetEntity=ArtNewsContent.class, cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="artNewsContent_id")
	private ArtNewsContent artNewsContent;
	
	@Column
	private String summary;
	
	@Column 
	private String imageURL;
	
	public ArtNews(String title,Date createTime,Date editTime,String state,Editor editor,
			String type,String summary,String imageURL)
    {
		setTitle(title);
		setCreateTime(createTime);
		setEditTime(editTime);
		setEditor(editor);
		setType(type);
		//setArtNewsContent(artNewsContent);
		setSummary(summary);
		setImageURL(imageURL);
		//setDateAndPositions(dateAndPositionList);
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
	public void setEditTime(Date editTime) {
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
		this.dateAndPositions = dateAndPositions;
	}
	
	public ArtNewsContent getArtNewsContent() {
		return artNewsContent;
	}
	public void setArtNewsContent(ArtNewsContent artNewsContent) {
		this.artNewsContent = artNewsContent;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	/**
	 * the method is a static method which is aimed to mix the artNews and the advertisement
	 * @param artNews
	 * @param ads
	 * @return mixedArtNewsList 
	 */
	public static List<ArtNews> mixArtNewsAndAdvertisement(List<ArtNews> artNews,List<ArtNews> ads) {
		List<ArtNews> mixedArtNewsList=new ArrayList<ArtNews>();
		int k=1;
		int i=1;
		for(i=1;i<=artNews.size();i++) {
			mixedArtNewsList.add(artNews.get(i-1));
			if(i%5==0&&ads.size()>=k) {
				mixedArtNewsList.add(ads.get(k-1));
				k++;
			}
		}
		for(int m=k;m<=ads.size();m++) {
			mixedArtNewsList.add(ads.get(m-1));
		}
		return mixedArtNewsList;
	}
}
