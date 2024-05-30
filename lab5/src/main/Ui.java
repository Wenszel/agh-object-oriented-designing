package main;

import java.util.Calendar;

import discount.DiscountStrategy;
import discount.FractionToPercentageDiscountAdapter;
import discount.PercentageDiscountStrategy;
import printer.ClassicInvoicePrinter;
import printer.InvoicePrinter;
import warehouse.Category;
import warehouse.Product;

import document.Invoice;

import rabatlosowy.LosowyRabat;

public class Ui {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		Configuration configuration = Configuration.getInstance();
		LosowyRabat losowyRabat = new LosowyRabat();
		Product product1 = new Product(10,"shoes");
		Product product2 = new Product(2,"socks");
		Category rootCategory = new Category("Root Category");
		Category subCategory1 = new Category("Subcategory 1");
		Category subSubCategory1 = new Category("Sub-Subcategory 1");
		Category subCategory2 = new Category("Subcategory 2");

		rootCategory.addComponent(subCategory1);
		rootCategory.addComponent(subCategory2);
		subCategory1.addComponent(subSubCategory1);
		subSubCategory1.addComponent(product1);
		subSubCategory1.addComponent(product2);
		rootCategory.print(0);

		PercentageDiscountStrategy percentageDiscountStrategy = new PercentageDiscountStrategy(losowyRabat.losujRabat());
		DiscountStrategy discountStrategy = new FractionToPercentageDiscountAdapter(percentageDiscountStrategy);
		configuration.setDiscountStrategy(discountStrategy);

		Invoice invoice = new Invoice(now.getTime(),"Fido");
		invoice.addItemToInvoice(product1,3);
		invoice.addItemToInvoice(product2, 5);

		InvoicePrinter printer = new ClassicInvoicePrinter(invoice);
		configuration.setInvoicePrinter(printer);
		configuration.getInvoicePrinter().print();
	}
}
