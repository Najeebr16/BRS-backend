package com.lti.bus.bustest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lti.bus.admin.dao.AdminDao;
import com.lti.bus.BusResApplication;
import com.lti.bus.user.dao.BusDao;
import com.lti.bus.user.entity.Admin;
import com.lti.bus.user.entity.BusAvailibility;
import com.lti.bus.user.entity.UserRegistration;


	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = BusResApplication.class)
	@Rollback(false)
   @AutoConfigureTestDatabase(replace=Replace.NONE)
	public class BusDaoTest {
		@Autowired
		private BusDao busDao;
		
		@Autowired
		private AdminDao admdao;
		
		@Test
		@Transactional
		public void addBus() {
			UserRegistration br=new UserRegistration();
			
			 br.setFullname("najeeb ur rahman");
			 br.setEmail("r16najeeb@gmail.com");
			 br.setGender("male");
			 br.setMobile("9916334439");
			 br.setAddress("bangalore");
			 br.setDateOfBirth("01-09-1996");
			br.setPassword("ROCKSTAR");
			busDao.add(br);
		} 
		
		@Test
		@Transactional
		public void fetchRoute() {
			List<BusAvailibility> a=busDao.fetchRoute("mumbai", "pune");
			assertEquals(1, a.size());
		}
		@Test
		@Transactional
		public void fetch() {
			List<UserRegistration> a=busDao.fetchAll();
			assertEquals(3, a.size());
		}
		@Test
		@Transactional
		public void verify() {
			List<Admin> a =admdao.verifyLogin("najeeb.rahman@lntinfotech.com", "abc123!!");
			assertEquals(1, a.size());
		}
//		@Test
//		@Transactional
//		public void verify1() {
//			List<UserRegistration> a =busDao.verifyLogin("r16najeeb@gmail.com", "123");
//			assertEquals(1, a.size());
//		}
	}
		
	

