/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

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
			query="from Artwork"),
			@NamedQuery(name="@HQL_getArtworkById",
			query="from Artwork a where a.id=?"),
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column
	private String name;
	@Column(length=100)
	private Artist artist;
	@Column
	private String artistName;
	@Column(length=100)
	private String material;
	@Column(length=100)
	private String size;
	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(length=1000)
	private String description;
	//imageURL will keep for images for normal,small,medium,large 
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="artworkImageURL", joinColumns=@JoinColumn(name="artwork_id"))
	@MapKeyColumn(name="size")
	@MapKeyClass(String.class)
	@Column(name="artworkImageURL")
	private Map<String, String> imageURL;
	@Column(length=100)
	private String type;
	@Column(length=100)
	private String theme;
	@ManyToOne(targetEntity = Shop.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "shop_id", nullable = false)
	private Shop shop;
	@Column
	private Double price;
	@Column
	private Integer inventory;
	@Column
	private String imageUrl;
	
	public Artwork(){}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getArtistName()
	{
		return this.artistName;
	}
	public void setArtistName(String artistName)
	{
		this.artistName=artistName;
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date creationTime) {
		this.createTime = creationTime;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Map<String, String> getImageURL() {
		return imageURL;
	}
	public void setImageURL(Map<String, String> imageURL2) {
		this.imageURL = imageURL2;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price=price;
	}
	
	public Integer getInventory()
	{
		return this.inventory;
	}
	public void setInventory(Integer inventory)
	{
		this.inventory=inventory;
	}
	
	public String getImageUrl()
	{
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl=imageUrl;
	}
}
