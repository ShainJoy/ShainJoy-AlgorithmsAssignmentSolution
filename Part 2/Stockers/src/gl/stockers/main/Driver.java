package gl.stockers.main;

import java.util.Scanner;
import gl.stockers.model.Records;

/**
 * This is the driver class for 'Stockers' project.
 * Mainly receives user choices and makes use of 'Records' class to get the task done.
 * It has only main method.
 * 
 * @author Shain Joy
 */

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Records stocks = new Records();
		int choice = 0;
		
		//Based on user input, allows 'Records' class to populate it by itself.
		System.out.println("Enter the no of companies");
		int companies = sc.nextInt();
		stocks.populate(companies);
	
		//Provides a menu system to user for interactions
		do {
			System.out.println("\n-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			System.out.println("-----------------------------------------------");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				stocks.dispAscendingOrder();
				break;
			case 2:
				stocks.dispDescendingOrder();
				break;
			case 3:
				stocks.priceIncreases();
				break;
			case 4:
				stocks.priceDecreases();
				break;
			case 5:
				stocks.searchPrice();
				break;
			case 0:
				System.out.println("Exited successfully");
				break;
			default:
				System.out.println("Please enter a valid choice!");
			}
		}while(choice != 0);
		
		sc.close();
	}
}
