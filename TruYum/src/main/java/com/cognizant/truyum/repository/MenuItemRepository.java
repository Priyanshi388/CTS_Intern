package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

	@Query(value = "select * from menu_item where me_active=true and me_date_of_launch<=current_date()",nativeQuery = true)
	public List<MenuItem> getAllActiveItems();
	
}
