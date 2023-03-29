package alex.tasks.subject;

public class SuperClass {
    private String superString;

    private int superInt;

    public SuperClass(String superString, int superInt) {
        this.superString = superString;
        this.superInt = superInt;
    }

    public String getSuperString() {
        return superString;
    }

    public void setSuperString(String superString) {
        this.superString = superString;
    }

    public int getSuperInt() {
        return superInt;
    }

    public void setSuperInt(int superInt) {
        this.superInt = superInt;
    }
}
