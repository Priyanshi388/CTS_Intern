package com.truyum.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truyum.model.Cart;
@Repository
public interface CartDao  extends JpaRepository<Cart, Integer>{

	
	
}
