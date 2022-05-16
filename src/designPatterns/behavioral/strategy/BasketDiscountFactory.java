package designPatterns.behavioral.strategy;

public class BasketDiscountFactory {
    public static BasketDiscountStrategy getDiscount(DiscountType DiscountType) {
        switch (DiscountType) {
            case NO_DISCOUNT:
                return new BasketDiscountMoneyOff();
            case PERCENTAGE_OFF:
                return new BasketDiscountPercentageOff();
            default:
                return new NoBasketDiscount();
        }
    }
}