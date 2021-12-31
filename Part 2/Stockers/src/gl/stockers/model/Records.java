package gl.stockers.model;

import java.util.Scanner;

import gl.stockers.service.BinarySearch;
import gl.stockers.service.Sort;

public class Records {
	Scanner sc = new Scanner(System.in);
	BinarySearch search = new BinarySearch();
	Sort stkSort = new Sort();
	boolean aryInAscending = false;
	Share[] shares;
	Share share;
	
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
	
	public void priceIncreases() {
		int reslt = 0;
		for (Share stk: shares) {
			if (stk.upTrend == true) {
				reslt++;
			}
		}
		System.out.println("\nTotal no of companies whose stock price rose today : " + reslt);	
	}
	
	public void priceDecreases() {
		int reslt = 0;
		for (Share stk: shares) {
			if (stk.upTrend == false) {
				reslt ++;
			}
		}
		System.out.println("\nTotal no of companies whose stock price declined today : " + reslt);
	}

	public void dispDescendingOrder() {
		stkSort.descending(shares);
		System.out.println("\nStock prices in descending order are :");
		display();
		aryInAscending = false;
	}

	public void dispAscendingOrder() {
		stkSort.ascending(shares);
		System.out.println("\nStock prices in ascending order are :");
		display();
		aryInAscending = true;
	}
	
	public void display() {
		for (Share stk: shares) {
			System.out.print(stk.price + " ");
		}
		System.out.println();
	}
	
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
