package ATM.CS151;

import java.util.ArrayList;

/**
 * ATM for ATM_Network project
 * @author AnthonyJhong
 * @version 1.0 3/2/2019
 */

/**
 * The Customer class represents a customer who uses an ATM
 */

public class Customer {
	
	private String name;
	private ArrayList<CheckingAccount> custAccounts;
	
	/**
	 * Constructor of the Customer Class initializes the name of the customer and an ArrayList of CheckingAccounts the user may have
	 * @param n name of the customer
	 */
	public Customer(String n) {
		name = n;
		custAccounts = new ArrayList<>();
	}
	
	/**
	 * Returns the name of the customer
	 * @return String name of customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Checking Accounts that the customer has opened
	 * @return ARrayList<CheckingAccounts> all checking accounts
	 */
	public ArrayList<CheckingAccount> getCustomerAccounts(){
		return custAccounts;
	}
	
	/**
	 * Adds a checking account to the list of accounts the user has open
	 * @param acc Checking account the customer opened
	 */
	public void addAccount(CheckingAccount acc) {
		custAccounts.add(acc);
	}
}
