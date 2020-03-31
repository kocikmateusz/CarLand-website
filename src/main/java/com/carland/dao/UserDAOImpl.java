package com.carland.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carland.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User theUser) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theUser);

	}

}
