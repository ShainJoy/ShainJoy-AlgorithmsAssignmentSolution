package gl.stockers.model;

/**
 * A small class, just to hold the particulars of a company share.
 * 
 * @author Shain Joy
 */

public class Share {

	public double price;
	public boolean upTrend;
	
	public Share(double price, boolean upTrend) {
		this.price = price;
		this.upTrend = upTrend;
	}
}
