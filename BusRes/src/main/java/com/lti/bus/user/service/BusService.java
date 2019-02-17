package com.lti.bus.user.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bus.user.dao.BusDao;
import com.lti.bus.user.dto.BusFilter;
import com.lti.bus.user.dto.LoginDto;
import com.lti.bus.user.dto.LoginStatus;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.PassengerDetails;
import com.lti.bus.user.entity.UserRegistration;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;

	@Transactional
	public void add(Object obj) {
		busDao.add(obj);
	}
	@Transactional
	public void delete(BookingRecords obj) {
		busDao.delete(obj);
	}
	@Transactional
	public UserRegistration fetchUser(int id) {
		return busDao.fetchUser(id);
	}
	@Transactional
	public BusAvailibility fetchBus(int id) {
		return busDao.fetchBus(id);
	}
	@Transactional
	public List<BusAvailibility> fetchRoutes(BusFilter busfil) {
		String type=busfil.getType();
		String timerange=busfil.getTimerange();
		String src=busfil.getSource();
		String dst=busfil.getDestination();
		if(type==null && timerange==null) {
			return busDao.fetchRoute(src, dst);
		}
		if(type==null) {
			return busDao.fetchRouteFilter1(busfil);
		}
		else if(timerange==null) {
			return busDao.fetchRouteFilter2(busfil);
		}
		else
		return busDao.fetchRoute(busfil);
	}
	
	@Transactional
	public LoginStatus verifyLogin(LoginDto loginDto) {
		LoginStatus loginStatus = new LoginStatus();
		String email=loginDto.getEmail();
		String password=loginDto.getPassword();
		
		try {
			UserRegistration log =busDao.verifyLogin(email, password);
			loginStatus.setStatus("VERIFIED");
			loginStatus.setUserid(log.getId());
			loginStatus.setName(log.getFullname());
		}
		catch(Exception e) { 
			loginStatus.setStatus("NOTVERIFIED");
			e.printStackTrace();
		}
		return loginStatus;
		}

	@Transactional
	public List<PassengerDetails> fetchallpass(int id) {
		return busDao.fetchallpass(id);
	}
	@Transactional
	public List<BusAvailibility> fetchAllBus(int id) {
		return busDao.fetchBusDetails(id);
	}
	@Transactional
	public List<UserRegistration> search(int id ) {
		return busDao.search(id);
	}

}
