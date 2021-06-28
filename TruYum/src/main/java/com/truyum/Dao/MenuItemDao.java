package com.truyum.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.truyum.model.MenuItem;
@Repository
public interface MenuItemDao  extends JpaRepository<MenuItem, Integer>{
	//This function is to menuitems who is active and dateoflaunch is not future
	@Query("select m from MenuItem m where active='Yes' and dateOfLaunch<=sysdate()")
	List<MenuItem> getMenuItemListCustomer();
}
