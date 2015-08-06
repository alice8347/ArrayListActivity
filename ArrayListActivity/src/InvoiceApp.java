import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Invoice invoice = new Invoice();
		invoice.setHeader();
		
		HashMap<String, Report> salesReport = new HashMap<String, Report>();
		
		boolean exit = false;
		String code = "";
		String choice = "y";
		String overrideChoice = "n";
		
		System.out.println("Welcome to the invoice application.");
		System.out.println();
		
		top:
		while (!exit) {
			while (choice.equalsIgnoreCase("y") && exit == false) {
				LineItem item = new LineItem();
				code = Validator.getString(sc, "Enter product code: ");
				if (!code.equalsIgnoreCase("exit")) {
					Report report = new Report();
					item.setProduct(code);
					report.setCode(code);
					
					System.out.print("Override the price? (y/n): ");
					overrideChoice = sc.next();
					if (overrideChoice.equalsIgnoreCase("y")) {
						item.setPrice(Validator.getDouble(sc, "Enter product price: ", 0, 1000));
					}
					item.setQuantity(Validator.getInt(sc, "Enter quantity: ", 0, 50));
					invoice.addItem(item);
					
					report.setQuantity(item.getQuantity());
					report.setTotal(item.getSubtotal());
					if (salesReport.containsKey(code)) {
						int tempQuantity = 0;
						double tempTotal = 0.0;
						Report tempReport = new Report();
						tempQuantity = salesReport.get(code).getQunatity();
						tempTotal = salesReport.get(code).getTotal();
						tempReport.setCode(code);
						tempReport.setQuantity(tempQuantity + report.getQunatity());
						tempReport.setTotal(tempTotal + report.getTotal());
						salesReport.put(code, tempReport);
					} else {
						salesReport.put(code, report);
					}
					
					System.out.print("Another line item? (y/n): ");
					choice = sc.next();
					System.out.println();
				} else {
					exit = true;
					System.out.println();
					break top;
				}
			}
			System.out.println(invoice.getHeader());
			System.out.println(printLineItem(invoice.getLineItems()));
			System.out.printf("%40s%-16s%s%n", "", "Invoice total: ", invoice.getFormattedTotal());
			choice =  "y";
			invoice = new Invoice();
			invoice.setHeader();
		}
		System.out.printf("%-9s%-8s%-9s%s%n", "Code", "Qty", "Total", "Average Price");
		System.out.printf("%-9s%-8s%-9s%s%n", "----", "---", "-----", "-----------------");
		
		for (String key : salesReport.keySet()) {
			System.out.print(salesReport.get(key).toString());
		}
	}
	
	public static String printLineItem(ArrayList<LineItem> items) {
		String list = "";
		for (int i = 0; i < items.size(); i++) {
			list += items.get(i).toString();
		}
		return list;
	}
	
}