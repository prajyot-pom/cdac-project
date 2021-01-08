package com.app.dao;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Item;
import com.app.pojos.User;


@Repository
@Transactional
public class UserDaoImpl implements IUserDao
{
	@Autowired
	private SessionFactory sf;

	@Override
	public List<User> getAllUser() {
		String jpql = "select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

	@Override
	public User getUserById(int userId) {
		return sf.getCurrentSession().get(User.class, userId);
	}

	@Override
	public void deleteUser(User u) {
		sf.getCurrentSession().delete(u);
		
	}

	@Override
	public User addUser(User u) {
		sf.getCurrentSession().persist(u);
		return u;
	}

	@Override
	public User updateUser(User u) {
		System.out.println(u);
		User u1 = sf.getCurrentSession().get(User.class, u.getU_id());
		
		u1.setFirst_name(u.getFirst_name());
		u1.setLast_name(u.getLast_name());
		u1.setAge(u.getAge());
		u1.setMob_no(u.getMob_no());
		u1.setEmail(u.getEmail());
		u1.setPassword(u.getPassword());
		u1.setGender(u.getGender());
		u1.setRole(u.getRole());
		u1.setImage(u.getImage());
		
		return u1;
	}

	@Override
	public User getUserWithAddress(int id) {
		String jpql = "select u from User u join fetch u.address where u.u_id=:id";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public User changePwd(int id, String newPwd) {
		User u = sf.getCurrentSession().get(User.class, id); // u is persistant
		u.setPassword(newPwd);
		sf.getCurrentSession().save(u);
		return u;
	}

	@Override
	public User getUserWithCart(int id) {
		String jpql = "select u from User u join fetch u.item where u.u_id=:id";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public User clearCart(User u) {
		User u1 = u;
		//u1.getItem().clear();
		List<Item> i = u1.getItem();
		
//		CopyOnWriteArrayList<Item> list = new CopyOnWriteArrayList<>(i);
//		Iterator itr = list.iterator();
//		while(itr.hasNext())
//		{
//			Item myItem = (Item) itr.next();
//			if(myItem!=null)
//				itr.remove();
//		}
		
		
		
//		ListIterator<Item> ii = i.listIterator();
//		while(ii.hasNext())
//		{
//			Item i1 = ii.next();
//			
//		}
//		//i.clear();
//		//u1.clearCart();
		return u1;
	}

	
	
	
}
