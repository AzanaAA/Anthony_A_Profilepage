package com.codingdojo.yoga.controllers;

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

import com.codingdojo.yoga.models.Course;
import com.codingdojo.yoga.models.LoginUser;
import com.codingdojo.yoga.models.User;
import com.codingdojo.yoga.services.CourseService;
import com.codingdojo.yoga.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private CourseService courseService;
	
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
		return "redirect:/courses";
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
		return "redirect:/courses";
		}
		
	}
	
	@GetMapping("/courses")
	public String welcome(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("user", userServ.findById(userId));
		model.addAttribute("courses", courseService.allCourses());
		return "courses.jsp";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		return "new_course.jsp";
	}
	
	
	@PostMapping("/courses/new")
	public String addNewCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return"redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		if(result.hasErrors()) {
			return"new_course.jsp";
		} else {
			User user = userServ.findById(userId);
			Course newCourse = new Course(course.getCourseName(),course.getWeekDay(),course.getPrice(),course.getDescription());
			newCourse.setUser(user);
			courseService.addCourse(newCourse);
			userServ.updateUser(user);
			return "redirect:/courses";
		}
	}
	
	
	
	
	@RequestMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id")Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		Course course = courseService.findById(id);
		if(course !=null) {
			courseService.deleteCourse(course);
		}
		return "redirect:/courses";
	}
	
	
	
	@GetMapping("/courses/{id}")
	public String viewCourse(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Course course = courseService.findById(id);
		model.addAttribute("course", course);
		return"view_course.jsp";
	}
	
	
	
	
	@GetMapping("/courses/edit/{id}")
	public String openEditCourse(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/logout";
		}
		Course course = courseService.findById(id);
		Long userId = (Long) session.getAttribute("userId");
		if(userServ.findById(userId)==course.getUser()) {
			model.addAttribute("course",course);
			model.addAttribute("canEdit", true);
			return "edit_course.jsp";
		}
		else {
			model.addAttribute("canEdit",false);
			return "edit_course.jsp";
		}
	}
	
	
	@PostMapping("/courses/edit/{id}")
	public String editCourse(@PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")== null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userServ.findById(userId);
		if(result.hasErrors()) {
			return "edit_course.jsp";
		} else {
			Course thisCourse = courseService.findById(id);
			course.setUser(thisCourse.getUser());
			course.setUser(user);
			courseService.updateCourse(course);
			return "redirect:/courses";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
