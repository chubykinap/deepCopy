package alex.tasks;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Man man = new Man(
                "Name",
                1,
                Arrays.asList("Harry", "Potter"));
        CopyUtils cu = new CopyUtils();
        try {
            Man clone = cu.deepCopy(man);
            System.out.println("Cloning completed");
            if (compareObjects(man,clone))
                System.out.println("Objects are identical");
            else
                System.out.println("Objects are different");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static <T> boolean compareObjects(T o1, T o2) {
        Field[] fields = o1.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!field.canAccess(o1)){
                field.setAccessible(true);
            }
            try {
                if (!field.get(o1).equals(field.get(o2)))
                    return false;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}