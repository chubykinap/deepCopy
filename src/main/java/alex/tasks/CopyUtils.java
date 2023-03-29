package alex.tasks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CopyUtils {
    private final Set<Class<?>> primitives = new HashSet<>();

    public ICloner deepClone = this::innerClone;

    public CopyUtils() {
        primitives.add(Integer.class);
        primitives.add(Short.class);
        primitives.add(Long.class);
        primitives.add(Byte.class);
        primitives.add(Character.class);
        primitives.add(Double.class);
        primitives.add(Float.class);
        primitives.add(Boolean.class);
        primitives.add(String.class);
    }

    public <T> T deepCopy(T object) {
        if (object == null) return null;
        return innerClone(object);
    }

    private <T> T innerClone(T o) {
        ICloner cloner = cloneResolve(o);
        if (cloner == null)
            return o;
        return cloner.cloneValue(o);
    }

    private <T> ICloner cloneResolve(T object) {
        ICloner cloner;
        Class<?> oClass = object.getClass();
        if (primitives.contains(oClass))
            return null;
        else {
            if (object instanceof List<?>)
                cloner = new ListCloner(deepClone);
            else
                cloner = new ClassCloner(deepClone);
        }
        return cloner;
    }




}
