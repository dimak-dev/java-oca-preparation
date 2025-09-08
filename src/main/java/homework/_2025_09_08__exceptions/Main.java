package homework._2025_09_08__exceptions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayListPositive<>();

        System.out.println("ArrayListPositive was created with size: " + list.size());

        add(list, 12);
        add(list, "12");
        add(list, 42);
        add(list, -1);
        add(list, 15);
        add(list, false);
        add(list, null);

    }

    static void add(List<Object> list, Object value) {
        System.out.printf("%nAttempt to add %s (as %s): ", value, value == null ? "null" : value.getClass().getSimpleName());
        try {
            list.add(value);
            System.out.println("successfully added");
            System.out.println("New size is: " + list.size());
            System.out.println("ArrayList: " + list);
        } catch (Exception e) {
            System.out.println("failed, " + e.getClass() + " - " + e.getMessage());
        }
    }
}
