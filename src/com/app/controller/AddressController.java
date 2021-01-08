package com.app.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dao.IAddressDao;
import com.app.dao.IUserDao;
import com.app.pojos.Address;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/address")
public class AddressController 
{
	@Autowired 
	private IAddressDao dao;
	@Autowired
	private IUserDao dao1;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init" + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> listAddress()
	{
		
		System.out.println("Inside list books ");
		List<Address> adlist = dao.getAllAddress();
		if(adlist.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Address>>(adlist,HttpStatus.OK);
	}
	
	@GetMapping("/{address_id}")
	public ResponseEntity<?> getAddressDetails(@PathVariable int address_id)
	{
		System.out.println("inside book dtls by id = "+address_id);
		Address a = dao.getAddressById(address_id);
		System.out.println(a.toString());
//		if(b==null)
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Address>(a,HttpStatus.OK);
	}
	
	@PostMapping("/{u_id}")
	public ResponseEntity<?> addAddress(@RequestBody Address a, @PathVariable int u_id)
	{
		System.out.println("inside address controller post method");
		System.out.println(a.toString());
		//Address aa = a;
		User uu = dao1.getUserById(u_id);
		uu.addAddress(a);
		try
		{
			return new ResponseEntity<User>(dao.addAddress(uu),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateAddressData(@RequestBody Address a)
	{
		System.out.println(a);
		Address aa = dao.updateAddress(a);
		if(aa == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Address>(aa, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{a_id}/{u_id}")
	public ResponseEntity<?> deleteAddress(@PathVariable int a_id, @PathVariable int u_id)
	{
		System.out.println("Inside deletea address controller");
		User du = dao1.getUserById(u_id);
		Address da = dao.getAddressById(a_id);
		du.removeAddress(da);
		
		try
		{
			return new ResponseEntity<User>(dao.removeAddress(du),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
