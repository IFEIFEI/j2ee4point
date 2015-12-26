/**
 * @author XiaWenSheng
 */
package cn.edu.xmu.artworkauction.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_artNewsContent")
public class ArtNewsContent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column
	private String content;
	
	@OneToOne(mappedBy="artNewsContent")
	@JoinColumn(name="artNews_id")
	private ArtNews artNews;
	
	public ArtNewsContent(){};
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ArtNews getArtNews() {
		return artNews;
	}
	public void setArtNews(ArtNews artNews) {
		this.artNews = artNews;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
