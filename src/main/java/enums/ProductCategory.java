package enums;

public enum ProductCategory {

    MILK_PRODUCTS("Milk Products"),
    BAKERY("Bakery Products"),
    DRINKS("Drinks"),
    AUTO("Auto");

    public String productCategoryName;

    ProductCategory(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getName() {
        return productCategoryName;
    }
}
