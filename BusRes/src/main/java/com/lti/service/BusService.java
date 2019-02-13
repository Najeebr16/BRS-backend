package com.lti.service;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bus.dao.BusDao;
import com.lti.bus.entity.BusAvailibility;
import com.lti.bus.entity.BusRegistration;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;

	@Transactional
	public void add(Object obj) {
		busDao.add(obj);
	}
	public BusRegistration fetch(int id) {
		return busDao.fetchCustomer(id);
	}
	@Transactional
	public List<BusAvailibility> fetchRoutes(String src,String dst) {
		return busDao.fetchRoute(src, dst);
	}
	@Transactional
	public boolean verify(BusRegistration log) {
		String email=log.getEmail();
		String password=log.getPassword();
		boolean flag=false;
		List<BusRegistration> logList=busDao.fetchAll();
		
		for(BusRegistration x:logList) {
			if(email.equals(x.getEmail())) {
					if(password.equals(x.getPassword()))  {
					 flag=true;
				}
			  }
			}
		return flag;
		}

}
