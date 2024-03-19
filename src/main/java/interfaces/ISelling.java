package interfaces;

import people.Customer;
import shop.Product;
import shop.Receipt;

import java.util.List;

public interface ISelling {

    Receipt sell(Customer customer);
}
