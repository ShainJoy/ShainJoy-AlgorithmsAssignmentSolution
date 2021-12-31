package gl.stockers.model;

import java.util.Scanner;
import gl.stockers.service.BinarySearch;
import gl.stockers.service.Sort;

/**
 * This class holds all shares data in an array. 
 * All operations related to the share records are managed in this class.
 * For searching and sorting, it makes use of other classes. 
 * 
 * @author Shain Joy
 */

public class Records {
	Scanner sc = new Scanner(System.in);
	BinarySearch search = new BinarySearch();
	Sort stkSort = new Sort();
	boolean aryInAscending = false;
	Share[] shares;
	Share share;
	
	// This method allows user to enter a share price and search it in the list
	// If array is not in ascending order, it sorts before search.
	public void searchPrice() {
		System.out.println("\nEnter the key value");
		double price = sc.nextDouble();
		if (aryInAscending == false) {
			stkSort.ascending(shares);
		}
		int tmp = search.find(shares, price);
		if (tmp == -1) {
			System.out.println("Value not found");
		}
		else {
			System.out.println("Stock of value " + shares[tmp].price + " is present ");
		}
	}
	
	// Counting and displaying total no of companies for which 
	// stock prices declined.
	public void priceIncreases() {
		int reslt = 0;
		for (Share stk: shares) {
			if (stk.upTrend == true) {
				reslt++;
			}
		}
		System.out.println("\nTotal no of companies whose stock price rose today : " + reslt);	
	}
	
	// Counting and displaying total no of companies for which 
	// stock prices rose.
	public void priceDecreases() {
		int reslt = 0;
		for (Share stk: shares) {
			if (stk.upTrend == false) {
				reslt ++;
			}
		}
		System.out.println("\nTotal no of companies whose stock price declined today : " + reslt);
	}

	// This method sorts the array in Descending order and 
	// uses display method to print the same
	public void dispDescendingOrder() {
		stkSort.descending(shares);
		System.out.println("\nStock prices in descending order are :");
		display();
		aryInAscending = false;
	}

	// Sorting in ascending order and prints the prices
	public void dispAscendingOrder() {
		stkSort.ascending(shares);
		System.out.println("\nStock prices in ascending order are :");
		display();
		aryInAscending = true;
	}
	
	// This method simply prints out all elements' prices
	// in the same order, as it is in the array.
	public void display() {
		for (Share stk: shares) {
			System.out.print(stk.price + " ");
		}
		System.out.println();
	}
	
	
	// This method receives the user input of each share 
	// and stores into an array as share objects
	public void populate(int noOfShares) {
		shares = new Share[noOfShares];
		double price;
		boolean upTrend;
		
		for(int i = 1; i <= noOfShares; i++) {
			System.out.println("Enter current stock price of the company " + i);
			price = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			upTrend = sc.nextBoolean();
			share = new Share(price, upTrend);
			shares[i-1] = share;
		}
	}
}
