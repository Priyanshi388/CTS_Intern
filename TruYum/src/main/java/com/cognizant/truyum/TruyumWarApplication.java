package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
public class TruyumWarApplication {

	public static MenuItemService menuItemService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MenuItemService.class);
	
	/**
	 *   get Admin menuitem List
	 */
	public void getMenuItemListAdmin()
	{
		LOGGER.debug("Admin Menu Item List :{}",menuItemService.getMenuItemListAdmin());
	}
	
	/**
	 *  get customer menuitem list
	 */
	public void getMenuItemListCustomer()
	{
		LOGGER.debug("Customer Menu Item List: {}",menuItemService.getMenuItemListCustomer());
	}
	
	/**
	 *   edit menuitems 
	 */
	public void modifyMenuItem()
	{
		MenuItem menuItem=menuItemService.getMenuItem(1);
		menuItem.setActive(true);
		menuItem.setPrice(100);
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.debug("MenuItems: {}",menuItem);
		LOGGER.info("********end**********");
	}
	
	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(TruyumWarApplication.class, args);
		menuItemService=context.getBean(MenuItemService.class);
		TruyumWarApplication obj=new TruyumWarApplication();
		//obj.getMenuItemListAdmin(); 
		obj.getMenuItemListCustomer(); 
		//obj.modifyMenuItem();
	}

}
