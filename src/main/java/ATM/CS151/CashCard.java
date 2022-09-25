package ATM.CS151;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * CashCard for ATM_Network project
 * @author AnthonyJhong
 * @version 1.0 3/2/2019
 */

/**
 * The CashCard class is used by customers with checking accounts to withdraw money from ATMs
 */

public class CashCard {
	private LocalDate expDate;
	private String cardNumber;//first character is the bank id and the rest is the customer account number
	private ArrayList<String> log;
	
	/**
	 * Constructor of CashCard class 
	 * @param number the ID of the bank the card belongs to + the account number of the account that the card belongs to
	 */
	public CashCard(String number) {
		cardNumber = number;
		log = new ArrayList<String>();
		expDate = LocalDate.now().plusMonths(36); //adds 3 years to the current date to sent the expiration date
	}
	
	/**
	 * Set the card number of the CashCard
	 * @param num card number
	 */
	public void setCardNumber(String num) {
		cardNumber = num;
	}
	
	/**
	 * Returns the card number of the CashCard
	 * @return String card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * Returns the expiration date of the card
	 * @return LocalDate expiration date
	 */
	public LocalDate getExpDate(){
		return expDate;
	}
	
	/**
	 * Logs the transactions of the card
	 * @param event transaction
	 */
	public void logTransaction(String event) {
		log.add(event);
	}
	
	/**
	 * Returns the log of transactions on the CashCard
	 * @return ArrayList<String> transaction log
	 */
	public ArrayList<String> getTransactionHitory(){
		return log;
	}
	
	public void setExpDate(LocalDate d) {
		expDate = d;
	}
}
