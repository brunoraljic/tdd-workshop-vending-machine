package com.brunoraljic.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class VendingMachineTest {

	// Coin denominations
	private static final String COIN_2_00 = "2.00";
	private static final String COIN_1_00 = "1.00";
	private static final String COIN_0_50 = "0.50";
	private static final String COIN_0_20 = "0.20";
	private static final String COIN_0_10 = "0.10";
	private static final String COIN_0_05 = "0.05";
	private static final String COIN_0_02 = "0.02";
	private static final String COIN_0_01 = "0.01";
	
	VendingMachine machine;

	BigDecimal price;
	BigDecimal cashPaid;

	@Before
	public void setUp() {
		machine = new VendingMachineFactory().getVendingMachine();
	}

	/**
	 * Price is same as total cash paid. No change is expected (i.e. empty list)
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase1() {
		// Test data
		price = new BigDecimal("2.00");
		cashPaid = new BigDecimal(COIN_2_00);

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertTrue("Change should be empty, but it is not!", change.isEmpty());

	}

	/**
	 * Price is higher than total cash paid. Exception is expected
	 */
	@Test(expected = IllegalArgumentException.class)
	@Ignore
	public void testCalculateChangeCase2() {
		// Test data
		price = new BigDecimal("3.00");
		cashPaid = new BigDecimal(COIN_2_00);

		try {
			// method to be tested
			machine.calculateChange(price, cashPaid);
		} catch (IllegalArgumentException e) {
			// assertions in catch block are necessary because of exception message
			assertEquals("Not enough money!", e.getMessage());
			throw e;
		}

	}

	/**
	 * Change should be only one coin of value 2.00
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase3() {
		// Test data
		price = new BigDecimal("2.00");
		cashPaid = new BigDecimal("4.00");

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertEquals(1, change.size());
		assertEquals(COIN_2_00, change.get(0).toString());
	}

	/**
	 * Change should be two coins of value 2 => 6 - 2 = 4 = 2 x 2.00
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase4() {
		// Test data
		price = new BigDecimal("2.00");
		cashPaid = new BigDecimal("6.00");

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertEquals(2, change.size());
		assertEquals(COIN_2_00, change.get(0).toString());
		assertEquals(COIN_2_00, change.get(1).toString());
	}

	/**
	 * Change should be two coins of values 2.00 and 1.00 => 5 - 2 = 3 = 2.00 + 1.00
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase5() {
		// Test data
		price = new BigDecimal("2.00");
		cashPaid = new BigDecimal("5.00");

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertEquals(2, change.size());
		assertEquals(COIN_2_00, change.get(0).toString());
		assertEquals(COIN_1_00, change.get(1).toString());
	}

	/**
	 * Test case for several coins of different denomination
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase6() {
		// Test data
		price = new BigDecimal("1.36");
		cashPaid = new BigDecimal("5.00");

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertEquals(6, change.size());
		assertEquals(COIN_2_00, change.get(0).toString());
		assertEquals(COIN_1_00, change.get(1).toString());
		assertEquals(COIN_0_50, change.get(2).toString());
		assertEquals(COIN_0_10, change.get(3).toString());
		assertEquals(COIN_0_02, change.get(4).toString());
		assertEquals(COIN_0_02, change.get(5).toString());
	}

	/**
	 * Test case that will return each coin
	 */
	@Test
	@Ignore
	public void testCalculateChangeCase7() {
		// Test data
		price = new BigDecimal("0.12");
		cashPaid = new BigDecimal("4.00");

		// method to be tested
		List<BigDecimal> change = machine.calculateChange(price, cashPaid);

		// assertions
		assertEquals(8, change.size());
		assertEquals(COIN_2_00, change.get(0).toString());
		assertEquals(COIN_1_00, change.get(1).toString());
		assertEquals(COIN_0_50, change.get(2).toString());
		assertEquals(COIN_0_20, change.get(3).toString());
		assertEquals(COIN_0_10, change.get(4).toString());
		assertEquals(COIN_0_05, change.get(5).toString());
		assertEquals(COIN_0_02, change.get(6).toString());
		assertEquals(COIN_0_01, change.get(7).toString());
	}
}
