package interfaces;

import exceptions.InvalidInputException;
import exceptions.ProductNotExistsException;
import exceptions.SummLessThanZeroException;
import people.Customer;
import shop.Product;
import shop.Receipt;

import java.util.List;

public interface ISelling {

    Receipt sell(Customer customer) throws ProductNotExistsException, InvalidInputException, SummLessThanZeroException;
}
