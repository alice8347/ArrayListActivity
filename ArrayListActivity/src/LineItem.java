import java.text.NumberFormat;

public class LineItem {
	private Product myProduct;
	private int quantity;
	private double total;
	
	public LineItem() {
		myProduct = new Product();
	}
	
	public void setProduct(String code) {
		myProduct = ProductDB.getProduct(code);
	}
	
	public Product getProduct() {
		return myProduct;
	}

	public void setPrice(double p) {
		myProduct.setPrice(p);
	}
	
	public double getPrice() {
		return myProduct.getPrice();
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getSubtotal() {
		calculateSubtotal();
		return total;
	}
	
	private void calculateSubtotal() {
		if (myProduct.getInStock()) {
			total = quantity * myProduct.getPrice();
		} else {
			total = 0;
		}
	}
	
	public String getFormattedSubtotal() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(getSubtotal());
	}

	@Override
	public String toString() {
		String line = String.format("%-8s%-32s%-8s%-8s%s%n", myProduct.getCode(), myProduct.getDescription(), myProduct.getFormattedPrice(), quantity, getFormattedSubtotal());
		return line;
	}

}