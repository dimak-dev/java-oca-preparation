package homework._2025_09_10__exceptions_parse_date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class DateParserTest {

    @Test
    void testLocalDateToISOString() {
        assertEquals("2025-12-31", DateParser.localDateToISOString(LocalDate.of(2025, 12, 31)));
    }

    @Test
    void testLocalDateToFullGermanString() {
        assertEquals("Dienstag, 22. Januar 2019", DateParser.localDateToFullGermanString(LocalDate.of(2019, 1, 22)));
    }

    @Test
    void testLocalDateToFullUSString() {
        assertEquals("Wednesday, January 5, 2022", DateParser.localDateToFullUSString(LocalDate.of(2022, 1, 5)));
    }

    @Test
    void testDiffBetweenDates() {
        LocalDate dateFrom = LocalDate.of(2020, 1, 1);
        LocalDate dateTo = LocalDate.of(2022, 1, 1);

        assertEquals(0, DateParser.diffBetweenDates(dateFrom, dateFrom));
        assertEquals(2, DateParser.diffBetweenDates(dateFrom, dateFrom.withDayOfMonth(3)));
        assertEquals(731, DateParser.diffBetweenDates(dateTo, dateFrom));
        assertEquals(731, DateParser.diffBetweenDates(dateFrom, dateTo));
    }
}
