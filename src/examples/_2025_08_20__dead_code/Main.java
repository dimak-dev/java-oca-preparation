package examples._2025_08_20__dead_code;

import java.util.Random;

public class Main {
    private void deadCode() {
        System.out.println("Dead Code!");
    }

    public static void main(String[] args) {
        if (new Random().nextInt(1) > 10) return;

        System.out.println("Hello World!");
        int[] iia = new int[10];
        System.out.println(iia.length);
        String[] ss = {"", "'"};
    }
}
