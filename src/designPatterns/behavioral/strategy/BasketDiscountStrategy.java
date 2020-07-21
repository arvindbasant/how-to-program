package designPatterns.behavioral.strategy;

public interface BasketDiscountStrategy {
    double getTotalCostAfterApplyingDiscountTo(Basket basket);
}
