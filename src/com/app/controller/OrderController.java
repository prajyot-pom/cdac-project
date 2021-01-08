package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IOrderDao;
import com.app.pojos.Book;
import com.app.pojos.Orders;
import com.app.pojos.User;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController 
{
	@Autowired
	private IOrderDao dao;
	
	public OrderController() {
		System.out.println("inside ctor of "+getClass().getName());
	}
	
	@GetMapping("/{book_id}/{user_id}")
	public ResponseEntity<?> addNewOrder(@PathVariable int book_id, @PathVariable int user_id)
	{
		System.out.println("Inside order controller "+ book_id + user_id);
		
		return null;
	}
}
