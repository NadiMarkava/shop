package shop;

import interfaces.IPurchase;
import interfaces.ISelling;
import people.Customer;
import people.Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Shop extends AbstractEntity implements IPurchase, ISelling {

    private String regNumber;
    private String name;
    private Address address;
    private List<Product> productList;
    private List<Salesman> salesmanList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private List<CashRegister> cashRegisterList;
    private List<Receipt> receiptList;

    public Shop(String regNumber, String name, Address address, List<Product> productList, List<Salesman> salesmanList, List<Customer> customerList, List<Provider> providerList, List<CashRegister> cashRegisterList, List<Receipt> receiptList) {
        this.regNumber = regNumber;
        this.name = name;
        this.address = address;
        this.productList = productList;
        this.salesmanList = salesmanList;
        this.customerList = customerList;
        this.providerList = providerList;
        this.cashRegisterList = cashRegisterList;
        this.receiptList = receiptList;
    }
    public Shop(){

    }

    public List<Product> add(Product product) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
        return productList;
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void addProvider(Provider provider) {
        providerList.add(provider);
    }

    public void addReceipt(Receipt receipt) {
        receiptList.add(receipt);
    }

    @Override
    public String toString() {
        return "Shop [" +
                "Reg number=" + regNumber + ' ' +
                ", Name=" + name + ' ' +
                ", Address=" + address.getCity() + ", " + address.getStreet() + ", " + address.getHouse() + "]";
    }

    @Override
    public List<Product> buy(List<Product> products) {
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.addAll(products);
        return productList;
    }

    @Override
    public void sell(List<Product> products){
    }

    public List<Product> getProductList() {
        return productList;
    }
}
