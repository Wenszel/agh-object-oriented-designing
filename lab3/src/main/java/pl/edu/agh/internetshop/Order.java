package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.data.User;
import pl.edu.agh.internetshop.payment.MoneyTransfer;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {
	private final UUID id;
    private User user;
    private OrderDetails orderDetails;
    private ShipmentManager shipmentManager;
    private PaymentProcessor paymentProcessor;

    public Order() {
        this.id = UUID.randomUUID();
    }

    public BigDecimal getPrice() {
        return orderDetails.getPrice();
    }

    public BigDecimal getPriceWithTaxes() {
        return orderDetails.getPriceWithTaxes();
    }

    public String getUserLastname() {
        return user.getLastname();
    }

    public void send() {
        shipmentManager.send();
    }

    public void pay(MoneyTransfer moneyTransfer) {
        paymentProcessor.processPayment(moneyTransfer);
    }

    public boolean containsProductByName(String name) {
        return orderDetails.containsProductByName(name);
    }

    public boolean isSent() {
        return shipmentManager.isSent();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ShipmentManager getShipmentManager() {
        return shipmentManager;
    }

    public void setShipmentManager(ShipmentManager shipmentManager) {
        this.shipmentManager = shipmentManager;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
}
