/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class Shop {
	private Integer id;
	private Artist artist;
	private List<Artwork> artworks;
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
	
	@OneToOne(mappedBy="shop")
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist=artist;
	}
}
