package com.Smart_Contact_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Smart_Contact_Manager.Dao.UserRepository;
import com.Smart_Contact_Manager.entity.User;




@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title","home_smart_contact");
		model.addAttribute("description","welcome to my home page ");
	return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("aboutf","Welcome to my about section");
		
		return "about";
		
	}
	
	@GetMapping("/SignUp")
	public String SignUp(Model model) {
		model.addAttribute("sign","Welcome to my SignUp section");
		model.addAttribute("user",new User());
		
		return "SignUp";
		
	}
	
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
	public String RegisterUser(
			@ModelAttribute("user") User user,
			@RequestParam(value = "aggrement",
			defaultValue = "false")
	        boolean aggrement,Model model
	        )
	
	{  
		if(!aggrement) {
			System.out.println("you have to maintain term and condition");
		}
		user.setRole("ROLE_USER");
		user.setEnable(true);
		
		System.out.println("Aggrement" +aggrement);
	 System.out.println("User" +user);
	User result= userRepository.save(user);
	model.addAttribute(result);
	     
		return "SignUp";
	}
	
	
	

}
