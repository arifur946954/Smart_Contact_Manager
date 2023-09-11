package com.Smart_Contact_Manager.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailServiceImpl();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authentaticitionprovider() {
		DaoAuthenticationProvider daoauthonticitionProvider=new DaoAuthenticationProvider();
		daoauthonticitionProvider.setUserDetailsService(this.getUserDetailsService());
		daoauthonticitionProvider.setPasswordEncoder(passwordEncoder());
		return daoauthonticitionProvider;
	}
	//configue method
	//-> src+ override/implent 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authentaticitionprovider());
	}
	
	//configure http security
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN").
		antMatchers("/user/**").hasAnyRole("USER").antMatchers("/**").permitAll().and().formLogin().and().
        csrf().disable();
		
	}
	
	
	
		
	

}
