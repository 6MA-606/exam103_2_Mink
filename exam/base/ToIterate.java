package exam.base;

import java.util.Iterator;

public class ToIterate<T> implements Iterable { // implements Iterable so that ToIterate can be iterated
    private final T[] internal;

    public static final <T> ToIterate<T> of(T ... ts) {
        T[] array = (T[]) new Object[ts.length];
        System.arraycopy(ts, 0, array, 0, ts.length);
        return new ToIterate(array);
    }

    private ToIterate(T[] ts) { internal = ts; }

    @Override
    public Iterator iterator() {
        return new Iterator() {

            int i = 0;
            @Override
            public boolean hasNext() {
                return i < internal.length;
            }

            @Override
            public Object next() {
                return internal[i++];
            }
        };
    }
}
