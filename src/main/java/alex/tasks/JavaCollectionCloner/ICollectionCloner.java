package alex.tasks.JavaCollectionCloner;

import alex.tasks.ClonerClass.ICloner;

public interface ICollectionCloner {
    Object cloneValue(Object o, ICloner cloner) throws Exception;
}
