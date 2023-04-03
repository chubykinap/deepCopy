package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.ArrayList;

public class ArrayListCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        final ArrayList<Object> list = (ArrayList<Object>) o,
                res = new ArrayList<>();
        for (Object value : list) res.add(cloner.cloneValue(value));
        return res;
    }
}
