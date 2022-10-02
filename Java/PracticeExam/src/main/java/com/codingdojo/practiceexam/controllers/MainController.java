package com.codingdojo.practiceexam.controllers;

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

import com.codingdojo.practiceexam.models.Listing;
import com.codingdojo.practiceexam.models.LoginUser;
import com.codingdojo.practiceexam.models.User;
import com.codingdojo.practiceexam.services.ListingService;
import com.codingdojo.practiceexam.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private ListingService listingService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin",new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result , Model model, HttpSession session) {
		User user = userServ.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/welcome";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()|| user==null) {
			model.addAttribute("newUser" , new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/welcome";
		
		
	}
	
	@GetMapping("/welcome")
	public String welcome(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("listings",listingService.allListings());
			
		
		return "welcome.jsp";
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
			User user = userServ.findById(userId);
			Listing newListing = new Listing(listing.getAddress(),listing.getPrice());
			newListing.setUser(user);
			listingService.addListing(newListing);
			userServ.updateUser(user);
			return "redirect:/welcome";
		}
	}
	
	
	
	@RequestMapping("/listings/delete/{id}")
	public String deleteListing(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userServ.findById(userId);
		
		Listing listing = listingService.findById(id);
		if(listing !=null) {
			listingService.deleteListing(listing);
		}
		
		
		return "redirect:/welcome";
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
		Long userId = (Long) session.getAttribute("userId");
		if(userServ.findById(userId)==listing.getUser()) {
			model.addAttribute("listing", listing);
			model.addAttribute("canEdit", true);
			return "edit_listing.jsp";
		}
		else {
			model.addAttribute("canEdit", false);
			return "edit_listing.jsp";
		}
		
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
		
		User user = userServ.findById(userId);
		
		if(result.hasErrors()) {
			return "edit_listing.jsp";
		}else {
			Listing thisListing = listingService.findById(id);
			listing.setUser(thisListing.getUser());
			listing.setUser(user);
			listingService.updateListing(listing);
			return "redirect:/welcome";
		}
	}

	
	
	
	
	
	

}
