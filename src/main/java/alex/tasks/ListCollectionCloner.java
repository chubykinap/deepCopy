package alex.tasks;

import java.util.ArrayList;
import java.util.List;

public class ListCollectionCloner implements ICollectionCloner {
    @Override
    public Object cloneValue(Object o, ICloner cloner) {
        List<?> list = (List<?>) o;
        List<Object> res = new ArrayList<>();
        for (Object value : list) res.add(cloner.cloneValue(value));
        return res;
    }
}
