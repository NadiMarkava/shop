package shop;

import people.Customer;
import people.Salesman;

import java.util.List;

public final class CashRegister extends AbstractEntity {

    public double getPrimarySumm(List<Product> products){
        double summ = 0;
        for (Product product : products) {
            summ += product.getPrice();
        }
        return summ;
    }

    public Receipt saleProducts(List<Product> products, Salesman salesman, Customer customer) {
        return new Receipt(products, salesman, customer);
    }
}
