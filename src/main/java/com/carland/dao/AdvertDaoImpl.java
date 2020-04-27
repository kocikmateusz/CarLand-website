package com.carland.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carland.entity.Advert;


@Repository
public class AdvertDaoImpl implements AdvertDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveAdvert(Advert advert) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(advert);
		
	}

}
