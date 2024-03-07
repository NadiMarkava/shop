package shop;

import interfaces.ISelling;

import java.util.List;
import java.util.function.Predicate;

public class Provider extends AbstractEntity implements ISelling {

    private String name;
    private Address address;
    private List<Product> productList;

    public Provider(String name) {
        this.name = name;
    }

    public Provider(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void sell(List<Product> products) {
        productList.removeAll(products);
    }
}
