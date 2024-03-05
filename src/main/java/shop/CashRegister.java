package shop;

import java.util.List;

public class CashRegister extends AbstractEntity{

    private Salesman salesman;

    private Customer customer;

    public Receipt saleProducts(List<Product> products){
        Receipt receipt = new Receipt();
        double summ = 0;
        for (Product product: products){
            summ+=product.getPrice();
        }
        receipt.setSumm(summ);
        return receipt;
    }
}
