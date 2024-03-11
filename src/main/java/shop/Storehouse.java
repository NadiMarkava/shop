package shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Storehouse {

    private Map<Product, Integer> availableProducts;

    public void removeProduct(Product product) {

    }

    public void removeProducts(List<Product> products) {
        for (Product product:products){
            availableProducts.remove(product, 1);
        }
    }

    public void addProduct(Product product) {
            availableProducts.merge(product, 1, Integer::sum);
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                "availableProducts=" +availableProducts +
                '}';
    }

    public void setAvailableProducts(Map<Product, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }
}

