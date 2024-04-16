package reflection;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.*;

public class Reflection {

    private final static Logger LOGGER = LogManager.getLogger(Reflection.class);

    public static void getFieldNamesModifiers(Field[] fields) {
        for (Field field : fields) {
            LOGGER.info("Modifier: " + Modifier.toString(field.getModifiers()));
            LOGGER.info("Field: " + field.toGenericString());
        }
    }

    public static void getConstructors(Constructor[] constructors) {
        LOGGER.info("Number of constructors are" + constructors.length);
        for (Constructor constructor : constructors) {
            for (Parameter parameter : constructor.getParameters()) {
                LOGGER.info("Parameter:" + parameter.getType() + " "+ parameter.getName());
                LOGGER.info("Modifier:" + parameter.getModifiers());
            }
        }
    }

    public static void getMethodsModifiersParametersReturnTypes(Method[] methods) {
        for (Method method : methods) {
            LOGGER.info("Method: " + method.toGenericString());
            LOGGER.info("Modifier:" + Modifier.toString(method.getModifiers()));
            for (Parameter parameter : method.getParameters()) {
                LOGGER.info("Parameter:" + parameter.getType());
            }
            LOGGER.info("Return type:" + method.getReturnType());
        }
    }
}
