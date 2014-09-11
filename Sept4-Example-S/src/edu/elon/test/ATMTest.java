package edu.elon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMTest {

	ATM testAtm;
	
	@Before
	public void setUp() throws Exception {
		testAtm = new ATM(10);
	}

	@After
	public void tearDown() throws Exception {
		testAtm = null;
	}

	@Test
	public void testDeposit() {
		int expected = 15;
		testAtm.deposit(5);
		int actual = (int) testAtm.getBalance(); 
		assertEquals(actual, expected);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDepositFail() {
		testAtm.deposit(-3);
	}

	@Test
	public void testGetBalance() {
		int actual = 10;
		int expected = (int) testAtm.getBalance();
		assertEquals(actual, expected);
	}

	@Test
	public void testToString() {
		String expected = "Amount balance is $10.00";
		String actual = testAtm.toString();
		assertEquals(actual, expected);
	}

	@Test
	public void testWithdraw() {
		int expected = 5;
		testAtm.withdraw(5);
		int actual = (int) testAtm.getBalance();
		assertEquals(actual, expected);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithdrawFailNegative() {
		testAtm.withdraw(-4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testWithdrawFailBalance() {
		testAtm.withdraw(15);
	}

}
