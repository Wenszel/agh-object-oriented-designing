package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.discount.DiscountStrategy;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;
import java.util.Map;

public class PriceCalculator {
    private final Map<Product, Integer> productsWithQuantity;
    private final DiscountStrategy discountStrategy;
    private final BigDecimal tax;

    public PriceCalculator(Map<Product, Integer> productsWithQuantity, DiscountStrategy discountStrategy, BigDecimal tax) {
        this.productsWithQuantity = productsWithQuantity;
        this.discountStrategy = discountStrategy;
        this.tax = tax;
    }

    public BigDecimal getPrice() {
        return productsWithQuantity.entrySet().stream()
                .map(this::calculatePriceForEntry)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    private BigDecimal calculatePriceForEntry(Map.Entry<Product, Integer> entry) {
        BigDecimal discountedPrice = discountStrategy.applyDiscount(entry.getKey());
        return discountedPrice.multiply(BigDecimal.valueOf(entry.getValue()));
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice()
                .multiply(tax)
                .setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }
}
