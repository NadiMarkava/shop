package interfaces;

import exceptions.ProductCannotBeReturnException;
import shop.Receipt;

public interface IReturn {

    void returnProducts(Receipt receipt) throws ProductCannotBeReturnException;
}
