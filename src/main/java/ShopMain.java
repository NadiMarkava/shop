import enums.CustomerType;
import enums.Position;
import enums.ProductCategory;
import enums.Promotion;
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
        Product product = new Product("Yogurt", 7.45, ProductCategory.MILK_PRODUCTS, new Provider("Savushkin"));
        Product productF = new Product("Yogurt", 3.45, ProductCategory.MILK_PRODUCTS, new Provider("Sofiika"));
        Product productB = new Product("Ice cream", 1.45, ProductCategory.MILK_PRODUCTS, new Provider("Miskays marka"));
        Product productC = new Product("Prosseco", 13.45, ProductCategory.DRINKS, new Provider("Italia marka"));
        Product productD = new Product("oil", 23.45, ProductCategory.AUTO, new Provider("BMW marka"));
        Salesman salesman = new Salesman("John", "Obermaier", Position.HEAD_SALESMAN, 450);
        Salesman salesman1 = new Salesman("Sepp", "Herrmann", Position.SALESMAN, 450);
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

        storehouse.addProduct(productF, 1);
        storehouse.addProduct(productB, 6);
        storehouse.addProduct(productB, 1);
        storehouse.addProduct(product, 6);
        storehouse.addProduct(product, 1);
        storehouse.addProduct(productD, 2);

        Map<Product, Integer> productsBySearch = storehouse.searchProducts("Yogurt");
        productsBySearch.entrySet().stream().forEach(t -> LOGGER.info("Products Yogurt" + t + "\n"));

        LOGGER.info("Available Products" + availableProducts);
        Map<Product, Integer> productsToBuy = new HashMap<>();
        customer.setProductsToBuy(productsToBuy);
        productsToBuy = customer.takeProduct(product, 2);
        customer.takeProduct(productD, 2);
        customer.setCustomerType(CustomerType.STUDENT);
        shop.createDiscountCard(customer);
        LOGGER.info("Products to buy" + productsToBuy);

        try {
            shop.createDiscountCard(customer);
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
        Receipt receipt = shop.sell(customer, Promotion.NO_PROMOTION);
        LOGGER.info("Receipt" + receipt.toString());
        LOGGER.info("Available Products after selling" + availableProducts);
        shop.returnProducts(receipt);
        LOGGER.info("Available Products after return" + availableProducts);
    }
}
