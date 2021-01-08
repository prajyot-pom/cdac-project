package com.app.dao;

import java.util.List;

import com.app.pojos.Book;

public interface IBookDao 
{
	List<Book> getAllBooks();
	Book getBookById(int bookId);
	void deleteBook(Book b);
	Book addBook(Book b);
	Book updateBook(Book b);
	List<Book> getBookByTitle(String title1);
}
