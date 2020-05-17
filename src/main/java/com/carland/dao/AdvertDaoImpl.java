package com.carland.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
	@Transactional
	public void saveAdvert(Advert advert) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(advert);
		
	}

	@Override
	public List<Advert> getActiveAdverts() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Advert> theQuery = session.createQuery("from Advert where state=:state", Advert.class);
		theQuery.setParameter("state", "ACTIVE");
		
		return theQuery.getResultList();
		
	}

	@Override
	public Advert getAdvertById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Advert> theQuery = session.createQuery("from Advert where id=:advertId",Advert.class);
		theQuery.setParameter("advertId", id);
		
		return theQuery.getSingleResult();
	}

	@Override
	@Transactional
	public void deleteAdvert(Advert advert) {
		Session session = entityManager.unwrap(Session.class);
		
		session.delete(advert);
	}

	@Override
	public Advert getOnePendingAdvert() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Advert> theQuery = session.createQuery("from Advert where state=:state",Advert.class);
		theQuery.setParameter("state", "PENDING");
		
		return theQuery.getResultList().get(0);
	}

}
