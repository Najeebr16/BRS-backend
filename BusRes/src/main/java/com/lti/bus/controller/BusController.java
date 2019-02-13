package com.lti.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.bus.entity.BookingRecords;
import com.lti.bus.entity.BusAvailibility;
import com.lti.bus.entity.BusRegistration;
import com.lti.service.BusService;

@RestController
public class BusController {

		@Autowired
		private BusService busser;
		
		@RequestMapping(path="/bus/add", method=RequestMethod.POST)
		@CrossOrigin
		public String add(@RequestBody BusRegistration busres) {
			busser.add(busres);
			return "Registration record created";
		}
		@RequestMapping(path="/busres/{id}", method=RequestMethod.GET)
		@CrossOrigin
		public BusRegistration fetchCustomer(@PathVariable("id") int id) {
			return busser.fetch(id);
		}
		@RequestMapping(path="/busres/{source}/{destination}",method=RequestMethod.GET)
		@CrossOrigin
		public @ResponseBody List<BusAvailibility> fetchRoute(@PathVariable("source") String source,@PathVariable("destination") String destination){
			System.out.println("DISPLAY KAR IDER");
			System.out.println( busser.fetchRoutes(source, destination));
			return busser.fetchRoutes(source, destination);
		}	
		@CrossOrigin
		@RequestMapping(path="/verify",method=RequestMethod.POST)
		public boolean verify(@RequestBody BusRegistration login) {
			boolean flag=busser.verify(login);
			if(flag) {
				String flag1=Boolean.toString(flag);  
			return true;
			}
			else{
				return false;
			}

		}
		@RequestMapping(path="/bus/book", method=RequestMethod.POST)
		@CrossOrigin
		public String add(@RequestBody BookingRecords bookrec) {
			busser.add(bookrec);
			return "booking successfull";
		}
		
	}


