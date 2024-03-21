package interfaces;

import exceptions.SummLessThanZeroException;
import people.Customer;
import shop.Receipt;

public interface ISelling {

    Receipt sell(Customer customer) throws SummLessThanZeroException;
}
