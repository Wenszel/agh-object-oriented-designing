package discount;

public class PercentageDiscountStrategy implements DiscountStrategy{
    private double percentageDiscount;
    public PercentageDiscountStrategy(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public double calculateDiscountPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        } else if (percentageDiscount < 0) {
            throw new IllegalArgumentException("Discount cannot be negative");
        } else if (percentageDiscount > 1) {
            throw new IllegalArgumentException("Discount cannot be greater than 100%");
        }
        return price * (1 - (percentageDiscount / 100));
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }
}
