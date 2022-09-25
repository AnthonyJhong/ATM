package ATM.CS151;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ATM for ATM_Network project
 * @author AnthonyJhong
 * @version 1.0 3/2/2019
 */

/**
 * The ATM class is used to simulate real world ATM's allowing users to withdraw money using CashCards
 */

public class ATM {
	private double max;
	private Bank bank;
	private String name;
	private CashCard currentCard;
	
	/**
	 * Constructor of ATM class
	 * @param b the bank that the ATM belongs to
	 * @param n The name of the ATM
	 * @param max The max amount of money that can be withdrawn
	 */
	public ATM(Bank b, String n, double max) {
		bank = b;
		name = n;	
		this.max = max;
	}
	
	/**
	 * Returns the bank that the ATM belongs to 
	 * @return Bank
	 */
	public Bank getBank() {
		return bank;
	}
	public void welcomMessage() {
		System.out.println(name + ": ATM for bank" + bank.getID());
		System.out.println("   The maximum amount of cash a card can widthraw per transaction: " + max);
	}
	
	/**
	 * Checks if the account and bank on the card match the bank of the current card
	 * @param card card number that the user inputs
	 * @return boolean
	 */
	public void cardValidation(String cardNumber, Scanner in) {
		currentCard =  bank.accountExists(cardNumber);
		if(currentCard== null) {
			System.out.print("This card is not supported by this ATM the card has been returned to you! Please enter a different card: ");
			cardNumber = in.nextLine();
			currentCard = bank.accountExists(cardNumber);
		}
		
		if(currentCard.getExpDate().isBefore(LocalDate.now())) {
			System.out.print("This card is expired! Enter a different card: ");
			cardNumber = in.nextLine();
			currentCard = bank.accountExists(cardNumber);
		}
	}
	
	/**
	 * Checks if the password the user entered corresponds with their account
	 * @param passcode the pass code the user entered
	 * @return boolean if the password was correct or not
	 */
	public boolean passWordValidated(String passcode) {
		return bank.passwordCorrect(passcode, currentCard.getCardNumber());
	}
	
	/**
	 * Withdraws money Calls withdrawRequest in Bank class
	 * @param ammount the amount of money the user would like to withdraw
	 * @param in Scanner to read amount if current amount is greater than max
	 */
	public void withdrawal(double amount, Scanner in) {
		
		if(amount >= max) {
			in = new Scanner(System.in);
			System.out.print("The amount that you wanted to withdraw exceeded the max allowed! Please enter a new value: ");
			amount = in.nextDouble();
		}
		bank.withdrawRequest(amount, currentCard.getCardNumber(), in);
		
	}
	
	/**
	 * Prints the transaction log of the card that is currently being used
	 */
	public void printTransactionLog() {
		ArrayList<String> transLog = currentCard.getTransactionHitory();
		
		for(int i = 0; i < transLog.size(); i++) {
			System.out.println(transLog.get(i));
		}
	}
	
}
