
import exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Customer;
import people.Salesman;
import shop.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShopTests {

    private final static Logger LOGGER = LogManager.getLogger(ShopTests.class);

    public static void main(String[] args) throws ProductNotExistsException, InvalidInputException, SummLessThanZeroException, ProductCannotBeReturnException, DiscoountCardAlreadyExists {

        Shop shop = new Shop();

        Product product = new Product("Yogurt", -3.45, new ProductCategory("Milk Products"), new Provider("Sofiika"));
        Product productB = new Product("Ice cream", -1.45, new ProductCategory("Milk Products"), new Provider("Miskays marka"));
//        Product productC = new Product("Prosseco", 13.45, new ProductCategory("Drinks"), new Provider("Italia marka"));
        Product productD = new Product("oil", 23.45, new ProductCategory("Auto"), new Provider("BMW marka"));

        Salesman salesman = new Salesman("John", "Obermaier", 450);
        Salesman salesman1 = new Salesman("Sepp", "Herrmann", 450);


        Customer customer = new Customer("Elisaveta", "Zhuk");
        Storehouse storehouse = new Storehouse();
        shop.setStorehouse(storehouse);


        Map<Product, Integer> availableProducts = new HashMap<>();
        storehouse.setAvailableProducts(availableProducts);
        System.out.println("Available Products" + availableProducts);
        storehouse.addProduct(productB,6);
        storehouse.addProduct(productB,1);
        storehouse.addProduct(product, 6);
        storehouse.addProduct(product, 1);
        storehouse.addProduct(productD, 2);

        System.out.println("Available Products" + availableProducts);


        Map<Product, Integer> productsToBuy = new HashMap<>();
        customer.setProductsToBuy(productsToBuy);
        productsToBuy = customer.takeProduct(product, 2);
        customer.takeProduct(productD, 2);
//        customer.takeProduct(productC, 2);

        shop.createDiscountCard(customer, 5);
        System.out.println("Products to buy" + productsToBuy);
        try {
            shop.createDiscountCard(customer, 5);
        } catch (DiscoountCardAlreadyExists e) {
            System.out.println("!!!!This customer has alreade discount card!!!" + customer);
        }
        List<CashRegister> cashRegisterList = new ArrayList<>();
        List<Receipt> receiptList = new ArrayList<>();
        CashRegister cashRegister = new CashRegister(salesman);
        CashRegister cashRegister1 = new CashRegister(salesman1);
        cashRegisterList.add(cashRegister);
        cashRegisterList.add(cashRegister1);
        shop.setCashRegisterList(cashRegisterList);
        shop.setReceiptList(receiptList);
        cashRegister.setBusy(true);
        Receipt receipt = shop.sell(customer);
        System.out.println("Receipt" + receipt.toString());

        System.out.println("Available Products after selling" + availableProducts);
        shop.returnProducts(receipt);

        System.out.println("Available Products after return" + availableProducts);
    }
}
