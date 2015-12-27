/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author XiaWenSheng
 *
 */
@Entity
@DiscriminatorValue("artist")
@NamedQueries(
		{ 
			//艺术家注册的时候要求身份证号是唯一的
			@NamedQuery(name = "@HQL_CheckArtistIDNumberUnique", 
			query = "from Artist u where u.IDNumber=? "),
			//艺术家注册的时候要求用户名是唯一的
			@NamedQuery(name = "@HQL_CheckArtistNameUnique", 
			query = "from Artist u where u.userName=?"),
			//艺术家注册的时候要求邮箱是唯一的
			@NamedQuery(name = "@HQL_CheckArtistEmailUnique", 
			query = "from Artist u where u.email=?"),
			@NamedQuery(name = "@HQL_getArtistById", 
			query = "from Artist u where u.id=?"),
		})
public class Artist extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//身份证号
	private String IDNumber;
	//对自身的描述
	private String description;
	//国籍
	private String country;
    //出生日期
	
	private Shop shop;
	
	private Date birthday;
	//教育
	private String education;

	public Artist(){}

	//注册使用
	public Artist(String realname,String IDNumber,String userName,String email,String phoneNumber,String password,String country,String education,String description)
	{
		setRealName(realname);
		setIDNumber(IDNumber);
		setUserName(userName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setPassword(password);
		setCountry(country);
		setEducation(education);
		setDescription(description);
	}
	
	//更新艺术家个人信息
	//返回更新后的艺术家
	public void updateArtist(String userName,String email,String phoneNumber,String education,String description,String imageURL){
		setUserName(userName);
		setEmail(email);
		setPhoneNumber(phoneNumber);
	    setEducation(education);
		setDescription(description);
		setImageURL(imageURL);
	}

	@Column(length = 18,unique=true)
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	
	@Column(length = 200)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(length = 20)
	public String getCountry(){
		return country;
	}
	public void setCountry(String country)
	{
		this.country=country;
	}

	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
    public Date getBirthday(){
    	return birthday;
    }
    public void setBirthday(Date birthday)
    {
    	this.birthday=birthday;
    }

    @Column(length = 20)
	public String getEducation(){
		return education;
	}
	public void setEducation(String education)
	{
		this.education=education;
	}
	
	
	@OneToOne(mappedBy="artist")
    @JoinColumn(name="shop_id")
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
