package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Item {
	
	private Integer i_id;
	private String book_name;
	private int book_id;
	private int qty;
	private double price;
	private double amount;
	private User shopper;
	
	public Item() {
		System.out.println("inside item ctor");
	}

	public Item(String book_name, int book_id, int qty, double price, double amount) {
		super();
		this.book_name = book_name;
		this.book_id = book_id;
		this.qty = qty;
		this.price = price;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	@Column(name = "book_id")
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Column(name = "Qty")
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getShopper() {
		return shopper;
	}

	public void setShopper(User shopper) {
		this.shopper = shopper;
	}

	@Column(name = "title", length = 50)
	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Item [i_id=" + i_id + ", book_name=" + book_name + ", book_id=" + book_id + ", qty=" + qty + ", price="
				+ price + ", amount=" + amount + "]";
	}

}
