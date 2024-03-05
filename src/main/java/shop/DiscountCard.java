package shop;

public class DiscountCard extends AbstractEntity{

    private double discount;

    public DiscountCard(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
