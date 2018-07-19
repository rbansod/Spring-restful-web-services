package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.User;

@Component
public class UserDAOService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"Adam", new Date()));
		users.add(new User(2,"Jack", new Date()));
		users.add(new User(3,"Eve", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==null || user.getId()==0)
			user.setId(++usersCount);
		users.add(user);
		
		return user;
	}
	
	public User findUser(int id) {
		for(User user: users) {
			if(user.getId()==id) return user;
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId()==id) {
				iterator.remove(); 
				return user;
			}
		}
		return null;
	}
}
