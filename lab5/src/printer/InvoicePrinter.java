package printer;


import document.Invoice;

public abstract class InvoicePrinter {
    protected final Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        printHeader();
        printBody();
        printFooter();
    }

    public abstract void printHeader();
    public abstract void printBody();
    public abstract void printFooter();
}
