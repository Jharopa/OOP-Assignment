package com.tus.services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.tus.models.accounts.Account;
import com.tus.models.accounts.AccountException;
import com.tus.models.users.Customer;
import com.tus.utils.StringUtils;

public class CustomerService {
	private Customer currentCustomer;
	
	private static Scanner input = new Scanner(System.in);
	
	public CustomerService() {
		this.currentCustomer = null;
	}
	
	private void mainMenu() {
		String header = StringUtils.makeHeader("Account ID: " + currentCustomer.getId() + " Customer: " + currentCustomer.getFullName());
		
		System.out.println(header);
		System.out.println("1. Deposit");
		System.out.println("2. Widthdraw");
		System.out.println("3. List Transactions");
		System.out.println("0. Return");
		System.out.print("Select option from menu above: ");
	}
	
	private void customerSelection(ArrayList<Customer> customers) {
		do {
			System.out.println("ID\tCustomer Name");
			
			for (Customer customer : customers) {
				System.out.println(customer.getId() + "\t" + customer.getFullName());
			}
			
			int id;
			
			try {
				System.out.print("Please select customer from list above by ID: ");
				
				id = input.nextInt();
				
				currentCustomer = Customer.findCustomerById(customers, id);
				
				if (currentCustomer == null) {
					System.out.println("Unable to find customer with ID " + id);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, Customer ID must be an integer.");
				input.nextLine();
			}
			
			System.out.println();
		} while (this.currentCustomer == null);
	}
	
	private Account accountSelection() {
		Account selectedAccount = null;
		
		do {
			System.out.println("\nID\tType\tBalance");
			
			for (Account account : currentCustomer.getAccounts()) {
				System.out.println(account);
			}
			
			int id;
			
			try {
				System.out.print("Please select customer from list above by ID: ");
				
				id = input.nextInt();
				
				selectedAccount = Account.findAccountById(currentCustomer.getAccounts(), id);
				
				if (currentCustomer == null) {
					System.out.println("Unable to find account with ID " + id + "\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, Account ID must be an integer.");
				input.nextLine();
			}
			
 		} while (selectedAccount == null); 
		
		return selectedAccount;
	}
	
	private void deposit(Account account) {
		System.out.print("\nEnter amount to be deposited: ");
		
		double amount;
		
		try {
			amount = input.nextDouble();
			account.deposit(amount);
			System.out.println("\nSuccessfully desposited " + amount + " to account " + account.getId() + "\n");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input, deposit amount must be a decimal.");
			input.nextLine();
		} catch (AccountException e) {
			System.out.println("Invalid input, " + e.getMessage());
		} finally {
			System.out.println("Cancelling deposit.\n");
		}
	}
	
	private void widthdraw(Account account) {
		System.out.print("\nEnter amount to be widthdrawn: ");
		double amount;
		
		try {
			amount = input.nextDouble();
			account.withdraw(amount);
			System.out.println("\nSuccessfully withdrew " + amount + " to account " + account.getId() + "\n");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input, widthdrawl must be a decimal.");
			input.nextLine();
		} catch (AccountException e) {
			System.out.println("Invalid input, " + e.getMessage());
		} finally {
			System.out.println("Cancelling widthdrawl.\n");
		}
	}
	
	private void listTransactions(Account account) {
		System.out.println();
		account.listTransactions();
		System.out.println();
	}
	
	public void run(ArrayList<Customer> customers) {
		customerSelection(customers);
		
		int selection = -1;
		
		do {
			mainMenu();
			
			try {
				selection = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invlaid input, menu selection must be an interger.\n");
				input.nextLine();
				continue;
			}
			
			Account account;
			
			switch(selection) {
			case 1:
				account = accountSelection();
				deposit(account);
				break;
			case 2:
				account = accountSelection();
				widthdraw(account);
				break;
			case 3:
				account = accountSelection();
				listTransactions(account);
				break;
			case 0:
				System.out.println("\nReturning to bank menu\n");
				break;
			default:
				System.out.println("Invalid option, please select from menu items provided.");
			}
		} while (selection != 0);
	}
}
