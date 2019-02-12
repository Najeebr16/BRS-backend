package com.lti.bustest;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bus.BusResApplication;
import com.lti.dao.BusDao;
import com.lti.entity.BusRegistration;

	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = BusResApplication.class)
	@Rollback(false)

	public class BusDaoTest {
		@Autowired
		private BusDao busDao;
		
		@Test
		@Transactional
		public void addBus() {
			BusRegistration br=new BusRegistration();
			
			 br.setFullname("najeeb ur rahman");
			 br.setEmail("r16najeeb@gmail.com");
			 br.setGender("male");
			 br.setMobile("9916334439");
			 br.setAddress("bangalore");
			 br.setDateOfBirth("01-09-1996");
			br.setPassword("ROCKSTAR");
			busDao.add(br);
		}
		
		
	}
		
	

