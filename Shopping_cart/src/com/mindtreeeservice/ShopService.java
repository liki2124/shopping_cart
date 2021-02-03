package com.mindtreeeservice;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



import com.mindtreedao.Dao;
import com.mindtreeentity.Customer;
import com.mindtreeentity.Item;
import com.mindtreeexception.DatabaseFailedConnection;
import com.mindtreeexception.IdPresentAlready;

public class ShopService {

	Item i = new Item();
	static Scanner sc=new Scanner(System.in);
	public void add(Item i) {
		try {
			Dao.addToDb(i);
		} catch (DatabaseFailedConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(int quantity, String name) {
		try {
			Dao.updateToDb(quantity, name);
		} catch (DatabaseFailedConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			Dao.delete(id);
		} catch (DatabaseFailedConnection e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public double calculateBill(String name, int quantity) {
		double cal = 0;
		try {
			List<Item> list = Dao.retreive();
			for (Item i : list) {
				if (i.getName().equals(name)) {
					cal = i.getPriceperitem() * i.getQuantity();
				}
			}

		} catch (DatabaseFailedConnection e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
	}

	public void display() {
		try {
			List<Item> list = Dao.retreive();
			System.out.println("Based on quantity");
			Collections.sort(list, (a, b) -> (int) (a.getQuantity() - b.getQuantity()));
			list.forEach(s -> System.out
					.println(i.getId() + " " + i.getName() + " " + i.getPriceperitem() + " " + i.getQuantity()));
			System.out.println("==================");

			System.out.println("Based on price");
			Collections.sort(list, (a, b) -> (int) (a.getPriceperitem() - b.getPriceperitem()));
			list.forEach(i -> System.out.println(i.getId() + " " + i.getName() + " " + i.getPriceperitem() + " " + i.getQuantity()));
		} 
		catch (DatabaseFailedConnection e) 
		{

			e.printStackTrace();
		} 
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}

	

}
