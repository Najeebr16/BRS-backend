package com.lti.bus.logincontroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.bus.loginservice.LoginService;
import com.lti.entity.Login;

@Controller
public class LoginController {
	@Autowired 
	private LoginService loginService;


	@RequestMapping(path="/verify",method=RequestMethod.GET)
	public String login(@RequestBody Login busres) {
		boolean flag=loginService.verify(busres);
		String flag1=Boolean.toString(flag);  
		if(flag1=="true") {
		System.out.println("Verified");
		}return flag1;
		
	}


}
