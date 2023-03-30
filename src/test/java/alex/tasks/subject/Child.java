package alex.tasks.subject;

import java.util.Objects;

public class Child extends Parent {
    private int childInt;
    private String childString;

    public Child(int parentInt, String parentString, int childInt, String childString) {
        super(parentInt, parentString);
        this.childInt = childInt;
        this.childString = childString;
    }

    public Child(int childInt, String childString) {
        this.childInt = childInt;
        this.childString = childString;
    }

    public Child() {
    }

    public Child(Parent parent, int childInt, String childString) {
        super(parent.getParentInt(), parent.getParentString());
        this.childInt = childInt;
        this.childString = childString;
    }

    public int getChildInt() {
        return childInt;
    }

    public void setChildInt(int childInt) {
        this.childInt = childInt;
    }

    public String getChildString() {
        return childString;
    }

    public void setChildString(String childString) {
        this.childString = childString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return childInt == child.childInt && childString.equals(child.childString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childInt, childString);
    }
}
