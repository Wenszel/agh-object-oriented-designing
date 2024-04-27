package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.payment.MoneyTransfer;
import pl.edu.agh.internetshop.payment.PaymentMethod;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void processPayment(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
    }
}
