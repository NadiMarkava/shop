package enums;

public enum Event {

    SALE (10),
    NEW(0);

    private double shopDiscount;

    Event(double shopDiscount) {
        this.shopDiscount = shopDiscount;
    }

    public double getShopDiscount() {
        return shopDiscount;
    }
}
