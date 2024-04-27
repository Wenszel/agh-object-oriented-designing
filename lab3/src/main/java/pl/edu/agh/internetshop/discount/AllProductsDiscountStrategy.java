package pl.edu.agh.internetshop.discount;

import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;

public class AllProductsDiscountStrategy implements DiscountStrategy{
    private final BigDecimal discount;

    public AllProductsDiscountStrategy(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public BigDecimal applyDiscount(Product product) {
        return product.getPrice().multiply(discount);
    }
}
