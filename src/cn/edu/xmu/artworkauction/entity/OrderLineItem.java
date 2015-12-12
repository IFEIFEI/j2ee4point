package cn.edu.xmu.artworkauction.entity;

import java.math.BigDecimal;

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
 * @author XiaWenSheng
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_orderLineItem")
public class OrderLineItem {
	private Integer id;
	private Order order;
	private Artwork artwork;
	private BigDecimal transactionPrice;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(targetEntity = Order.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_id", nullable = false)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public Artwork getArtwork() {
		return artwork;
	}
	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}
	@Column
	public BigDecimal getTransactionPrice() {
		return transactionPrice;
	}
	public void setTransactionPrice(BigDecimal transactionPrice) {
		this.transactionPrice = transactionPrice;
	}
	
}
