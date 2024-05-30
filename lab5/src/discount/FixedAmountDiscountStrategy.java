package discount;

public class FixedAmountDiscountStrategy implements DiscountStrategy {
    private final double fixedAmountDiscount;

    public FixedAmountDiscountStrategy(double fixedAmountDiscount) {
        this.fixedAmountDiscount = fixedAmountDiscount;
    }

    @Override
    public double calculateDiscountPrice(double price) {
        return Math.min(0, price - fixedAmountDiscount);
    }
}
