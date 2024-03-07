package shop;

import interfaces.IPurchase;
import interfaces.IReturn;
import interfaces.ISelling;

import java.util.List;

public class Storehouse implements IPurchase, ISelling, IReturn {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public List<Product> buy(List<Product> products) {
        productList.addAll(products);
        return productList;
    }

    @Override
    public void sell(List<Product> products){
        productList.removeAll(products);
    }

    @Override
    public void returnProducts(List<Product> products) {
        productList.addAll(products);
    }
}
