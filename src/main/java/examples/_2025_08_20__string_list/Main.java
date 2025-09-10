package examples._2025_08_20__string_list;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.NumberFormat;
import java.util.Locale;

class Foo {
    private String s;
    private void m(){};
}

public class Main {

    public static void main(String[] args) throws ParseException {
        String[] stringArr = {"a", "b", "c"};

        List<String> list1 = Arrays.asList(stringArr);
        List<String> list2 = new ArrayList<>(Arrays.asList(stringArr));

        System.out.println("hello".equals("HELLO".toLowerCase()));
        ;
        System.out.println(((String) null).valueOf(1));

        String numberStr = "111.142,35";
        NumberFormat germanFormat = NumberFormat.getInstance(Locale.GERMAN);
        Double number = germanFormat.parse(numberStr).doubleValue();
        System.out.println(number);

        int testNumber = 255;
        String hexString = Integer.toHexString(testNumber);
        System.out.println("Hex representation of " + testNumber + " is: " + hexString);

        Foo f = new Foo();
    }
}
