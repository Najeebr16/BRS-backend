package com.lti.bus.user.dao;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.bus.user.dto.BusFilter;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.PassengerDetails;
import com.lti.bus.user.entity.UserRegistration;

@Repository
public class BusDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void add(Object obj) {
		
		entityManager.persist(obj);
	}
public void delete(BookingRecords br) {
		
		Query q = entityManager.createQuery("delete from BookingRecords where bookId = ?1");
		q.setParameter(1, br.getBookId());
	}
	
	public UserRegistration fetchCustomer(int id){
		
	return entityManager.find(UserRegistration.class, id);	
	
	}
public List<UserRegistration> fetchAll(){
		
		Query q=entityManager.createQuery("select obj from UserRegistration as obj ");
		return q.getResultList();
	}
	
	public List<BusAvailibility> fetchRoute(String src,String dst) {
	
		Query query = entityManager.createQuery("from BusAvailibility ba where ba.source= ?1 and ba.destination= ?2");
	    query.setParameter(1, src);
		query.setParameter(2, dst);
		return query.getResultList();
	}
	public List<BusAvailibility> fetchRoute(BusFilter busfil) {
		
		Query query = entityManager.createQuery("from BusAvailibility ba where ba.source= ?1 and ba.destination= ?2 and ba.type= ?3 and ba.timerange= ?4");
	    query.setParameter(1, busfil.getSource());
		query.setParameter(2, busfil.getDestination());
		query.setParameter(3, busfil.getType());
		query.setParameter(4, busfil.getTimerange());
		return query.getResultList();
	}
public List<BusAvailibility> fetchRouteFilter1(BusFilter busfil) {
		
		Query query = entityManager.createQuery("from BusAvailibility ba where ba.source= ?1 and ba.destination= ?2  and ba.timerange= ?3");
	    query.setParameter(1, busfil.getSource());
		query.setParameter(2, busfil.getDestination());
		query.setParameter(3, busfil.getTimerange());
		return query.getResultList();
	}
public List<BusAvailibility> fetchRouteFilter2(BusFilter busfil) {
	
	Query query = entityManager.createQuery("from BusAvailibility ba where ba.source= ?1 and ba.destination= ?2 and ba.type= ?3");
    query.setParameter(1, busfil.getSource());
	query.setParameter(2, busfil.getDestination());
	query.setParameter(3, busfil.getType());
	return query.getResultList();
}
	
	public UserRegistration verifyLogin(String uname,String upass) {
		
		Query query = entityManager.createQuery("from UserRegistration ur where ur.email= ?1 and ur.password= ?2");
	    query.setParameter(1, uname);
		query.setParameter(2, upass);
		return (UserRegistration) query.getSingleResult(); 
	}
	public List<PassengerDetails> fetchallpass(int id) {
		Query q=entityManager.createQuery("from PassengerDetails as obj where obj.id=?1 ");
		q.setParameter(1, id);
		return q.getResultList();
	}
	public List<BusAvailibility> fetchBusDetails(int id) {
		Query q=entityManager.createQuery("from BusAvailibility as ba where ba.bus_id=?1");
		q.setParameter(1, id);
		return q.getResultList();
	}
	public List<UserRegistration> search(int id) {
		Query q = entityManager.createQuery("from UserRegistration ur where ur.id= ?1");
		 q.setParameter(1,id);
		 return q.getResultList();
		}
}
