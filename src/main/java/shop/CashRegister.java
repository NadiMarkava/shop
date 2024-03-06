package shop;

import people.Customer;
import people.Salesman;

import java.util.List;

public final class CashRegister extends AbstractEntity {

    public Receipt saleProducts(List<Product> products, Salesman salesman, Customer customer) {
        return new Receipt(products, salesman, customer);
    }
}
