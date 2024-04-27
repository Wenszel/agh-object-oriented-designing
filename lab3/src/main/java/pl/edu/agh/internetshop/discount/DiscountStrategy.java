package pl.edu.agh.internetshop.discount;

import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountStrategy {
    BigDecimal applyDiscount(Product product);
}
