package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Brett on 11/17/16.
 */
public class Bank {
	ArrayList<Customer> myCustomers = new ArrayList<>();

	public void menu() {
		if(myCustomers.size() == 0) {
			newCustomer();
		} else {
			newCustomer();
		}

	}

	public void newCustomer() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter your first name:");
		System.out.println("--------");
		String first = inputScanner.nextLine();
		System.out.println("Please enter your last name:");
		System.out.println("--------");
		String last = inputScanner.nextLine();
		Customer myCustomer = new Customer(first, last);
		System.out.println("Thank you, " + myCustomer.getFirstName() + ".");
		myCustomers.add(myCustomer);
	}

	public void openAccount(String firstName) {
		Scanner inputScanner = new Scanner(System.in);

		System.out.println("Please choose an account to open");
		try {
			System.out.println("1. Checking");
			System.out.println("2. Savings");
			System.out.println("3. Retirement");
			int accountChoice = Integer.valueOf(inputScanner.nextLine());
			if (accountChoice == 1) {
				System.out.println("What would you like to name your checking account?");
				String accountName = inputScanner.nextLine();
				BankAccount myChecking = new Checking();
				System.out.println("What is your initial deposit?");
				double initialDeposit = Integer.valueOf(inputScanner.nextLine());
				myChecking.deposit(initialDeposit);
				int customerIndex = getIndexByName(firstName);
				myCustomers.get(customerIndex).myAccounts.put(accountName, myChecking);
			} else if (accountChoice ==2) {
				System.out.println("What would you like to name your savings account?");
				String accountName = inputScanner.nextLine();
				BankAccount mySavings = new Savings();
				System.out.println("What is your initial deposit?");
				double initialDeposit = Integer.valueOf(inputScanner.nextLine());
				mySavings.deposit(initialDeposit);
				int customerIndex = getIndexByName(firstName);
				myCustomers.get(customerIndex).myAccounts.put(accountName, mySavings);
			} else if (accountChoice == 3) {
				System.out.println("What would you like to name your retirement account?");
				String accountName = inputScanner.nextLine();
				BankAccount myRetirement = new Retirement();
				System.out.println("What is your initial deposit?");
				double initialDeposit = Integer.valueOf(inputScanner.nextLine());
				myRetirement.deposit(initialDeposit);
				int customerIndex = getIndexByName(firstName);
				myCustomers.get(customerIndex).myAccounts.put(accountName, myRetirement);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getIndexByName(String inputName) {
		for (Customer currentCustomer : myCustomers) {
			if (currentCustomer.getFirstName().equalsIgnoreCase(inputName)) {
				return myCustomers.indexOf(currentCustomer);
			}
		}
		return -1;

	}

}
