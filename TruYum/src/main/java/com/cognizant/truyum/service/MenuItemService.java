package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	public MenuItemRepository menuItemRepository;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(MenuItemService.class);
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin()
	{
		LOGGER.info("start");
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer()
	{
		LOGGER.info("start");
		return menuItemRepository.getAllActiveItems();
	}
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem)
	{
		LOGGER.info("start");
		menuItemRepository.save(menuItem);
	}
	
	@Transactional
	public MenuItem getMenuItem(int menuItemId)
	{
		LOGGER.info("start");
		return menuItemRepository.findById(menuItemId).get();
	}
	
}
