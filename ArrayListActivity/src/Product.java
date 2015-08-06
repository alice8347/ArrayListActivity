import java.text.NumberFormat;

public class Product {
	private String code;
	private String description;
	private double price;
	private boolean isInStock;
	
	public Product() {
		code = "";
		description = "";
		price = 0;
		isInStock = false;
	}
	
	public void setCode(String c) {
		code = c;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setDescription(String d) {
		description = d;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getFormattedPrice() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(getPrice());
	}

	
	public void setInStock(boolean s) {
		isInStock = s;
	}
	
	public boolean getInStock() {
		return isInStock;
	}
}