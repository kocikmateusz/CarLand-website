package com.carland.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
		session.saveOrUpdate(theUser);

	}

	@Override
	public User findByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<User> theQuery = session.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", username);
		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		
		return theUser;
	}

}
