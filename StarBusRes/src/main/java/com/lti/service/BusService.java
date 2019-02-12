package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BusDao;
import com.lti.entity.BusRegistration;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;

	@Transactional
	public void add(BusRegistration busres) {
		busDao.add(busres);
	}
	public BusRegistration fetch(int id) {
		return busDao.fetch(id);
	}

	
	
		}

	
