package com.lti.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.BusRegistration;

@Repository
public class BusDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void add(BusRegistration busres) {
		entityManager.persist(busres);
	}
	public BusRegistration fetch(int id)
	{
	return entityManager.find(BusRegistration.class, id);	
	}
	
	public List<BusRegistration> fetchAll(){
		
		Query q=entityManager.createQuery("select obj from BusRegistration as obj ");
		return q.getResultList();
	}
	
}
