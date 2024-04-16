import enums.Position;
import exceptions.InvalidInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import people.Salesman;
import shop.Shop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static reflection.Reflection.*;

public class ReflectionTest {

    private final static Logger LOGGER = LogManager.getLogger(ReflectionTest.class);

    public static void main(String[] args) throws InvalidInputException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Field[] fields = Shop.class.getDeclaredFields();
        Constructor[] constructors = Shop.class.getDeclaredConstructors();
        Method[] methods = Shop.class.getDeclaredMethods();
        getFieldNamesModifiers(fields);
        getMethodsModifiersParametersReturnTypes(methods);
        getConstructors(constructors);
        Shop shop = Shop.class.getConstructor().newInstance();

        Salesman salesman = Salesman.class.getConstructor(
                String.class, String.class, Position.class, double.class).newInstance("John","Obermaier",Position.HEAD_SALESMAN, 450);
        Salesman salesman1 = Salesman.class.getConstructor(
                String.class, String.class, Position.class, double.class).newInstance("Sepp","Herrmann",Position.SALESMAN, 550);
        List<Salesman> salesmen = new ArrayList<>();
        salesmen.add(salesman);
        salesmen.add(salesman1);

        Method sumInstanceMethod = Shop.class.getMethod("salaryСosts", List.class);
        Double result = (Double) sumInstanceMethod.invoke(shop, salesmen);
        Assert.assertEquals(result, 1000.0, "Salary costs are not equal");
    }
}
