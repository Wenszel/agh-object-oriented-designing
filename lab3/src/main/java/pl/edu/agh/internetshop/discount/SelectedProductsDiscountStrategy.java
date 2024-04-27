package pl.edu.agh.internetshop.discount;

import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;
import java.util.Set;

public class SelectedProductsDiscountStrategy implements DiscountStrategy{
    private final Set<Product> products;
    private final BigDecimal discount;

    public SelectedProductsDiscountStrategy(Set<Product> products, BigDecimal discount) {
        this.products = products;
        this.discount = discount;

    }

    @Override
    public BigDecimal applyDiscount(Product product) {
        if (products.contains(product)) {
            return product.getPrice().multiply(discount);
        }
        return product.getPrice();
    }
}
