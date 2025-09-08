package homework._2025_09_04__datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {


    public static void main(String[] args) {
        task2();
    }

    void m(Integer i) {}

    static void task2() {
        int hour = 8;
        int minute = 0;
        int seconds = 0;
        ZoneId zoneId = ZoneId.of("UTC+1");

        ZonedDateTime zoneDateTime = ZonedDateTime.now()
                .withHour(hour)
                .withMinute(minute)
                .withSecond(seconds)
                .withZoneSameInstant(zoneId);

        System.out.printf("Time 1: %02d:%02d%n", zoneDateTime.getHour(), zoneDateTime.getMinute());

        ZonedDateTime zoneDateTime2 = ZonedDateTime.now()
                .withZoneSameInstant(zoneId)
                .withHour(hour)
                .withMinute(minute)
                .withSecond(seconds);

        System.out.printf("Time 2: %02d:%02d%n", zoneDateTime2.getHour(), zoneDateTime2.getMinute());
    }
}
