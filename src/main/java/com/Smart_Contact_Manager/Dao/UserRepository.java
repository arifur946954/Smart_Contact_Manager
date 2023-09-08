package com.Smart_Contact_Manager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Smart_Contact_Manager.entity.User;
//JpaRepository represent CRUD and integer is primary key of user databse/class

public interface UserRepository extends JpaRepository<User,Integer > {
	@Query("select u from User u where u.email=:email ")
	public User getUserByName(@Param ("email") String email); 
		
	

}
