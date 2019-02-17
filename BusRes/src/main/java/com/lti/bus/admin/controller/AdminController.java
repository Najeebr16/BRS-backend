package com.lti.bus.admin.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bus.admin.service.AdminService;
import com.lti.bus.user.entity.Admin;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.UserRegistration;

@RestController
public class AdminController {
	
	@Autowired
    private AdminService admser;	
	
    @CrossOrigin
	@RequestMapping(path="/verify/admin",method=RequestMethod.POST)
	public Object verify(@RequestBody Admin adminlog) {
		boolean flag=admser.verifyLogin(adminlog);
		if(flag) {
			String flag1=Boolean.toString(flag);  
		return true;
		}
		else{
			return false;
		}
	}
	@RequestMapping(path="/admin/bus/details/add", method=RequestMethod.POST)
	@CrossOrigin
	public Object add(@RequestBody BusAvailibility busavl) {
		System.out.println("==============" + busavl);
		admser.add(busavl);
		return "Bus details added..!!";
	}
	
	@RequestMapping(path="/admin/bus/details/delete/{id}", method=RequestMethod.GET)
	@CrossOrigin
	public Object deleteRecord(@PathVariable("id") int id) {
		admser.delete(id);
		return "bus record deleted";
	}
	
	@RequestMapping(path="/admin/display/busdetails", method=RequestMethod.GET)
	@CrossOrigin
	public List<BusAvailibility> busAvailibilityRecord() {
		return admser.fetchallbus();
	}
	
	@RequestMapping(path="/admin/display/bookingdetails", method=RequestMethod.GET)
	@CrossOrigin
	public List<BookingRecords> bookingDetailsRecord() {
		return admser.fetchallbook();
	}
	@RequestMapping(path="/admin/display/userdetails", method=RequestMethod.GET)
	@CrossOrigin
	public List<UserRegistration> userDetails() {
		return admser.fetchalluser();
	}
	@RequestMapping(path="/admin/user/detail/{email}", method=RequestMethod.GET)
	@CrossOrigin
	public List<UserRegistration> search(@PathVariable("email") String email) {
		return admser.search(email);
	}
	
}
