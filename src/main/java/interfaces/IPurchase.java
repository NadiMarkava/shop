package interfaces;

import shop.Product;

import java.util.List;

public interface IPurchase {

    public List<Product> buy(List<Product> products);
}
