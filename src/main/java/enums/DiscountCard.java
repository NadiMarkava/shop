package enums;

public enum DiscountCard {

    STANDART("Standard card", 5),
    LOYALITY("Loyalty card", 10);

    private final String cardName;
    private final double discount;

    DiscountCard(String cardName, int discount) {
        this.cardName = cardName;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
