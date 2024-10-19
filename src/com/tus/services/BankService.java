package com.tus.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.tus.enums.AccountType;
import com.tus.interfaces.Accountable;
import com.tus.models.Account;
import com.tus.models.Customer;
import com.tus.models.SavingsAccount;
import com.tus.models.Teller;
import com.tus.models.User;

public class BankService {
	private ArrayList<User> users = new ArrayList<User>();
	private CustomerService customerService = new CustomerService();
	
	private static Scanner input = new Scanner(System.in);
	
	public BankService() {
		users.add(new Teller("John", "Doe", LocalDate.of(1990, Month.JANUARY, 12), "0831234567", "123 Fake St.", "password1234"));
		
		Customer c1 = new Customer("Jane", "Doe", LocalDate.of(1991, Month.SEPTEMBER, 18), "0851122334", "98 O'Connel Avenue");
		c1.addAccount(Accountable.createAccount(AccountType.Savings, 100));
		
		users.add(c1);
		
		Customer c2 = new Customer("Mary", "Smith", LocalDate.of(1999, Month.JULY, 2), "0857654321", "28 Chapel St. Leonards");
		c2.addAccount(Accountable.createAccount(AccountType.Savings, 100));
		c2.addAccount(Accountable.createAccount(AccountType.Current, 0));
		
		users.add(c2);
	}
	
	private void mainMenu() {
		System.out.println("---------\nBank Menu\n---------");
		System.out.println("1. List Customers");
		System.out.println("2. List Tellers");
		System.out.println("3. Add new customer");
		System.out.println("4. Pay Monthly Dividends");
		System.out.println("5. Customer Menu");
		System.out.println("0. Quit");
		System.out.print("Select option from menu above: ");
	}
	
	private void listCustomers() {
		System.out.println("---------\nCustomers\n---------");
		
		users.stream()
			.filter(c -> c instanceof Customer)
			.forEach(c -> System.out.println(c));
	}
	
	private void listTellers() {
		System.out.println("-------\nTellers\n-------");
		
		users.stream()
			.filter(t -> t instanceof Teller)
			.forEach(t -> System.out.println(t));
	}
	
	private void payDividends() {
		var customers = users.stream()
			.filter(u -> u instanceof Customer)
			.map(c -> (Customer) c)
			.collect(Collectors.toList());
			
		customers.forEach(c -> {
			for (Account account : c.getAccounts()) {
				if (account instanceof SavingsAccount) {
					((SavingsAccount) account).payDividends(); 
				}
			}
		});
	}
	
	public void run() {
		int selection = -1;
		
		do  {
			mainMenu();
			
			try {
				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invlaid input, menu selection must be an interger.\n");
				input.nextLine();
				continue;
			}
			
			System.out.println();
			
			switch(selection) {
			case 1:
				listCustomers();
				break;
			case 2:
				listTellers();
				break;
			case 3:
				break;
			case 4:
				payDividends();
				break;
			case 5:
				var customers = users.stream()
					.filter(c -> c instanceof Customer)
					.map(c -> (Customer) c)
					.collect(Collectors.toList());
				
				customerService.run(new ArrayList<Customer>(customers));
				
				break;
			case 0:
				System.out.println("Application Exited");
				break;
			default:
				System.out.println("Invalid option, please select from menu items provided.");
			}
		} while (selection != 0);
	}
}
