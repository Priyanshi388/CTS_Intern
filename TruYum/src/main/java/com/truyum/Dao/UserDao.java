package com.truyum.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truyum.model.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer> { 
	
	public User  findByUserName(String name);
	
	
	

}
