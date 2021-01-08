package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment 
{
	private Integer p_id;
	private Orders order;
	private double amount;
	
	public Payment() {
		System.out.println("inside ctor of payments");
	}

	public Payment(double amount) {
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	@OneToOne
	@JoinColumn(name = "o_id")
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	@Column(name = "amount", columnDefinition = "double(6,1)")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
