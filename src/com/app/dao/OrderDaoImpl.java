package com.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Orders;

@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao 
{

	@Override
	public Orders addOrder(Orders o) {
		// TODO Auto-generated method stub
		return null;
	}

}
