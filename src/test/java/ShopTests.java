
import people.Customer;
import people.Salesman;
import shop.*;

import java.util.ArrayList;
import java.util.List;

public class ShopTests {

    public static void main(String[] args) {

        //variables
        double discountCard = 10.00;
        Provider provider = new Provider("Sofiika");
        ProductCategory productCategory = new ProductCategory("Milk Products");
        Salesman salesman = new Salesman("John", "Obermaier", 450);
        Customer customer = new Customer("Elisaveta", "Zhuk", new DiscountCard(discountCard));
        Product product = new Product("Yogurt", 3.45, productCategory, provider);
        Product productA = new Product("Cream", 7.20, productCategory, provider);
        Product productFirst = new Product("Bread", 1.85, new ProductCategory("Bread Products"), new Provider("BreadTasty"));
        Product productSecond = new Product("Meat", 7.20, new ProductCategory("Meat Products"), new Provider("RealMeat"));

        //shop has
        Shop shop = new Shop();
        Storehouse storehouse = new Storehouse();
        shop.setStorehouse(storehouse);
        List<Product> shopProducts = new ArrayList<>();
        shopProducts.add(productFirst);
        shopProducts.add(productSecond);
        shop.getStorehouse().setProductList(shopProducts);
        System.out.println("Products are in the shop=" + shopProducts);

        //shop buys

        List<Product> providerProducts = new ArrayList<>();
        providerProducts.add(product);
        providerProducts.add(productA);
        provider.setProductList(providerProducts);
//        provider.sell(providerProducts);
        shop.getStorehouse().buy(providerProducts);
        System.out.println("Products after delivery=" + shopProducts);

        //customer buys

        Product wishThirdProduct = new Product("Cola", 3.45, productCategory, provider);
        List<Product> wishProducts = new ArrayList<>();
        wishProducts.add(productFirst);
        wishProducts.add(productSecond);
        wishProducts.add(wishThirdProduct);
        customer.setWishList(wishProducts);
        System.out.println("Card balance="+ customer.getDiscountCard().toString());
        salesman.say();
        List<Product> customerProducts = customer.buy(shopProducts);
        CashRegister cashRegister = new CashRegister();
        cashRegister.setStorehouse(storehouse);
        double summ = cashRegister.getPrimarySumm(customerProducts);
        customer.pay(summ);

        System.out.println("Card balance after pay="+ customer.getDiscountCard().toString());
        Receipt receipt = cashRegister.saleProducts(customerProducts, salesman, customer);
        System.out.println("Receipt=" + receipt);
        System.out.println("Products after purchase= " + shopProducts);

        //customer return

        List<Product> customerReturnProducts = new ArrayList<>();
        customerReturnProducts.add(product);
        customer.returnProducts(customerReturnProducts);
        shop.getStorehouse().returnProducts(customerReturnProducts);
        System.out.println("Products after return=" + shopProducts);
        System.out.println("Card balance after return products=" + customer.getDiscountCard().toString());
    }
}
