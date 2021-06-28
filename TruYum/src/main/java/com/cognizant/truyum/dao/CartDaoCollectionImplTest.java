package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		int itemAdded = 0;

		do {
			System.out.println("Menu \n 1. Add Cart Item. \n 2. Get All Cart Items. \n3. Remove Cart Item\n 4.Exit");
			choice = sc.nextLine();
			switch (choice) {
			case "1": {
				System.out.println("Item is added in User Id 1. Enter 2 To test.");
				testAddCartItem();
				itemAdded++;
				break;
			}
			case "2": {
				testGetAllCartItems();
				break;
			}
			case "3": {
				if (itemAdded != 0) {
					System.out.println("Item is removed in User Id 1. Enter 2 to test.");
				
					testRemoveCartItem();
					itemAdded--;
				} else {
					System.out.println("Cart is Empty!!!!");
				}
				break;
			}
			case "4": {
				break;
			}
			default: {
				System.out.println("Enter the correct choice");
			}
			}
		} while (!choice.equals("4"));

		sc.close();
	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
	}

	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		try {
			List<MenuItem> menuItemList = cartDao.getAllCartItems(1);
			System.out.println("User Id 1 content is displayed");
		
			for (MenuItem menuItem : menuItemList) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println("Cart Empty !!");
		
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);
	}
}
