/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Dany ifeifei@stu.xmu.edu.cn
 *  modified By XiaWenSheng 12/12
 */
@Entity
@DiscriminatorValue("chiefEditor")
public class ChiefEditor extends User {

	/**
	 * 
	 */
	public ChiefEditor() {}
	private static final long serialVersionUID = 1L;
	private List<ArtNews> artNews;
	
	@OneToMany(mappedBy = "chiefEditor", targetEntity = ArtNews.class,
            cascade = CascadeType.ALL)
	public List<ArtNews> getArtNews() {
		return artNews;
	}
	public void setArtNews(List<ArtNews> artNews) {
		this.artNews = artNews;
	}
}
