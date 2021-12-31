package gl.stockers.service;

import gl.stockers.model.Share;

/**
 * It uses 'Merge Sort' algorithm for sorting operation of array of shares.
 * Two public methods are there for ascending and descending sort orders.
 * 
 * @author Shain Joy
 */

public class Sort {
	
	public void ascending(Share[] ary) {
		ascDivider(ary,0,ary.length-1);
	}
	
	public void descending(Share[] ary) {
		desDivider(ary,0,ary.length-1);
	}

	private void desDivider(Share[] ary, int lft, int right) {
		
		if (lft < right) {
			
			int mid = (lft + right)/2;
			desDivider(ary, lft, mid);
			desDivider(ary, mid+1, right);
			
			desMerge(ary, lft, mid, right);
		}
	}

	private void desMerge(Share[] ary, int lh, int mid, int rh) {
		
		int lhLn = mid - lh + 1;
		int rhLn = rh - mid;
		
		Share[] lhAry = new Share[lhLn];
		Share[] rhAry = new Share[rhLn];
				
		
		for (int i = 0; i < lhLn; i++)
			lhAry[i] = ary[lh + i];
		for (int j = 0; j < rhLn; j++)
			rhAry[j] = ary[mid + 1 + j];
		
		int i, j, k;
		i = 0;
		j = 0;
		k = lh;
		
		while (i < lhLn && j < rhLn) {
			if (lhAry[i].price >= rhAry[j].price) {
				ary[k] = lhAry[i];
				i++;
			} else {
				ary[k] = rhAry[j];
				j++;
			}
			k++;
		}
		
		while (i < lhLn) {
			ary[k] = lhAry[i];
			i++;
			k++;
		}
		while (j < rhLn) {
			ary[k] = rhAry[j];
			j++;
			k++;
		}
	}
	
	private void ascDivider(Share[] ary, int lft, int right) {
		
		if (lft < right) {
			
			int mid = (lft + right)/2;
			ascDivider(ary, lft, mid);
			ascDivider(ary, mid+1, right);
			
			ascMerge(ary, lft, mid, right);
		}
	}
	
	private void ascMerge(Share[] ary, int lh, int mid, int rh) {
		
		int lhLn = mid - lh + 1;
		int rhLn = rh - mid;
		
		Share[] lhAry = new Share[lhLn];
		Share[] rhAry = new Share[rhLn];
				
		
		for (int i = 0; i < lhLn; i++)
			lhAry[i] = ary[lh + i];
		for (int j = 0; j < rhLn; j++)
			rhAry[j] = ary[mid + 1 + j];
		
		int i, j, k;
		i = 0;
		j = 0;
		k = lh;
		
		while (i < lhLn && j < rhLn) {
			if (lhAry[i].price <= rhAry[j].price) {
				ary[k] = lhAry[i];
				i++;
			} else {
				ary[k] = rhAry[j];
				j++;
			}
			k++;
		}
		
		while (i < lhLn) {
			ary[k] = lhAry[i];
			i++;
			k++;
		}
		while (j < rhLn) {
			ary[k] = rhAry[j];
			j++;
			k++;
		}
	}

}
