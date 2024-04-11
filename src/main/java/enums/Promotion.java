package enums;

public enum Promotion {

    SALE_FOR_STUDENT("Sale for student", 7),
    SALE_FOR_PENSIONER("Sale for pensioner", 10);

    private String nameDiscount;
    private double shopDiscount;

    Promotion(String nameDiscount, double shopDiscount) {
        this.nameDiscount = nameDiscount;
        this.shopDiscount = shopDiscount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public double getShopDiscount() {
        return shopDiscount;
    }
}
