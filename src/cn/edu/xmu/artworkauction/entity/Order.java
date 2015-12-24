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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author XiaWenSheng
 *	@version D-1223_2.0.0
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_order")
@NamedQueries(
		{
			@NamedQuery(name="@HQL_GetAllOrder",
					query="from Order"),
			@NamedQuery(name="@HQL_GetOrderById",
					query="from Order o where o.id=?"),
			//按照用户查找订单
			@NamedQuery(name="@HQL_getOrderByUser",
			query="from Order a where a.user_id=?")
		})
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	@Column
	private Date orderDate;
	@OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="shipment_id")
	private Shipment shipment;
	@OneToMany(mappedBy="order", targetEntity = OrderLineItem.class,
            cascade = CascadeType.ALL)
	private List<OrderLineItem> orderLineItems;
	@Column
	private Integer state;
	@Column
	private String orderLineNum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	public void setOrderLineNum(String orderLineNum) {
		this.orderLineNum = orderLineNum;
	}
	public String getOrderLineNum() {
		return orderLineNum;
	}
}
