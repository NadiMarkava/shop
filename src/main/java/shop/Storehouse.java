package shop;

import java.util.List;
import java.util.Map;

public class Storehouse {

    private Map<Product, Integer> availableProducts;

    public void removeProduct(Product product, int count) {
        availableProducts.put(product, availableProducts.get(product) - count);
    }

    public void removeProducts(List<Product> products) {
        for (Product product : products) {
            availableProducts.put(product, availableProducts.get(product) - 1);
        }
    }

    public void addProduct(Product product, int count) {
        availableProducts.merge(product, count, Integer::sum);
    }

    public void setAvailableProducts(Map<Product, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                "availableProducts=" + availableProducts +
                '}';
    }
}

