package examples._2025_08_12__predicate;

import java.util.function.Predicate;

class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("John", 30),
                new Person("Jane", 25),
                new Person("Jill", 42),
                new Person("Jack", 18),
        };

        Predicate<Person> predicate = person -> person.age > 22;

        Person[] arr2 = java.util.Arrays.stream(arr)
                .filter(predicate)
                .toArray(Person[]::new);

        for (Person person : arr2) {
            System.out.println(person);
        }

        System.out.println("---------");
    }
}
