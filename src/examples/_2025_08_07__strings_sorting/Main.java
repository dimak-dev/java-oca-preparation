package examples._2025_08_07__strings_sorting;

import java.util.Arrays;
import java.util.Comparator;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class Main {
    public static void main(String[] args) {

        String[] arr = {
                "AA", "aa", "AA", "aa", "BBBB", "bbbbbb", "c", "cccccccc",
        };

        System.out.println("--------- Initial -------");
        System.out.println(Arrays.toString(arr));

        System.out.println("--------- Sorted (default) -------");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("--------- Sorted (default, ignore case) -------");
        Arrays.sort(arr, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));

        System.out.println("--------- Sorted (StringLengthComparator, length) -------");
        Arrays.sort(arr, new StringLengthComparator());
        System.out.println(Arrays.toString(arr));

        System.out.println("--------- Sorted (Lambda, reverse length) -------");
        Arrays.sort(arr, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(arr));
    }
}
