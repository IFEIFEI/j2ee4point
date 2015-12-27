/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="tb_address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column
	private String country;
	@Column
	private String province;
	@Column
	private String city;
	@Column
	private String detailedAddress;
	
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(targetEntity=Shipment.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="shipment_id")
	private Shipment shipment; 
	
	public Address()
	{
	}
	
	public Address(String country,String province,String city,String detailedAddress)
	{
		setCountry(country);
		setProvince(province);
		setCity(city);
		setDetailedAddress(detailedAddress);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
}
