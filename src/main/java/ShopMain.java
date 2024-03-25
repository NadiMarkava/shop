import exceptions.DiscountCardAlreadyExistsException;
import exceptions.InvalidInputException;
import exceptions.SummLessThanZeroException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Customer;
import people.Salesman;
import shop.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopMain {

    private final static Logger LOGGER = LogManager.getLogger(ShopMain.class);

    public static void main(String[] args) throws InvalidInputException, SummLessThanZeroException, DiscountCardAlreadyExistsException {
        Shop shop = new Shop();
        Product product = new Product("Yogurt", 3.45, new ProductCategory("Milk Products"), new Provider("Sofiika"));
        Product productB = new Product("Ice cream", 1.45, new ProductCategory("Milk Products"), new Provider("Miskays marka"));
        Product productC = new Product("Prosseco", 13.45, new ProductCategory("Drinks"), new Provider("Italia marka"));
        Product productD = new Product("oil", 23.45, new ProductCategory("Auto"), new Provider("BMW marka"));
        Salesman salesman = new Salesman("John", "Obermaier", 450);
        Salesman salesman1 = new Salesman("Sepp", "Herrmann", 450);
        Customer customer = new Customer("Elisaveta", "Zhuk");
        //Collections
        List<Salesman> salesmanList = new ArrayList<>();
        List<CashRegister> cashRegisterList = new ArrayList<>();
        List<Receipt> receiptList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        Map<Product, Integer> availableProducts = new HashMap<>();

        salesmanList.add(salesman);
        salesmanList.add(salesman1);
        customerList.add(customer);

        Storehouse storehouse = new Storehouse();
        shop.setStorehouse(storehouse);
        storehouse.setAvailableProducts(availableProducts);

        LOGGER.info("Available Products" + availableProducts);

        storehouse.addProduct(productB, 6);
        storehouse.addProduct(productB, 1);
        storehouse.addProduct(product, 6);
        storehouse.addProduct(product, 1);
        storehouse.addProduct(productD, 2);

        LOGGER.info("Available Products" + availableProducts);

        Map<Product, Integer> productsToBuy = new HashMap<>();
        customer.setProductsToBuy(productsToBuy);
        productsToBuy = customer.takeProduct(product, 2);
        customer.takeProduct(productD, 2);
        customer.takeProduct(productC, 2);
        shop.createDiscountCard(customer, 5);

        LOGGER.info("Products to buy" + productsToBuy);

        try {
            shop.createDiscountCard(customer, 5);
        } catch (DiscountCardAlreadyExistsException e) {
            LOGGER.error("!!!!This customer has already discount card!!!" + customer);
        }

        CashRegister cashRegister = new CashRegister(salesman);
        CashRegister cashRegister1 = new CashRegister(salesman1);
        cashRegisterList.add(cashRegister);
        cashRegisterList.add(cashRegister1);
        shop.setCashRegisterList(cashRegisterList);
        shop.setReceiptList(receiptList);
        cashRegister.setBusy(true);
        Receipt receipt = shop.sell(customer);

        LOGGER.info("Receipt" + receipt.toString());
        LOGGER.info("Available Products after selling" + availableProducts);
        shop.returnProducts(receipt);
        LOGGER.info("Available Products after return" + availableProducts);
    }
}
