package examples._2025_08_22__inner_class;

import java.util.ArrayList;

public class Main {
    private int mA = 1;
    protected int mB = 2;
    public int mC = 3;

    static int sA = 4;

    class InnerClass {
        private int mA = -1;
        void print() {
            System.out.println(mA);
            System.out.println(mB);
            System.out.println(mC);
            System.out.println(Main.this.mA);
            System.out.println(Main.this.mB);
            System.out.println(Main.this.mC);
            System.out.println(sA);
            System.out.println(Main.sA);
        }

        class InnerInnerClass {
            private int mA = -2;
            void print() {
                System.out.println("InnerInnerClass");
                System.out.println(mA);
                System.out.println(mB);
                System.out.println(mC);
                System.out.println(InnerClass.this.mA);
                System.out.println(Main.this.mA);
                System.out.println(Main.this.mB);
                System.out.println(Main.this.mC);
                System.out.println(sA);
                System.out.println(Main.sA);
            }
        }
    }

    String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        return new String(chars);
//        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Main().reverse("Hello World!"));
//        Main.InnerClass.InnerInnerClass innerInnerClass = (new Main()).new InnerClass().new InnerInnerClass();
//        new Main().new InnerClass().print();
//        (new Main()).new InnerClass().new InnerInnerClass().print();
    }
}


class Main2 extends Main{
    class InnerClass2 extends Main.InnerClass {

    }
    void print() {
        this.new InnerClass().new InnerInnerClass();
        new Main().new InnerClass().new InnerInnerClass();
    }
}