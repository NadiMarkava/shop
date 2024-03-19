
import people.Customer;
import people.Salesman;
import shop.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopTests {

    public static void main(String[] args) {

        Shop shop = new Shop();

        Product product = new Product("Yogurt", 3.45, new ProductCategory("Milk Products"), new Provider("Sofiika"));
        Product productB = new Product("Ice cream", 1.45, new ProductCategory("Milk Products"), new Provider("Miskays marka"));
        int count = 20;
        Salesman salesman = new Salesman("John", "Obermaier", 450);
        Salesman salesman1 = new Salesman("Sepp", "Herrmann", 450);


        Customer customer = new Customer("Elisaveta", "Zhuk");
        Storehouse storehouse = new Storehouse();
        shop.setStorehouse(storehouse);


        Map<Product, Integer> availableProducts = new HashMap<>();
        availableProducts.put(product, count);
        storehouse.setAvailableProducts(availableProducts);
        System.out.println("Available Products" + availableProducts);
        storehouse.addProduct(productB,1);
        storehouse.addProduct(productB,1);
        storehouse.addProduct(product, 1);
        storehouse.addProduct(product, 1);

        System.out.println("Available Products" + availableProducts);


        List<Product> productsToBuy = new ArrayList<>();
        customer.setProductsToBuy(productsToBuy);
        productsToBuy = customer.takeProduct(product);
        customer.takeProduct(productB);
        System.out.println("Products to buy" + productsToBuy);
//        shop.createDiscountCard(customer, 5);
        List<CashRegister> cashRegisterList = new ArrayList<>();
        List<Receipt> receiptList = new ArrayList<>();
        CashRegister cashRegister = new CashRegister(salesman);
        CashRegister cashRegister1 = new CashRegister(salesman1);
        cashRegisterList.add(cashRegister);
        cashRegisterList.add(cashRegister1);
        shop.setCashRegisterList(cashRegisterList);
        shop.setReceiptList(receiptList);
        cashRegister.setBusy(true);
//        cashRegister1.setBusy(true);
        Receipt receipt = shop.sell(customer);
        System.out.println("Receipt" + receipt.toString());
//        cashRegister.sell(customer);

        System.out.println("Available Products after selling" + availableProducts);
        shop.returnProducts(receipt);

        System.out.println("Available Products after return" + availableProducts);
    }
}
