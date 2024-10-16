package com.tus.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import com.tus.enums.AccountType;
import com.tus.interfaces.Account;
import com.tus.models.Customer;
import com.tus.models.Teller;
import com.tus.models.User;

public class BankService {
	private ArrayList<User> users = new ArrayList<User>();
	private static Scanner input = new Scanner(System.in);
	
	public BankService() {
		users.add(new Teller("John", "Doe", LocalDate.of(1990, Month.JANUARY, 12), "0831234567", "123 Fake St.", "password1234"));
		
		Customer c1 = new Customer("Jane", "Doe", LocalDate.of(1991, Month.SEPTEMBER, 18), "0851122334", "98 O'Connel Avenue");
		c1.addAccount(Account.createAccount(AccountType.Savings, 100));
		
		users.add(c1);
		
		Customer c2 = new Customer("Mary", "Smith", LocalDate.of(1999, Month.JULY, 2), "0857654321", "28 Chapel St. Leonards");
		c2.addAccount(Account.createAccount(AccountType.Savings, 100));
		c2.addAccount(Account.createAccount(AccountType.Current, 0));
		
		users.add(c2);
	}
	
	private void listCustomers() {
		System.out.println("---------\nCustomers\n---------");
		
		for (User user : users) {
			if (user instanceof Customer) {
				System.out.println(user);
			}
		}
	}
	
	private void listTellers() {
		System.out.println("-------\nTellers\n-------");
		
		for (User user : users) {
			if (user instanceof Teller) {
				System.out.println(user);
			}
		}
	}
	
	private void mainMenu() {
		System.out.println("---------\nBank Menu\n---------");
		System.out.println("1. List Customers");
		System.out.println("2. List Tellers");
		System.out.println("0. Quit");
		System.out.print("Select option from menu above: ");
	}
	
	public void run() {
		int choice = -1;
		do  {
			mainMenu();
			
			choice = input.nextInt();
			
			System.out.println();
			
			switch(choice) {
			case 1:
				listCustomers();
				break;
			case 2:
				listTellers();
				break;
			case 0:
				System.out.println("Application Exited");
				break;
			default:
				System.out.println("Invalid option, please select from menu items provided.");
			}
		} while (choice != 0);
	}
}
