package alex.tasks.subject;

import java.util.List;

public class Child {
    private String childString;

    private int childInt;

    private double childDouble;

    private List<Parent> parents;

    public Child(String childString, int childInt, double childDouble) {
        this.childString = childString;
        this.childInt = childInt;
        this.childDouble = childDouble;
    }

    public void addParent(Parent parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public void removeParent(Parent parent){
        parents.remove(parent);
    }

    public String getChildString() {
        return childString;
    }

    public void setChildString(String childString) {
        this.childString = childString;
    }

    public int getChildInt() {
        return childInt;
    }

    public void setChildInt(int childInt) {
        this.childInt = childInt;
    }

    public double getChildDouble() {
        return childDouble;
    }

    public void setChildDouble(double childDouble) {
        this.childDouble = childDouble;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }
}
