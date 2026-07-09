import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public enum BeanFactory {
    INSTANCE;

    public <T> T getInstanceOf(Class<T> beanClass, Object... arguments) {
        try {
            // Creating the array of the parameters types
            Class<?>[] argumentsClasses = Arrays.stream(arguments).map(Object::getClass).toArray(Class<?>[]::new);
            // Locating the corresponding constructor
            Constructor<T> beanConstructor = beanClass.getConstructor(argumentsClasses);
            // creating the bean
            T bean = beanConstructor.newInstance(arguments);

            return bean;
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}