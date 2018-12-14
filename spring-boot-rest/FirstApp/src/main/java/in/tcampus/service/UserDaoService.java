package in.tcampus.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import in.tcampus.model.User;

@Component
public class UserDaoService {

	
	private static List <User> userList=new ArrayList<>();
	
	
	static{
		
		userList.add(new User(1,"Adam",new Date()));
		userList.add(new User(2,"Eve",new Date()));
		userList.add(new User(3,"Jack",new Date()));
	}
	
	
	public List<User> findAll(){
	
		return userList;
	}
	
	public User findOne(int id){
		for(User user: userList){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
	public User addUser(User user){
		
		if(user.getId()==null){
			user.setId(userList.size()+1);			
		}
		
		userList.add(user);
		
		return user;
	}
	
	
	
}
