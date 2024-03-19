package shop;

import interfaces.IClose;
import interfaces.ISelling;
import people.Customer;
import people.Salesman;

import java.util.List;

public final class CashRegister extends AbstractEntity implements ISelling, IClose {

    private Salesman salesman;
    private boolean isBusy = false;
    private static double summOfReceipts = 0;

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

    @Override
    public Receipt sell(Customer customer) {
        salesman.say("Welcome");
        double summ = calculateSumm(customer.getProductsToBuy());
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
