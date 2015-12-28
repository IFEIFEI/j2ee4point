/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/**
 * @author yu
 * 
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_auctionItem")
public class AuctionItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(targetEntity=Payment.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="payment_id")
	private Payment payment;
	
	//艺术家上传的图片
	@Column
	private String imageURL;
	
	//艺术家填写的描述
	@Column(length=500)
	private String description;
	
	public AuctionItem() {
		// TODO Auto-generated constructor stub
	}
	
	public AuctionItem(Payment payment,String imageURL,String description) {
		setPayment(payment);
		setImageURL(imageURL);
		setDescription(description);
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	public Payment getPayment()
	{
		return payment;
	}
	public void setPayment(Payment payment)
	{
		this.payment=payment;
	}
	
	public String getImageURL()
	{
		return imageURL;
	}
	public void setImageURL(String imageURL)
	{
		this.imageURL=imageURL;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}

}
