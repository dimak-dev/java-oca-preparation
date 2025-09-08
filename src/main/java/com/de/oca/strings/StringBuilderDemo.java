package com.de.oca.strings;

/**
 * Demonstration der Arbeit mit String und StringBuilder in Java.
 * Zeigt die Unterschiede zwischen unveränderlichen Strings und veränderlichen String-Puffern.
 */
public class StringBuilderDemo {

    /**
     * Demonstration der Unveränderlichkeit von Strings (String Immutability)
     */
    public void demonstrateStringImmutability() {
        System.out.println("=== Unveränderlichkeit von Strings ===");
        String str1 = "Hallo";
        String str2 = str1; // str2 verweist auf dasselbe Objekt
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str2: " + (str1 == str2)); // true - gleiche Referenzen

        // "Änderung" von str1 erzeugt ein neues Objekt
        str1 = str1 + " Welt";
        System.out.println("Nach der 'Änderung' von str1:");
        System.out.println("str1: " + str1); // "Hallo Welt"
        System.out.println("str2: " + str2); // "Hallo" - hat sich nicht geändert!
        System.out.println("str1 == str2: " + (str1 == str2)); // false - unterschiedliche Objekte

        // Demonstration der Erstellung vieler Objekte
        String result = "Start";
        System.out.println("\nErstellung vieler String-Objekte:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Vor der Konkatenation: " + result.hashCode());
            result = result + " " + i; // jedes Mal wird ein neues Objekt erstellt!
            System.out.println("Nach der Konkatenation: " + result + " (hashCode: " + result.hashCode() + ")");
        }
    }

    /**
     * Demonstration der grundlegenden String-Methoden
     */
    public void demonstrateStringMethods() {
        System.out.println("\n=== Grundlegende String-Methoden ===");
        String text = " Java Programming Language ";
        System.out.println("Ursprünglicher String: '" + text + "'");

        // Methoden zum Abrufen von Informationen
        System.out.println("Länge: " + text.length());
        System.out.println("Ist der String leer: " + text.isEmpty());
        System.out.println("Zeichen am Index 2: " + text.charAt(2));

        // Suchmethoden
        System.out.println("Index von 'Java': " + text.indexOf("Java"));
        System.out.println("Letzter Index von 'a': " + text.lastIndexOf('a'));
        System.out.println("Enthält 'Program': " + text.contains("Program"));
        System.out.println("Beginnt mit ' Ja': " + text.startsWith(" Ja"));
        System.out.println("Endet mit 'ge ': " + text.endsWith("ge "));

        // Umwandlungsmethoden (geben neue Objekte zurück!)
        System.out.println("Großbuchstaben: " + text.toUpperCase());
        System.out.println("Kleinbuchstaben: " + text.toLowerCase());
        System.out.println("Ohne Leerzeichen: '" + text.trim() + "'");

        // Methoden zum Extrahieren von Teilstrings
        System.out.println("Teilstring von 2 bis 6: '" + text.substring(2, 6) + "'");
        System.out.println("Teilstring ab 7: '" + text.substring(7) + "'");

        // Ersetzungsmethoden (geben neue Objekte zurück!)
        System.out.println("Ersetzung von 'a' durch '@': " + text.replace('a', '@'));
        System.out.println("Ersetzung von 'Java' durch 'Python': " + text.replace("Java", "Python"));

        // Der ursprüngliche String bleibt unverändert!
        System.out.println("Ursprünglicher String immer noch: '" + text + "'");
    }

    /**
     * Demonstration des String Pools (String-Pool)
     */
    public void demonstrateStringPool() {
        System.out.println("\n=== String Pool ===");
        // String-Literale werden im Pool abgelegt
        String str1 = "Hallo";
        String str2 = "Hallo";
        String str3 = "Hal" + "lo"; // Der Compiler optimiert dies zu "Hallo"
        System.out.println("str1 == str2: " + (str1 == str2)); // true - aus dem Pool
        System.out.println("str1 == str3: " + (str1 == str3)); // true - Compiler-Optimierung

        // new String() erstellt immer ein neues Objekt
        String str4 = new String("Hallo");
        System.out.println("str1 == str4: " + (str1 == str4)); // false - neues Objekt
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true - der Inhalt ist gleich

        // intern() legt den String in den Pool (oder gibt eine Referenz zurück, wenn bereits vorhanden)
        String str5 = str4.intern();
        System.out.println("str1 == str5: " + (str1 == str5)); // true - jetzt aus dem Pool

        // Dynamisch erstellte Strings sind nicht im Pool
        String dynamic = "Hal" + new String("lo");
        System.out.println("str1 == dynamic: " + (str1 == dynamic)); // false
        System.out.println("str1 == dynamic.intern(): " + (str1 == dynamic.intern())); // true
    }

    /**
     * Demonstration der Grundlagen von StringBuilder
     */
    public void demonstrateStringBuilderBasics() {
        System.out.println("\n=== Grundlagen von StringBuilder ===");
        // StringBuilder erstellen
        StringBuilder sb1 = new StringBuilder(); // leer
        StringBuilder sb2 = new StringBuilder("Initialer Text"); // mit Anfangstext
        StringBuilder sb3 = new StringBuilder(50); // mit Anfangskapazität
        System.out.println("sb1: '" + sb1 + "' (Länge: " + sb1.length() + ")");
        System.out.println("sb2: '" + sb2 + "' (Länge: " + sb2.length() + ")");
        System.out.println("sb3: '" + sb3 + "' (Kapazität: " + sb3.capacity() + ")");

        // Grundlegende Operationen
        sb1.append("Hallo"); // am Ende anfügen
        sb1.append(" ").append("Welt"); // Methodenverkettung
        System.out.println("Nach append: " + sb1);
        sb1.insert(5, " wunderschöne"); // an einem Index einfügen
        System.out.println("Nach insert: " + sb1);
        sb1.replace(6, 19, "erstaunliche"); // einen Teil ersetzen
        System.out.println("Nach replace: " + sb1);
        sb1.delete(5, 17); // einen Teil löschen
        System.out.println("Nach delete: " + sb1);
        sb1.reverse(); // umkehren
        System.out.println("Nach reverse: " + sb1);
    }

    /**
     * Demonstration der StringBuilder-Methoden
     */
    public void demonstrateStringBuilderMethods() {
        System.out.println("\n=== StringBuilder-Methoden ===");
        StringBuilder sb = new StringBuilder("Java Programmierung");
        // Informationsmethoden
        System.out.println("Ursprünglicher StringBuilder: " + sb);
        System.out.println("Länge: " + sb.length());
        System.out.println("Kapazität: " + sb.capacity());
        System.out.println("Zeichen am Index 5: " + sb.charAt(5));

        // Änderungsmethoden
        sb.setCharAt(0, 'j'); // Zeichen ändern
        System.out.println("Nach setCharAt(0, 'j'): " + sb);
        sb.deleteCharAt(4); // Zeichen am Index löschen
        System.out.println("Nach deleteCharAt(4): " + sb);

        // Teilstring erhalten (gibt einen neuen String zurück!)
        String substring = sb.substring(0, 4);
        System.out.println("Teilstring (0, 4): " + substring);
        System.out.println("StringBuilder ist geblieben: " + sb);

        // Umwandlung in einen String
        String result = sb.toString();
        System.out.println("Finaler String: " + result);
        System.out.println("StringBuilder: " + sb + " (hat sich nicht geändert)");
    }

    /**
     * Leistungsvergleich von String vs. StringBuilder
     */
    public void demonstratePerformance() {
        System.out.println("\n=== Leistungsvergleich ===");
        int iterations = 1000;

        // Leistungstest für String (langsam)
        long startTime = System.currentTimeMillis();
        String stringResult = "";
        for (int i = 0; i < iterations; i++) {
            stringResult += "a"; // jedes Mal wird ein neues Objekt erstellt!
        }
        long stringTime = System.currentTimeMillis() - startTime;

        // Leistungstest für StringBuilder (schnell)
        startTime = System.currentTimeMillis();
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbResult.append("a"); // das vorhandene Objekt wird geändert
        }
        String sbFinalResult = sbResult.toString();
        long sbTime = System.currentTimeMillis() - startTime;

        System.out.println("Ergebnisse für " + iterations + " Iterationen:");
        System.out.println("String-Konkatenation: " + stringTime + " ms");
        System.out.println("StringBuilder: " + sbTime + " ms");
        System.out.println("StringBuilder ist " + (stringTime > 0 ? stringTime / Math.max(sbTime, 1) : "viel") + " mal schneller");

        // Überprüfen, ob die Ergebnisse gleich sind
        System.out.println("Ergebnisse sind gleich: " + stringResult.equals(sbFinalResult));
        System.out.println("Länge des Ergebnisses: " + stringResult.length());
    }
    
    /**
    * Demonstration der Kapazität von StringBuilder
    */
    public void demonstrateStringBuilderCapacity() {
        System.out.println("\n=== Kapazität von StringBuilder ===");
        StringBuilder sb = new StringBuilder();
        System.out.println("Anfangskapazität: " + sb.capacity()); // normalerweise 16
        // Fügen Sie Zeichen hinzu und beobachten Sie die Kapazitätsänderung
        for (int i = 1; i <= 20; i++) {
            sb.append("x");
            if (i % 5 == 0 || i == 17) { // zeigen, wann die Kapazität erhöht wird
                System.out.println("Nach " + i + " Zeichen - Länge: " + sb.length() +
                    ", Kapazität: " + sb.capacity());
            }
        }
        // Kapazität explizit festlegen
        sb.ensureCapacity(100);
        System.out.println("Nach ensureCapacity(100): " + sb.capacity());
        // Auf die aktuelle Länge zuschneiden
        sb.trimToSize();
        System.out.println("Nach trimToSize(): " + sb.capacity());
    }

    /**
     * Demonstration typischer Fehler bei der Arbeit mit Strings
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Typische Fehler ===");
        // Fehler 1: Verwendung von == anstelle von equals()
        String str1 = new String("test");
        String str2 = new String("test");
        System.out.println("str1 == str2: " + (str1 == str2)); // false!
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true

        // Fehler 2: NullPointerException bei der Arbeit mit Strings
        String nullString = null;
        try {
            int length = nullString.length(); // NPE!
        } catch (NullPointerException e) {
            System.out.println("NPE beim Aufruf einer Methode auf einem null-String");
        }

        // Korrekte Prüfung auf null
        if (nullString != null && !nullString.isEmpty()) {
            System.out.println("Der String ist nicht leer");
        } else {
            System.out.println("Der String ist null oder leer");
        }

        // Fehler 3: Ineffiziente Konkatenation in Schleifen
        System.out.println("\nSCHLECHT - String-Konkatenation in einer Schleife:");
        String inefficient = "";
        for (int i = 1; i <= 5; i++) {
            inefficient += i + " "; // bei jeder Iteration wird ein neues Objekt erstellt
        }
        System.out.println("Ergebnis: " + inefficient);

        System.out.println("GUT - StringBuilder in einer Schleife:");
        StringBuilder efficient = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            efficient.append(i).append(" "); // ein Objekt wird geändert
        }
        System.out.println("Ergebnis: " + efficient.toString());

        // Fehler 4: Vergessen von toString() für StringBuilder
        StringBuilder sb = new StringBuilder("Hallo Welt");
        System.out.println("StringBuilder direkt: " + sb); // funktioniert, ist aber nicht offensichtlich
        System.out.println("StringBuilder.toString(): " + sb.toString()); // explizit und verständlich
    }

    /**
     * Demonstration der Arbeit mit der equals()-Methode und dem String-Vergleich
     */
    public void demonstrateStringComparison() {
        System.out.println("\n=== String-Vergleich ===");
        String str1 = "Hallo";
        String str2 = "hallo";
        String str3 = "Hallo";
        String str4 = new String("Hallo");

        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false - unterschiedliche Groß-/Kleinschreibung
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true

        System.out.println("str1 == str3: " + (str1 == str3)); // true - aus dem Pool
        System.out.println("str1 == str4: " + (str1 == str4)); // false - neues Objekt

        // compareTo zur Sortierung
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // negativ
        System.out.println("str2.compareTo(str1): " + str2.compareTo(str1)); // positiv
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0

        // Vergleich mit null
        try {
            str1.equals(null); // sicher
            System.out.println("str1.equals(null): " + str1.equals(null)); // false
        } catch (Exception e) {
            System.out.println("Fehler beim Vergleich mit null: " + e.getMessage());
        }
    }

    /**
     * Hauptmethode zum Ausführen aller Demonstrationen
     */
    public static void main(String[] args) {
        StringBuilderDemo demo = new StringBuilderDemo();
        demo.demonstrateStringImmutability();
        demo.demonstrateStringMethods();
        demo.demonstrateStringPool();
        demo.demonstrateStringBuilderBasics();
        demo.demonstrateStringBuilderMethods();
        demo.demonstratePerformance();
        demo.demonstrateStringBuilderCapacity();
        demo.demonstrateCommonMistakes();
        demo.demonstrateStringComparison();
    }
}
