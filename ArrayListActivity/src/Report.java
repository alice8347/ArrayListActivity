import java.text.NumberFormat;

public class Report {
	String code;
	int quantity;
	double total;
	
	public Report() {
		code = "";
		quantity = 0;
		total = 0.0;
	}
	
	public void setCode(String c) {
		code = c;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setQuantity(int q) {
		quantity += q;
	}
	
	public int getQunatity() {
		return quantity;
	}
	
	public void setTotal(double t) {
		total += t;
	}
	
	public double getTotal() {
		return total;
	}
	
	public String getFormattedNum(double num) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(num);
	}
	
	@Override
	public String toString() {
		double average = total / quantity;
		String line = String.format("%-9s%-8s%-9s%s%n", code, quantity, getFormattedNum(total), getFormattedNum(average));
		return line;
	}
	
}