package cn.edu.xmu.artworkauction.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  ArtNews
 *  @author Dany ifeifei@stu.xmu.edu.cn
 *   Modified by XiaWenSheng  
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column
	private String article;
	
	@Column
	private String type;
	
	@Column
	private Date createTime;
	
	@Column
	private Date editTime;
	
	@Column
	private Integer checked;
	
	@Column
	private Integer checkedout;
	
	@Column
	private Date launchTime;
	
	@Column
	private Date offlineTime;
	
	@Column
	private BigDecimal expense;
	
	@Column
	private String position;
	
	@ManyToOne(targetEntity=Editor.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="editor_id",nullable=true)
	private Editor editor;
	
	@ManyToOne(targetEntity=ChiefEditor.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="chiefEditor_id",nullable=true)
	private ChiefEditor chiefEditor;
	
	public ArtNews(String title,String article,Date createTime,Date editTime,Integer checked,Integer checkedout,Editor editor)
    {
		setTitle(title);
		setArticle(article);
		setCreatetime(createTime);
		setEditTime(editTime);
		setChecked(checked);
		setCheckedout(checkedout);
		setEditor(editor);
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
	
	public String getArticle() {
		return this.article;
	}
	public void setArticle(String article) {
		this.article=article;
	}
	
	public String getType() {
		return this.type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	
	public Date getCreatetime() {
		return this.createTime;
	}
	public void setCreatetime(Date createtime)
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
	
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked)
	{
		this.checked=checked;	
	}
	
	public Integer getCheckedout(){
		return checkedout;
	}
	public void setCheckedout(Integer checked){
		this.checkedout=checked;	
	}
	
	public Editor getEditor() {
		return this.editor;
	}
	public void setEditor(Editor editor) {
		this.editor=editor;
	}
	
	public Editor getChiefeditor() {
		return this.editor;
	}
	public void setChiefeditor(ChiefEditor chiefEditor) {
		this.chiefEditor=chiefEditor;
	}
	
	public Date getLaunchTime() {
		return this.launchTime;
	}
	public void setLaunchTime(Date launchTime) {
		this.launchTime=launchTime;
	}
	
	public Date getOfflineTime() {
		return this.offlineTime;
	}
	public void setOfflineTime(Date offlineTime) {
		this.offlineTime=offlineTime;
	}
	
	public BigDecimal getExpense() {
		return expense;
	}
	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
