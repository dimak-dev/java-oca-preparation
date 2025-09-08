package examples._2025_09_08__exceptions__null;

public class Main {
    public static void main(String[] args) {
        try {
            m1();
        } catch (Exception e) {
            System.out.println("m1: " + e.getClass().getSimpleName());
        }

        try {
            m2();
        } catch (Exception e) {
            System.out.println("m2: " + e.getClass().getSimpleName());
        }

        try {
            m3();
        } catch (Exception e) {
            System.out.println("m3: " + e.getClass().getSimpleName());
        }
    }

    static void m1() {
        throw null;
    }

    static void m2() {
        throw (RuntimeException) null;
    }

    static void m3() {
        Exception e = null;
        throw (RuntimeException) e;
    }
}
