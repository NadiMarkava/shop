package shop;

import exceptions.DiscountCardAlreadyExistsException;
import exceptions.ProductCannotBeReturnException;
import exceptions.ProductNotExistsException;
import exceptions.SummLessThanZeroException;
import interfaces.IClose;
import interfaces.IReturn;
import interfaces.ISelling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Customer;
import people.Salesman;

import java.util.List;
import java.util.Map;

public class Shop extends AbstractEntity implements ISelling, IReturn, IClose {

    private final static Logger LOGGER = LogManager.getLogger(Shop.class);
    private static final String REGNUMBER = "5384255";
    private String name;
    private Address address;
    private Storehouse storehouse;
    private List<Salesman> salesmanList;
    private List<Customer> customerList;
    private List<Provider> providerList;
    private CashRegister cashRegister;
    private List<CashRegister> cashRegisterList;
    private List<Receipt> receiptList;

    public Shop() {
    }

    public void createDiscountCard(Customer customer, double discount) throws DiscountCardAlreadyExistsException {
        if (customer.hasDiscountCard()) {
            throw new DiscountCardAlreadyExistsException();
        } else {
            DiscountCard discountCard = new DiscountCard(discount);
            customer.setDiscountCard(discountCard);
        }
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

    public CashRegister getAvailableCashRegister() {
        for (int i = 0; i < cashRegisterList.size(); i++) {
            if (!cashRegisterList.get(i).isBusy()) {
                return cashRegisterList.get(i);
            }
        }
        throw new UnsupportedOperationException("No available cash registers");
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
    public Receipt sell(Customer customer) throws SummLessThanZeroException {
        CashRegister cashRegister = getAvailableCashRegister();
        cashRegister.setBusy(true);
        try {
            storehouse.checkIfProductsPresent(customer.getProductsToBuy());
        } catch
        (ProductNotExistsException e) {
            LOGGER.error("!!!!!No such product in storehouse or wrong quantity!!!!");
        }
        Receipt receipt = cashRegister.sell(customer);
        addReceipt(receipt);
        cashRegister.setBusy(false);
        storehouse.removeProducts(customer.getProductsToBuy());
        return receipt;
    }

    @Override
    public void returnProducts(Receipt receipt) {
        Map<Product, Integer> products = receipt.getProductList();
        for (Product product : products.keySet()) {
            try {
                getStorehouse().isProductCanBeReturned(product, products.get(product));
            } catch (ProductCannotBeReturnException ex) {
                LOGGER.error("!!!!Products of this category can not be return!!!");
            }
        }
    }

    @Override
    public void close() {
        LOGGER.info("Shop is closed");
    }

    @Override
    public String toString() {
        return "Shop [" +
                "Reg number=" + REGNUMBER + ' ' +
                ", Name=" + name + ' ' +
                ", Address=" + address.getCity() + ", " + address.getStreet() + ", " + address.getHouse() + "]";
    }
}
