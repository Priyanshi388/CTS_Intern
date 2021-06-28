package com.truyum.controller;
//import necessary packages
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.truyum.model.Cart;
import com.truyum.model.MenuItem;
import com.truyum.model.User;
import com.truyum.service.CartService;
import com.truyum.service.MenuItemService;
import com.truyum.service.UserService;

@Controller
public class TruyumController { 
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private MenuItemService menuService;
	@Autowired CartService cartService;
	
	
	//This used to register a new user to the Website and store it in database
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String viewIndex(@ModelAttribute User user) {
		LOGGER.debug("hello"); 
		
		return "Register";
	}
	
	//This Function actually store the user to the database and redirect the user to login page
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public String saveUser( User user,Model map ) {
		System.out.print("hello");
		
		String result=userService.createUser(user);
		if(result.equalsIgnoreCase("User created")) {
		LOGGER.debug(result);
		
		return "redirect:/login";
		}
		else {
			map.addAttribute("user",user);
			return "usernametaken";
					}
		
	}
	

	//This function is to view the login page
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(@ModelAttribute User user) {
		LOGGER.debug("hello"); 
		
		return "login";
	} 
	
	//This function is used to logout the user and redirect the user to login
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(@ModelAttribute User user) {
		LOGGER.debug("hello"); 
		
		return "redirect:/login";
	} 
	
	//This function is used to checks if the username is present in the database or not if true it redirects it to the respective pages.
	//If the username is "Admin" the it redirects to the admin page
	//if the username is anything other than admin it redirects it to the customer page
 	@RequestMapping(value="/loggedin",method=RequestMethod.POST)
	public String logged(User user, Model map,RedirectAttributes redirectAttributes) {
		LOGGER.debug("user"+user.getUserName()); 
		
		
		
		 if(userService.getUserByName(user)) {
			 if(user.getUserName().equalsIgnoreCase("admin")) {
					map.addAttribute("user",user);
					map.getAttribute("user");
					List<MenuItem> admin = menuService.getMenuItemAdmin();
					map.addAttribute("menuitemlist",admin);
					redirectAttributes.addFlashAttribute("user",user);
				return "redirect:/admin";
				}
			map.addAttribute("user",user);
			map.getAttribute("user");
			List<MenuItem> customer = menuService.getMenuItemCustomer();
			map.addAttribute("menuitemlist",customer);
			redirectAttributes.addFlashAttribute("user",user);
		return "redirect:/menu-item-customer";
		}
		else {
			LOGGER.debug("User not found");
			map.addAttribute("user",user);
			return "usernotfound";
		}
	} 
	
	//This function is for  the customer to view the list of available menuitems
	@RequestMapping(value="/menu-item-customer",method=RequestMethod.GET)
	public String MenuItemCustomer(@ModelAttribute("user") User user,Model map) {
		LOGGER.debug("hello menu"); 
		map.addAttribute("user",user);
		map.getAttribute("user");
		List<MenuItem> customer = menuService.getMenuItemCustomer();
		LOGGER.debug("Customer{}",customer);
		map.addAttribute("menuitemlist",customer);
		
		return "menu-item-customer";
	} 
	
	//This is function is for the customer(particular user) to view their cart
	//The "username"  here to identify the user  as username is unique in the table.
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public String viewCart(String username,Model map) {
		LOGGER.debug("hello cart"+username);
		
		User user =  userService.getUserByUserName(username);
		Cart cart;
		LOGGER.debug(user.getUserName());
		if(userService.getUserByUserName(username)!=null) {
			cart= user.getCart(); 
			if(cart ==null) {
				cart = new Cart();
				map.addAttribute("user",user);
				user.setCart(cart);
				return "cart-empty";
			
			}
		Set<MenuItem> mList=	cart.getMenuItemList();
		if(mList.size()==0) {
			map.addAttribute("user",user);
			return "empty-cart";
		}
		map.addAttribute("user",user);
		map.addAttribute("menuitemlist",mList);
		double sum=0;
		for(MenuItem m : mList) {
			sum= sum+m.getPrice();
			
		}
		map.addAttribute("total",sum);
		return "cart";
		}
		
		map.addAttribute("user",username);
		return "nouserfound";
		
	}
	//This is function is for the customer(particular user) to add a particular item to  their cart
		//The "username"  here to identify the user  as username is unique in the table.
	//The menuitem is primary key for the MenuItem , here to identify the mneuitem.
	@RequestMapping(value="/addtocart",method=RequestMethod.GET)
	public String addtoCart (int menuitem, String username,Model map) {
		LOGGER.debug("hello cart"+username+menuitem);
		User user =  userService.getUserByUserName(username);
		Cart cart; 
		cart= user.getCart(); 
		LOGGER.debug("cart{}",cart);
		if(cart ==null) {
			cart = new Cart( user); 
		String result=	cartService.saveCart(cart);
		LOGGER.debug(result);
		}
		Set<MenuItem> mList=	cart.getMenuItemList();
		MenuItem menuItem=	menuService.getMenuITemById(menuitem);
		Set<Cart> cartset=	menuItem.getCartset();
		LOGGER.debug("cartset"+cartset);
		
		
		
	
	if(mList==null)
		mList= new  HashSet<MenuItem>();
		mList.add(menuItem);
		cart.setMenuItemList(mList);
		user.setCart(cart); 
cartset=	menuItem.getCartset();
	LOGGER.debug("cartset"+cartset);
	if(cartset.size()==0)
	{
		cartset=new HashSet<Cart>();
	
		
	}
	cartset.add(cart);
	menuItem.setCartset(cartset);
String result=	menuService.saveMenuItem(menuItem);
LOGGER.debug(result);
	
		userService.createUser(user);
		cartService.saveCart(cart);
		menuService.saveMenuItem(menuItem);
		map.addAttribute("user",user);
		map.addAttribute("menuitemlist",mList);
		double sum=0;
		for(MenuItem m : mList) {
			sum= sum+m.getPrice();
			
		}
		map.addAttribute("total",sum);
		return "cart";
			
	
	}

	
	
	//This is function is for the customer(particular user) to remove a particular item from  their cart
			//The "username"  here to identify the user  as username is unique in the table.
		//The menuitem is primary key for the MenuItem , here to identify the mneuitem.
	@RequestMapping(value="/cart-notification",method=RequestMethod.GET)
	public String deletetoCart (int menuitem, String username,Model map) {	
		LOGGER.debug("Hello in remove item from cart");
		LOGGER.debug("hello cart"+username+menuitem);
		User user =  userService.getUserByUserName(username);
		Cart cart; 
		cart= user.getCart(); 
		LOGGER.debug("cart{}",cart);
		
		Set<MenuItem> mList=	cart.getMenuItemList();
		MenuItem menuItem=	menuService.getMenuITemById(menuitem);
		Set<Cart> cartset=	menuItem.getCartset();
		LOGGER.debug("cartset"+cartset);
		
		mList.remove(menuItem);
		cart.setMenuItemList(mList);
		user.setCart(cart); 

	LOGGER.debug("cartset"+cartset);
	cartset.remove(cart);
	menuItem.setCartset(cartset);
	String result=	menuService.saveMenuItem(menuItem);
	System.out.print("result"+result);
	

LOGGER.debug(result);

	
		userService.createUser(user);
		cartService.saveCart(cart);
		menuService.saveMenuItem(menuItem);
		map.addAttribute("user",user);
		map.addAttribute("menuitemlist",mList);
		double sum=0;
		for(MenuItem m : mList) {
			sum= sum+m.getPrice();
			
		}
		map.addAttribute("total",sum);
		
		return "cart-notification";
	} 
	
	
	//This  function is to view the list of menuitems 
	//The username maps afor the particular user
	@RequestMapping(value="/menu-item-list-customer_",method=RequestMethod.GET)	
	public String getMenuItemFromUser(String username,Model map) {
		User user =  userService.getUserByUserName(username);
		LOGGER.debug("hello menu update"); 
		map.addAttribute("user",user);
		map.getAttribute("user");
		List<MenuItem> customer = menuService.getMenuItemCustomer();
		LOGGER.debug("Customer{}",customer);
		map.addAttribute("menuitemlist",customer);
		
		return "menu-item-customer";
		
		
		
	} 
	
	//This function is for  the admin to view the list of available menuitems
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String viewIndexAdmin(@ModelAttribute("user") User user,Model map) {
		LOGGER.debug("hello menu"); 
	List<MenuItem> admin = menuService.getMenuItemAdmin();
		LOGGER.debug("admin{}",admin);
		map.addAttribute("user",user);
		map.addAttribute("menuitemlist",admin);
		LOGGER.debug("hello");
		return "menu-item-list-admin";
	}
	
	//This function is for  the admin to edit the list of available menuitems
	//Basically to view the from page
	@RequestMapping(value="/edit-menu-item",method=RequestMethod.GET)
	public String viewEditItem(int menuitem,String username,Model map) { 
		map.addAttribute("username",username);
		map.addAttribute("item",menuService.getMenuITemById(menuitem));
	
	return "edit-menu-item";

}
	
	//This function is for  the admin to edit the list of available menuitems
	//here actually the edit made by the admin get  reflected to the database
	@RequestMapping(value="/edit-menu-item-status",method=RequestMethod.POST)
	public String viewEditItemStatus(MenuItem menu,int menuitem,String username,Model map) { 
		LOGGER.debug("hello edit menu");
		map.addAttribute("username",username);
		map.addAttribute("item",menuService.getMenuITemById(menuitem));
		LOGGER.debug(menu.getActive()+menu.getFreeDelivery()); 
		String result=menuService.updateMenuITem(menuitem, menu);
		LOGGER.debug(result);
		
	
	return "edit-menu-item-status";
	
	}
	
	//This function for date to convert in the requested format
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));   
	}
	
	//This  function is to view the list of menuitems 
	//The username maps for the particular user
	@RequestMapping(value="/menu-item-list-admin",method=RequestMethod.GET)	
	public String getMenuItemAdminFromUser(String username,Model map) {
		User user =  userService.getUserByUserName(username);
		LOGGER.debug("hello menu update"); 
		map.addAttribute("user",user);
		map.getAttribute("user");
		List<MenuItem> admin = menuService.getMenuItemAdmin();
		LOGGER.debug("admin{}",admin);
		map.addAttribute("menuitemlist",admin);
		
		return "menu-item-list-admin";
		
		
		
	} 
	//This id function for  if the user wishes to access the menu/cart options before login.
	@RequestMapping(value="/login-first",method=RequestMethod.GET)	
	public String loginFirst() {
		return "login-first";		
	}
}	
	

