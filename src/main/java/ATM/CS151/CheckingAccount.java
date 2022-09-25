package ATM.CS151;

import java.util.Scanner;

/**
 * ATM for ATM_Network project
 * @author AnthonyJhong
 * @version 1.0 3/2/2019
 */

/**
 * The CheckingAccount class is used by customers and banks storing their passwords and balances
 */

public class CheckingAccount {
	
	private Customer customer;
	private double balance;
	private String password;
	private String accNumber;
	private CashCard card;
	
	/**
	 * Constructor of CheckingAccount sets the Customer, Password, and AccountNumber
	 * @param cust Customer that the CheckingAccount belongs to 
	 * @param pass Password of the newly created CheckingAccount
	 * @param accNum Account number of the new CheckingAccount
	 */
	public CheckingAccount(Customer cust, String pass, String accNum) {
		customer = cust;
		balance = 600;
		password = pass;
		accNumber = accNum;
	}
	
	/**
	 * Sets the password of the account
	 * @param pass new password
	 */
	public void setPassword(String pass) {
		password = pass;
	}
	
	/**
	 * Sets the balance of the account
	 * @param ammount the new balance
	 */
	public void setBalance(double amount) {
		balance  = amount;
	}
	
	/**
	 * Returns the Customer that the account belongs to
	 * @return Customer owner of account
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Returns the balance of the account
	 * @return double balance of account
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Returns the password of the account
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Returns the account number
	 * @return String account number
	 */
	public String getAccountnumber() {
		return accNumber;
	}
	
	/**
	 * Withdraws money from account, subtracts amount from the balance of the account
	 * @param ammount the amount of money that is being withdrawn
	 * @param in scanner that is used to prompt the user to enter another amount if current amount is greater than balance
	 */
	public void withDraw(double ammount, Scanner in) {
		if(ammount >= balance) {
			in = new Scanner(System.in);
			System.out.print("The amount that you are trying to withdraw exceeds your balance! Please enter a new value below $" + 
					balance + ": ");
			ammount = in.nextDouble();
		}
		
		balance = balance - ammount;
		System.out.println("$" + ammount + " is withdrawn from  your account. The remaining balance of this account is $ "+ balance);
		card.logTransaction(Double.toString(ammount) + " withdrawn");
	}
	
	/**
	 * sets the CashCard of the checking account
	 * @param c CashCard
	 */
	public void setCashCard(CashCard c) {
		card = c;
	}
	/**
	 * Returns the cash card of the checking account
	 * @return CashCard card 
	 */
	public CashCard getCashCard() {
		return card;
	}
}
