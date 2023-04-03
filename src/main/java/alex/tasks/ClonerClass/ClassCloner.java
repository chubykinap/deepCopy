package alex.tasks.ClonerClass;

import alex.tasks.ClonerException.CloneException;
import alex.tasks.Supplier;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public class ClassCloner implements ICloner {
    private final ICloner innerClone;

    public ClassCloner(ICloner innerClone) {
        this.innerClone = innerClone;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> T cloneValue(T o) {
        try {
            T clone = (T) new Supplier(o.getClass()).createInstance();
            Field[] fields = getCloneFields(o.getClass());
            for (Field field : fields) {
                if (!field.canAccess(o))
                    field.setAccessible(true);
                Object val = field.get(o);
                Object valClone = innerClone.cloneValue(val);
                field.set(clone, valClone);
            }
            return clone;
        } catch (IllegalAccessException e) {
            throw new CloneException(e.getMessage());
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
