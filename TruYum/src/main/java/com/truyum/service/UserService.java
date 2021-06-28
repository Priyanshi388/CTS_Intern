package com.truyum.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.truyum.Dao.UserDao;
import com.truyum.model.User;
@Service
public class UserService {


@Autowired
private UserDao userRepo;

private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

//This is function is used to save the user to the database ,it only performs the operation if username is not present in the database
public  String createUser(User user)
{  if(! getUserByName( user)) {
	userRepo.saveAndFlush(user);
	return "User created";
}
else {
	return "username already taken";
}
}

//This function is used to check if the user is present or not based on  username(as username is unique)
public boolean getUserByName(User user) { 
	
	User userCheck = userRepo.findByUserName(user.getUserName());
	if(userCheck==null)
		return false;
	else
		return true;
	
	
	
	
}

//This function is used to get  the user  based on  username(as username is unique)
public User getUserByUserName(String username) { 
	LOGGER.debug("username"+username);
	
	User userCheck = userRepo.findByUserName(username);
	return userCheck;
	
	
	
	
}
}
