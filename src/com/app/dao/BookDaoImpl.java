package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Book;

@Repository
@Transactional
public class BookDaoImpl implements IBookDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Book> getAllBooks() {
		String jpql = "select b from Book b";
		return sf.getCurrentSession().createQuery(jpql, Book.class).getResultList();
	}

	@Override
	public Book getBookById(int bookId) {
	
		return sf.getCurrentSession().get(Book.class, bookId);
	}
	
	@Override
	public void deleteBook(Book b) {
		sf.getCurrentSession().delete(b);
		
	}

	@Override
	public Book addBook(Book b) {
		sf.getCurrentSession().persist(b);
		return b;
	}

	@Override
	public Book updateBook(Book b) {
		System.out.println(b);
		Book b1 = sf.getCurrentSession().get(Book.class, b.getB_id());
		
		b1.setTitle(b.getTitle());
		b1.setAuthor(b.getAuthor());
		b1.setPublication(b.getPublication());
		b1.setPrice(b.getPrice());
		b1.setCount(b.getCount());
		b1.setIsbn(b.getIsbn());
		b1.setImage(b.getImage());
		b1.setType(b.getType());
		return b1;
	}
	
	@Override
	public List<Book> getBookByTitle(String title1) {
		String jpql = "select b from Book b where b.title=:title2 ";
		return sf.getCurrentSession().createQuery(jpql,Book.class).setParameter("title2",title1).getResultList();
		
	}
}
