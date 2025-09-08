package com.de.oca.operators;

/**
 * Demonstration der arithmetischen Operatoren in Java.
 * Zeigt die grundlegenden arithmetischen Operationen, deren Priorität,
 * Besonderheiten im Umgang mit verschiedenen Datentypen und mögliche Probleme.
 */
public class ArithmeticOperatorsDemo {

    /**
     * Demonstration der grundlegenden arithmetischen Operatoren
     */
    public void demonstrateBasicArithmeticOperators() {
        System.out.println("=== Grundlegende arithmetische Operatoren ===");
        int a = 15;
        int b = 4;
        System.out.println("Operanden: a = " + a + ", b = " + b);
        System.out.println();

        // Addition (+)
        int sum = a + b;
        System.out.println("Addition (a + b): " + sum);

        // Subtraktion (-)
        int difference = a - b;
        System.out.println("Subtraktion (a - b): " + difference);

        // Multiplikation (*)
        int product = a * b;
        System.out.println("Multiplikation (a * b): " + product);

        // Teilen (/)
        int quotient = a / b; // Ganzzahlige Teilen
        System.out.println("Ganzzahlige Teilen (a / b): " + quotient);

        // Rest bei Teilen (%)
        int remainder = a % b;
        System.out.println("Rest bei Teilen (a % b): " + remainder);
        System.out.println();
    }

    /**
     * Demonstration von Besonderheiten der Teilen
     */
    public void demonstrateTeilenSpecifics() {
        System.out.println("=== Besonderheiten der Teilen ===");
        // Ganzzahlige Teilen
        int intA = 15;
        int intB = 4;
        int intResult = intA / intB;
        System.out.println("Ganzzahlige Teilen: " + intA + " / " + intB + " = " + intResult);

        // Teilen mit Gleitkommazahlen
        double doubleA = 15.0;
        double doubleB = 4.0;
        double doubleResult = doubleA / doubleB;
        System.out.println("Teilen double: " + doubleA + " / " + doubleB + " = " + doubleResult);

        // Gemischte Teilen (int und double)
        double mixedResult1 = intA / doubleB; // int wird zu double konvertiert
        double mixedResult2 = (double) intA / intB; // explizite Typumwandlung
        System.out.println("Gemischte Teilen (int/double): " + intA + " / " + doubleB + " = " + mixedResult1);
        System.out.println("Mit Typumwandlung: (double)" + intA + " / " + intB + " = " + mixedResult2);

        // Teilen durch Null
        System.out.println("\n--- Teilen durch Null ---");
        try {
            int zeroResult = intA / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Teilen int durch 0: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Teilen von double durch Null wirft keine Exception
        double doubleZeroResult = 5.0 / 0.0;
        System.out.println("Teilen 5.0 durch 0.0: " + doubleZeroResult);
        double negativeZeroResult = -5.5 / 0.0;
        System.out.println("Teilen -5.5 durch 0.0: " + negativeZeroResult);
        double nanResult = 0.0 / 0.0;
        System.out.println("Teilen 0.0 durch 0.0: " + nanResult);
        System.out.println();
    }

    /**
     * Demonstration des Modulo-Operators (%)
     */
    public void demonstrateModulusOperator() {
        System.out.println("=== Modulo-Operator (%) ===");
        // Positive Zahlen
        System.out.println("15 % 4 = " + (15 % 4)); // 3
        System.out.println("20 % 6 = " + (20 % 6)); // 2
        System.out.println("7 % 3 = " + (7 % 3)); // 1
        System.out.println("8 % 4 = " + (8 % 4)); // 0

        // Negative Zahlen
        System.out.println("\n--- Mit negativen Zahlen ---");
        System.out.println("-15 % 4 = " + (-15 % 4)); // -3
        System.out.println("15 % -4 = " + (15 % -4)); // 3
        System.out.println("-15 % -4 = " + (-15 % -4)); // -3

        // Mit Gleitkommazahlen
        System.out.println("\n--- Mit Gleitkommazahlen ---");
        System.out.println("15.5 % 4.0 = " + (15.5 % 4.0)); // 3.5
        System.out.println("10.7 % 3.2 = " + (10.7 % 3.2)); // ca. 1.1

        // Praktische Anwendung
        System.out.println("\n--- Praktische Anwendung ---");
        // Prüfung auf gerade/ungerade Zahlen
        int[] numbers = {10, 15, 22, 33, 44};
        for (int num : numbers) {
            String type = (num % 2 == 0) ? "gerade" : "ungerade";
            System.out.println(num + " - " + type);
        }
        System.out.println();
    }

    /**
     * Demonstration der unären arithmetischen Operatoren
     */
    public void demonstrateUnaryOperators() {
        System.out.println("=== Unäre arithmetische Operatoren ===");
        int value = 10;
        System.out.println("Ausgangswert: " + value);

        // Unäres Plus (+)
        int unaryPlus = +value;
        System.out.println("Unäres Plus (+value): " + unaryPlus);

        // Unäres Minus (-)
        int unaryMinus = -value;
        System.out.println("Unäres Minus (-value): " + unaryMinus);

        // Präfix-Inkrement (++variable)
        int prefixIncrement = ++value; // erst erhöhen, dann zurückgeben
        System.out.println("Nach Präfix-Inkrement (++value): value = " + value + ", Ergebnis = " + prefixIncrement);

        // Postfix-Inkrement (variable++)
        int postfixIncrement = value++; // erst zurückgeben, dann erhöhen
        System.out.println("Nach Postfix-Inkrement (value++): value = " + value + ", Ergebnis = " + postfixIncrement);

        // Präfix-Dekrement (--variable)
        int prefixDecrement = --value; // erst verringern, dann zurückgeben
        System.out.println("Nach Präfix-Dekrement (--value): value = " + value + ", Ergebnis = " + prefixDecrement);

        // Postfix-Dekrement (variable--)
        int postfixDecrement = value--; // erst zurückgeben, dann verringern
        System.out.println("Nach Postfix-Dekrement (value--): value = " + value + ", Ergebnis = " + postfixDecrement);
        System.out.println();
    }

    /**
     * Demonstration der Priorität arithmetischer Operatoren
     */
    public void demonstrateOperatorPrecedence() {
        System.out.println("=== Priorität arithmetischer Operatoren ===");
        // Ohne Klammern
        int result1 = 2 + 3 * 4; // Multiplikation hat höhere Priorität
        System.out.println("2 + 3 * 4 = " + result1); // 14, nicht 20

        // Mit Klammern
        int result2 = (2 + 3) * 4; // Klammern ändern die Reihenfolge
        System.out.println("(2 + 3) * 4 = " + result2); // 20

        // Komplexer Ausdruck
        int result3 = 10 - 6 / 2 + 3 * 4;
        System.out.println("10 - 6 / 2 + 3 * 4 = " + result3); // 10 - 3 + 12 = 19

        // Mit unären Operatoren
        int a = 5;
        int result4 = -a + 3 * ++a; // Unäre Operatoren haben höchste Priorität
        System.out.println("Anfangswert a = 5");
        a = 5; // Zurücksetzen für Demonstration
        result4 = -a + 3 * ++a; // -5 + 3 * 6 = 13
        System.out.println("-a + 3 * ++a = " + result4);
        System.out.println("Endwert a = " + a);

        // Prioritätstabelle (höchste bis niedrigste)
        System.out.println("\n--- Operatorpriorität (höchste -> niedrigste) ---");
        System.out.println("1. Unary: +, -, ++, --");
        System.out.println("2. Multiplikation und Teilen: *, /, %");
        System.out.println("3. Addition und Subtraktion: +, -");
        System.out.println("4. Klammern () ändern die Ausführungsreihenfolge");
        System.out.println();
    }

    /**
     * Demonstration von Überlauf und Genauigkeitsverlust
     */
    public void demonstrateOverflowAndPrecision() {
        System.out.println("=== Überlauf und Genauigkeitsverlust ===");
        // Überlauf int
        System.out.println("--- Überlauf int ---");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE: " + maxInt);
        System.out.println("MAX_VALUE + 1: " + (maxInt + 1)); // Überlauf!
        int minInt = Integer.MIN_VALUE;
        System.out.println("Integer.MIN_VALUE: " + minInt);
        System.out.println("MIN_VALUE - 1: " + (minInt - 1)); // Überlauf!

        // Überlauf bei Multiplikation
        int big1 = 100000;
        int big2 = 30000;
        int overflowResult = big1 * big2; // Überlauf
        long correctResult = (long) big1 * big2; // Korrektes Ergebnis
        System.out.println("\n--- Überlauf bei Multiplikation ---");
        System.out.println(big1 + " * " + big2 + " (int): " + overflowResult);
        System.out.println(big1 + " * " + big2 + " (long): " + correctResult);

        // Genauigkeitsverlust bei Gleitkommazahlen
        System.out.println("\n--- Genauigkeitsverlust float ---");
        float f1 = 0.1f;
        float f2 = 0.2f;
        float f3 = f1 + f2;
        System.out.println("0.1f + 0.2f = " + f3);
        System.out.println("Ist es gleich 0.3f? " + (f3 == 0.3f));

        // Genauigkeitsverlust bei großen Zahlen
        System.out.println("\n--- Genauigkeitsverlust bei großen Zahlen ---");
        float bigFloat = 16777216f; // 2^24
        float nextFloat = bigFloat + 1;
        System.out.println("bigFloat: " + bigFloat);
        System.out.println("bigFloat + 1: " + nextFloat);
        System.out.println("Sind sie gleich? " + (bigFloat == nextFloat));
        System.out.println();
    }

    /**
     * Demonstration der automatischen Typumwandlung bei arithmetischen Operationen
     */
    public void demonstrateTypePromotion() {
        System.out.println("=== Automatische Typumwandlung ===");
        // Umwandlung von byte und short zu int
        byte b1 = 10;
        byte b2 = 20;
        // byte result = b1 + b2; // FEHLER! Ergebnis ist int
        int byteResult = b1 + b2; // OK
        System.out.println("byte + byte -> int: " + b1 + " + " + b2 + " = " + byteResult);

        short s1 = 100;
        short s2 = 200;
        int shortResult = s1 + s2; // short + short -> int
        System.out.println("short + short -> int: " + s1 + " + " + s2 + " = " + shortResult);

        // Gemischte Operationen
        int intValue = 42;
        long longValue = 1000L;
        long mixedResult1 = intValue + longValue; // int -> long
        System.out.println("int + long -> long: " + intValue + " + " + longValue + " = " + mixedResult1);

        float floatValue = 3.14f;
        double doubleResult = intValue + floatValue; // int -> float -> double (im Ausdruck)
        System.out.println("int + float -> double: " + intValue + " + " + floatValue + " = " + doubleResult);

        // Regeln der Typumwandlung
        System.out.println("\n--- Regeln der automatischen Typumwandlung ---");
        System.out.println("1. byte, short, char -> int (bei arithmetischen Operationen)");
        System.out.println("2. Wenn ein Operand long ist, ist das Ergebnis long");
        System.out.println("3. Wenn ein Operand float ist, ist das Ergebnis float");
        System.out.println("4. Wenn ein Operand double ist, ist das Ergebnis double");
        System.out.println();
    }

    /**
     * Demonstration der zusammengesetzten Zuweisungsoperatoren
     */
    public void demonstrateCompoundAssignmentOperators() {
        System.out.println("=== Zusammengesetzte Zuweisungsoperatoren ===");
        int value = 10;
        System.out.println("Anfangswert: " + value);

        // += (Addition mit Zuweisung)
        value += 5; // entspricht value = value + 5
        System.out.println("Nach value += 5: " + value);

        // -= (Subtraktion mit Zuweisung)
        value -= 3; // entspricht value = value - 3
        System.out.println("Nach value -= 3: " + value);

        // *= (Multiplikation mit Zuweisung)
        value *= 2; // entspricht value = value * 2
        System.out.println("Nach value *= 2: " + value);

        // /= (Teilen mit Zuweisung)
        value /= 4; // entspricht value = value / 4
        System.out.println("Nach value /= 4: " + value);

        // %= (Modulo mit Zuweisung)
        value %= 3; // entspricht value = value % 3
        System.out.println("Nach value %= 3: " + value);

        // Besonderheit bei Typumwandlung
        System.out.println("\n--- Implizite Typumwandlung bei zusammengesetzten Operatoren ---");
        byte byteValue = 100;
        System.out.println("Anfangsbyte: " + byteValue);
        byteValue += 50; // kompiliert! Implizite Typumwandlung (byte)(byteValue + 50)
        System.out.println("Nach byteValue += 50: " + byteValue);

        // Das folgende kompiliert nicht:
        // byteValue = byteValue + 50; // FEHLER! Explizite Typumwandlung nötig
        System.out.println();
    }

    /**
     * Demonstration praktischer Beispiele für arithmetische Operationen
     */
    public void demonstratePracticalExamples() {
        System.out.println("=== Praktische Beispiele ===");

        // Beispiel 1: Berechnung des Durchschnitts
        System.out.println("--- Beispiel 1: Arithmetisches Mittel ---");
        int[] numbers = {85, 92, 78, 95, 88};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length; // Wichtig: Typumwandlung zu double
        System.out.println("Noten: 85, 92, 78, 95, 88");
        System.out.println("Summe: " + sum);
        System.out.println("Durchschnitt: " + average);

        // Beispiel 2: Celsius in Fahrenheit umwandeln
        System.out.println("\n--- Beispiel 2: Celsius zu Fahrenheit ---");
        double celsius = 25.0;
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        // Beispiel 3: Flächenberechnung eines Kreises
        System.out.println("\n--- Beispiel 3: Flächenberechnung eines Kreises ---");
        double radius = 5.0;
        double pi = 3.14159;
        double area = pi * radius * radius;
        System.out.println("Radius: " + radius);
        System.out.println("Fläche: " + area);

        // Beispiel 4: Prozentrechnung und Rabatt
        System.out.println("\n--- Beispiel 4: Rabattberechnung ---");
        double originalPrice = 150.0;
        double discountPercent = 20.0;
        double discountAmount = originalPrice * discountPercent / 100;
        double finalPrice = originalPrice - discountAmount;
        System.out.println("Originalpreis: $" + originalPrice);
        System.out.println("Rabatt " + discountPercent + "%: $" + discountAmount);
        System.out.println("Endpreis: $" + finalPrice);
        System.out.println();
    }

    /**
     * Hauptmethode zur Demonstration aller arithmetischen Operatoren
     */
    public static void main(String[] args) {
        System.out.println("=== Demonstration der arithmetischen Operatoren in Java ===\n");
        ArithmeticOperatorsDemo demo = new ArithmeticOperatorsDemo();

        // Alle Demonstrationen ausführen
        demo.demonstrateBasicArithmeticOperators();
        demo.demonstrateTeilenSpecifics();
        demo.demonstrateModulusOperator();
        demo.demonstrateUnaryOperators();
        demo.demonstrateOperatorPrecedence();
        demo.demonstrateOverflowAndPrecision();
        demo.demonstrateTypePromotion();
        demo.demonstrateCompoundAssignmentOperators();
        demo.demonstratePracticalExamples();

        System.out.println("=== Wichtige Punkte der arithmetischen Operatoren ===");
        System.out.println("1. Ganzzahlige Teilen verwirft den Nachkommateil");
        System.out.println("2. Teilen int durch Null löst ArithmeticException aus");
        System.out.println("3. Teilen double durch Null ergibt Infinity oder NaN");
        System.out.println("4. Unäre Operatoren haben höchste Priorität");
        System.out.println("5. ++/-- als Präfix und Postfix verhalten sich unterschiedlich");
        System.out.println("6. byte/short werden bei arithmetischen Operationen automatisch zu int konvertiert");
        System.out.println("7. Zusammengesetzte Operatoren führen implizite Typumwandlungen durch");
        System.out.println("8. Überlauf passiert ohne Exception (Wrap-around)");
        System.out.println("9. float und double haben begrenzte Genauigkeit");
        System.out.println("10. Verwenden Sie Klammern, um die Reihenfolge der Operationen explizit zu bestimmen");
    }
}
