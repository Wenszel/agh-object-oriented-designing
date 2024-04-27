package pl.edu.agh.internetshop.discount;

import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy{
    @Override
    public BigDecimal applyDiscount(Product product) {
        return product.getPrice();
    }
}
