package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.dao.*;
import com.app.pojos.*;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

	
	@Autowired
	private IItemDao dao;
	
	@Autowired
	private IUserDao dao1;
	
	@GetMapping
	public ResponseEntity<?> listItems()
	{
		System.out.println("Inside list Item");
		List<Item> allItems= dao.getAllItems();
		if(allItems.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Item>>(allItems,HttpStatus.OK);
	}
	
	
	@GetMapping("/{bookId}/{qty}/{userId}/{title}/{price}")
	public ResponseEntity<?> addItem(@PathVariable int bookId, @PathVariable int qty,@PathVariable int userId, 
									@PathVariable String title, @PathVariable double price)
	{
		System.out.println("Inside add item controller method");
		//System.out.println(i.toString());
		double amount = price * qty;
		Item i = new Item(title,bookId,qty,price,amount);
		
		User u = dao1.getUserById(userId);
		u.addToCart(i);
		try
		{
			return new ResponseEntity<User>(dao.addItem(u), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{i_id}/{u_id}")
	public ResponseEntity<?> deleteItem(@PathVariable int i_id, @PathVariable int u_id)
	{
		System.out.println("Inside deletea address controller");
		User du = dao1.getUserById(u_id);
		Item i = dao.getItemById(i_id);
		du.removeFromCart(i);;
		
		try
		{
			return new ResponseEntity<Item>(dao.removeItem(i),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
