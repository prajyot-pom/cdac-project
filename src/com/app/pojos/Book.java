package com.app.pojos;

//import java.util.HashSet;
//import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book 
{
	private Integer b_id;
	private String title,author,publication,type;
	private int isbn;
	private double price;
	private byte[] image;
	private int count;
	//private Set<Orders> orders = new HashSet<>();
	
	public Book() 
	{
		System.out.println("Inside book ctor");
	}

	public Book(String title, String author, 
				String publication, String type, 
				int isbn, double price) {		
		this.title = title;
		this.author = author;
		this.publication = publication;
		this.type = type;
		this.isbn = isbn;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	@Column(length = 30, name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 30, name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 30, name = "publication")
	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Column(name = "isbn")
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

//	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
//	@JoinTable(name = "book_order",joinColumns = @JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="order_id"))
//	public Set<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}

	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(length = 30, name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", title=" + title + ", author=" + author + ", publication=" + publication
				+ ", type=" + type + ", isbn=" + isbn + ", price=" + price + "]";
	}

//	//helper methods
//	public void addOrders(Orders o)
//	{
//		orders.add(o);
//		o.getSelectedBooks().add(this);
//	}
//	
//	public void removeOrders(Orders o)
//	{
//		orders.remove(o);
//		o.getSelectedBooks().remove(null);
//	}
//
//	//override hashcode and equals
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
//		Book other = (Book) obj;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		return true;
//	}

}
