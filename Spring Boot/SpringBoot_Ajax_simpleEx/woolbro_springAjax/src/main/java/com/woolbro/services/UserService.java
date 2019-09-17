package com.woolbro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.woolbro.model.User;

@Service
public class UserService {
	
	private List<User> users;
	
	public List<User> findByUserNameOrEmail(String username){
		List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
		return result;
	}
	
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();
		
		User user1 = new User("woolbro","qwer111","woolbro@tistory.com");
		User user2 = new User("yunani","qwer222","yunani@tistory.com");
		User user3 = new User("bjkang","qwer333","bjkang@tistory.com");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}
}
