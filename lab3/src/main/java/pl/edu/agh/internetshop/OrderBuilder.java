package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.data.Product;
import pl.edu.agh.internetshop.discount.DiscountStrategy;
import pl.edu.agh.internetshop.data.User;

import java.math.BigDecimal;
import java.util.Map;

public class OrderBuilder {
    private final Order order;
    private final OrderDetails orderDetails;

    public OrderBuilder() {
        order = new Order();
        orderDetails = new OrderDetails();
    }

    public OrderBuilder addProducts(Map<Product, Integer> productsWithQuantity) {
        productsWithQuantity.forEach(orderDetails::addProduct);
        return this;
    }

    public OrderBuilder setDiscountStrategy(DiscountStrategy discountStrategy) {
        orderDetails.setDiscountStrategy(discountStrategy);
        return this;
    }

    public OrderBuilder setUser(User user) {
        order.setUser(user);
        return this;
    }

    public OrderBuilder setTax(BigDecimal tax) {
        orderDetails.setTax(tax);
        return this;
    }

    public OrderBuilder setPaymentProcessor(PaymentProcessor paymentProcessor) {
        order.setPaymentProcessor(paymentProcessor);
        return this;
    }

    public OrderBuilder setShipmentManager(ShipmentManager shipmentManager) {
        order.setShipmentManager(shipmentManager);
        return this;
    }

    public OrderBuilder setPriceCalculator(PriceCalculator priceCalculator) {
        orderDetails.setPriceCalculator(priceCalculator);
        return this;
    }

    public Order build() {
        if (orderDetails.getDiscountStrategy() == null) {
            throw new IllegalStateException("OrderBuilder requires a non-null DiscountStrategy before calling build()");
        }
        if (orderDetails.getProductsWithQuantity().isEmpty()) {
            throw new IllegalStateException("OrderBuilder requires at least one product before calling build()");
        }
        if (orderDetails.getTax() == null) {
            throw new IllegalArgumentException("OrderBuilder requires a non-null tax before calling build()");
        }
        if (orderDetails.getPriceCalculator() == null) {
            throw new IllegalStateException("OrderBuilder requires a non-null PriceCalculator before calling build()");
        }
        if (order.getUser() == null) {
            throw new IllegalStateException("OrderBuilder requires a non-null User before calling build()");
        }
        if (order.getPaymentProcessor() == null) {
            throw new IllegalStateException("OrderBuilder requires a non-null PaymentProcessor before calling build()");
        }
        if (order.getShipmentManager() == null) {
            throw new IllegalStateException("OrderBuilder requires a non-null ShipmentManager before calling build()");
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
