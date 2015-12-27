/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author XiaWenSheng
 *user entity ,is inherited by Artist
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="userType")  
@DiscriminatorValue("user") 
@Table(name="tb_user")
@NamedQueries(
		{ 
			@NamedQuery(name = "@HQL_CheckUserNameUnique", 
			query = "from User u where u.userName=?"),
			@NamedQuery(name = "@HQL_CheckEmailUnique", 
			query = "from User u where u.email=?"),
			@NamedQuery(name = "@HQL_FindUserByUserNameAndPassword", 
			query = "from User u where u.userName=? and u.password=?"),
			@NamedQuery(name = "@HQL_FindUserByEmailAndPassword",
			query = "from User u where u.email=? and u.password=?"),
			@NamedQuery(name = "@HQL_getUserById", 
			query = "from User u where u.id=?"),
		})
public class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String password;
	private String realName;
	private String phoneNumber;
	private String email;
	private String imageURL;
	private String userType;
	private List<Address> addresses;
	public User(){}
	
	public User(String email,String userName,String phoneNumber,String password)
	{
		setEmail(email);
		setUserName(userName);
		setPhoneNumber(phoneNumber);
		setPassword(password);
	}
	
	//用户信息的更新
	public void updateUserInfo(String email,String userName,String phoneNumber,String imageURL)
	{
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setUserName(userName);	
		setImageURL(imageURL);
	}
	
	@Column(name="userType",insertable=false,updatable=false)
	public String getUserType(){
		return this.userType;
	}
	public void setUserType(String userType){
		this.userType=userType;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length = 32,unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(length = 50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=30)
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	@Column(length = 30)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(length = 50,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length = 200)
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	@OneToMany(mappedBy = "user", targetEntity = Address.class,
            cascade = CascadeType.ALL)
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses=addresses;
	}
}
