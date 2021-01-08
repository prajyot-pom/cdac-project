package com.app.dao;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.User;

public interface IAddressDao 
{
	List<Address> getAllAddress();
	User addAddress(User u);
	Address getAddressById(int id);
	Address updateAddress(Address a);
	User removeAddress(User u);
	
}
