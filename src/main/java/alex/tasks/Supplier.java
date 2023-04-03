package alex.tasks;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Supplier<T> {
    private final Constructor<T> constructor;

    @SuppressWarnings("unchecked")
    public Supplier(Class<T> type) {
        Constructor<T>[] constructors = (Constructor<T>[]) type.getDeclaredConstructors();
        this.constructor = Arrays.stream(constructors)
                .min(Comparator.comparing(x -> x.getParameterTypes().length))
                .orElseThrow(NoSuchMethodError::new);
        this.constructor.setAccessible(true);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public T createInstance() throws NoSuchMethodException {
        try {
            Class<?>[] params = constructor.getParameterTypes();
            Object[] args = new Object[params.length];
            int i = 0;
            for (Class<?> cl : params) {
                if (cl.isPrimitive()) {
                    if (cl.equals(Boolean.TYPE))
                        args[i] = true;
                    else
                        args[i] = 0;
                } else if (cl.equals(String.class)) {
                    args[i] = "";
                } else if (Collection.class.isAssignableFrom(cl))
                    args[i] = cl.getDeclaredConstructor().newInstance();
                else {
                    Supplier supplier = new Supplier(cl);
                    args[i] = supplier.createInstance();
                }
                i++;
            }
            return constructor.newInstance(args);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
