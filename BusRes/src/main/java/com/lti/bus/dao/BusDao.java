package com.lti.bus.dao;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.bus.entity.BusAvailibility;
import com.lti.bus.entity.BusRegistration;

@Repository
public class BusDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void add(Object obj) {
		
		entityManager.persist(obj);
	}
	
	public BusRegistration fetchCustomer(int id){
		
	return entityManager.find(BusRegistration.class, id);	
	
	}
public List<BusRegistration> fetchAll(){
		
		Query q=entityManager.createQuery("select obj from BusRegistration as obj ");
		return q.getResultList();
	}
	
	public List<BusAvailibility> fetchRoute(String src,String dst) {
	
		Query query = entityManager.createQuery("from BusAvailibility ba where ba.source= ?1 and ba.destination= ?2");
	    query.setParameter(1, src);
		query.setParameter(2, dst);
		return query.getResultList();
	}
}
