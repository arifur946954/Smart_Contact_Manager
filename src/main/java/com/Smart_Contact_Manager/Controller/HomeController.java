package com.Smart_Contact_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Smart_Contact_Manager.Dao.UserRepository;
import com.Smart_Contact_Manager.Helper.Message;
import com.Smart_Contact_Manager.entity.User;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "home_smart_contact");
		model.addAttribute("description", "welcome to my home page ");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("aboutf", "Welcome to my about section");

		return "about";

	}

	@GetMapping("/SignUp")
	public String SignUp(Model model) {
		model.addAttribute("sign", "Welcome to my SignUp section");
		model.addAttribute("user", new User());

		return "SignUp";

	}

	// here aggrement is name of checkbox

	@PostMapping("/do_register")
	public String RegisterUser(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "aggrement", defaultValue = "false") boolean aggrement, Model model,
			BindingResult result1, HttpSession session

	)

	{
		try {
			if (!aggrement) {
				System.out.println("you have to maintain term and condition");
				throw new Exception("you have to maintain term and condition");
			}	
			
			  if(result1.hasErrors())
			  { System.out.println("ERROR"+result1.toString());
			  model.addAttribute("user",user);
			 
			  return "SignUp"; 
			  }
			 
			
			user.setRole("ROLE_USER");
			user.setEnable(true);
			user.setImage("default.png");

			System.out.println("Aggrement" + aggrement);
			System.out.println("User" + user);
			User result = userRepository.save(user);
			model.addAttribute("user", new User());

			session.setAttribute("messages", new Message("Register successfully", "allert-success"));
			return "SignUp";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			/* +e.getMessage() */
			session.setAttribute("messages",
					new Message("Something went" + " wrong and try again" + e.getMessage(), "alert-danger"));
			return "SignUp";
		}

	}

}
