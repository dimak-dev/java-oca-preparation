package com.ru.oca.timedate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Демонстрация работы с датой и временем в Java 8 Time API.
 * Показывает основные классы LocalDate, LocalTime, LocalDateTime и их методы.
 */
public class BasicTimeDemo {

    /**
     * Демонстрация работы с LocalDate
     */
    public void demonstrateLocalDate() {
        System.out.println("=== LocalDate - Работа с датами ===");

        // Создание LocalDate
        LocalDate today = LocalDate.now();
        LocalDate specificDate = LocalDate.of(2023, 12, 25);
        LocalDate fromString = LocalDate.parse("2023-06-15");

        System.out.println("Сегодня: " + today);
        System.out.println("Конкретная дата: " + specificDate);
        System.out.println("Из строки: " + fromString);

        // Получение компонентов даты
        System.out.println("\nКомпоненты даты " + today + ":");
        System.out.println("Год: " + today.getYear());
        System.out.println("Месяц (число): " + today.getMonthValue());
        System.out.println("Месяц (enum): " + today.getMonth());
        System.out.println("День месяца: " + today.getDayOfMonth());
        System.out.println("День недели: " + today.getDayOfWeek());
        System.out.println("День года: " + today.getDayOfYear());

        // Создание с использованием Month enum
        LocalDate withMonthEnum = LocalDate.of(2023, Month.DECEMBER, 31);
        System.out.println("С Month enum: " + withMonthEnum);

        // Проверки
        System.out.println("\nПроверки:");
        System.out.println("Високосный год: " + today.isLeapYear());
        System.out.println("До Нового года: " + today.isBefore(LocalDate.of(2024, 1, 1)));
        System.out.println("После 2020: " + today.isAfter(LocalDate.of(2020, 12, 31)));
    }

    /**
     * Демонстрация работы с LocalTime
     */
    public void demonstrateLocalTime() {
        System.out.println("\n=== LocalTime - Работа со временем ===");

        // Создание LocalTime
        LocalTime now = LocalTime.now();
        LocalTime specificTime = LocalTime.of(14, 30, 45);
        LocalTime fromString = LocalTime.parse("09:15:30");
        LocalTime withNanos = LocalTime.of(12, 0, 0, 123456789);

        System.out.println("Сейчас: " + now);
        System.out.println("Конкретное время: " + specificTime);
        System.out.println("Из строки: " + fromString);
        System.out.println("С наносекундами: " + withNanos);

        // Получение компонентов времени
        System.out.println("\nКомпоненты времени " + specificTime + ":");
        System.out.println("Час: " + specificTime.getHour());
        System.out.println("Минута: " + specificTime.getMinute());
        System.out.println("Секунда: " + specificTime.getSecond());
        System.out.println("Наносекунда: " + specificTime.getNano());

        // Сокращенные формы создания
        LocalTime hourAndMinute = LocalTime.of(15, 45); // секунды = 0
        LocalTime onlyHour = LocalTime.of(12, 0); // минуты и секунды = 0
        System.out.println("Только час и минута: " + hourAndMinute);
        System.out.println("Только час: " + onlyHour);

        // Специальные константы
        System.out.println("\nКонстанты:");
        System.out.println("Полночь: " + LocalTime.MIDNIGHT);
        System.out.println("Полдень: " + LocalTime.NOON);
        System.out.println("Минимальное время: " + LocalTime.MIN);
        System.out.println("Максимальное время: " + LocalTime.MAX);
    }

    /**
     * Демонстрация работы с LocalDateTime
     */
    public void demonstrateLocalDateTime() {
        System.out.println("\n=== LocalDateTime - Дата и время вместе ===");

        // Создание LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime specific = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        LocalDateTime fromString = LocalDateTime.parse("2023-06-15T14:30:45");

        System.out.println("Сейчас: " + now);
        System.out.println("Конкретный момент: " + specific);
        System.out.println("Из строки: " + fromString);

        // Создание из отдельных LocalDate и LocalTime
        LocalDate date = LocalDate.of(2023, 7, 4);
        LocalTime time = LocalTime.of(18, 30);
        LocalDateTime combined = LocalDateTime.of(date, time);
        LocalDateTime combined2 = date.atTime(time);
        LocalDateTime combined3 = time.atDate(date);

        System.out.println("Объединение date + time: " + combined);
        System.out.println("date.atTime(time): " + combined2);
        System.out.println("time.atDate(date): " + combined3);

        // Извлечение компонентов
        System.out.println("\nИзвлечение компонентов из " + specific + ":");
        System.out.println("Дата: " + specific.toLocalDate());
        System.out.println("Время: " + specific.toLocalTime());
        System.out.println("Год: " + specific.getYear());
        System.out.println("Час: " + specific.getHour());
    }

    /**
     * Демонстрация операций изменения дат и времени
     */
    public void demonstrateDateTimeManipulation() {
        System.out.println("\n=== Изменение дат и времени ===");

        LocalDate baseDate = LocalDate.of(2023, 6, 15);
        System.out.println("Базовая дата: " + baseDate);

        // Методы plus (добавление)
        System.out.println("Плюс 1 день: " + baseDate.plusDays(1));
        System.out.println("Плюс 2 недели: " + baseDate.plusWeeks(2));
        System.out.println("Плюс 3 месяца: " + baseDate.plusMonths(3));
        System.out.println("Плюс 1 год: " + baseDate.plusYears(1));

        // Методы minus (вычитание)
        System.out.println("Минус 5 дней: " + baseDate.minusDays(5));
        System.out.println("Минус 1 месяц: " + baseDate.minusMonths(1));

        // Операции со временем
        LocalTime baseTime = LocalTime.of(14, 30, 45);
        System.out.println("\nБазовое время: " + baseTime);
        System.out.println("Плюс 2 часа: " + baseTime.plusHours(2));
        System.out.println("Плюс 30 минут: " + baseTime.plusMinutes(30));
        System.out.println("Минус 15 секунд: " + baseTime.minusSeconds(15));

        // Операции с LocalDateTime
        LocalDateTime baseDateTime = LocalDateTime.of(2023, 6, 15, 14, 30);
        System.out.println("\nБазовая дата-время: " + baseDateTime);
        System.out.println("Плюс 1 день 2 часа: " + baseDateTime.plusDays(1).plusHours(2));
        System.out.println("Минус 1 неделя: " + baseDateTime.minusWeeks(1));

        // Важно: все методы возвращают новый объект!
        LocalDate original = LocalDate.of(2023, 1, 1);
        LocalDate modified = original.plusMonths(6);
        System.out.println("\nИммутабельность:");
        System.out.println("Исходная дата: " + original);
        System.out.println("Измененная дата: " + modified);
        System.out.println("Исходная не изменилась!");
    }

    /**
     * Демонстрация методов with (установка конкретных значений)
     */
    public void demonstrateWithMethods() {
        System.out.println("\n=== Методы with - установка значений ===");

        LocalDate baseDate = LocalDate.of(2023, 6, 15);
        System.out.println("Базовая дата: " + baseDate);

        // Установка конкретных значений
        System.out.println("Установить год 2025: " + baseDate.withYear(2025));
        System.out.println("Установить месяц декабрь: " + baseDate.withMonth(12));
        System.out.println("Установить день 1: " + baseDate.withDayOfMonth(1));
        System.out.println("Установить день года 100: " + baseDate.withDayOfYear(100));

        LocalTime baseTime = LocalTime.of(14, 30, 45);
        System.out.println("\nБазовое время: " + baseTime);
        System.out.println("Установить час 9: " + baseTime.withHour(9));
        System.out.println("Установить минуту 0: " + baseTime.withMinute(0));
        System.out.println("Установить секунду 30: " + baseTime.withSecond(30));

        // Цепочка изменений
        LocalDate chainedChanges = baseDate
                .withYear(2024)
                .withMonth(12)
                .withDayOfMonth(31);
        System.out.println("\nЦепочка изменений: " + chainedChanges);
    }

    /**
     * Демонстрация форматирования и парсинга
     */
    public void demonstrateFormattingAndParsing() {
        System.out.println("\n=== Форматирование и парсинг ===");

        LocalDate date = LocalDate.of(2023, 12, 25);
        LocalTime time = LocalTime.of(14, 30, 45);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Использование предопределенных форматтеров
        System.out.println("Дата ISO: " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("Время ISO: " + time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("Дата-время ISO: " + dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        // Пользовательские форматы
        DateTimeFormatter customDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter customTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        System.out.println("Дата (dd/MM/yyyy): " + date.format(customDateFormatter));
        System.out.println("Время (HH:mm:ss): " + time.format(customTimeFormatter));
        System.out.println("Дата-время (dd.MM.yyyy HH:mm): " + dateTime.format(customDateTimeFormatter));

        // Парсинг строк
        System.out.println("\nПарсинг строк:");
        LocalDate parsedDate = LocalDate.parse("25/12/2023", customDateFormatter);
        LocalTime parsedTime = LocalTime.parse("14:30:45", customTimeFormatter);
        System.out.println("Распарсенная дата: " + parsedDate);
        System.out.println("Распарсенное время: " + parsedTime);

        // Парсинг с использованием стандартного формата
        LocalDate isoDate = LocalDate.parse("2023-12-25");
        LocalDateTime isoDateTime = LocalDateTime.parse("2023-12-25T14:30:45");
        System.out.println("ISO дата: " + isoDate);
        System.out.println("ISO дата-время: " + isoDateTime);
    }

    /**
     * Демонстрация Period для работы с периодами дат
     */
    public void demonstratePeriod() {
        System.out.println("\n=== Period - Периоды между датами ===");

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        Period period = Period.between(startDate, endDate);
        System.out.println("Период между " + startDate + " и " + endDate + ": " + period);
        System.out.println("Лет: " + period.getYears());
        System.out.println("Месяцев: " + period.getMonths());
        System.out.println("Дней: " + period.getDays());

        // Создание периодов
        Period oneYear = Period.ofYears(1);
        Period twoMonths = Period.ofMonths(2);
        Period tenDays = Period.ofDays(10);
        Period combined = Period.of(1, 2, 10); // 1 год, 2 месяца, 10 дней

        System.out.println("\nСозданные периоды:");
        System.out.println("1 год: " + oneYear);
        System.out.println("2 месяца: " + twoMonths);
        System.out.println("10 дней: " + tenDays);
        System.out.println("Комбинированный: " + combined);

        // Использование периодов с датами
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня: " + today);
        System.out.println("Плюс 1 год 2 месяца 10 дней: " + today.plus(combined));
        System.out.println("Минус 6 месяцев: " + today.minus(Period.ofMonths(6)));
    }

    /**
     * Демонстрация типичных ошибок при работе с датой и временем
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки ===");

        // Ошибка 1: Неверные параметры при создании
        try {
            LocalDate invalidDate = LocalDate.of(2023, 2, 30); // 30 февраля не существует!
        } catch (DateTimeException e) {
            System.out.println("Ошибка создания даты: " + e.getMessage());
        }

        try {
            LocalTime invalidTime = LocalTime.of(25, 0); // 25 часов не существует!
        } catch (DateTimeException e) {
            System.out.println("Ошибка создания времени: " + e.getMessage());
        }

        // Ошибка 2: Неверный формат при парсинге
        try {
            LocalDate wrongFormat = LocalDate.parse("25-12-2023"); // неверный формат
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка парсинга даты: " + e.getMessage());
        }

        // Ошибка 3: Забывание о неизменяемости
        LocalDate date = LocalDate.of(2023, 6, 15);
        date.plusDays(5); // результат не сохранен!
        System.out.println("Дата не изменилась: " + date);

        // Правильно:
        LocalDate correctDate = date.plusDays(5);
        System.out.println("Правильное изменение: " + correctDate);

        // Ошибка 4: Смешивание LocalDate и LocalTime операций
        LocalDate dateOnly = LocalDate.of(2023, 6, 15);
        try {
            // LocalDate не имеет методов для работы со временем
            // dateOnly.plusHours(2); // Это не скомпилируется
            System.out.println("LocalDate не может работать с часами напрямую");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Правильно - преобразовать в LocalDateTime
        LocalDateTime dateTimeForHours = dateOnly.atStartOfDay().plusHours(2);
        System.out.println("Правильное добавление часов: " + dateTimeForHours);
    }

    /**
     * Демонстрация сравнения дат и времени
     */
    public void demonstrateComparisons() {
        System.out.println("\n=== Сравнение дат и времени ===");

        LocalDate date1 = LocalDate.of(2023, 6, 15);
        LocalDate date2 = LocalDate.of(2023, 6, 20);
        LocalDate date3 = LocalDate.of(2023, 6, 15);

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("date3: " + date3);

        // Методы сравнения
        System.out.println("\nСравнение:");
        System.out.println("date1.isBefore(date2): " + date1.isBefore(date2));
        System.out.println("date1.isAfter(date2): " + date1.isAfter(date2));
        System.out.println("date1.isEqual(date3): " + date1.isEqual(date3));
        System.out.println("date1.equals(date3): " + date1.equals(date3));

        // compareTo
        System.out.println("\ncompareTo:");
        System.out.println("date1.compareTo(date2): " + date1.compareTo(date2)); // отрицательное
        System.out.println("date2.compareTo(date1): " + date2.compareTo(date1)); // положительное
        System.out.println("date1.compareTo(date3): " + date1.compareTo(date3)); // 0

        // Сравнение времени
        LocalTime time1 = LocalTime.of(14, 30);
        LocalTime time2 = LocalTime.of(16, 45);
        System.out.println("\nСравнение времени:");
        System.out.println(time1 + " до " + time2 + ": " + time1.isBefore(time2));
        System.out.println(time1 + " после " + time2 + ": " + time1.isAfter(time2));
    }

    /**
     * Главный метод для запуска всех демонстраций
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
