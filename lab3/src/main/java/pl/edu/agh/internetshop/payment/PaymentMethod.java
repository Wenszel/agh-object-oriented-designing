package pl.edu.agh.internetshop.payment;


public interface PaymentMethod {
    boolean commit(MoneyTransfer transfer);
}
