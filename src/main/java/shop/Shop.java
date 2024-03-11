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
    private CashRegister cashRegister;
    private List<CashRegister> cashRegisterList;
    private List<Receipt> receiptList;

    public Shop(){
    }

    public void createDiscountCard(Customer customer, double discount){
        DiscountCard discountCard = new DiscountCard(discount);
        customer.setDiscountCard(discountCard);
    }

    public Receipt getReceipt(Customer customer){
        CashRegister cashRegister = getAvailableCashRegister();
        cashRegister.setBusy(true);
        Receipt receipt = cashRegister.sellProducts(customer);
        addReceipt(receipt);
        cashRegister.setBusy(false);
        storehouse.removeProducts(customer.getProductsToBuy());
//        returnItemsFromCustomer(receipt);
        return receipt;
    }

    public CashRegister getAvailableCashRegister() {
        for (int i = 0; i < cashRegisterList.size(); i++) {
            if (!cashRegisterList.get(i).isBusy()) {
                return cashRegisterList.get(i);
            }
        }
        throw new UnsupportedOperationException("No available cash registers");
    }

    public void returnItemsFromCustomer(Receipt receipt) {
        List<Product> products = receipt.getProductList();
        for(int i =0; i<products.size(); i++) {
            getStorehouse().addProduct(products.get(i));
        }
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

    public void setCashRegisterList(List<CashRegister> cashRegisterList) {
        this.cashRegisterList = cashRegisterList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }
}
