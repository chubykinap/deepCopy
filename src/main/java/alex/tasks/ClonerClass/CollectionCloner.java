package alex.tasks.ClonerClass;

import alex.tasks.JavaCollectionCloner.ICollectionCloner;

public class CollectionCloner implements ICloner {
    ICollectionCloner cCloner;
    ICloner cloner;

    public CollectionCloner(ICloner deepClone, ICollectionCloner iCloner) {
        this.cCloner = iCloner;
        this.cloner = deepClone;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public <T> T cloneValue(T o) throws Exception {
        return (T) cCloner.cloneValue(o, cloner);
    }
}
