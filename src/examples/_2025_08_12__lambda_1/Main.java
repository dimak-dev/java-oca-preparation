package examples._2025_08_12__lambda_1;

import java.util.ArrayList;

@FunctionalInterface
interface AgeComparable<T> {
    static int value = 23;

    static int toInt() {
        return 12;
    }

    int hhjhk(T obj);
}

class Person {
    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean isMoreThan18() {
        return age > 18;
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

        ArrayList<Person> list = new ArrayList<>();

        int foo = 100;

        AgeComparable<Person> lambda = person -> {
            list.add(person);
            return person.age + 42 + AgeComparable.value + foo;
        };

        System.out.println("---------");
        System.out.println("Lambda: " + lambda.hhjhk(arr[0]));
        System.out.println("Lambda: " + lambda.hhjhk(arr[1]));
        System.out.println("Lambda: " + lambda.hhjhk(arr[2]));

        for (Person person : list) {
            System.out.println(person);
        }
    }
}
