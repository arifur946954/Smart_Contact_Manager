package com.Smart_Contact_Manager.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Smart_Contact_Manager.Dao.UserRepository;
import com.Smart_Contact_Manager.entity.User;

public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user from database
	User user=	userRepository.getUserByName(username);
	if(user==null) {
		throw new UsernameNotFoundException("could not found userName");
	}
CustomerDetails customDetails=	new CustomerDetails(user);
		return customDetails;
	}

}
