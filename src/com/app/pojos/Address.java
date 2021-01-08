package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address 
{
	private Integer a_id,house_no;
	private String street,city,state,country;
	private int pincode;
	private User user;
	
	public Address() {
		System.out.println("inside address ctor");
	}

	public Address(int house_no, String street, String city, String state, String country, int pincode, User user) {
	
		this.house_no = house_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	@Column(name = "house_no")
	public int getHouse_no() {
		return house_no;
	}

	public void setHouse_no(int house_no) {
		this.house_no = house_no;
	}

	@Column(length = 20, name = "street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(length = 20, name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 20, name = "state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(length = 20, name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "pin")
	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="u_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [a_id=" + a_id + ", house_no=" + house_no + ", street=" + street + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
}
