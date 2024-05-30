package printer;

import document.Invoice;

public class ClassicInvoicePrinter extends InvoicePrinter {
public ClassicInvoicePrinter(Invoice invoice) {
        super(invoice);
    }

    @Override
    public void printHeader() {
        String sb = "=====================================================\n" +
                "Invoice Date: " + invoice.getSaleDate().toString() + "\n" +
                "Issued to: " + invoice.getContractor() + "\n" +
                "=====================================================\n";
        System.out.println(sb);
    }

    @Override
    public void printBody() {
        StringBuilder sb = new StringBuilder();
        invoice.getInvoiceItems().forEach(item -> sb.append(item.toString()));
        System.out.println(sb);
    }

    @Override
    public void printFooter() {
        System.out.println("Total Amount: " + invoice.getTotalPrice() + "\n");
    }
}
