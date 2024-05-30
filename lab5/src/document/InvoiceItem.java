package document;

import warehouse.Product;

public class InvoiceItem {
	private Product product;
	private double price;
	private double quantity;
	private double totalPrice;
	private String name;

	public InvoiceItem(Product product, double quantity) {
		this.product = product;
		this.quantity = quantity;
		this.price = product.getPrice();
		this.name = product.getName();
		recalculateTotalPrice();
	}

	private void recalculateTotalPrice() {
		totalPrice = quantity * price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
		recalculateTotalPrice();
	}

	public void setPrice(double price) {
		this.price = price;
		recalculateTotalPrice();
	}

	public String getName() {
		return name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Product: " + name + " quantity: "+ quantity+" total price:" + totalPrice + "\n";
	}
}
