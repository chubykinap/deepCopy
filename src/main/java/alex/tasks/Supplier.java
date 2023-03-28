package alex.tasks;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Supplier<T> {
    private final Constructor<T> constructor;

    public Supplier(Class<T> type) {
        try {
            this.constructor = type.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public T createInstance(){
        try {
            return constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
