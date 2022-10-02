package com.codingdojo.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService{
	
	
	
	
    @Autowired
    private UserRepository userRepository;
    
    
    
    public void validate (User newUser, BindingResult result) {
    	Optional<User> userLookUp = userRepository.findByEmail(newUser.getEmail());
    	if (userLookUp.isPresent()){
    		result.rejectValue("Email", "Unique", "Account with this email already exists.");
    	}
        	if(!newUser.getPassword().equals(newUser.getConfirm())){
    	    result.rejectValue("Confirm", "Matches", "The Confirm Password must match Password!");
    	}
       	
    }
    
    public User registerUser (User newUser) {
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	newUser = userRepository.save(newUser);
    	System.out.println("User Created ID: " + newUser.getId());
        return newUser;
    }
    	
    
    public User login(UserLogin newLogin, BindingResult result){
    	Optional<User> userLookUp = userRepository.findByEmail(newLogin.getEmail());
    	if (!userLookUp.isPresent()){
    		result.rejectValue("Email", "Missing Account", "No Account Has Been Found!");
    		return null; 
    	}
    	User user = userLookUp.get();
         	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
    	    result.rejectValue("Password", "Matches", "Invalid Password!");
    	}
    	if(result.hasErrors()){
    	return null;
    	}
        return user;
    }

    
    
    
	public User findByEmail(String email) {
		Optional<User> result = userRepository.findByEmail(email);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
	
	
	
	public User findById(Long id){
		Optional<User> result = userRepository.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
