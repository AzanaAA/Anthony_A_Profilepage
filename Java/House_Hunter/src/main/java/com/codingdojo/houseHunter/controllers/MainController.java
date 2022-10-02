package com.codingdojo.houseHunter.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.houseHunter.models.User;
import com.codingdojo.houseHunter.models.UserLogin;
import com.codingdojo.houseHunter.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

	
	
	
	
	@GetMapping("/")
	public String index(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new UserLogin());
	    return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {

	    User user = userService.register(newUser, result);
	     
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new UserLogin());
	        return "index.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, 
			BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	     
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	
	@GetMapping("/home")
	public String dashboard(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userService.findById(userId));
		

		 
		return "home.jsp";
		
	}
	
	
	

}
