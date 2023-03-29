package alex.tasks;

import alex.tasks.subject.Man;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyUtilsTest extends TestCase {
    public void testManClass() {
        Man man = new Man(
                "Name",
                10,
                new ArrayList<>(Arrays.asList("Book", "book")));
        Man clone = new CopyUtils().deepCopy(man);
        assertNotSame(man, clone);
        assertEquals(man.getName(), clone.getName());
        assertEquals(man.getAge(), clone.getAge());
        for (int i = 0; i < man.getFavoriteBooks().size(); i++)
            assertEquals(man.getFavoriteBooks().get(i),
                    clone.getFavoriteBooks().get(i));
    }
}