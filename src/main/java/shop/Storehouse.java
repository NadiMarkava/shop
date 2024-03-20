package shop;

import exceptions.MyCustomException;

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

    public boolean checkIfProductsPresent(Map<Product, Integer> products) {
        boolean poductsPresent = false;
        for (Product product : products.keySet()) {
            try {
                if (availableProducts.containsKey(product)
                        && availableProducts.get(product) >= products.get(product)) {
                    poductsPresent = true;
                } else throw new MyCustomException();
            } catch (MyCustomException ex) {
                System.out.println("!!!!!No such product in storehouse or wrong quantity!!!!" + product);
            }
        }
        return poductsPresent;
    }

    public void addProduct(Product product, int count) {
        try {
            availableProducts.merge(product, count, Integer::sum);
        } catch (NullPointerException e){
            System.out.println("!!!! need to initializate!!!");
        }
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

