package shop;

import enums.Promotion;
import exceptions.SummLessThanZeroException;
import interfaces.IClose;
import interfaces.ISelling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Customer;
import people.Salesman;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static shop.Shop.getAvailablePromotions;

public final class CashRegister extends AbstractEntity implements ISelling, IClose {

    private final static Logger LOGGER = LogManager.getLogger(CashRegister.class);
    private Salesman salesman;
    private boolean isBusy = false;
    private static double summOfReceipts = 0;

    public CashRegister(Salesman salesman) {
        this.salesman = salesman;
    }


    public double calculateSumm(Customer customer) {
        Promotion promotion = getAvailablePromotions(customer);
        double summ = 0;
        if (promotion == Promotion.NO_PROMOTION) {
            summ = customer.getProductsToBuy().entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum();
        } else {
            summ = calculateDiscounts(promotion, customer.getProductsToBuy());
        }
        return summ;
    }

    @Override
    public Receipt sell(Customer customer) throws SummLessThanZeroException {
        salesman.say("Welcome");
        double summ = calculateSumm(customer);
        if (summ < 0) {
            throw new SummLessThanZeroException("!!!Only Positive Numbers in Summ!!!");
        }
        salesman.say("Your total: " + summ);
        if (customer.hasDiscountCard()) {
            double discount = summ * customer.getDiscountCard().getDiscount() / 100;
            summ = summ - discount;
        }
        customer.pay(summ);
        customer.say("Paid");
        summOfReceipts += summ;
        return new Receipt(customer.getProductsToBuy(), salesman, customer);
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public static double getSummOfReceipts() {
        return summOfReceipts;
    }

    public double calculateDiscounts(Promotion promotion, Map<Product, Integer> products) {
        double summ = products.entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum();
        double summWithDiscount = summ - summ * promotion.getShopDiscount() / 100;
        return summWithDiscount;
    }

    @Override
    public void close() {
        LOGGER.info("Total amount for day " + getSummOfReceipts());
    }
}
