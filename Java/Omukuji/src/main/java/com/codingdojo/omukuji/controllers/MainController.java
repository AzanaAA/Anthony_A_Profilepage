package com.codingdojo.omukuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	
	
	@GetMapping("/")
	public String redirect() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	

	
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		String result= (String) session.getAttribute("passage");
		model.addAttribute("result", result);
		
		return "show.jsp";
	}
	
	
	@PostMapping("/form")
	public String form(
			@RequestParam("number") int number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("professional") String professional,
			@RequestParam("living") String living,
			@RequestParam("message") String message,
			HttpSession session
			) {
		
	String passage = String.format("In %s years you will live in %s with %s as your roomate, %s for a living. The next time you see a %s, you will have good luck. Also, %s.", number, city, person,professional,living,message);
		
		session.setAttribute("passage", passage);
		
		return "redirect:/omikuji/show";
	}

}
