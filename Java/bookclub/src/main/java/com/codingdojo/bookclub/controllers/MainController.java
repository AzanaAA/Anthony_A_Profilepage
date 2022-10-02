package com.codingdojo.bookclub.controllers;

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


import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.UserLogin;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;


@Controller
public class MainController{
	
	
	
	@Autowired
    private UserService users;
	
	
	
    @Autowired
    private BookService books;
    
    
    
    
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new UserLogin());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session){
    	users.validate(newUser, result);
        if(result.hasErrors()){
            model.addAttribute("newLogin", new UserLogin());
            return "index.jsp";
        }
    
    User user = users.registerUser(newUser);
        session.setAttribute("userId", user.getId());
        return "redirect:/home";
    }
    
    
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session){
    	if(session.getAttribute("userId") == null){
    		return "redirect:/";
    		}
    	model.addAttribute("books", books.all());
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "home.jsp";
    }
    
    
   
    
    
    
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, BindingResult result, Model model, HttpSession session){
        User user = users.login(newLogin, result);
        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId());  
        return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
    	session.invalidate();
    	return "redirect:/";
    }
    
    
    
    
    
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result){
    	if (result.hasErrors()){
    		return "addBook.jsp";
    		}
    	books.create(book);
    	return "redirect:/home";
    }
    
    
    
    
    @GetMapping("/books/{id}")
    public String showPage(Model model, @PathVariable("id") Long id, HttpSession session){
    	if(session.getAttribute("userId") == null){
  		return "redirect:/";
    	}
    	Book book = books.findById(id);
    	model.addAttribute("book", book);
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	return "book.jsp";
    }
    
    
    
    
    @GetMapping("/books/new")
    public String addPage(@ModelAttribute("book") Book book, Model model, HttpSession session){
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	return "addBook.jsp";
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
