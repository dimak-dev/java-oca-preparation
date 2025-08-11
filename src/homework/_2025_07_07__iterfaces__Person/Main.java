package homework._2025_07_07__iterfaces__Person;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person("Paul", "Smith"),
                new Person("Paul", "Black"),
                new Person("John", "Smith"),
                new Person("John", "Black"),
        };

        System.out.println("Sorted by last name:");
        Arrays.sort(persons);
        printPersons(persons);

        var result = Arrays.binarySearch(persons, new Person("John", "Black"));

        if (result >= 0) {
            System.out.println("Found John Smith at index: " + result);
        } else {
            System.out.println("John Smith not found");
        }

        System.out.println("Sorted (DESC) by last name:");
        Arrays.sort(persons, Comparator.reverseOrder());
        printPersons(persons);

        var result2 = Arrays.binarySearch(persons, new Person("Paul", "Smith"), Comparator.reverseOrder());
        if (result2 >= 0) {
            System.out.println("Found Paul Smith at index: " + result2);
        } else {
            System.out.println("Paul Smith not found");
        }
    }

    private static void printPersons(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
