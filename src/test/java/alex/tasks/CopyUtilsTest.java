package alex.tasks;

import alex.tasks.subject.Child;
import alex.tasks.subject.ListContainer;
import alex.tasks.subject.Man;
import alex.tasks.subject.Parent;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class CopyUtilsTest extends TestCase {
    private final CopyUtils cu = new CopyUtils();
    public void testManClass() {
        Man man = new Man(
                "Name",
                10,
                new ArrayList<>(Arrays.asList("Book", "book")));
        Man clone = cu.deepCopy(man);
        assertNotSame(man, clone);
        assertEquals(man.getName(), clone.getName());
        assertEquals(man.getAge(), clone.getAge());
        for (int i = 0; i < man.getFavoriteBooks().size(); i++)
            assertEquals(man.getFavoriteBooks().get(i),
                    clone.getFavoriteBooks().get(i));
    }

    public void testParentChild() {
        Parent parent = new Parent(1, "1");
        Child child = new Child(parent, 2, "2");

        Parent parentClone = cu.deepCopy(parent);

        Child childClone = cu.deepCopy(child);

        Parent parentChild = child;

        /*
            Check Class object equality
         */
        assertNotSame(parent, parentClone);
        assertNotSame(child, childClone);

        /*
            Check Class object fields equality
         */
        assertEquals(parent, parentClone);
        assertEquals(childClone, child);

        /*
            Check inheritance equality
         */
        assertEquals(child, parentChild);
    }

    public void testNestedList() {
        ListContainer listContainer = new ListContainer(5);
        ListContainer listContainerClone =
                cu.deepCopy(listContainer);

        assertNotSame(listContainerClone, listContainer);
        assertEquals(listContainerClone, listContainer);
    }

    public void testNullObject() {
        assertNull(cu.deepCopy(null));
    }
}