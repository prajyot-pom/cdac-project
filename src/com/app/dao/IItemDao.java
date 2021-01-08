package com.app.dao;

import java.util.List;

import com.app.pojos.Item;
import com.app.pojos.User;

public interface IItemDao 
{
	User addItem(User u);
	List<Item> getAllItems();
	Item getItemById(int i_id);
	Item removeItem(Item i);
}
