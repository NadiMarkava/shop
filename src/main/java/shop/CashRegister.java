package shop;

import exceptions.MyCustomException;
import interfaces.IClose;
import interfaces.ISelling;
import people.Customer;
import people.Salesman;

import java.util.List;
import java.util.Map;

public final class CashRegister extends AbstractEntity implements ISelling, IClose {

    private Salesman salesman;
    private boolean isBusy = false;
    private static double summOfReceipts = 0;

    public CashRegister(Salesman salesman) {
        this.salesman = salesman;
    }

    public double calculateSumm(Map<Product, Integer> products){
        double summ = 0;
        for (Product product : products.keySet()) {
            summ += product.getPrice() * products.get(product);
        }
        return summ;
    }

    @Override
    public Receipt sell(Customer customer) {
        salesman.say("Welcome");
        try {
            if (salesman.getLastName().contains(" ")) {
                throw new MyCustomException();
            }
        } catch (MyCustomException ex) {
            System.out.println("!!!Last name contains blank:!!!" + salesman.getFirstName());
        }
        double summ = calculateSumm(customer.getProductsToBuy());
        try {
            if (summ < 0) {
                throw new MyCustomException();
            }
        } catch (MyCustomException ex) {
            System.out.println("!!!Only Positive Numbers!!!");
        }
        salesman.say("Your total: " + summ);
        if(customer.hasDiscountCard()){
            double discount = summ * customer.getDiscountCard().getDiscount()/100;
            summ = summ - discount;
        }
        customer.pay(summ);
        customer.say("Paid");
        summOfReceipts += summ;
        return new Receipt(customer.getProductsToBuy(), salesman, customer);
    }

    public boolean isBusy(){
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public static double getSummOfReceipts() {
        return summOfReceipts;
    }

    @Override
    public void close() {
        System.out.println("Total amount for day " + getSummOfReceipts());
    }
}
