package shop;

import people.Customer;
import people.Salesman;

import java.util.List;

public final class CashRegister extends AbstractEntity {

    private Salesman salesman;

    private boolean isBusy = false;

    public CashRegister(Salesman salesman) {
        this.salesman = salesman;
    }

    public double calculateSumm(List<Product> products){
        double summ = 0;
        for (Product product : products) {
            summ += product.getPrice();
        }
        return summ;
    }

    public Receipt sellProducts(Customer customer) {
        salesman.say("Welcome");
        double summ = calculateSumm(customer.getProductsToBuy());
        salesman.say("Your total: " + summ);
        if(customer.hasDiscountCard() == true){
            double discount = summ * customer.getDiscountCard().getDiscount()/100;
            summ = summ - discount;
        }
        customer.pay(summ);
        customer.say("Paid");
        return new Receipt(customer.getProductsToBuy(), salesman, customer);
    }

    public boolean isBusy(){
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }
}
