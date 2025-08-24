package examples._2025_08_11__inheritance__static_init;

class A {
    static String b;
    {
        b = "a";
    }
    public Number toI(int a) {
        return a;
    }
}

class B extends A {
    public Integer toI(int a) {
        return a;
    }
}

interface I2 {
    
}

interface I extends Comparable, Cloneable {
    static String b = "i";
    default String b() {
        return "i";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new A().toI(1));
        System.out.println(new B().toI(1));
        System.out.println(A.b);
    }
}
