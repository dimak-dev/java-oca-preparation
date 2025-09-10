package examples._2025_08_05__init_blocks;

class Foo {
    Foo() {
        System.out.println("a");
    }
    Foo(int i) {
        System.out.println("b");
    }

    protected int foo(String s) {return 42;}

    static {
        System.out.println("A");
    }
    {
        System.out.println("X");
    }
}

class Bar extends Foo {
    Bar() {
        System.out.println("c");
    }
    Bar(int i) {
        System.out.println("d");
    }
    Bar(String s) {
        this();
        System.out.println("e");
    }
    static {
        System.out.println("B");
    }

    public int foo(String s){return super.foo(s);};

    {
        System.out.println("Y");
    }
}


public class Example1 {
    public static void main(String[] args) {
        new Bar("foo");
    }
}
