/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * @author XiaWenSheng
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_artwork")
@NamedQueries(
		{ 
			@NamedQuery(name="@HQL_getAllArtwork",
					query="form Artwork"),
			@NamedQuery(name="@HQL_getArtworkById",
					query="form Artwork a where a.id=?"),
			@NamedQuery(name="@HQL_getArtworkByArtist",
			query="from Artwork a where a.artist=?"),
			@NamedQuery(name="@HQL_getArtworkByMaterial",
			query="from Artwork a where a.material=?"),
			@NamedQuery(name="@HQL_getArtworkBySize",
			query="from Artwork a where a.size=?"),
			@NamedQuery(name="@HQL_getArtworkByCreateTime",
			query="from Artwork a where a.createTime=?"),
			@NamedQuery(name="@HQL_getArtworkByDescription",
			query="from Artwork a where a.description=?"),
			@NamedQuery(name="@HQL_getArtworkByType",
			query="from Artwork a where a.type=?"),
			@NamedQuery(name="@HQL_getArtworkByTheme",
			query="from Artwork a where a.theme=?"),
			@NamedQuery(name="@HQL_getArtworkByShop",
			query="from Artwork a where a.shop=?"),
			@NamedQuery(name="@HQL_getArtworkByPrice",
			query="from Artwork a where a.price between ? and ?")
		})
public class Artwork implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Artist artist;
	private String material;
	private String size;
	@Column
	@Temporal(value=TemporalType.TIME)
	private Date creationTime;
	private String description;
	private List<String> imageURL;
	private String type;
	private String theme;
	private Shop shop;
	private BigDecimal price;
	public Artwork(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Column(length=100)
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(length=100)
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Column(length=1000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@ElementCollection
	@CollectionTable(name="artworkImageURL", joinColumns=@JoinColumn(name="artwork_id"))
	@Column(name="artworkImageURL")
	public List<String> getImageURL() {
		return imageURL;
	}
	public void setImageURL(List<String> imageURL) {
		this.imageURL = imageURL;
	}

	@Column(length=100)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Column(length=100)
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	@ManyToOne(targetEntity = Shop.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "shop_id", nullable = false)
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price=price;
	}
}
