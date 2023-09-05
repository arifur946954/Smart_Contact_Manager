package com.Smart_Contact_Manager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller

public class HomeController {
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
		
		return "SignUp";
		
	}
	
	
	

}
