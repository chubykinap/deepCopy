package alex.tasks.subject;

import java.util.HashMap;
import java.util.HashSet;

public class HashTest {
    private final String text;

    private final HashMap<Integer, ListContainer> hash;

    private final HashSet<Man> man;

    public HashTest(String text, HashMap<Integer, ListContainer> hash, HashSet<Man> man) {
        this.text = text;
        this.hash = hash;
        this.man = man;
    }

    public String getText() {
        return text;
    }

    public HashMap<Integer, ListContainer> getHash() {
        return hash;
    }

    public HashSet<Man> getMan() {
        return man;
    }

}
