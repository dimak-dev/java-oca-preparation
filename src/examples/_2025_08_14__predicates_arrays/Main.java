package examples._2025_08_14__predicates_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Anna");
        list.add("Nick");
        list.add("Oliver");
        list.add("Alice");
        list.add("Bob");
        list.add("Alex");
        list.add("Maria");
        list.add("Adam");
        list.add("Peter");

        Predicate<String> predi = s -> s.startsWith("A");
        for (String s : list) {
            if (predi.test(s)) {
                System.out.println("Name " + s + " starts with A");
            }
        }

        ArrayList<String> beginsWithA = new ArrayList<>();
        ArrayList<String> beginsWithNotA = new ArrayList<>();

        for (String s : list) {
            if (predi.test(s)) beginsWithA.add(s);
            else beginsWithNotA.add(s);
        }

        System.out.println("---- beginsWithA -----");
        System.out.println(beginsWithA);
        System.out.println("---- beginsWithNotA -----");
        System.out.println(beginsWithNotA);
    }
}
