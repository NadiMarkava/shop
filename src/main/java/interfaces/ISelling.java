package interfaces;

import enums.Promotion;
import exceptions.SummLessThanZeroException;
import people.Customer;
import shop.Receipt;

public interface ISelling {

    Receipt sell(Customer customer) throws SummLessThanZeroException;
}
