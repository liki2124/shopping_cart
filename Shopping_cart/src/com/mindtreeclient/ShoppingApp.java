package com.mindtreeclient;

import java.security.Provider.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindtreeentity.Customer;
import com.mindtreeentity.Item;
import com.mindtreeeservice.ShopService;

public class ShoppingApp {
	static Scanner sc = new Scanner(System.in);
	static ShopService serOb = new ShopService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		Item i = new Item();
		boolean exitmenu = true;
do {
			System.out.println("************************");
			System.out.println("1. sign up customer");
			System.out.println("2. calculate bill");
			System.out.println("3. add item");
			System.out.println("4. update item quantity");
			System.out.println("5. delete an item");
			System.out.println("6. display all items");
			System.out.println("7. exit");
			System.out.println("**************************");
			System.out.println("enter your choice");

			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
			case 1:
				c = signUp();

				break;
			case 2:
				String name = getName();
				int quantity = 0;
				try {
					quantity = getQuantity();
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				double cal = serOb.calculateBill(name, quantity);
				System.out.println(cal);
				break;
			
			case 3:
				i = addItem();
				serOb.add(i);
				break;
			case 4:
				String name1 = getName();
				int quantity1 = 0;
				try {
					quantity1 = getQuantity();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				serOb.update(quantity1, name1);
				break;
			case 5:
				int id1;
				try {
					id1 = getId();
					serOb.delete(id1);
				} catch (Exception e) {

					e.printStackTrace();
				}

				break;
			case 6:
				serOb.display();
				break;
			case 7:
				exitmenu= false;
				break;
			default:
				System.out.println("invalid choice");
			}
}while(exitmenu);
		}
	
	

	public static Customer signUp() {
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.println("enter phone number");
		String number = sc.nextLine();
		
		LocalDate date = LocalDate.now();
		Customer ob = new Customer(id, name, number, date);
		return ob;

	}

	public static Item addItem() {
		System.out.println("enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("enter name");
		String name = sc.nextLine();
		System.out.println("enter price");
		double price = sc.nextDouble();
		System.out.println("enter quantity");
		int quantity = sc.nextInt();
		sc.nextLine();
		Item i = new Item(id, name, price, quantity);
		return i;
	}

	public static int getId() throws Exception {
		try {
			System.out.println("enter id");
			int id = sc.nextInt();
			sc.nextLine();
			return id;
		} catch (InputMismatchException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static int getQuantity() throws Exception {
		try {
			System.out.println("enter quantity");
			int id = sc.nextInt();
			sc.nextLine();
			return id;
		} catch (InputMismatchException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String getName() {
		System.out.println("enter item name");
		String name = sc.nextLine();
		return name;
	}

	public static double calBill() {
		System.out.println("enter the item purchased and quantity");

		return 0;
	}

}
