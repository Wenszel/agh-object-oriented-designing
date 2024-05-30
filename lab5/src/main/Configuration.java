package main;

import discount.DiscountStrategy;
import printer.InvoicePrinter;

public class Configuration {
    private static Configuration instance = null;
    private DiscountStrategy discountStrategy = null;
    private InvoicePrinter invoicePrinter = null;
    private Configuration() {
    }

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public InvoicePrinter getInvoicePrinter() {
        return invoicePrinter;
    }

    public void setInvoicePrinter(InvoicePrinter invoicePrinter) {
        this.invoicePrinter = invoicePrinter;
    }
}
