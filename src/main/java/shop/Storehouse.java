package shop;

import java.util.List;
import java.util.Map;

public class Storehouse {

    private Map<Product, Integer> availableProducts;

    public void removeProduct(Product product, int count) {
        availableProducts.put(product, availableProducts.get(product) - count);
    }

    public void removeProducts(Map<Product, Integer> products) {
        for (Product product : products.keySet()) {
            availableProducts.put(product, availableProducts.get(product) - products.get(product));
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

    public Map<Product, Integer> getAvailableProducts() {
        return availableProducts;
    }
}

