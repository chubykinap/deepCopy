package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.LinkedList;

public class LinkedListCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        LinkedList<Object> list = (LinkedList<Object>) o,
                res = new LinkedList<>();
        for (Object value : list) res.add(cloner.cloneValue(value));
        return res;
    }
}
