package com.Smart_Contact_Manager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/index")
	public String Dashboard() {
		return "User_Dashboard";
	}

}
