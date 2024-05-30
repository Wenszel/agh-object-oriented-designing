package printer;

import document.Invoice;

public class AdInvoicePrinter extends InvoicePrinter{
    public AdInvoicePrinter(Invoice invoice) {
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
        System.out.println("Total Amount: " + invoice.getTotalPrice() + "\n");
        System.out.println(sb);
    }

    @Override
    public void printFooter() {
        System.out.println("This is an advertisement");
    }
}
