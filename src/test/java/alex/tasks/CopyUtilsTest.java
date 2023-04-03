package alex.tasks;

import alex.tasks.subject.Man;
import alex.tasks.subject.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CopyUtilsTest extends TestCase {
    private final CopyUtils cu = new CopyUtils();

    public void testManClass() {
        Man man = new Man(
                "Name",
                10,
                new ArrayList<>(Arrays.asList("Book", "book")));
        Man clone;
        try {
            clone = cu.deepCopy(man);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertNotSame(man, clone);
        assertEquals(man.getName(), clone.getName());
        assertEquals(man.getAge(), clone.getAge());
        for (int i = 0; i < man.getFavoriteBooks().size(); i++)
            assertEquals(man.getFavoriteBooks().get(i),
                    clone.getFavoriteBooks().get(i));
    }

    public void testParentChild() {
        Parent parent = new Parent(1, "parent1");
        Child child = new Child(new Parent(10, "parent2"), 1, "child1");
        Child childParent = new Child(parent, 2, "child2");

        Parent parentClone;
        Child childClone, childParentClone;
        try {
            parentClone = cu.deepCopy(parent);

            childClone = cu.deepCopy(child);

            childParentClone = cu.deepCopy(childParent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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

        assertNotSame(parent, childParent.getParent());
        assertEquals(parent.getParentInt(), childParentClone.getParentInt());
        assertEquals(parent.getParentString(), childParentClone.getParentString());

    }

    public void testNestedList() {
        ListContainer listContainer = new ListContainer(5);
        ListContainer listContainerClone;
        try {
            listContainerClone = cu.deepCopy(listContainer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertNotSame(listContainerClone, listContainer);
        assertEquals(listContainerClone, listContainer);
    }

    public void testNullObject() {
        try {
            assertNull(cu.deepCopy(null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testHashCollections() {
        ListContainer list1 = new ListContainer(2);
        ListContainer list2 = new ListContainer(5, 2);
        HashMap<Integer, ListContainer> map = new HashMap<>();
        map.put(1, list1);
        map.put(2, list2);

        Man man1 = new Man("man1", 1, new ArrayList<>(Arrays.asList("book1", "book2")));
        Man man2 = new Man("man2", 2, new ArrayList<>(Arrays.asList("book3", "book4")));
        HashSet<Man> set = new HashSet<>();
        set.add(man1);
        set.add(man2);

        HashTest test = new HashTest("Sample1", map, set);
        HashTest clone;
        try {
            clone = cu.deepCopy(test);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertNotSame(test, clone);
        assertEquals(test.getText(), clone.getText());
        assertNotSame(test.getHash(), clone.getHash());
        assertNotSame(test.getMan(), clone.getMan());
    }
}