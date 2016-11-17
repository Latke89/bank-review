package com.practice;

/**
 * Created by Brett on 11/17/16.
 */
public class BankAccount {

	private double accountBalance = 0;

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double deposit(double depositAmount) {
		accountBalance += depositAmount;
		return accountBalance;
	}

	public double withdraw(double withdrawAmount) {
		accountBalance -= withdrawAmount;
		return accountBalance;
	}

	public double getBalance() {
		return accountBalance;
	}

}
