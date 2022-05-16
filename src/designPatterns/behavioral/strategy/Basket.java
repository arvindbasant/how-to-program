package designPatterns.behavioral.strategy;

public class Basket {
    private final BasketDiscountStrategy basketDiscountStrategy;

    Basket(DiscountType discountType) {
        basketDiscountStrategy = BasketDiscountFactory.getDiscount(discountType);
    }

    public double getTotalCostAfterDiscount() {
        return basketDiscountStrategy.getTotalCostAfterApplyingDiscountTo(this);
    }

    private double totalCost;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}

