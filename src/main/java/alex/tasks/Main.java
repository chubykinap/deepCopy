package alex.tasks;

import alex.tasks.test.Man;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Man man = new Man(
                "Alex",
                24,
                Arrays.asList("Harry", "Potter"));
        Man clone;
        try {
            clone = new CopyUtils().deepCopy(man);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        System.out.println("Cloning completed");
    }
}