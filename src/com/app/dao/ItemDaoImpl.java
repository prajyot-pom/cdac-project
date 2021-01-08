package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Item;
import com.app.pojos.User;


@Repository
@Transactional
public class ItemDaoImpl implements IItemDao {

	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public User addItem(User u) {
		sf.getCurrentSession().update(u);
		return u;
	}

	@Override
	public List<Item> getAllItems() {
		String jpql="select i from Item i";
		return sf.getCurrentSession().createQuery(jpql, Item.class).getResultList();
	}

	@Override
	public Item getItemById(int i_id) {
		return sf.getCurrentSession().get(Item.class, i_id);
	}

	@Override
	public Item removeItem(Item i) {
		sf.getCurrentSession().remove(i);
		return i;
	}

}
