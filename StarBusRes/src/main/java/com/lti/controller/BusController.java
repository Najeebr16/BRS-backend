package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.BusRegistration;
import com.lti.service.BusService;
;

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
		public BusRegistration fetch(@PathVariable("id") int id) {
			return busser.fetch(id);    
		}
		
		
	}


