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
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_dateAndPosition")
public class DateAndPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column
	private Date publishDate;
	
	@Column
	private String position;
	
	@Column
	private String columnID;
	
	@ManyToOne(targetEntity=ArtNews.class,cascade = {CascadeType.ALL})
	@JoinColumn(name="artNews_id",nullable=false)
	private ArtNews artNews;
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
}
