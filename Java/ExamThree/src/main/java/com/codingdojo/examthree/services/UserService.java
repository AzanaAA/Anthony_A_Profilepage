package com.codingdojo.examthree.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.examthree.models.LoginUser;
import com.codingdojo.examthree.models.User;
import com.codingdojo.examthree.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	public User register (User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "An account with that email already exists!");
			return null;
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm password must match Password");
			return null;
		}
		if(result.hasErrors()) {
			return null;}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		
		if(!potentialUser.isPresent()) {
			result.rejectValue("email","matches","user not found");
			return null;
		
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
			return null;
		}
		

		return user;
	}
	
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public User updateUser (User user) {
		return userRepo.save(user);
	}

}
