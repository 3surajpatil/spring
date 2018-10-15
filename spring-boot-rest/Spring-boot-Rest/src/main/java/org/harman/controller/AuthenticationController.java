package org.harman.controller;

import java.util.Map;

import org.harman.model.User;
import org.harman.service.AuthenticationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;



@RestController
public class AuthenticationController {
	
	private static final Logger logger=(Logger) LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getMessage()
	{
		
		logger.debug("in default method.");
		return "Hello from Spring-Rest App";
	}
	
	@RequestMapping(value="/validateCreds",method=RequestMethod.POST)
	public boolean validateCreds(@RequestParam Map<String,String> requestParams		
			)
	{	
		boolean validAuthentication=false;
		
			String username=requestParams.get("username");
			String password=requestParams.get("password");
			
			
			User credsBean=new User();
			credsBean.setUsername(username);
			credsBean.setPassword(password);
					
			validAuthentication=authenticationService.validateCredentials(credsBean);
			
		return validAuthentication;
		}
	
	
	}
	
