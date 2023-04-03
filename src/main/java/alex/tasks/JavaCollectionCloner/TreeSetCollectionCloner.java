package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.TreeSet;

public class TreeSetCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        TreeSet<Object> set = (TreeSet<Object>) o,
                res = new TreeSet<>(set.comparator());
        for (Object val : set) res.add(cloner.cloneValue(val));
        return res;
    }
}
