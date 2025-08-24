package homework._2025_07_06__interfaces__OS;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        OS[] os = {
                new OS("Linux", 23),
                new OS("Windows", 3),
                new OS("Linux", 10),
                new OS("Mac OS", 1),
                new OS("Windows", 15),
                new OS("Linux", 2),
                new OS("Mac OS", 7),
                new OS("Mac OS", 0),
                new OS("Linux", 1),
        };

        print(os);

        System.out.println("------------ Nutzung von OSVersionComparator ---------------");
        Arrays.sort(os, new OSVersionComparator());
        print(os);
        System.out.println("------------ Nutzung von Comparable ---------------");
        Arrays.sort(os);
        print(os);

        OS search = new OS("Windows", 3);
        int result1 = Arrays.binarySearch(os, search);
        System.out.println("Binary Search: " + search);

        if (result1 >= 0) {
            System.out.println("Element gefunden: " + os[result1]);
        }

        System.out.println("------------ Nutzung von OSDescComparator ---------------");
        Arrays.sort(os, new OSDescComparator<>());
        print(os);

        OS search2 = new OS("Mac OS", 7);
        int result2 = Arrays.binarySearch(os, search2, new OSDescComparator<>());
        System.out.println("Binary Search: " + search2);

        if (result2 >= 0) {
            System.out.println("Element gefunden: " + os[result2]);
        }

        System.out.println("------------ Nutzung von Lambda ---------------");
        Arrays.sort(os, (o1, o2) -> o1.getVersion() - o2.getVersion());
//        Arrays.sort(os, Comparator.comparingInt(OS::getVersion));
        print(os);

        System.out.println("------------ Nutzung von Lambda (Desc) ---------------");
        Arrays.sort(os, (o1, o2) -> o2.getVersion() - o1.getVersion());
        print(os);


        System.out.println("------------ Nutzung von anonymer Klasse ---------------");

        Comparator<OS> comparator = new Comparator<OS>() {
            public int compare(OS o1, OS o2) {
                return o1.getVersion() - o2.getVersion();
            }
        };

        Arrays.sort(os, comparator);
        print(os);
    }

    private static void print(OS[] os) {
        for (OS o : os) {
            System.out.println(o);
        }
    }
}
