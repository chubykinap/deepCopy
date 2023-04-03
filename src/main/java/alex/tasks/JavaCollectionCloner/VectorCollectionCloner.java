package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.Vector;

public class VectorCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        final Vector<Object> vec = (Vector<Object>) o,
                res = new Vector<>();
        for (Object val : vec) res.add(cloner.cloneValue(val));
        return res;
    }
}
