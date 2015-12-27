/**
 * @author XiaWenSheng
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_dateAndPosition")
@NamedQueries(
		{
			@NamedQuery(name="@HQL_DeleteArtNewsById",
			query="from ArtNews dp where dp.id=:id"),
			@NamedQuery(name="@HQL_GetDateAndPositionListByArtNews",
			query="from DateAndPosition dp where dp.artNews=:artNews")
		}
		)
public class DateAndPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	@Column
	private String position;
	
	@Column
	private String columnID;
	
	@Column
	private Integer priority;
	
	@ManyToOne(targetEntity=ArtNews.class,cascade = {CascadeType.ALL},optional=true)
	@JoinColumn(name="artNews_id")
	private ArtNews artNews;
	public DateAndPosition() {}
	public DateAndPosition(Date publishDate,String position,String columnID,String priority) {
		this.publishDate=publishDate;
		this.position=position;
		this.columnID=columnID;
		this.priority=Integer.parseInt(priority);
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getColumnID() {
		return columnID;
	}

	public void setColumnID(String columnID) {
		this.columnID = columnID;
	}
	
	public ArtNews getArtNews() {
		return artNews;
	}
	public void setArtNews(ArtNews artNews) {
		this.artNews=artNews;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}
