package alex.tasks;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Man man = new Man(
                "Name",
                1,
                new ArrayList<>(Arrays.asList("Harry", "Potter")));
        CopyUtils cu = new CopyUtils();
        try {
            Man clone = cu.deepCopy(man);

            compareObjects(man, clone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static <T> void compareObjects(T o1, T o2) {
        Field[] fields = o1.getClass().getDeclaredFields();
        boolean ident = true;
        for (Field field : fields) {
            if (!field.canAccess(o1)) {
                field.setAccessible(true);
            }
            try {
                if (!field.get(o1).equals(field.get(o2)))
                    ident = false;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Cloning completed");
        if (o1.equals(o2))
            System.out.println("Objects are identical");
        else
            System.out.println("Objects are different");
        if (ident)
            System.out.println("Objects parameters are identical");
        else
            System.out.println("Objects are different");
    }
}