/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * @author XiaWenSheng
 *
 */
@Entity
@DiscriminatorValue("artist")
public class Artist extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String IDNumber;
	private String description;
	private Shop shop;
	public Artist(){}
	@Column(length = 18,unique=true)
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="shop_id")
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop=shop;
	}
}
