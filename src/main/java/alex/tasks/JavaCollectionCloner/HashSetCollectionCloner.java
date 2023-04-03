package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.HashSet;

public class HashSetCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        HashSet<Object> set = (HashSet<Object>) o,
                res = new HashSet<>();
        for (Object val : set) res.add(cloner.cloneValue(val));
        return res;
    }
}
