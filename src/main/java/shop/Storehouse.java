package shop;

import exceptions.ProductCannotBeReturnException;
import exceptions.ProductNotExistsException;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public Map<Product, Integer> filterProductsByName(String name) {
        Predicate<? super Map.Entry<Product, Integer>> condition = p -> p.getKey().getName().contains(name);
        return availableProducts.entrySet()
                .stream()
                .filter(condition)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Product, Integer> filterProductsByProvider(Provider provider) {
        return availableProducts.entrySet()
                .stream()
                .filter(p -> p.getKey().getProviders().equals(provider))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void increasePrice(Map<Product, Integer> products, double value) {
        products.keySet()
                .forEach(p -> {
                    p.setPrice(p.getPrice() * value);
                });
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

