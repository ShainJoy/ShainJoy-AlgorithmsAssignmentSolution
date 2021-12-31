package gl.stockers.service;

import gl.stockers.model.Share;

/**
 * 'Binary search' algorithm is used in this class to do search operation.
 * Array of shares passed in, is expected to be in ascending order.
 * 
 * @author Shain Joy
 */

public class BinarySearch {
	
	public int find(Share[] ary, double key) {
		int last = ary.length - 1;
		int first = 0;
		int mid = (0 + last)/2;
		while (first <= last) {
			if (ary[mid].price == key) {
				return mid;
			} else if(ary[mid].price < key) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
			mid = (first + last)/2;
		}
		return -1;
	}


}
