package com.de.oca.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstration der Grundlagen der Arbeit mit ArrayList in Java.
 * Zeigt Erstellung, Initialisierung, Hinzufügen, Entfernen von Elementen und Iteration über ArrayList.
 */
public class BasicArrayListDemo {

    /**
     * Demonstration der Erstellung von ArrayList auf verschiedene Weise
     */
    public void demonstrateArrayListCreation() {
        System.out.println("=== ArrayList Erstellung ===");

        // Erstellung einer leeren ArrayList
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Leere ArrayList erstellt, Größe: " + names.size());

        // Erstellung einer ArrayList mit Anfangskapazität
        ArrayList<Integer> numbers = new ArrayList<>(10);
        System.out.println("ArrayList mit Anfangskapazität 10 erstellt, Größe: " + numbers.size());

        // Erstellung einer ArrayList aus einer anderen Collection
        List<String> cities = Arrays.asList("Berlin", "Hamburg", "München");
        ArrayList<String> citiesList = new ArrayList<>(cities);
        System.out.println("ArrayList aus Collection: " + citiesList);

        // Verwendung des List-Interfaces (empfohlener Ansatz)
        List<String> fruits = new ArrayList<>();
        fruits.add("Apfel");
        fruits.add("Banane");
        System.out.println("ArrayList über List-Interface: " + fruits);
    }

    /**
     * Demonstration des Hinzufügens von Elementen zur ArrayList
     */
    public void demonstrateAddingElements() {
        System.out.println("\n=== Elemente hinzufügen ===");

        List<String> colors = new ArrayList<>();

        // Hinzufügen am Ende der Liste
        colors.add("Rot");
        colors.add("Grün");
        colors.add("Blau");
        System.out.println("Nach Hinzufügen am Ende: " + colors);

        // Hinzufügen nach Index
        colors.add(1, "Gelb");
        System.out.println("Nach Hinzufügen bei Index 1: " + colors);

        // Hinzufügen aller Elemente aus einer anderen Collection
        List<String> newColors = Arrays.asList("Violett", "Orange");
        colors.addAll(newColors);
        System.out.println("Nach Hinzufügen der Collection: " + colors);

        // Hinzufügen einer Collection bei bestimmtem Index
        colors.addAll(2, Arrays.asList("Rosa", "Grau"));
        System.out.println("Nach Hinzufügen der Collection bei Index 2: " + colors);
    }

    /**
     * Demonstration des Zugriffs auf ArrayList-Elemente
     */
    public void demonstrateElementAccess() {
        System.out.println("\n=== Zugriff auf Elemente ===");

        List<String> animals = new ArrayList<>();
        animals.add("Katze");
        animals.add("Hund");
        animals.add("Vogel");
        animals.add("Fisch");

        // Element nach Index abrufen
        String firstAnimal = animals.get(0);
        String lastAnimal = animals.get(animals.size() - 1);
        System.out.println("Erstes Tier: " + firstAnimal);
        System.out.println("Letztes Tier: " + lastAnimal);

        // Element nach Index ändern
        String oldValue = animals.set(2, "Papagei");
        System.out.println("Ersetzt '" + oldValue + "' durch '" + animals.get(2) + "'");
        System.out.println("Aktualisierte Liste: " + animals);

        // Prüfung auf Vorhandensein eines Elements
        boolean hasCat = animals.contains("Katze");
        boolean hasMouse = animals.contains("Maus");
        System.out.println("Enthält 'Katze': " + hasCat);
        System.out.println("Enthält 'Maus': " + hasMouse);

        // Suche nach Index eines Elements
        int dogIndex = animals.indexOf("Hund");
        int mouseIndex = animals.indexOf("Maus");
        System.out.println("Index 'Hund': " + dogIndex);
        System.out.println("Index 'Maus': " + mouseIndex + " (-1 bedeutet nicht gefunden)");
    }

    /**
     * Demonstration des Entfernens von Elementen aus ArrayList
     */
    public void demonstrateElementRemoval() {
        System.out.println("\n=== Elemente entfernen ===");

        List<String> foods = new ArrayList<>();
        foods.add("Brot");
        foods.add("Milch");
        foods.add("Eier");
        foods.add("Fleisch");
        foods.add("Milch"); // Duplikat zur Demonstration
        System.out.println("Ursprüngliche Liste: " + foods);

        // Entfernen nach Index
        String removed = foods.remove(0);
        System.out.println("Element bei Index 0 entfernt: " + removed);
        System.out.println("Nach Entfernung: " + foods);

        // Entfernen nach Wert (erstes gefundenes wird entfernt)
        boolean wasRemoved = foods.remove("Milch");
        System.out.println("'Milch' entfernt: " + wasRemoved);
        System.out.println("Nach Entfernung: " + foods);

        // Entfernen aller Elemente aus Collection
        List<String> toRemove = Arrays.asList("Eier", "Milch");
        foods.removeAll(toRemove);
        System.out.println("Nach Entfernung der Collection: " + foods);

        // Leeren der gesamten Liste
        foods.clear();
        System.out.println("Nach Leerung: " + foods + ", Größe: " + foods.size());
        System.out.println("Liste ist leer: " + foods.isEmpty());
    }

    /**
     * Demonstration der Iteration über ArrayList
     */
    public void demonstrateIteration() {
        System.out.println("\n=== Iteration über ArrayList ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Normale for-Schleife
        System.out.println("Normale for-Schleife:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("  Index " + i + ": " + numbers.get(i));
        }

        // Erweiterte for-Schleife (for-each)
        System.out.println("Erweiterte for-Schleife:");
        for (Integer number : numbers) {
            System.out.println("  Wert: " + number);
        }

        // Verwendung von forEach mit Lambda (Java 8+)
        System.out.println("forEach mit Lambda:");
        numbers.forEach(number -> System.out.println("  Lambda: " + number));
    }

    /**
     * Demonstration von Größe und Kapazität der ArrayList
     */
    public void demonstrateSizeAndCapacity() {
        System.out.println("\n=== Größe und Kapazität ===");

        List<String> items = new ArrayList<>();
        System.out.println("Anfangsgröße: " + items.size());

        // Elemente hinzufügen
        for (int i = 1; i <= 5; i++) {
            items.add("Element " + i);
            System.out.println("Element " + i + " hinzugefügt, Größe: " + items.size());
        }

        // Demonstration, dass ArrayList automatisch wächst
        for (int i = 6; i <= 15; i++) {
            items.add("Element " + i);
        }
        System.out.println("Nach Hinzufügung von 15 Elementen, Größe: " + items.size());
    }

    /**
     * Demonstration der Arbeit mit null-Werten und Duplikaten
     */
    public void demonstrateNullsAndDuplicates() {
        System.out.println("\n=== Null-Werte und Duplikate ===");

        List<String> values = new ArrayList<>();

        // ArrayList erlaubt null-Werte
        values.add("Erster");
        values.add(null);
        values.add("Dritter");
        values.add(null);
        System.out.println("Liste mit null: " + values);

        // ArrayList erlaubt Duplikate
        values.add("Erster"); // Duplikat
        System.out.println("Liste mit Duplikaten: " + values);

        // Zählung der null-Werte
        long nullCount = values.stream().filter(v -> v == null).count();
        System.out.println("Anzahl der null-Werte: " + nullCount);

        // Entfernung aller null-Werte
        values.removeIf(v -> v == null);
        System.out.println("Nach Entfernung von null: " + values);
    }

    /**
     * Demonstration typischer Fehler bei der Arbeit mit ArrayList
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Typische Fehler ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Fehler 1: IndexOutOfBoundsException
        try {
            int value = numbers.get(5); // Index existiert nicht
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Fehler beim Zugriff mit falschem Index: " + e.getMessage());
        }

        // Fehler 2: Problem beim Entfernen während Iteration
        System.out.println("Liste vor Entfernung gerader Zahlen: " + numbers);
        List<Integer> numbersToRemove = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 20 == 0) { // gerade Zahlen, die durch 20 teilbar sind
                numbersToRemove.add(num);
            }
        }
        numbers.removeAll(numbersToRemove);
        System.out.println("Liste nach sicherer Entfernung: " + numbers);

        // Fehler 3: Versuch, Primitive direkt mit Autoboxing zu verwenden
        List<Integer> autoboxing = new ArrayList<>();
        autoboxing.add(42); // Autoboxing int -> Integer
        int value = autoboxing.get(0); // Autounboxing Integer -> int
        System.out.println("Autoboxing/Unboxing funktioniert: " + value);
    }

    /**
     * Hauptmethode zum Starten aller Demonstrationen
     */
    public static void main(String[] args) {
        BasicArrayListDemo demo = new BasicArrayListDemo();

        demo.demonstrateArrayListCreation();
        demo.demonstrateAddingElements();
        demo.demonstrateElementAccess();
        demo.demonstrateElementRemoval();
        demo.demonstrateIteration();
        demo.demonstrateSizeAndCapacity();
        demo.demonstrateNullsAndDuplicates();
        demo.demonstrateCommonMistakes();
    }
}
