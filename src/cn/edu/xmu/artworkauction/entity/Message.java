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
 *  @author Yu
 *	
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_message")
public class Message{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="userfrom_id")
	private User userFrom;
	
	@ManyToOne(targetEntity=User.class, cascade = {CascadeType.ALL})
	@JoinColumn(name="userto_id")
	private User userTo;
	
	//此处在 constant 类中定义所有消息的类型
	@Column
	private Integer type;
	
	//信息当前的状态
	@Column
	private Integer state;
	
	
	public Message(){}
	
	public Message(User userForm,User userTo,Integer type,Integer state)
	{
		setUserFrom(userFrom);
		setUserTo(userTo);
		setType(type);
		setState(state);
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setTd(Integer id)
	{
		this.id=id;
	}
	
	public User getUserFrom()
	{
		return userFrom;
	}
	public void setUserFrom(User userFrom)
	{
		this.userFrom=userFrom;
	}
	
	public User getUserTo()
	{
		return userTo;
	}
	public void setUserTo(User userTo)
	{
		this.userTo=userTo;
	}
	
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type=type;
	}	
	
	public Integer getState()
	{
		return state;
	}
	public void setState(Integer state)
	{
		this.state=state;
	}
}
