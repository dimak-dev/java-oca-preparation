package homework._2025_09_08__exceptions;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListPositive<T> extends ArrayList<T> {
    public ArrayListPositive() {
        super();
    }

    public ArrayListPositive(int initialCapacity) {
        super(initialCapacity);
    }

    public void checkType(T value) {
        if (value == null) {
            throw new NullPointerException();
        } else if (value instanceof Integer) {
            if ((Integer) value > 0) return;
            throw new NotPositiveArgumentException();
        }

        throw new IllegalArgumentException("Only Integer type is allowed. Arg is: " + value.getClass().getCanonicalName());
    }

    @Override
    public boolean add(T value) {
        this.checkType(value);
        return super.add(value);
    }

    @Override
    public void add(int index, T element) {
        this.checkType(element);
        super.add(index, element);
    }

//    @Override
//    public void addFirst(T element) {
//        this.checkType(element);
//        super.addFirst(element);
//    }
//
//    @Override
//    public void addLast(T element) {
//        super.addLast(element);
//    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        c.forEach(this::checkType);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        c.forEach(this::checkType);
        return super.addAll(index, c);
    }
}
