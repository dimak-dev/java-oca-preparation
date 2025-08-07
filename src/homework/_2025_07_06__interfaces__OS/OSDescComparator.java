package homework._2025_07_06__interfaces__OS;

import java.util.Comparator;

public class OSDescComparator<T> implements Comparator<Comparable<T>> {

    @Override
    public int compare(Comparable<T> o1, Comparable<T> o2) {
        return o2.compareTo((T) o1);
    }
}
