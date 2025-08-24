package examples._2025_08_14__interfaces;

//@FunctionalInterface
interface I {
    default void m() {}
}

interface J  {
    default void m(int i) {}
}

public class Main implements I, J {
    public static void main(String[] args) {

    }
}
