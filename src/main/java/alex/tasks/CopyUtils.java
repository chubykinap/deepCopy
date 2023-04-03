package alex.tasks;

import alex.tasks.ClonerClass.ClassCloner;
import alex.tasks.ClonerClass.CollectionCloner;
import alex.tasks.ClonerClass.ICloner;
import alex.tasks.ClonerException.CloneException;
import alex.tasks.JavaCollectionCloner.*;

import java.util.*;

public class CopyUtils {
    private final Set<Class<?>> primitives = new HashSet<>();
    private final HashMap<Class<?>, ICollectionCloner> supported = new HashMap<>();

    private final ICloner deepClone = this::innerClone;

    public CopyUtils() {
        addPrimitives();
        addSupportedCloneable();
    }

    private void addPrimitives() {
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

    private void addSupportedCloneable() {
        supported.put(ArrayList.class, new ArrayListCollectionCloner());
        supported.put(LinkedList.class, new LinkedListCollectionCloner());
        supported.put(HashMap.class, new HashMapCollectionCloner());
        supported.put(HashSet.class, new HashSetCollectionCloner());
        supported.put(Vector.class, new VectorCollectionCloner());
        supported.put(TreeSet.class, new TreeSetCollectionCloner());
        supported.put(TreeMap.class, new TreeMapCollectionCloner());
    }

    public <T> T deepCopy(T object) throws Exception {
        if (object == null) return null;
        return innerClone(object);
    }

    private <T> T innerClone(T o) throws Exception {
        ICloner cloner = cloneResolve(o);
        if (cloner == null)
            return o;
        return cloner.cloneValue(o);
    }

    private <T> ICloner cloneResolve(T object) {
        if (object == null) {
            throw new NullPointerException("Cannot clone null object!");
        }
        ICloner cloner;
        Class<?> oClass = object.getClass();
        if (primitives.contains(oClass))
            return null;
        else {
            if (supported.containsKey(oClass))
                cloner = new CollectionCloner(deepClone,
                        supported.get(oClass));
            else if (object instanceof Collection)
                throw new CloneException(oClass + " is not supported for this deep cloning");
            else
                cloner = new ClassCloner(deepClone);
        }
        return cloner;
    }
}
