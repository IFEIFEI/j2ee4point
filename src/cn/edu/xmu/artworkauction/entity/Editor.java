/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author XiaWenSheng
 *
 */
@Entity
@DiscriminatorValue("editor")
public class Editor extends User{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ArtNews> artNews;
	
	@OneToMany(mappedBy = "editor", targetEntity = ArtNews.class,
            cascade = CascadeType.ALL)
	public List<ArtNews> getArtNews() {
		return artNews;
	}
	public void setArtNews(List<ArtNews> artNews) {
		this.artNews = artNews;
	}
}
