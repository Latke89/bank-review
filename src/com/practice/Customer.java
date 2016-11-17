package com.practice;

import java.util.HashMap;

/**
 * Created by Brett on 11/17/16.
 */
public class Customer {
	HashMap<String, BankAccount> myAccounts = new HashMap<>();
	private String firstName;
	private String lastName;

	public HashMap<String, BankAccount> getMyAccounts() {
		return myAccounts;
	}

	public void setMyAccounts(HashMap<String, BankAccount> myAccounts) {
		this.myAccounts = myAccounts;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
