package alex.tasks.subject;

import java.util.List;

public class Parent  extends SuperClass{
    private String parentString;

    private int parentInt;

    private double parentDouble;

    private List<Child> children;

    public Parent(String superString, int superInt,
                  String parentString, int parentInt, double parentDouble) {
        super(superString,superInt);
        this.parentString = parentString;
        this.parentInt = parentInt;
        this.parentDouble = parentDouble;
    }

    public void addChild(Child child){
        if (!children.contains(child)){
            children.add(child);
        }
    }

    public void removeChild(Child child){
        children.remove(child);
    }

    public String getParentString() {
        return parentString;
    }

    public void setParentString(String parentString) {
        this.parentString = parentString;
    }

    public int getParentInt() {
        return parentInt;
    }

    public void setParentInt(int parentInt) {
        this.parentInt = parentInt;
    }

    public double getParentDouble() {
        return parentDouble;
    }

    public void setParentDouble(double parentDouble) {
        this.parentDouble = parentDouble;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
