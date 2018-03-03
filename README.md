# TDD workshop - Vending machine
## Purpose
This is material for our internal TDD quickstart workshop. It comes as maven project (mvn wrapper included). 
## Problem to solve
* `VendingMachine` has a single method 
`List<BigDecimal> calculateChange(BigDecimal price, BigDecimal cashPaid)`
* Your task is to provide implementation of calculating change. Return type is sorted `List<BigDecimal>` (e.g. change of 3.50 will be returned as 2.00, 1.00 and 0.50).
* In case the there is not enough money, throw an `IllegalArgumentException` with message `"Not enough money!"`

## Workshop steps
1. Project setup 
    * Add your own implementation of `VendingMachine`
    * Make changes in `VendingMachineFactory` that will return your implementation, instead of `null`
2. Think about the problem and about your solution in the next 3-5 minutes, write down your general idea or  pseudo code (not in too much details)
3. All the test cases are marked with `@Ignore`. Remove that annotation one at a time respecting the `red-green-refactor` cycle.
4. Compare your solution with the one from the beginning
5. Bonus step: Refactor tests
