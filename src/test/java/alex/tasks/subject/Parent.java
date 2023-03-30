package alex.tasks.subject;

import java.util.Objects;

public class Parent {
    private int parentInt;
    private String parentString;

    public Parent(int parentInt, String parentString) {
        this.parentInt = parentInt;
        this.parentString = parentString;
    }

    public Parent() {
    }

    public int getParentInt() {
        return parentInt;
    }

    public void setParentInt(int parentInt) {
        this.parentInt = parentInt;
    }

    public String getParentString() {
        return parentString;
    }

    public void setParentString(String parentString) {
        this.parentString = parentString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return parentInt == parent.parentInt && parentString.equals(parent.parentString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentInt, parentString);
    }
}
