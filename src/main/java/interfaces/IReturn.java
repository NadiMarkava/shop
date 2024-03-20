package interfaces;

import exceptions.ProductCannotBeReturnException;
import shop.DiscountCard;
import shop.Product;
import shop.Receipt;

import java.util.List;

public interface IReturn {

    void returnProducts(Receipt receipt) throws ProductCannotBeReturnException;
}
