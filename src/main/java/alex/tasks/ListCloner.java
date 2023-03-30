package alex.tasks;

public class ListCloner implements ICloner {
    ICollectionCloner cCloner;
    ICloner cloner;

    public ListCloner(ICloner deepClone) {
        cCloner = new ListCollectionCloner();
        this.cloner = deepClone;
    }

    @Override
    public <T> T cloneValue(T o) {
        return (T) cCloner.cloneValue(o, cloner);
    }
}
