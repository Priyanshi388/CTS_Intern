package com.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truyum.Dao.CartDao;
import com.truyum.model.Cart;
@Service
public class CartService {

@Autowired
private CartDao cartrepo; 

//This  function is used to add cart to the database
public String saveCart(Cart cart) {
	
  	cartrepo.save(cart);
  	return "cart saved";
	
	
}


	
	
	
}
