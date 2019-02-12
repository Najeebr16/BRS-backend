package com.lti.bus.loginservice;

import org.springframework.stereotype.Service;

import com.lti.dao.BusDao;
import com.lti.entity.BusRegistration;
import com.lti.entity.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginService {
	@Autowired
	private BusDao busDao;
	
	public boolean verify(Login busres) {
	String email=busres.getUserName();
	String password=busres.getPassWord();
	boolean flag=false;
	List<BusRegistration> busresList=busDao.fetchAll();
	
	for(BusRegistration busres1:busresList) {
		if(email.equals(busres1.getEmail()) && password.equals(busres1.getPassword())) {
				 flag=true;
				 return flag;
			}
		}
	return false;
	}
}
