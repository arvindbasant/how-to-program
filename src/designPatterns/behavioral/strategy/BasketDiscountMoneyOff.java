package designPatterns.behavioral.strategy;

class BasketDiscountMoneyOff implements BasketDiscountStrategy {
    @Override
    public double getTotalCostAfterApplyingDiscountTo(Basket basket) {
        if (basket.getTotalCost() > 1500d)
            return basket.getTotalCost() - 100d;
        return basket.getTotalCost();
    }
}

class BasketDiscountPercentageOff implements BasketDiscountStrategy {
    @Override
    public double getTotalCostAfterApplyingDiscountTo(Basket basket) {
        return basket.getTotalCost() * 0.85;
    }
}

class NoBasketDiscount implements BasketDiscountStrategy {
    @Override
    public double getTotalCostAfterApplyingDiscountTo(Basket basket) {
        return basket.getTotalCost();
    }
}