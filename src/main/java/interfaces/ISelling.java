package interfaces;

import enums.Promotion;
import exceptions.SummLessThanZeroException;
import people.Customer;
import shop.Receipt;

public interface ISelling {

    Receipt sell(Customer customer, Promotion promotion) throws SummLessThanZeroException;
}
