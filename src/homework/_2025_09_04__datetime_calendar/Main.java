package homework._2025_09_04__datetime_calendar;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;
import java.util.function.Function;


public class Main {

    static Function<String, String> firstCapitalize = s -> s.substring(0, 1) + s.substring(1).toLowerCase();

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Main printer = new Main();

        printer.printCalendar(4, 2010);
        printer.printCalendar(date.getMonth(), date.getYear());

        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter year: ");     
            int year = sc.nextInt(10);    
            System.out.println("Enter month (1..12): ");
            int month = sc.nextInt(10);
            printer.printCalendar(month, year);
        } catch (Exception e) { 
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
        
        
    }

    void printCalendar(Month month, int year) {
        LocalDate date = LocalDate.of(year, month.getValue(), 1);

        System.out.println("|--------------------|");
        System.out.printf("| %-18s |%n", month.toString().transform(firstCapitalize) + ", " +  year);
        System.out.println("|--------------------|");        
       
        while (date.getMonth().equals(month)) { 
            System.out.printf("| %02d | %-13s |%n", date.getDayOfMonth(), date.getDayOfWeek().toString().transform(firstCapitalize));
            date = date.plus(Period.ofDays(1));
        }
    }
    
    void printCalendar(int month, int year) {
        if (month > 12 || month < 1) {
            throw new IllegalArgumentException("\"month\" argument should be 1..12");
        }

        this.printCalendar(Month.of(month), year);        
    }
}
