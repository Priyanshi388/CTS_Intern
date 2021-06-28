package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static ApplicationContext cpxac = new ClassPathXmlApplicationContext("spring-config.xml");
	public static MenuItemService menuItemService = (MenuItemService) cpxac.getBean("menuItemService");

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String aChoice;

		do {
			System.out.println("Menu\n 1.Admin\n2.Customer\n3.Exit");			
			aChoice = sc.nextLine();
			

			switch (aChoice) {
			case "1": {
				String adminChoice;
				do {
					System.out.println("Admin Menu\n1. Get Menu Item List.\n 2. Modify Menu Item.\n3. Get Menu Item.\n4. Main Menu");
				
					adminChoice = sc.nextLine();
					switch (adminChoice) {
					case "1": {
						System.out.println("Admin Menu Item List");
						testGetMenuItemListAdmin();
						break;
					}
					case "2": {
						System.out.println("Item 2 is modified. Enter 3 to display the changes.");
						testModifyMenuItem();
						break;
					}
					case "3": {
						System.out.println("2nd Menu Item is displayed");
						testGetMenuItem();
						break;
					}
					case "4": {
						break;
					}
					default: {
						System.out.println("Enter the valid choice");
					}
					}
				} while (aChoice.equals("4"));
				break;
			}
			case "2": {
				System.out.println("Customer Menu Item List");
				testGetMenuItemListCustomer();
				break;
			}
			case "3": {
				break;
			}
			default: {
				System.out.println("Enter the  correct choice");
			}
			}
		} while (aChoice.equals("3"));

		sc.close();
	}

	public static void testGetMenuItemListAdmin() {

		

		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}
	}

	public static void testGetMenuItemListCustomer() {
		
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(2, "Pizza", 129f, true, DateUtil.convertToDate("22/09/19"), "Starter",
				false);
		
		menuItemService.modifyMenuItem(menuItem);
	}

	public static void testGetMenuItem() {
		
		System.out.println(menuItemService.getMenuItem(2));
	}
}
