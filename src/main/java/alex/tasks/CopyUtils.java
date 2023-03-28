package alex.tasks;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

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
                cloner = new ListCloner();
            else
                cloner = new ClassCloner();
        }
        return cloner;
    }

    private class ListCloner implements ICloner {
        ICollectionCloner cCloner;
        ICloner cloner;

        public ListCloner() {
            cCloner = new ListCollectionCloner();
            this.cloner = deepClone;
        }

        @Override
        public <T> T cloneValue(T o) {
            try {
                return (T) cCloner.cloneValue(o, cloner);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ClassCloner implements ICloner {
        @Override
        public <T> T cloneValue(T o) {
            try {
                T clone = (T) new Supplier(o.getClass()).createInstance();
                Field[] fields = getCloneFields(o.getClass());
                for (Field field : fields) {
                    if (!field.canAccess(o))
                        field.setAccessible(true);
                    Object val = field.get(o);
                    Object valClone = innerClone(val);
                    field.set(clone, valClone);
                }
                return clone;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private Field[] getCloneFields(Class<?> o) {
            Field[] fields = o.getDeclaredFields();

            Class<?> parent = o.getSuperclass();
            if (parent != null && !parent.equals(Object.class)) {
                Field[] parentFields = getCloneFields(parent);
                fields = Stream.concat(Stream.of(fields), Stream.of(parentFields)).toArray(Field[]::new);
            }
            return fields;
        }
    }
}
