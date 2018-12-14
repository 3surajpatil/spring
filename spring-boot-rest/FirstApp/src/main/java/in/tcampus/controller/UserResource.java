package in.tcampus.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.tcampus.exceptions.UserNotFoundException;
import in.tcampus.model.User;
import in.tcampus.service.UserDaoService;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping(path="/users")
	private List<User> getAllUsers(){	
		return userDaoService.findAll();
	}
	
	
	@GetMapping(path="/users/{id}")
	private User getUser(@PathVariable int id){
		
		User retrivedUser = userDaoService.findOne(id);
			
		if(retrivedUser==null){
			throw new UserNotFoundException("user not found with id :-"+id);
		}
		
		return retrivedUser;
	}
	
	@PostMapping(path="/users")
	private ResponseEntity<Object> createUser(@RequestBody User user){
		
		User savedUser=userDaoService.addUser(user);		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri(); 		
		return ResponseEntity.created(location).build();
	}
	
	
}
