package com.codingdojo.houseHunter.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.houseHunter.models.User;
import com.codingdojo.houseHunter.models.UserLogin;
import com.codingdojo.houseHunter.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> loginAttempt = userRepository.findByEmail(newUser.getEmail());
    	
    	if(loginAttempt.isPresent()) {
    		result.rejectValue("email", "Matches", "An account with that email already exists!");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepository.save(newUser);	
	}
	
	public User login(UserLogin newLogin, BindingResult result) {

		Optional<User> loginAttempt = userRepository.findByEmail(newLogin.getEmail());
		
    	if(!loginAttempt.isPresent()) {
    		result.rejectValue("email", "Matches", "User not found!");
    		return null;
    	}
    	User user = loginAttempt.get();   
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    	    result.rejectValue("password", "Matches", "Invalid Password!");
    	}	
    	if(result.hasErrors()) {
    		return null;
    	}
        return user;
	}
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	
	

	
	
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
	
	
	
	
}
