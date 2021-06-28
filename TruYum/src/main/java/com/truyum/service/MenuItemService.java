package com.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truyum.Dao.MenuItemDao;
import com.truyum.model.MenuItem;

@Service
public class MenuItemService {

	
@Autowired
private MenuItemDao menuRepo;
private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

//This function is to view all the menu-items list of customer
public List<MenuItem> getMenuItemCustomer() { 
	
	
return menuRepo.getMenuItemListCustomer();
	
}

//This function is to view all the menu-items list of admin
public List<MenuItem> getMenuItemAdmin() { 
	
	
return menuRepo.findAll();
	
}

//This function returns a particular menuitem filter by id
public MenuItem getMenuITemById(int mID) {
Optional<MenuItem>	menuItem=menuRepo.findById(mID);
if(menuItem.isPresent()) {
	return menuItem.get();
}
else {
	return null;
}

}

//This function update  a particular menuitem in the database
//Basically for cart Update
public String saveMenuItem(MenuItem m) {
	menuRepo.save(m);
	return "updated";
	
}

//This function update  a particular menuItem (particular values) in the database
public String updateMenuITem(int menu_id , MenuItem m) {
	Optional<MenuItem>	menuItem=menuRepo.findById(menu_id);
	if(menuItem.isPresent()) {
	MenuItem	menu= menuItem.get();
	menu.setPrice(m.getPrice());
	menu.setActive(m.getActive());
	menu.setDateOfLaunch(m.getDateOfLaunch());
	menu.setCategory(m.getCategory());
	if (m.getFreeDelivery()==null) {
		menu.setFreeDelivery("No");
	}
		else
			menu.setFreeDelivery("Yes");
	
	menuRepo.save(menu);
	return "Updated";
	}
	
	return "";
}
}

