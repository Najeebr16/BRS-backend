package com.lti.bus.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.bus.admin.dao.AdminDao;
import com.lti.bus.user.entity.Admin;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.UserRegistration;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao admdao;
	@Transactional
	public boolean verifyLogin(Admin log) {
		String username=log.getName();
		String password=log.getPassword();
		boolean flag=false;
		List<Admin> logList=admdao.verifyLogin(username, password);
		
		for(Admin x:logList) {
			if(username.equals(x.getName())) {
					if(password.equals(x.getPassword()))  {
					 flag=true;
				}
			  }
			}
		return flag;
		}
	@Transactional
	public void add(BusAvailibility busavail) {;
		admdao.add(busavail);
	}
	@Transactional
	public void delete(int id) {
		 admdao.delete(id);
	}
	@Transactional
	public List<UserRegistration> search(String email) {
		return admdao.search(email);
	}
	@Transactional
	public List<BusAvailibility> fetchallbus() {
		return admdao.fetchallbus();
	}
	@Transactional
	public List<BookingRecords> fetchallbook() {
		return admdao.fetchallbook();
	}
	@Transactional
	public List<UserRegistration> fetchalluser() {
		return admdao.fetchalluser();
	}

}
