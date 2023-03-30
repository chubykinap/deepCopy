package alex.tasks;


public class Main {
    public static void main(String[] args) {
        CopyUtils cu = new CopyUtils();
        try {
            //clone = cu.deepCopy(man);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        System.out.println("Cloning completed");
    }
}