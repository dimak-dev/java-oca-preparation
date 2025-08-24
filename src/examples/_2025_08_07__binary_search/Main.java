package examples._2025_08_07__binary_search;

import java.util.Arrays;
import java.util.Comparator;

class LoggerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println("Comparing " + o1 + " and " + o2);
        return o1.compareTo(o2);
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {
                5278, 7880, 1864, 1305, 8248, 5062, 6509, 6183, 1849, 591, 3229, 8442, 5907, 5938, 8644, 6365, 4991,
                3190, 4516, 6716, 4834, 1985, 3305, 6495, 6493, 3850, 2037, 269, 5235, 6990, 5839, 7175, 1514, 5208,
                5388, 7392, 6823, 7907, 2151, 7264, 6984, 8835, 8854, 9832, 4772, 7745, 691, 3602, 9531, 923, 7533,
                6730, 1947, 3657, 4836, 1786, 7770, 3418, 9309, 202, 204, 1646, 6249, 6953, 5331, 9697, 7904, 5152,
                7534, 2565, 1990, 5874, 2773, 3553, 1332, 158, 9402, 7682, 5716, 7270, 5123, 3343, 6653, 6522, 9175,
                5088, 7896, 3551, 311, 6446, 8743, 3341, 6210, 762, 269, 4382, 1377, 6057, 5296, 3786, 4280, 8539,
                3395, 2432, 3003, 6265, 7685, 6494, 2204, 7894, 1900, 4451, 9449, 8856, 979, 9580, 3866, 3297, 7471,
                4098, 2275, 5540, 9684, 4428, 1717, 430, 8535, 8086, 1354, 4591, 6033, 5107, 5973, 8820, 4364, 7012,
                257, 8556, 9780, 6878, 4127, 6924, 8035, 8844, 137, 255, 5658, 8292, 5478, 89, 7771, 1564, 6195, 886,
                7882, 4115, 4280, 8073, 4471, 420, 8566, 1098, 7122, 5410, 6959, 4713, 1736, 6236, 981, 6389, 5218,
                4379, 802, 6186, 8441, 1265, 44, 5767, 7465, 3908, 3909, 9174, 2316, 4304, 2381, 7821, 689, 7017,
                5928, 9929, 9994, 7641, 2278, 4130, 1885, 4743, 296, 5921, 1444, 1290
        };

        Comparator<Integer> comparator = new LoggerComparator();

        System.out.println("Search before sorting");
        int result = Arrays.binarySearch(arr, 296, comparator);
        if (result < 0) System.out.println("Element not found");

        System.out.println("Search after sorting");
        Arrays.sort(arr);
        result = Arrays.binarySearch(arr, 296, comparator);
        if (result > 0) System.out.println("Element found at index: " + result);

    }
}
