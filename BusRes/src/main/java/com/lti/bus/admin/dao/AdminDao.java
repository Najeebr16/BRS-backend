package com.lti.bus.admin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.bus.user.entity.Admin;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.UserRegistration;

@Repository
public class AdminDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Admin> verifyLogin(String uname,String upass) {
			
			Query query = entityManager.createQuery("from Admin a where a.name= ?1 and a.password= ?2");
		    query.setParameter(1, uname);
			query.setParameter(2, upass);
			return query.getResultList(); 
		}
	public void add(BusAvailibility busavail) {
			entityManager.persist(busavail);
			System.out.println("----");
		}
	public void delete(int id) {
		Query q = entityManager.createQuery("delete from BookingRecords where bookId = ?1");
		q.setParameter(1,id);
		}
	public List<UserRegistration> search(String email) {
		Query q = entityManager.createQuery("from UserRegistration ur where ur.email= ?1");
		 q.setParameter(1,email);
		 return q.getResultList();
		}
	public List<BusAvailibility> fetchallbus() {
		Query q=entityManager.createQuery("select obj from BusAvailibility as obj ");
		return q.getResultList();
	}
	public List<BookingRecords> fetchallbook() {
		Query q=entityManager.createQuery("select obj from BookingRecords as obj ");
		return q.getResultList();
	}
	public List<UserRegistration> fetchalluser() {
		Query q=entityManager.createQuery("select obj from UserRegistration as obj ");
		return q.getResultList();
	}
	
}
