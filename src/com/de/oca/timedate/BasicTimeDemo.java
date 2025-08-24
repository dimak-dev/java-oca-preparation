package com.de.oca.timedate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Demonstration der Arbeit mit Datum und Zeit in Java 8 Time API.
 * Zeigt die Hauptklassen LocalDate, LocalTime, LocalDateTime und ihre Methoden.
 */
public class BasicTimeDemo {

    /**
     * Demonstration der Arbeit mit LocalDate
     */
    public void demonstrateLocalDate() {
        System.out.println("=== LocalDate - Arbeit mit Daten ===");

        // Erstellung von LocalDate
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2023, 12, 25);
        LocalDate fromString = LocalDate.parse("2023-06-15");

        System.out.println("Heute: " + today);
        System.out.println("Bestimmtes Datum: " + specificDate);
        System.out.println("Aus String: " + fromString);

        // Abrufen von Datumskomponenten
        System.out.println("\nDatumskomponenten von " + today + ":");
        System.out.println("Jahr: " + today.getYear());
        System.out.println("Monat (Zahl): " + today.getMonthValue());
        System.out.println("Monat (enum): " + today.getMonth());
        System.out.println("Tag des Monats: " + today.getDayOfMonth());
        System.out.println("Wochentag: " + today.getDayOfWeek());
        System.out.println("Tag des Jahres: " + today.getDayOfYear());

        // Erstellung mit Month enum
        LocalDate withMonthEnum = LocalDate.of(2023, Month.DECEMBER, 31);
        System.out.println("Mit Month enum: " + withMonthEnum);

        // Überprüfungen
        System.out.println("\nÜberprüfungen:");
        System.out.println("Schaltjahr: " + today.isLeapYear());
        System.out.println("Vor Neujahr: " + today.isBefore(LocalDate.of(2024, 1, 1)));
        System.out.println("Nach 2020: " + today.isAfter(LocalDate.of(2020, 12, 31)));
    }

    /**
     * Demonstration der Arbeit mit LocalTime
     */
    public void demonstrateLocalTime() {
        System.out.println("\n=== LocalTime - Arbeit mit Zeit ===");

        // Erstellung von LocalTime
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30, 45);
        LocalTime fromString = LocalTime.parse("09:15:30");
        LocalTime withNanos = LocalTime.of(12, 0, 0, 123456789);

        System.out.println("Jetzt: " + now);
        System.out.println("Bestimmte Zeit: " + specificTime);
        System.out.println("Aus String: " + fromString);
        System.out.println("Mit Nanosekunden: " + withNanos);

        // Abrufen von Zeitkomponenten
        System.out.println("\nZeitkomponenten von " + specificTime + ":");
        System.out.println("Stunde: " + specificTime.getHour());
        System.out.println("Minute: " + specificTime.getMinute());
        System.out.println("Sekunde: " + specificTime.getSecond());
        System.out.println("Nanosekunde: " + specificTime.getNano());

        // Verkürzte Erstellungsformen
        LocalTime hourAndMinute = LocalTime.of(15, 45); // Sekunden = 0
        LocalTime onlyHour = LocalTime.of(12, 0); // Minuten und Sekunden = 0
        System.out.println("Nur Stunde und Minute: " + hourAndMinute);
        System.out.println("Nur Stunde: " + onlyHour);

        // Spezielle Konstanten
        System.out.println("\nKonstanten:");
        System.out.println("Mitternacht: " + LocalTime.MIDNIGHT);
        System.out.println("Mittag: " + LocalTime.NOON);
        System.out.println("Minimale Zeit: " + LocalTime.MIN);
        System.out.println("Maximale Zeit: " + LocalTime.MAX);
    }

    /**
     * Demonstration der Arbeit mit LocalDateTime
     */
    public void demonstrateLocalDateTime() {
        System.out.println("\n=== LocalDateTime - Datum und Zeit zusammen ===");

        // Erstellung von LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime specific = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        LocalDateTime fromString = LocalDateTime.parse("2023-06-15T14:30:45");

        System.out.println("Jetzt: " + now);
        System.out.println("Bestimmter Moment: " + specific);
        System.out.println("Aus String: " + fromString);

        // Erstellung aus separaten LocalDate und LocalTime
        LocalDate date = LocalDate.of(2023, 7, 4);
        LocalTime time = LocalTime.of(18, 30);
        LocalDateTime combined = LocalDateTime.of(date, time);
        LocalDateTime combined2 = date.atTime(time);
        LocalDateTime combined3 = time.atDate(date);

        System.out.println("Verbindung date + time: " + combined);
        System.out.println("date.atTime(time): " + combined2);
        System.out.println("time.atDate(date): " + combined3);

        // Extrahieren von Komponenten
        System.out.println("\nKomponenten extrahieren aus " + specific + ":");
        System.out.println("Datum: " + specific.toLocalDate());
        System.out.println("Zeit: " + specific.toLocalTime());
        System.out.println("Jahr: " + specific.getYear());
        System.out.println("Stunde: " + specific.getHour());
    }

    /**
     * Demonstration von Datum- und Zeitänderungsoperationen
     */
    public void demonstrateDateTimeManipulation() {
        System.out.println("\n=== Ändern von Daten und Zeiten ===");

        LocalDate baseDate = LocalDate.of(2023, 6, 15);
        System.out.println("Basisdatum: " + baseDate);

        // Plus-Methoden (Hinzufügen)
        System.out.println("Plus 1 Tag: " + baseDate.plusDays(1));
        System.out.println("Plus 2 Wochen: " + baseDate.plusWeeks(2));
        System.out.println("Plus 3 Monate: " + baseDate.plusMonths(3));
        System.out.println("Plus 1 Jahr: " + baseDate.plusYears(1));

        // Minus-Methoden (Abziehen)
        System.out.println("Minus 5 Tage: " + baseDate.minusDays(5));
        System.out.println("Minus 1 Monat: " + baseDate.minusMonths(1));

        // Operationen mit Zeit
        LocalTime baseTime = LocalTime.of(14, 30, 45);
        System.out.println("\nBasiszeit: " + baseTime);
        System.out.println("Plus 2 Stunden: " + baseTime.plusHours(2));
        System.out.println("Plus 30 Minuten: " + baseTime.plusMinutes(30));
        System.out.println("Minus 15 Sekunden: " + baseTime.minusSeconds(15));

        // Operationen mit LocalDateTime
        LocalDateTime baseDateTime = LocalDateTime.of(2023, 6, 15, 14, 30);
        System.out.println("\nBasis Datum-Zeit: " + baseDateTime);
        System.out.println("Plus 1 Tag 2 Stunden: " + baseDateTime.plusDays(1).plusHours(2));
        System.out.println("Minus 1 Woche: " + baseDateTime.minusWeeks(1));

        // Wichtig: alle Methoden geben ein neues Objekt zurück!
        LocalDate original = LocalDate.of(2023, 1, 1);
        LocalDate modified = original.plusMonths(6);
        System.out.println("\nUnveränderlichkeit:");
        System.out.println("Ursprüngliches Datum: " + original);
        System.out.println("Geändertes Datum: " + modified);
        System.out.println("Das ursprüngliche hat sich nicht geändert!");
    }

    /**
     * Demonstration der with-Methoden (Setzen konkreter Werte)
     */
    public void demonstrateWithMethods() {
        System.out.println("\n=== With-Methoden - Werte setzen ===");

        LocalDate baseDate = LocalDate.of(2023, 6, 15);
        System.out.println("Basisdatum: " + baseDate);

        // Setzen konkreter Werte
        System.out.println("Jahr auf 2025 setzen: " + baseDate.withYear(2025));
        System.out.println("Monat auf Dezember setzen: " + baseDate.withMonth(12));
        System.out.println("Tag auf 1 setzen: " + baseDate.withDayOfMonth(1));
        System.out.println("Tag des Jahres auf 100 setzen: " + baseDate.withDayOfYear(100));

        LocalTime baseTime = LocalTime.of(14, 30, 45);
        System.out.println("\nBasiszeit: " + baseTime);
        System.out.println("Stunde auf 9 setzen: " + baseTime.withHour(9));
        System.out.println("Minute auf 0 setzen: " + baseTime.withMinute(0));
        System.out.println("Sekunde auf 30 setzen: " + baseTime.withSecond(30));

        // Verkettung von Änderungen
        LocalDate chainedChanges = baseDate
                .withYear(2024)
                .withMonth(12)
                .withDayOfMonth(31);
        System.out.println("\nVerkettung von Änderungen: " + chainedChanges);
    }

    /**
     * Demonstration von Formatierung und Parsing
     */
    public void demonstrateFormattingAndParsing() {
        System.out.println("\n=== Formatierung und Parsing ===");

        LocalDate date = LocalDate.of(2023, 12, 25);
        LocalTime time = LocalTime.of(14, 30, 45);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Verwendung vordefinierter Formatierungen
        System.out.println("Datum ISO: " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("Zeit ISO: " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("Datum-Zeit ISO: " + dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        // Benutzerdefinierte Formate
        DateTimeFormatter customDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter customTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        System.out.println("Datum (dd/MM/yyyy): " + date.format(customDateFormatter));
        System.out.println("Zeit (HH:mm:ss): " + time.format(customTimeFormatter));
        System.out.println("Datum-Zeit (dd.MM.yyyy HH:mm): " + dateTime.format(customDateTimeFormatter));

        // Parsing von Strings
        System.out.println("\nParsing von Strings:");
        LocalDate parsedDate = LocalDate.parse("25/12/2023", customDateFormatter);
        LocalTime parsedTime = LocalTime.parse("14:30:45", customTimeFormatter);
        System.out.println("Geparste Datum: " + parsedDate);
        System.out.println("Geparste Zeit: " + parsedTime);

        // Parsing mit Standardformat
        LocalDate isoDate = LocalDate.parse("2023-12-25");
        LocalDateTime isoDateTime = LocalDateTime.parse("2023-12-25T14:30:45");
        System.out.println("ISO Datum: " + isoDate);
        System.out.println("ISO Datum-Zeit: " + isoDateTime);
    }

    /**
     * Demonstration von Period für die Arbeit mit Datumsperioden
     */
    public void demonstratePeriod() {
        System.out.println("\n=== Period - Perioden zwischen Daten ===");

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        Period period = Period.between(startDate, endDate);
        System.out.println("Periode zwischen " + startDate + " und " + endDate + ": " + period);
        System.out.println("Jahre: " + period.getYears());
        System.out.println("Monate: " + period.getMonths());
        System.out.println("Tage: " + period.getDays());

        // Erstellen von Perioden
        Period oneYear = Period.ofYears(1);
        Period twoMonths = Period.ofMonths(2);
        Period tenDays = Period.ofDays(10);
        Period combined = Period.of(1, 2, 10); // 1 Jahr, 2 Monate, 10 Tage

        System.out.println("\nErstellte Perioden:");
        System.out.println("1 Jahr: " + oneYear);
        System.out.println("2 Monate: " + twoMonths);
        System.out.println("10 Tage: " + tenDays);
        System.out.println("Kombiniert: " + combined);

        // Verwendung von Perioden mit Daten
        LocalDate today = LocalDate.now();
        System.out.println("Heute: " + today);
        System.out.println("Plus 1 Jahr 2 Monate 10 Tage: " + today.plus(combined));
        System.out.println("Minus 6 Monate: " + today.minus(Period.ofMonths(6)));
    }

    /**
     * Demonstration typischer Fehler beim Arbeiten mit Datum und Zeit
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Typische Fehler ===");

        // Fehler 1: Falsche Parameter beim Erstellen
        try {
            LocalDate invalidDate = LocalDate.of(2023, 2, 30); // 30. Februar existiert nicht!
        } catch (DateTimeException e) {
            System.out.println("Fehler bei Datumerstellung: " + e.getMessage());
        }

        try {
            LocalTime invalidTime = LocalTime.of(25, 0); // 25 Uhr existiert nicht!
        } catch (DateTimeException e) {
            System.out.println("Fehler bei Zeiterstellung: " + e.getMessage());
        }

        // Fehler 2: Falsches Format beim Parsing
        try {
            LocalDate wrongFormat = LocalDate.parse("25-12-2023"); // falsches Format
        } catch (DateTimeParseException e) {
            System.out.println("Fehler beim Datum-Parsing: " + e.getMessage());
        }

        // Fehler 3: Vergessen der Unveränderlichkeit
        LocalDate date = LocalDate.of(2023, 6, 15);
        date.plusDays(5); // Ergebnis nicht gespeichert!
        System.out.println("Datum hat sich nicht geändert: " + date);

        // Richtig:
        LocalDate correctDate = date.plusDays(5);
        System.out.println("Richtige Änderung: " + correctDate);

        // Fehler 4: Vermischen von LocalDate und LocalTime Operationen
        LocalDate dateOnly = LocalDate.of(2023, 6, 15);
        try {
            // LocalDate hat keine Methoden für die Zeitarbeit
            // dateOnly.plusHours(2); // Das kompiliert nicht
            System.out.println("LocalDate kann nicht direkt mit Stunden arbeiten");
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Richtig - in LocalDateTime konvertieren
        LocalDateTime dateTimeForHours = dateOnly.atStartOfDay().plusHours(2);
        System.out.println("Richtiges Hinzufügen von Stunden: " + dateTimeForHours);
    }

    /**
     * Demonstration von Datum- und Zeitvergleichen
     */
    public void demonstrateComparisons() {
        System.out.println("\n=== Vergleich von Daten und Zeiten ===");

        LocalDate date1 = LocalDate.of(2023, 6, 15);
        LocalDate date2 = LocalDate.of(2023, 6, 20);
        LocalDate date3 = LocalDate.of(2023, 6, 15);

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("date3: " + date3);

        // Vergleichsmethoden
        System.out.println("\nVergleich:");
        System.out.println("date1.isBefore(date2): " + date1.isBefore(date2));
        System.out.println("date1.isAfter(date2): " + date1.isAfter(date2));
        System.out.println("date1.isEqual(date3): " + date1.isEqual(date3));
        System.out.println("date1.equals(date3): " + date1.equals(date3));

        // compareTo
        System.out.println("\ncompareTo:");
        System.out.println("date1.compareTo(date2): " + date1.compareTo(date2)); // negativ
        System.out.println("date2.compareTo(date1): " + date2.compareTo(date1)); // positiv
        System.out.println("date1.compareTo(date3): " + date1.compareTo(date3)); // 0

        // Zeitvergleich
        LocalTime time1 = LocalTime.of(14, 30);
        LocalTime time2 = LocalTime.of(16, 45);
        System.out.println("\nZeitvergleich:");
        System.out.println(time1 + " vor " + time2 + ": " + time1.isBefore(time2));
        System.out.println(time1 + " nach " + time2 + ": " + time1.isAfter(time2));
    }

    /**
     * Hauptmethode zum Starten aller Demonstrationen
     */
    public static void main(String[] args) {
        BasicTimeDemo demo = new BasicTimeDemo();

        demo.demonstrateLocalDate();
        demo.demonstrateLocalTime();
        demo.demonstrateLocalDateTime();
        demo.demonstrateDateTimeManipulation();
        demo.demonstrateWithMethods();
        demo.demonstrateFormattingAndParsing();
        demo.demonstratePeriod();
        demo.demonstrateCommonMistakes();
        demo.demonstrateComparisons();
    }
}
