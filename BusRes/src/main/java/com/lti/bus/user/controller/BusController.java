package com.lti.bus.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.bus.user.dto.BusFilter;
import com.lti.bus.user.dto.LoginDto;
import com.lti.bus.user.dto.LoginStatus;
import com.lti.bus.user.dto.Ticket;
import com.lti.bus.user.entity.BookingRecords;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.PassengerDetails;
import com.lti.bus.user.entity.UserRegistration;
import com.lti.bus.user.service.BusService;

@RestController
public class BusController {

		@Autowired
		private BusService busser;
		
		@RequestMapping(path="/user/registration/add", method=RequestMethod.POST)
		@CrossOrigin
		public Object add(@RequestBody UserRegistration busres) {
			busser.add(busres);
			return "Registration record created";
		}

		@RequestMapping(path="/findbus/{id}", method=RequestMethod.GET)
		@CrossOrigin
		public UserRegistration fetchCustomer(@PathVariable("id") int id) {
			return busser.fetch(id);
		}
		
		@CrossOrigin
		@RequestMapping(path="/verify/user",method=RequestMethod.POST)
		public LoginStatus verify(@RequestBody LoginDto loginDto) {
			return busser.verifyLogin(loginDto);
		}
		
		@RequestMapping(path="/bus/booking", method=RequestMethod.POST)
		@CrossOrigin
		public Object add(@RequestBody Ticket ticket) {
			busser.add(ticket);
			return "booking successfull";
		}
		@RequestMapping(path="/bus/canceling", method=RequestMethod.GET)
		@CrossOrigin
		public Object delete(@RequestBody BookingRecords bookrec) {
			busser.delete(bookrec);
			return "booking cancelled";
		}
		@RequestMapping(path="/bus/booking/passenger/{id}", method=RequestMethod.POST)
		@CrossOrigin
		public Object add(@RequestBody PassengerDetails[] passdetails,@PathVariable("id") int id) {
			UserRegistration userreg=new UserRegistration();
			userreg = fetchCustomer(id);
			for(int i=0;i<passdetails.length;i++) {
				passdetails[i].setUserreg(userreg);
			busser.add(passdetails[i]);
			}
			return "passenger details added";
		}
		@RequestMapping(path="/findbus/applyfilter",method=RequestMethod.POST)
		@CrossOrigin
		public @ResponseBody List<BusAvailibility> filter1(@RequestBody BusFilter busfil)  {
			return busser.fetchRoutes(busfil);
		}	
		@RequestMapping(path="/display/passengerdetails/{id}", method=RequestMethod.GET)
		@CrossOrigin
		public List<PassengerDetails> passDetails(@PathVariable("id") int id) {
			return busser.fetchallpass(id);
		}
		@RequestMapping(path="/display/busdetails/{bus_id}", method=RequestMethod.GET)
		@CrossOrigin
		public List<BusAvailibility> busAvailibilityRecord(@PathVariable("bus_id")int id) {
			return busser.fetchAllBus(id);
		}
		@RequestMapping(path="/user/detail/{id}", method=RequestMethod.GET)
		@CrossOrigin
		public List<UserRegistration> search(@PathVariable("id") int id) {
			return busser.search(id);
		}
	}



