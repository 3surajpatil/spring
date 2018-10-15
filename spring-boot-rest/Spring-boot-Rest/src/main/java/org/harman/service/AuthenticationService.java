package org.harman.service;

import org.harman.model.User;
import org.harman.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AuthenticationService {

	
	User credsBean;
		
	
	@Autowired
	public UserRepository userRepository;
	
	
	private static final Logger logger= LoggerFactory.getLogger(AuthenticationService.class);
	
	public AuthenticationService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public boolean validateCredentials(User credsBean){
	
		boolean validCreds=false;

		int count=(int) userRepository.count();
		logger.debug("user count is "+count);
		
		if(count==1)
		{
			validCreds=true;
		}
		
		return validCreds;
	}
	
	
}