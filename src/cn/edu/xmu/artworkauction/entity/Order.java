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
import javax.persistence.OneToMany;
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
@Table(name="tb_order")
public class Order {
	private Integer id;
	private User user;
	private Date orderDate;
	private Shipment shipment;
	private List<OrderLineItem> orderLineItems;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="shipment_id")
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	@OneToMany(mappedBy="order", targetEntity = OrderLineItem.class,
            cascade = CascadeType.ALL)
	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	
}
