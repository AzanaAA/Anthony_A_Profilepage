package com.codingdojo.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.exam.models.Listing;
import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.ListingService;
import com.codingdojo.exam.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private ListingService listingService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {

	    User user = userService.register(newUser, result);
	     
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
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
		model.addAttribute("unassignedListings", listingService.getUnassignedUsers(userService.findById(userId)));
		model.addAttribute("assignedListings", listingService.getAssignedUsers(userService.findById(userId)));
		 
		return "home.jsp";
	}
	
	
	@GetMapping("/listings/{id}")
	public String viewListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Listing listing = listingService.findById(id);
		model.addAttribute("listing", listing);
		return "view_listing.jsp";
	}
	
	
	@GetMapping("/listings/edit/{id}")
	public String openEditListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Listing listing = listingService.findById(id);
		model.addAttribute("listing", listing);
		return "edit_listing.jsp";
	}
	
	@PostMapping("/listings/edit/{id}")
	public String editListing(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("listing") Listing listing, 
			BindingResult result, 
			HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userService.findById(userId);
		
		if(result.hasErrors()) {
			return "edit_listing.jsp";
		}else {
			Listing thislisting = listingService.findById(id);
			listing.setUsers(thislisting.getUsers());
			listing.setLead(user);
			listingService.updateListing(listing);
			return "redirect:/home";
		}
	}
	
	
	@RequestMapping("/listings/delete/{id}")
	public String deleteListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userService.findById(userId);
		
		Listing listing = listingService.findById(id);
		
		listingService.deleteListing(listing);
		model.addAttribute("unassignedListings", listingService.getUnassignedUsers(user));
		model.addAttribute("assignedListings", listingService.getAssignedUsers(user));
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/";
	}
	
	@GetMapping("/listings/new")
	public String newListing(@ModelAttribute("listing") Listing listing, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "new_listing.jsp";
	}
	
	@PostMapping("/listings/new")
	public String addNewListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		if(result.hasErrors()) {
			return "new_listing.jsp";
		}else {
			User user = userService.findById(userId);
			Listing newListing = new Listing(listing.getAddress(), listing.getListedOn(), listing.getAddedBy(),listing.getPrice() ,listing.getLead());
			newListing.setLead(user);
			listingService.addListing(newListing);
			user.getListingsLed().add(newListing);
			userService.updateUser(user);
			return "redirect:/home";
		}
	}

	
	
	
	
	
	
}
