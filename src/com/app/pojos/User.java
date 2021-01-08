package com.app.pojos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User 
{
	private Integer u_id;
	private String first_name,last_name,email,password;
	private RoleType role;
	private String mob_no;
	private int age;
	private byte[] image;
	private GenderType gender;
	private Address address;
	//private List<Orders> orders = new ArrayList<>();
	private List<Item> item = new ArrayList<>();
	
	public User() {
		System.out.println("inside user ctor");
	}

	public User(String first_name, String last_name, String email, String password, RoleType role, String mob_no,
			int age, GenderType gender, List<Address> address) {
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mob_no = mob_no;
		this.age = age;
		this.gender = gender;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	@Column(length = 20, name = "first_name")
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Column(length = 20, name = "last_name")
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Column(length = 20, name = "email", unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20, name = "password",nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "role", length = 20)
	public RoleType getRole() {
		return role;
	}

	public void setRole(RoleType role) {
		this.role = role;
	}

	@Column(length = 10, name = "mob_no")
	public String getMob_no() {
		return mob_no;
	}

	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}

	@Column(name = "age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", length =10)
	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}

	@JsonIgnore
	@OneToMany(mappedBy = "shopper", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", role=" + role + ", mob_no=" + mob_no + ", age=" + age + ", gender="
				+ gender + "]";
	}
	
	//Helper methods for address
	public void addAddress(Address a)
	{
		this.address=a;
		a.setUser(this);
	}
	
	public void removeAddress(Address a)
	{
		this.address=null;
		a.setUser(null);
	}
	
//	//Helper methods for order
//	public void addOrders(Orders o)
//	{
//		orders.add(o);
//		o.setUsers(this);
//	}
//	
//	public void removeOrders(Orders o)
//	{
//		orders.remove(o);
//		o.setUsers(null);
//	}
	
	public void addToCart(Item i)
	{
		this.item.add(i);
		i.setShopper(this);
	}
	
	public void removeFromCart(Item i)
	{
		this.item.remove(i);
		i.setShopper(null);
	}
	
//	public void clearCart()
//	{
//		System.out.println("inside pojo helper method");
//		
//		for (Item i : item) {
//			i.setShopper(null);
//		}
//		this.item.clear();
//	}
}
