package com.app.pojos;

import java.util.*;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Orders 
{
	private Integer o_id;
	private User users;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date o_date;
	private int qty;
	private double amount;
	private Payment payment;
	//private Set<Book> selectedBooks = new HashSet<>();
	
	public Orders() {
		System.out.println("inside orders ctor");
	}

	public Orders(Date o_date, int qty, double amount) {
		this.o_date = o_date;
		this.qty = qty;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "o_id")
	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	@ManyToOne
	@JoinColumn(name="u_id")
	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	
//	@ManyToMany(mappedBy = "orders")
//	public Set<Book> getSelectedBooks() {
//		return selectedBooks;
//	}
//
//	public void setSelectedBooks(Set<Book> selectedBooks) {
//		this.selectedBooks = selectedBooks;
//	}

	@Temporal(TemporalType.DATE)
	@Column(name = "o_date")
	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Column(name = "amount", columnDefinition = "double(6,1)")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	//helper methods
	public void addPayment(Payment p)
	{
		this.payment=p;
		p.setOrder(this);
	}
	
	public void removePayment(Payment p)
	{
		this.payment=null;
		p.setOrder(null);
	}
	
	@Override
	public String toString() {
		return "Orders [o_id=" + o_id + ", o_date=" + o_date + ", qty=" + qty + ", amount=" + amount + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((o_id == null) ? 0 : o_id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Orders other = (Orders) obj;
//		if (o_id == null) {
//			if (other.o_id != null)
//				return false;
//		} else if (!o_id.equals(other.o_id))
//			return false;
//		return true;
//	}

	
}
