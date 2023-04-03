package alex.tasks.subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListContainer {
    private final List<ListObject> list = new ArrayList<>();

    public ListContainer(int count) {
        while (count-- > 0)
            list.add(new ListObject(count, true));
    }

    public ListContainer(int begin, int count) {
        while (count-- > 0)
            list.add(new ListObject(begin++, true));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListContainer that = (ListContainer) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    private static class ListObject {
        private final int val;
        private final List<ListObject> list = new ArrayList<>();

        private ListObject(int val, boolean fillList) {
            this.val = val;
            if (fillList)
                for (int i = 0; i < val; i++)
                    list.add(new ListObject(val, false));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListObject that = (ListObject) o;
            return val == that.val && list.equals(that.list);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, list);
        }
    }
}
