package com.Smart_Contact_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Smart_Contact_Manager.Dao.UserRepository;
import com.Smart_Contact_Manager.entity.User;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/test")
	@ResponseBody
	
	public String Test() {
		User user=new User();
		user.setName("arifur rahmnan");
		user.setEmail("arif.bd08060@gmail.com");
		userRepository.save(user);
		return "working";
	}

}
