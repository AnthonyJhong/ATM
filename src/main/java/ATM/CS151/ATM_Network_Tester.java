package ATM.CS151;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.HashMap;

public class ATM_Network_Tester {
	public static void main(String []args) {
		
		//initialization of bank a
		Bank bankA = new Bank("A");
		
		HashMap<String,ATM> allATMs = new HashMap<>();
		
		//Bank A has 2 ATM's
		ATM ATM1_A = new ATM(bankA, "ATM1_A", 500);
		allATMs.put("ATM1_A",ATM1_A);
		ATM ATM2_A = new ATM(bankA, "ATM2_A", 300);
		allATMs.put("ATM2_A",ATM2_A);
		
		//Bank A has 2 customers
		Customer cust1 = new Customer("Bob");
		CheckingAccount cust1Checking = new CheckingAccount(cust1, "helloworld", "123");
		bankA.addAccount(cust1Checking);
		cust1Checking.getCashCard().setExpDate(LocalDate.now().plusMonths(-2));

		
		Customer cust2 = new Customer("Tony");
		CheckingAccount cust2Checking = new CheckingAccount(cust2, "tony 22", "124");
		bankA.addAccount(cust2Checking);
		
		//initialization of bank B
		Bank bankB = new Bank("B");
		
		//Bank B has 2 ATM's 
		ATM ATM1_B = new ATM(bankB, "ATM1_B", 250);
		allATMs.put("ATM1_B",ATM1_B);
		ATM ATM2_B = new ATM(bankB, "ATM2_B", 50);
		allATMs.put("ATM2_B",ATM2_B);
		
		//Bank B has 3 Customers one of which has an account at bankA
		CheckingAccount cust1Checking2 = new CheckingAccount(cust1, "helloworld", "12");
		bankB.addAccount(cust1Checking2);
		
		Customer cust3 = new Customer("Ben");
		CheckingAccount cust3Checking = new CheckingAccount(cust3, "CS151", "13");
		bankB.addAccount(cust3Checking);
		
		Customer cust4 = new Customer("Sara");
		CheckingAccount cust4Checking = new CheckingAccount(cust4, "SJSU", "14");
		bankB.addAccount(cust4Checking);
		
		System.out.println("Assume all accounts have 600 dollars preloaded!");
		
		//print all of the customers who have an account in bankA
		System.out.println("List of all cutomers in bankA: ");
		
		bankA.printAllCustomers();
		System.out.println();
		
		//print all customers who have an account at bankB
		System.out.println("List of all cutomers in bankB: ");
		
		bankB.printAllCustomers();
		System.out.println();
		
		System.out.println("State of 4 ATM's: ");
		ATM1_A.welcomMessage();
		ATM2_A.welcomMessage();
		ATM1_B.welcomMessage();
		ATM2_B.welcomMessage();
		System.out.println();
		
		Scanner in= new Scanner(System.in);
		String userATM;
		String userCard;
		String userPassword;
		String withdrawAmmount;
		
		System.out.print("Enter your choice of ATM: ");
		userATM = in.nextLine();
		
		while(!allATMs.containsKey(userATM)) {
			System.out.print("ATM Invalid: Enter your choice of ATM: ");
			userATM = in.nextLine();
		}
		
		System.out.print("Enter your card: ");
		userCard = in.nextLine();
		allATMs.get(userATM).cardValidation(userCard, in);
		System.out.println("A card has been accepted!");
		
		System.out.print("Enter password: ");
		userPassword = in.nextLine();
		if(!allATMs.get(userATM).passWordValidated(userPassword)) {
			System.out.print("Wrong Password! Please try again: ");
			userPassword = in.nextLine();
		}
		
		System.out.print("Authorization Accepted: Start by entering the amount you would like to withdraw: ");
		withdrawAmmount = in.nextLine();
		
		while(!withdrawAmmount.equals("q") || withdrawAmmount.equals("Q") ) {
			
			allATMs.get(userATM).withdrawal(Double.parseDouble(withdrawAmmount), in);
			System.out.print("The transaction has been successfuly completed! Enter another amount or [Q]uit: ");
			withdrawAmmount = in.nextLine();
		}
		in.close();
		
		System.out.println("\nThis is your transaction log: ");
		allATMs.get(userATM).printTransactionLog();
		
		System.out.println("\nThank you, please come agian!\n");
		
		System.out.println("This is the state of all the customers after the transaction:");
		bankA.printAllCustomers();
		bankB.printAllCustomers();
	}
}
