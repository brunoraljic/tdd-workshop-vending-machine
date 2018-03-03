package com.brunoraljic.tdd;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachine {

	/**
	 * This is the only method to be tested in this workshop.
	 * 
	 * It should calculate the change for the vending machine, using the following
	 * coin denominations: "2.00", "1.00", "0.50", "0.20", "0.10", "0.05", "0.02",
	 * "0.01"
	 * 
	 * @param price
	 *            of the article to be bought
	 * @param cashPaid
	 *            how much money we inserted into the vending machine
	 * @return {@link List} of {@link BigDecimal} representing the coins to be
	 *         returned. This list is sorted (e.g. change of 3.50 will be returned
	 *         as 2.00, 1.00 and 0.50). In case that price is bigger than the amount
	 *         of cash, it will throw {@link IllegalArgumentException} with message
	 *         "Not enough money!"
	 */
	List<BigDecimal> calculateChange(BigDecimal price, BigDecimal cashPaid) throws IllegalArgumentException;

}
