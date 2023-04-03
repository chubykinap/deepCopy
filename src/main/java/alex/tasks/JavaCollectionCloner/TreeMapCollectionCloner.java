package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings("unchecked")
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        final TreeMap<Object, Object> map = (TreeMap<Object, Object>) o,
                res = new TreeMap<>();
        for (Map.Entry<Object, Object> val : map.entrySet()) {
            res.put(cloner.cloneValue(val.getKey()),
                    cloner.cloneValue(val.getValue()));
        }
        return res;
    }
}
