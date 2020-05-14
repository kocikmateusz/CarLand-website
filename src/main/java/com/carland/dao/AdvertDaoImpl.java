package com.carland.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

	@Override
	public List<Advert> getActiveAdverts() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Advert> theQuery = session.createQuery("from Advert", Advert.class);
		
		return theQuery.getResultList();
		
	}

	@Override
	public Advert getAdvertById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Advert> theQuery = session.createQuery("from Advert where id=:advertId",Advert.class);
		theQuery.setParameter("advertId", id);
		
		return theQuery.getSingleResult();
	}

}
