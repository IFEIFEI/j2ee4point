/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.sql.rowset.JdbcRowSet;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author XiaWenSheng
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_shop")
public class Shop implements java.io.Serializable{
	
	private static final long serialVersionUID = -4828928765987122818L;
	private Integer id;
	private List<Artwork> artworks;
	private Artist artist;

	public Shop() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	@OneToMany(mappedBy = "shop", targetEntity = Artwork.class,
            cascade = CascadeType.ALL)
	public List<Artwork> getArtworks() {
		return artworks;
	}
	public void setArtworks(List<Artwork> artworks) {
		this.artworks=artworks;
	}
	
	
	@OneToOne(targetEntity=Artist.class, cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist=artist;
	}
}
