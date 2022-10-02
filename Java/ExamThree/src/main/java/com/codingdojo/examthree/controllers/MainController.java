package com.codingdojo.examthree.controllers;

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

import com.codingdojo.examthree.models.LoginUser;
import com.codingdojo.examthree.models.Team;
import com.codingdojo.examthree.models.User;
import com.codingdojo.examthree.services.TeamService;
import com.codingdojo.examthree.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	
	@Autowired
	private TeamService teamService;
	
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
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userServ.login(newLogin, result);
		if(result.hasErrors()|| user==null) {
			model.addAttribute("newUser" , new User());
			return "index.jsp";
		}
		else {
		session.setAttribute("userId", user.getId());
		return "redirect:/home";
		}
		
	}
	
	
	@GetMapping("/home")
	public String welcome(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("teams", teamService.allTeams());
		return "home.jsp";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
	
	@GetMapping("/teams/new")
	public String newTeam(@ModelAttribute("team") Team team, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		return"new_team.jsp";
	}
	
	
	@PostMapping("/teams/new")
	public String addNewTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		if(result.hasErrors()) {
			return"new_team.jsp";
		} else {
			User user = userServ.findById(userId);
			Team newTeam= new Team(team.getTeamName(), team.getSkillLevel(), team.getGameDay());
			newTeam.setUser(user);
			teamService.addTeam(newTeam);
			userServ.updateUser(user);
			return "redirect:/home";
		}
	}
	
	
	
	@RequestMapping("teams/delete/{id}")
	public String deleteTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		Team team = teamService.findById(id);
		if(team !=null) {
			teamService.deleteTeam(team);
		}
		return"redirect:/home";
	}
	
	
	
	@GetMapping("/teams/{id}")
	public String viewTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Team team = teamService.findById(id);
		model.addAttribute("team", team);
		return "view_team.jsp";
	}
	
	
	@GetMapping("/teams/edit/{id}")
	public String openEditTeam(@PathVariable("id") Long id,HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Team team = teamService.findById(id);
		model.addAttribute("team", team);
		return"edit.jsp";
	}
	
	
	@PostMapping("/teams/edit/{id}")
	public String editTeam(@PathVariable("id") Long id, @Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		if(result.hasErrors()) {
			return"edit.jsp";
		} else {
			Team thisTeam = teamService.findById(id);
			team.setUsers(thisTeam.getUsers());
			team.setUser(user);
			teamService.updateTeam(team);
			return"redirect:/home";
			
		}
		
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
