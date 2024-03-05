package shop;

import java.util.List;

public class CashRegister extends AbstractEntity{

    public Receipt saleProducts(List<Product> products, Salesman salesman, Customer customer) {
        return new Receipt(products, salesman, customer);
    }
}
