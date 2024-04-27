package pl.edu.agh.internetshop.payment;

public interface MoneyTransferPaymentTransaction extends PaymentMethod {
    boolean validate(MoneyTransfer transfer);
}
