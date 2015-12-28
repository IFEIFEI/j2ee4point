/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="tb_payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	//此处是艺术家设置的每期设置的付款日期
	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date paymentDate;
	
	//此处是用户实际的付款日期
	@Column
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date factPaymentDate;
	
	//这一期需要的付款
	@Column
	private Double money;
	
	@Column
	private Integer state;
	
	@OneToOne(mappedBy="payment")
	private AuctionItem auctionItem;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(Date paymentDate,Double money,Integer state,AuctionItem auctionItem)
	{
		setPaymentDate(paymentDate);
		setMoney(money);
		setState(state);
		setAuctionItem(auctionItem);
	}
	
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id=id;
	}
	
	
	public Double getMoney()
	{
		return money;
	}
	
	public void setMoney(Double money)
	{
		this.money=money;
	}
	
	public Date getPaymentDate()
	{
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate)
	{
		this.paymentDate=paymentDate;
	}
	
	public Date getFactPaymentDate()
	{
		return factPaymentDate;
	}
	
	public void setFactPaymentDate(Date factPaymentDate)
	{
		this.factPaymentDate=factPaymentDate;
	}
	
	public Integer getState()
	{
		return state;
	}
	public void setState(Integer state)
	{
		this.state=state;
	}
	
	public AuctionItem getAuctionItem()
	{
		return auctionItem;
	}
	public void setAuctionItem(AuctionItem auctionItem)
	{
		this.auctionItem=auctionItem;
	}	
}
