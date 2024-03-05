package shop;

import java.util.List;

public class Shop extends AbstractEntity{

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

    @Override
    public String toString() {
        return "Shop [" +
                "Reg number=" + regNumber + ' ' +
                ", Name=" + name + ' ' +
                ", Address=" + address.getCity() + ", " + address.getStreet() + ", " + address.getHouse() + "]";
    }
}
