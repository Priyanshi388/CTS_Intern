package com.cognizant.truyum.dao;

import java.util.Scanner;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice;

		do {
			System.out.println("Menu");
			System.out.println("****************************************");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.println("****************************************");

			choice = sc.nextLine();
			System.out.println("****************************************");

			switch (choice) {
			case "1": {
				String adminChoice;
				do {
					System.out.println("Admin Menu");
					System.out.println("****************************************");
					System.out.println("1. Get Menu Item List");
					System.out.println("2. Modify Menu Item");
					System.out.println("3. Get Menu Item");
					System.out.println("4. Main Menu");
					System.out.println("****************************************");

					adminChoice = sc.nextLine();
					System.out.println("****************************************");

					switch (adminChoice) {
					case "1": {
						System.out.println("Admin Menu Item List");
						System.out.println("****************************************");
						testGetMenuItemListAdmin();
						break;
					}
					case "2": {
						System.out.println("Item 2 is modified. Enter 3 to display the changes.");
						System.out.println("****************************************");
						testModifyMenuItem();
						break;
					}
					case "3": {
						System.out.println("2nd Menu Item is displayed");
						System.out.println("****************************************");
						testGetMenuItem();
						break;
					}
					case "4": {
						break;
					}
					default: {
						System.out.println("Enter valid choice");
					}
					}
				} while (adminChoice.equals("4"));
				break;
			}
			case "2": {
				System.out.println("Customer Menu Item List");
				System.out.println("****************************************");
				testGetMenuItemListCustomer();
				break;
			}
			case "3": {
				break;
			}
			default: {
				System.out.println("Enter valid choice");
			}
			}
		} while (choice.equals("3"));

		sc.close();
		
	}

	public static void testGetMenuItemListAdmin() {

	}

	public static void testGetMenuItemListCustomer() {

	}

	public static void testModifyMenuItem() {

	}

	public static void testGetMenuItem() {

	}
}