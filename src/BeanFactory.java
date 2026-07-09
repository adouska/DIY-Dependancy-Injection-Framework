import java.lang.reflect.Constructor;

public enum BeanFactory {
    INSTANCE;

    public <T> T getInstanceOf(Class<T> type, Object... args /*zero or more arguments*/) { // Given a class, it returns an object of that class
        try {
            Constructor<?> constructor = type.getDeclaredConstructors()[0];
            // This uses reflection. Reflection means Java code can inspect classes while the program is running.
            // Asking the class what constructor it has and gets the first one (0).
            constructor.setAccessible(true); // allows to call this constructor even if it is not public

            return type.cast(constructor.newInstance(args)); // object creation of whatever class was passed in. Calls the constructor and passes the arguments.
        } catch (Exception e) {
            throw new RuntimeException("Could not create instance of " + type.getName(), e);
        }
    }
}