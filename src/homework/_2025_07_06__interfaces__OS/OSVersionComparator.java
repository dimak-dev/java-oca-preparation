package homework._2025_07_06__interfaces__OS;

import java.util.Comparator;

public class OSVersionComparator implements Comparator<CustomVersionComparable> {

    @Override
    public int compare(CustomVersionComparable o1, CustomVersionComparable o2) {
        return o1.customCompareVersionTo(o2);
    }
}
