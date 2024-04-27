package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.discount.DiscountStrategy;
import pl.edu.agh.internetshop.data.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderDetails {
    private final Map<Product, Integer> productsWithQuantity = new HashMap<>();
    private DiscountStrategy discountStrategy;
    private BigDecimal tax;
    private PriceCalculator priceCalculator;

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Cannot add product with quantity less than or equal to 0");
        }
        if (product == null) {
            throw new IllegalArgumentException("Cannot add null product");
        }
        if (productsWithQuantity.containsKey(product)) {
            quantity += productsWithQuantity.get(product);
        }
        productsWithQuantity.put(product, quantity);
    }

    public boolean containsProductByName(String name) {
        return productsWithQuantity.keySet().stream().anyMatch(product -> product.getName().equals(name));
    }

    public BigDecimal getPrice() {
        return priceCalculator.getPrice();
    }

    public BigDecimal getPriceWithTaxes() {
        return priceCalculator.getPriceWithTaxes();
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public Map<Product, Integer> getProductsWithQuantity() {
        return productsWithQuantity;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public PriceCalculator getPriceCalculator() {
        return priceCalculator;
    }

    public void setPriceCalculator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }
}

