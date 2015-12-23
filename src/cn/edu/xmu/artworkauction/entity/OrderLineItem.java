package cn.edu.xmu.artworkauction.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 	@author XiaWenSheng
 *	@version D-1223_2.0.0
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_orderLineItem")
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="artwork_id")
	private Artwork artwork;
	@Column
	private Integer number;
	@Column
	private double  transactionPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Artwork getArtwork() {
		return artwork;
	}
	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	public double getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	
	public Integer getNumber() 
	{
		return number;
	}
	public void setNumber(Integer number) 
	{
		this.number = number;
	}
}
