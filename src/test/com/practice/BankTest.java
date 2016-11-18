package com.practice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Brett on 11/17/16.
 */
public class BankTest {
	@Before
	public void setUp() throws Exception {
		myBank = new Bank();
	}

	@After
	public void tearDown() throws Exception {

	}

	Bank myBank;

	@Test
	public void testAddCustomer() {
		String first = "Brett";
		String last = "Gordon";
		Customer myCustomer = new Customer(first, last);
		assertEquals("Brett", myCustomer.getFirstName());
	}

	@Test
	public void testCreateAccount() {
		String first = "Brett";
		String last = "Gordon";
		Customer testCustomer = new Customer(first, last);
		myBank.myCustomers.add(testCustomer);

		String accountName = "The Best Account Ever!";
		BankAccount myAccount = new Checking();
		int customerIndex = myBank.getIndexByName(first);
		myBank.myCustomers.get(customerIndex).myAccounts.put(accountName, myAccount);
		assertEquals(true, myBank.myCustomers.get(customerIndex).myAccounts.containsKey(accountName));
	}

	@Test
	public void multipleUsers() {
		String userOneFirst = "Brett";
		String userOneLast = "Gordon";
		Customer testOne = new Customer(userOneFirst, userOneLast);

		String userTwoFirst = "Ben";
		String userTwoLast = "Lee";
		Customer testTwo = new Customer(userTwoFirst, userTwoLast);

		String userThreeFirst = "Lauren";
		String userThreeLast = "Routier";
		Customer testThree = new Customer(userThreeFirst, userThreeLast);

		myBank.myCustomers.add(testOne);
		myBank.myCustomers.add(testTwo);
		myBank.myCustomers.add(testThree);

		assertEquals(3, myBank.myCustomers.size());

	}

	@Test
	public void multipleAccounts() {
		String first = "Brett";
		String last = "Gordon";
		Customer testCustomer = new Customer(first, last);
		myBank.myCustomers.add(testCustomer);
		int userIndex = myBank.getIndexByName(first);

		String accountOne = "The Best Damn Account";
		String accountTwo = "An ok Account";
		String accountThree = "Not Such A Great Account";

		BankAccount firstAccount = new Checking();
		BankAccount secondAccount = new Savings();
		BankAccount thirdAccount = new Retirement();

		myBank.myCustomers.get(userIndex).myAccounts.put(accountOne, firstAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountTwo, secondAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountThree, thirdAccount);

		assertEquals(3, myBank.myCustomers.get(userIndex).myAccounts.size());
	}

	@Test
	public void multipleUsersWithMultipleAccounts() {
		String userOneFirst = "Brett";
		String userOneLast = "Gordon";
		Customer testOne = new Customer(userOneFirst, userOneLast);

		String userTwoFirst = "Ben";
		String userTwoLast = "Lee";
		Customer testTwo = new Customer(userTwoFirst, userTwoLast);

		String userThreeFirst = "Lauren";
		String userThreeLast = "Routier";
		Customer testThree = new Customer(userThreeFirst, userThreeLast);

		myBank.myCustomers.add(testOne);
		myBank.myCustomers.add(testTwo);
		myBank.myCustomers.add(testThree);

		assertEquals(3, myBank.myCustomers.size());

		String accountOne = "The Best Damn Account";
		String accountTwo = "An ok Account";
		String accountThree = "Not Such A Great Account";

		BankAccount firstAccount = new Checking();
		BankAccount secondAccount = new Savings();
		BankAccount thirdAccount = new Retirement();

		int userIndex = myBank.getIndexByName(userOneFirst);

		myBank.myCustomers.get(userIndex).myAccounts.put(accountOne, firstAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountTwo, secondAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountThree, thirdAccount);

		assertEquals(3, myBank.myCustomers.get(userIndex).myAccounts.size());

		accountOne = "Another Account";
		accountTwo = "Second Account";
		accountThree = "Yet Another Bank Account";
		userIndex = myBank.getIndexByName(userTwoFirst);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountOne, firstAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountTwo, secondAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountThree, thirdAccount);

		assertEquals(3, myBank.myCustomers.get(userIndex).myAccounts.size());

		accountOne = "More Accounts!";
		accountTwo = "Names names names";
		accountThree = "Bill";
		userIndex = myBank.getIndexByName(userThreeFirst);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountOne, firstAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountTwo, secondAccount);
		myBank.myCustomers.get(userIndex).myAccounts.put(accountThree, thirdAccount);

		assertEquals(3, myBank.myCustomers.get(userIndex).myAccounts.size());

	}

}