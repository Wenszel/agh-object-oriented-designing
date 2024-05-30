package document;
import java.util.*;

import main.Configuration;
import warehouse.Product;
import discount.DiscountStrategy;


public class Invoice {
	private	Date saleDate;
	private String contractor;
	private List<InvoiceItem> invoiceItems;
	private double totalPrice;
	private DiscountStrategy discountStrategy;

	public Invoice(Date saleDate, String contractor) {
		this.saleDate = saleDate;
		this.contractor = contractor;
		this.invoiceItems = new LinkedList<>();
		this.totalPrice = 0;
		this.discountStrategy = Configuration.getInstance().getDiscountStrategy();
	}

	public void addItemToInvoice(Product product, double amount) {
		InvoiceItem item = new InvoiceItem(product, amount);
		if (discountStrategy != null) {
			item.setPrice(discountStrategy.calculateDiscountPrice(product.getPrice()));
		}
		invoiceItems.add(item);
		recalculatePrice();
	}

	private void recalculatePrice() {
		totalPrice = invoiceItems.stream()
				.map(InvoiceItem::getTotalPrice)
				.reduce(0.0, Double::sum);
	}

	public void setDiscountStrategy(DiscountStrategy discountStrategy) {
		this.discountStrategy = discountStrategy;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public String getContractor() {
		return contractor;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
}
