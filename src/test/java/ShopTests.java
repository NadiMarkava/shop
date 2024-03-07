
import org.testng.Assert;
import org.testng.annotations.Test;
import people.Customer;
import people.Salesman;
import shop.*;

import java.util.ArrayList;
import java.util.Arrays;
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

        //shop has
        Shop shop = new Shop();
        Product productFirst = new Product("Bread", 1.85, new ProductCategory("Bread Products"), new Provider("BreadTasty"));
        Product productSecond = new Product("Meat", 7.20, new ProductCategory("Meat Products"), new Provider("RealMeat"));
        shop.add(productFirst);
        shop.add(productSecond);
        List<Product> shopProducts = shop.getProductList();
        System.out.println(shopProducts.toString());

        //shop buys

        List<Product> providerProducts = new ArrayList<>();
        providerProducts.add(product);
        providerProducts.add(productA);
        provider.sell(providerProducts);
        shop.buy(providerProducts);
        System.out.println(shopProducts.toString());

        //customer buys

        List<Product> customerProducts = new ArrayList<>();
        customerProducts.add(productFirst);
        customerProducts.add(product);
        System.out.println(customer.getDiscountCard().toString());
        customer.buy(customerProducts);
        double summ = product.getSumm(customerProducts); ///не нравится
        customer.pay(summ);
        CashRegister cashRegister = new CashRegister();
        Receipt receipt = cashRegister.saleProducts(customerProducts, salesman, customer);
        System.out.println(receipt);
        System.out.println(customer.getDiscountCard().toString());

        //customer return

        List<Product> customerReturnProducts = new ArrayList<>();
        customerReturnProducts.add(product);
        customer.returnProducts(customerReturnProducts);
        System.out.println(customer.getDiscountCard().toString());

        //

//        Assert.assertNotEquals(product.hashCode(), productA.hashCode());
//        System.out.println(product);
//        System.out.println(product.equals(productA));

    }
}
