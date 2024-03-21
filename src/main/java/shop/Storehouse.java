package shop;

import exceptions.ProductCannotBeReturnException;
import exceptions.ProductNotExistsException;

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

    public boolean checkIfProductsPresent(Map<Product, Integer> products) throws ProductNotExistsException {
        boolean poductsPresent = false;
        for (Product product : products.keySet()) {
            if (availableProducts.containsKey(product)
                    && availableProducts.get(product) >= products.get(product)) {
                poductsPresent = true;
            } else throw new ProductNotExistsException();
        }
        return poductsPresent;
    }

    public boolean isProductCanBeReturned(Product product, int count) throws ProductCannotBeReturnException {
        boolean result = false;
        if (product.getProductCategory().getName().equals("Auto")) {
            throw new ProductCannotBeReturnException();
        } else {
            addProduct(product, count);
        }
        return result;
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

