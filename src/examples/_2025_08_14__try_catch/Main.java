package examples._2025_08_14__try_catch;

class MyClass {
    protected int x;
}


class MySubClass {
    public MySubClass(int x) {
        MyClass m = new MyClass();
        m.x = 1;
    }
}

public class Main {


    public static void main(String[] args) {
        try {
            int r1 = (byte) 1;
            System.out.println("r: " + r1);
            int r2 = (byte) 100;
            System.out.println("r: " + r2);
            int r3 = (byte) 127;
            System.out.println("r: " + r3);
            int r4 = (byte) 128;
            System.out.println("r: " + r4);
            int r5 = (byte) 250;
            System.out.println("r: " + r5);

            int q, w, e;
            q = w = e = 9;
            System.out.println("q: " + q + " w: " + w + " e: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("ArithmeticException caught");
//            throw new ArithmeticException("Division by zero");
//            System.exit(4);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getClass() + ": " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }


}
