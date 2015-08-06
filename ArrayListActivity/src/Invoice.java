import java.util.ArrayList;
import java.text.NumberFormat;

public class Invoice {
	String header;
	ArrayList<LineItem> lineItemList;
	
	public Invoice() {
		header = "";
		lineItemList = new ArrayList<LineItem>();
	}
	
	public void setHeader() {
		header = "Code    Description                     Price   Qty     Total\n"
				+ "----    -----------                     -----   ---     -----";
	}
	
	public String getHeader() {
		return header;
	}
	
	public void addItem(LineItem lineItem) {
		lineItemList.add(lineItem);
	}
	
	public ArrayList<LineItem> getLineItems() {
		return lineItemList;
	}
	
	public double getInvoiceTotal() {
		double total = 0.0;
		for (int i = 0; i < lineItemList.size(); i++) {
			total += lineItemList.get(i).getSubtotal();
		}
		return total;
	}
	
	public String getFormattedTotal() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(getInvoiceTotal());
	}
}