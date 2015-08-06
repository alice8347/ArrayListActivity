
public class ProductDB {
	public static Product getProduct(String code) {
		Product myProduct = new Product();
		
		myProduct.setCode(code);
		
		if (code.equalsIgnoreCase("java")) {
			myProduct.setDescription("Murach's Beginning Java");
			myProduct.setPrice(49.50);
			myProduct.setInStock(true);
		} else if (code.equalsIgnoreCase("jsps")){
			myProduct.setDescription("Murach's Java Servlets and JSP");
			myProduct.setPrice(49.50);
			myProduct.setInStock(true);
		} else if (code.equalsIgnoreCase("mcb2")) {
			myProduct.setDescription("Murach's Mainframe COBOL");
			myProduct.setPrice(59.50);
			myProduct.setInStock(true);
		} else {
			myProduct.setDescription("Unknown");
		}
		return myProduct;
	}
}