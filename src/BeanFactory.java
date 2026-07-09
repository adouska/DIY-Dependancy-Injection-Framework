import java.lang.reflect.Constructor;

public enum BeanFactory {
    INSTANCE;

    public <T> T getInstanceOf(Class<T> type, Object... args) {
        try {
            Constructor<?> constructor = type.getDeclaredConstructors()[0];
            constructor.setAccessible(true);

            return type.cast(constructor.newInstance(args));
        } catch (Exception e) {
            throw new RuntimeException("Could not create instance of " + type.getName(), e);
        }
    }
}