package shop;

public class DiscountCard extends AbstractEntity {

    private double discount;

    public DiscountCard(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "balance=" + discount +
                '}';
    }
}
