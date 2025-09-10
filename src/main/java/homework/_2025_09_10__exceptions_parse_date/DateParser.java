package homework._2025_09_10__exceptions_parse_date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class DateParser {
    public static void main(String[] args) {

        while (true) {
            System.out.print("Enter date in format YYYY-MM-DD: ");
            String string = getUserInput();

            try {
                LocalDate localDate = parseString(string);
                LocalDate today = LocalDate.now();

                System.out.println("Entered date (ISO): " + localDateToISOString(localDate));
                System.out.println("Entered date (German): " + localDateToFullGermanString(localDate));
                System.out.println("Entered date (US): " + localDateToFullUSString(localDate));

                System.out.println("Today (ISO): " + localDateToISOString(today));
                System.out.println("Today (German): " + localDateToFullGermanString(today));
                System.out.println("Today (US): " + localDateToFullUSString(today));

                System.out.println("Count of days between today and entered date: " + diffBetweenDates(localDate, today));

                break;
            } catch (DateTimeParseException e) {
                System.out.println("Entered value can not be parsed: " + e.getMessage());
                System.out.println("You have an extra chance to enter the correct date.");
            }
        }
    }

    public static String getUserInput() {
        try (Scanner scanner = new Scanner(System.console().reader())) {
            return scanner.nextLine().trim();
        }
    }

    public static LocalDate parseString(String string) {
        return LocalDate.parse(string, DateTimeFormatter.ISO_DATE);
    }

    public static String localDateToISOString(LocalDate localDate) {
        return localDate.toString();
    }

    private static String localDateToLocalizedString(LocalDate localDate, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(locale);

        return localDate.format(formatter);
    }

    public static String localDateToFullGermanString(LocalDate localDate) {
        return localDateToLocalizedString(localDate, Locale.GERMAN);
    }

    public static String localDateToFullUSString(LocalDate localDate) {
        return localDateToLocalizedString(localDate, Locale.US);
    }

    public static long diffBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return Math.abs(ChronoUnit.DAYS.between(fromDate, toDate));
    }
}
