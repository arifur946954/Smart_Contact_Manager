package com.Smart_Contact_Manager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Smart_Contact_Manager.entity.User;
//JpaRepository represent CRUD and integer is primary key of user databse/class

public interface UserRepository extends JpaRepository<User,Integer > {

}
