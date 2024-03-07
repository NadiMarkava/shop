package shop;

import people.Customer;
import people.Salesman;
import java.util.List;

public class Shop extends AbstractEntity{

    private String regNumber;
    private String name;
    private Address address;
    private Storehouse storehouse;
    private List<Salesman> salesmanList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private List<CashRegister> cashRegisterList;
    private List<Receipt> receiptList;

    public Shop(String regNumber, String name, Address address, List<Salesman> salesmanList, List<Customer> customerList, List<Provider> providerList, List<CashRegister> cashRegisterList, List<Receipt> receiptList) {
        this.regNumber = regNumber;
        this.name = name;
        this.address = address;
        this.salesmanList = salesmanList;
        this.customerList = customerList;
        this.providerList = providerList;
        this.cashRegisterList = cashRegisterList;
        this.receiptList = receiptList;
    }
    public Shop(){
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

    public Storehouse getStorehouse() {
        return storehouse;
    }

    @Override
    public String toString() {
        return "Shop [" +
                "Reg number=" + regNumber + ' ' +
                ", Name=" + name + ' ' +
                ", Address=" + address.getCity() + ", " + address.getStreet() + ", " + address.getHouse() + "]";
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }
}
