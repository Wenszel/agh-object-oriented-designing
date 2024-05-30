package discount;

public class FractionToPercentageDiscountAdapter implements DiscountStrategy {
    private final PercentageDiscountStrategy percentageDiscountStrategy;

    public FractionToPercentageDiscountAdapter(PercentageDiscountStrategy percentageDiscountStrategy) {
        this.percentageDiscountStrategy = percentageDiscountStrategy;
    }

    @Override
    public double calculateDiscountPrice(double cena) {
        return (1 - percentageDiscountStrategy.getPercentageDiscount()) * cena;
    }
}
