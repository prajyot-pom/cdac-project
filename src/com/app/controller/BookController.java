package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IBookDao;
import com.app.pojos.Book;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private IBookDao dao;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init" + dao);
	}
	
	@GetMapping
	public ResponseEntity<?> listBooks()
	{
		System.out.println("Inside list books");
		List<Book> allBooks = dao.getAllBooks();
		if(allBooks.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Book>>(allBooks,HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBookDetails(@PathVariable int bookId)
	{
		System.out.println("inside delete book  "+ bookId);
		Book b = dao.getBookById(bookId);
		if(b !=null)
			dao.deleteBook(b);
	}
	
	@PostMapping
	public ResponseEntity<?> addBook(@RequestBody Book b)
	{
		System.out.println("in add book controller " + b.toString());
		try
		{
			return new ResponseEntity<Book>(dao.addBook(b), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{book_id}")
	public ResponseEntity<?> getBookDetails(@PathVariable int book_id)
	{
		System.out.println("inside book dtls by id = "+book_id);
		Book b = dao.getBookById(book_id);
		System.out.println(b.toString());
//		if(b==null)
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> updateBookData(@RequestBody Book b)
	{
		System.out.println(b);
		Book bb = dao.updateBook(b);
		if(bb == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Book>(bb, HttpStatus.OK);
		
	}
	
	@GetMapping("/search/{title}")
	public ResponseEntity<?> SerachBook(@PathVariable String title)
	{
		System.out.println("in Book "+title);
		List<Book> b = dao.getBookByTitle(title);
		System.out.println(b);
		
		return new ResponseEntity<List<Book>>(b, HttpStatus.CREATED);
	
	}
}
