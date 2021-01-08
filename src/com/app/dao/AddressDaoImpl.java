package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Address;
import com.app.pojos.User;


@Repository
@Transactional
public class AddressDaoImpl implements IAddressDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Address> getAllAddress() {
		String jpql = "select a from Address a";
		return sf.getCurrentSession().createQuery(jpql, Address.class).getResultList();
	}

	@Override
	public User addAddress(User u) {
		
		sf.getCurrentSession().update(u);
		return u;
	}

	@Override
	public Address getAddressById(int id) {
		
		return sf.getCurrentSession().get(Address.class, id);
	}

	@Override
	public Address updateAddress(Address a) {
		System.out.println("inside dao of address update");
		System.out.println(a.toString());
		
		Address a1 = sf.getCurrentSession().get(Address.class, a.getA_id());
		a1.setCity(a.getCity());
		a1.setHouse_no(a.getHouse_no());
		a1.setState(a.getState());
		a1.setStreet(a.getStreet());
		a1.setCountry(a.getCountry());
		a1.setPincode(a.getPincode());
		return a1;
	}

	@Override
	public User removeAddress(User u) {
		sf.getCurrentSession().remove(u);
		return u;
	}

}


