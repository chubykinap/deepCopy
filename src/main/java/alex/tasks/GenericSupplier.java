package alex.tasks;


import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class GenericSupplier<T> {
    ObjectInstantiator<?> instantiateType;

    public GenericSupplier(Class<T> type) {
        instantiateType = new ObjenesisStd().getInstantiatorOf(type);
    }

    public T createInstance() {
        return (T) instantiateType.newInstance();
    }
}
