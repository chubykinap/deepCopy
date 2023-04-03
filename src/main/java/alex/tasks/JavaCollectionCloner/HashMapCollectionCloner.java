package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollectionCloner implements ICollectionCloner {
    @Override
    @SuppressWarnings({"unchecked"})
    public Object cloneValue(Object o, ICloner cloner) throws Exception {
        final HashMap<Object, Object> map = (HashMap<Object, Object>) o,
                res = new HashMap<>();
        for (Map.Entry<Object, Object> val : map.entrySet()) {
            res.put(cloner.cloneValue(val.getKey()),
                    cloner.cloneValue(val.getValue()));
        }
        return res;
    }
}
