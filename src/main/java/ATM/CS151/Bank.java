package ATM.CS151;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/**
 * Bank for ATM_Network project
 * @author AnthonyJhong
 * @version 1.0 3/2/2019
 */

/**
 * The Bank class is used to run transactions from the ATM to the checking accounts of the users
 */

public class Bank {
	private String id;
	private ArrayList<CheckingAccount> checkingAccounts;
	
	/**
	 * Constructor of the Bank class sets the ID of the bank and initializes an ArrayList of checking accounts
	 * @param setID the ID of the bank
	 */
	public Bank(String setID) {
		id = setID;
		checkingAccounts = new ArrayList<CheckingAccount>();
	}
	
	/**
	 * Returns the ID of the bank
	 * @return String the ID of the bank
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Returns the ArrayList of CheckingAccounts opened with the bank
	 * @return ArrayList of CheckingAccounts in the bank
	 */
	public ArrayList<CheckingAccount> getAccountsatBank(){
		return checkingAccounts;
	}
	
	/**
	 * Adds a CheckingAccount to the bank
	 * @param acc CheckingAccount opened with the bank
	 */
	public void addAccount(CheckingAccount acc) {
		checkingAccounts.add(acc);
		CashCard newCard = new CashCard(id+acc.getAccountnumber());
		acc.setCashCard(newCard);
	}
	
	/**
	 * Checks to see if an account exists
	 * @param accNumber account number being cross checked with ArrayList of CheckingAccounts
	 * @return CashCard the card that belongs to the account
	 */
	public CashCard accountExists(String accNumber) {
		if(checkingAccounts.isEmpty()) {
			return null;
		}
		if(!accNumber.substring(0, 1).equals(id))
			return null;
		else {
			for(int i = 0; i < checkingAccounts.size(); i++) {
				if(accNumber.substring(1).equals(checkingAccounts.get(i).getAccountnumber())) {
						return checkingAccounts.get(i).getCashCard();
					}
				}
			}
		return null;
	}
	
	/**
	 * Checks to see if the password that was entered was the correct one for the specific account
	 * @param passcode password that the user entered
	 * @param accNumber account number of the account the user was trying to access
	 * @return boolean if the password was correct or not
	 */
	public boolean passwordCorrect(String passcode, String accNumber) {
		
		if(checkingAccounts.isEmpty()) {
			return false;
		}
		if(!accNumber.substring(0, 1).equals(id))
			return false;
		else {
			for(int i = 0; i < checkingAccounts.size(); i++) {
				if(accNumber.substring(1).equals(checkingAccounts.get(i).getAccountnumber()) && 
						passcode.equals(checkingAccounts.get(i).getPassword())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Finds the account that the user is trying to withdraw from and calls withDraw in the CheckingAccount class
	 * @param ammount amount of money the user wants to withdraw
	 * @param accNumber the account number of the account that the user is trying to withdraw from 
	 * @param in Scanner to pass as a parameter for the withDraw() method in CheckingAccount 
	 */
	public void withdrawRequest(double ammount, String accNumber, Scanner in) {
		if(checkingAccounts.isEmpty()) {
			return;
		}
		else {
			for(int i = 0; i < checkingAccounts.size(); i++) {
				if(accNumber.substring(1).equals(checkingAccounts.get(i).getAccountnumber())) {
					checkingAccounts.get(i).withDraw(ammount, in);
					return;
				}
			}
		}
	}
	
	/**
	 * Prints all of the customers data and cash card information
	 */
	public void printAllCustomers() {
		if(checkingAccounts.isEmpty()) {
			return;
		}
		else {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			for(int i = 0; i < checkingAccounts.size(); i++) {
				
				System.out.println(checkingAccounts.get(i).getCustomer().getName() + " - cash card (" + checkingAccounts.get(i).getCashCard().getCardNumber() + 
						") Expires: " + formatter.format(checkingAccounts.get(i).getCashCard().getExpDate())+ 
						", Password: " + checkingAccounts.get(i).getPassword() + ", Balance: " + 
						checkingAccounts.get(i).getBalance());
				
			}
		}
		
	}
	
}
