package homework._2025_07_07__iterfaces__Person;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        var lastNameCompare = this.lastName.compareTo(o.lastName);
        if (lastNameCompare == 0) return this.firstName.compareTo(o.firstName);
        return lastNameCompare;
    }
}
