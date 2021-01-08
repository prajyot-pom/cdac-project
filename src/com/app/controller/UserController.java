package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dao.IUserDao;
import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private IUserDao dao;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init" + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> listUsers()
	{
		System.out.println("Inside list books");
		List<User> allUsers = dao.getAllUser();
		
		if(allUsers.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody User u)
	{
		String email = u.getEmail();
		String password = u.getPassword();
		System.out.println("inside login function");
		System.out.println(u.toString());
		User loggedUser = dao.validateUser(email, password);
		System.out.println(loggedUser.toString());
//		if(loggedUser == null)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(loggedUser,HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public void deleteUserDetails(@PathVariable int userId)
	{
		System.out.println("inside delete book  "+ userId);
		User u = dao.getUserById(userId);
		if(u !=null)
			dao.deleteUser(u);;
	}
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User u)
	{
		System.out.println("in add new User method "+ u.toString());
		try
		{
			return new ResponseEntity<User>(dao.addUser(u),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateUserData(@RequestBody User u)
	{
		System.out.println("u");
		User uu = dao.updateUser(u);
		if(uu == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(uu,HttpStatus.OK);
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<?> getUserDetails(@PathVariable int user_id)
	{
		System.out.println("insde find user by id "+ user_id);
		User u = dao.getUserById(user_id);
		System.out.println(u.toString());
//		if(u==null)
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	
	@GetMapping("/addr/{id}")
	public ResponseEntity<?>getUserAddress(@PathVariable int id)
	{
		System.out.println("Inside user controller "+id);
		User u = dao.getUserWithAddress(id);
		System.out.println(u.getAddress());
		if(u == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Address>(u.getAddress(),HttpStatus.OK);
	}
	
	@PostMapping("/changepwd/{id}")
	public ResponseEntity<?> changePassword(@PathVariable int id,@RequestBody User user)
	{
		System.out.println("id: "+id +"    new password :"+user.getPassword());
		User u = dao.changePwd(id, user.getPassword());
		if(u == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<?>getUserCart(@PathVariable int id)
	{
		System.out.println("Inside user controller "+id);
		User u = dao.getUserWithCart(id);
		
		if(u == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Item>>(u.getItem(),HttpStatus.OK);
	}
	
	@GetMapping("/payment/{id}")
	public ResponseEntity<?>getUserPayment(@PathVariable int id)
	{
		System.out.println("Inside user controller "+id);
		User u = dao.getUserWithCart(id);
		
		if(u == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		List<Item> itemList = u.getItem();
		double amount =0;
		for (Item item : itemList) {
			amount = amount + item.getAmount();
		}
		System.out.println(amount);
		return new ResponseEntity<Double>(amount,HttpStatus.OK);
	}
	
	@GetMapping("/clear/{userId}")
	public ResponseEntity<?> clearUserCart(@PathVariable int userId)
	{
		System.out.println("inside clear cart method " + userId);
		User u = dao.getUserById(userId);
		User uu = dao.clearCart(u);
		if(uu == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(uu,HttpStatus.OK);
	}
}
