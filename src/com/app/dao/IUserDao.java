package com.app.dao;

import java.util.List;

import com.app.pojos.User;

public interface IUserDao 
{
	List<User>getAllUser();
	User validateUser(String email, String password);
	User getUserById(int userId);
	void deleteUser(User u);
	User addUser(User u);
	User updateUser(User u);
	User getUserWithAddress(int id);
	User changePwd(int id, String password);
	User getUserWithCart(int id);
	User clearCart(User u);
	
}
