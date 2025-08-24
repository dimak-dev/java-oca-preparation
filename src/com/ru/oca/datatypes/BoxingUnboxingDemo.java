package com.ru.oca.datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация автоупаковки (boxing) и распаковки (unboxing) в Java.
 * Показывает преобразования между примитивными типами и их wrapper классами.
 */
public class BoxingUnboxingDemo {

    /**
     * Демонстрация базовых операций автоупаковки и распаковки
     */
    public void demonstrateBasicBoxingUnboxing() {
        System.out.println("=== Базовая автоупаковка и распаковка ===");

        // Автоупаковка (boxing) - примитив -> wrapper объект
        Integer integerObj = 42;              // Автоупаковка int в Integer
        Double doubleObj = 3.14;              // Автоупаковка double в Double
        Boolean booleanObj = true;            // Автоупаковка boolean в Boolean
        Character charObj = 'A';              // Автоупаковка char в Character

        System.out.println("Автоупаковка:");
        System.out.println("int 42 -> Integer: " + integerObj);
        System.out.println("double 3.14 -> Double: " + doubleObj);
        System.out.println("boolean true -> Boolean: " + booleanObj);
        System.out.println("char 'A' -> Character: " + charObj);

        // Распаковка (unboxing) - wrapper объект -> примитив
        int primitiveInt = integerObj;        // Автораспаковка Integer в int
        double primitiveDouble = doubleObj;   // Автораспаковка Double в double
        boolean primitiveBoolean = booleanObj; // Автораспаковка Boolean в boolean
        char primitiveChar = charObj;         // Автораспаковка Character в char

        System.out.println("\nРаспаковка:");
        System.out.println("Integer -> int: " + primitiveInt);
        System.out.println("Double -> double: " + primitiveDouble);
        System.out.println("Boolean -> boolean: " + primitiveBoolean);
        System.out.println("Character -> char: " + primitiveChar);
    }

    /**
     * Демонстрация всех wrapper классов
     */
    public void demonstrateAllWrapperClasses() {
        System.out.println("\n=== Все wrapper классы ===");

        // Создание wrapper объектов разными способами
        Byte byteObj = 127;                   // Автоупаковка
        Short shortObj = Short.valueOf("32000"); // valueOf метод
        Integer intObj = new Integer(100);     // Конструктор (deprecated в Java 9+)
        Long longObj = 5000000000L;           // Автоупаковка с суффиксом L
        Float floatObj = Float.parseFloat("3.14"); // parse метод
        Double doubleObj = Double.valueOf(2.718); // valueOf метод
        Character charObj = Character.valueOf('Z'); // valueOf метод
        Boolean booleanObj = Boolean.parseBoolean("true"); // parse метод

        System.out.println("Byte: " + byteObj);
        System.out.println("Short: " + shortObj);
        System.out.println("Integer: " + intObj);
        System.out.println("Long: " + longObj);
        System.out.println("Float: " + floatObj);
        System.out.println("Double: " + doubleObj);
        System.out.println("Character: " + charObj);
        System.out.println("Boolean: " + booleanObj);

        // Получение примитивных значений
        System.out.println("\nПолучение примитивных значений:");
        System.out.println("byteValue(): " + longObj.byteValue());
        System.out.println("intValue(): " + doubleObj.intValue());
        System.out.println("doubleValue(): " + intObj.doubleValue());
        System.out.println("floatValue(): " + longObj.floatValue());
    }

    /**
     * Демонстрация кеширования Integer объектов
     */
    public void demonstrateIntegerCaching() {
        System.out.println("\n=== Кеширование Integer объектов ===");

        // Java кеширует Integer объекты для значений от -128 до 127
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("Integer a = 100, b = 100");
        System.out.println("a == b: " + (a == b));          // true - один объект из кеша
        System.out.println("a.equals(b): " + a.equals(b));  // true - значения равны

        System.out.println("\nInteger c = 200, d = 200");
        System.out.println("c == d: " + (c == d));          // false - разные объекты
        System.out.println("c.equals(d): " + c.equals(d));  // true - значения равны

        // Демонстрация границ кеша
        Integer cached1 = 127;    // В кеше
        Integer cached2 = 127;    // В кеше
        Integer notCached1 = 128; // Не в кеше
        Integer notCached2 = 128; // Не в кеше

        System.out.println("\nГраницы кеша:");
        System.out.println("127 == 127: " + (cached1 == cached2));       // true
        System.out.println("128 == 128: " + (notCached1 == notCached2)); // false

        // Кеширование работает только с автоупаковкой
        Integer explicit1 = new Integer(100); // Явное создание
        Integer explicit2 = new Integer(100); // Явное создание
        Integer auto = 100;                   // Автоупаковка

        System.out.println("\nЯвное создание vs автоупаковка:");
        System.out.println("new Integer(100) == new Integer(100): " + (explicit1 == explicit2)); // false
        System.out.println("new Integer(100) == 100: " + (explicit1 == auto));                  // false
    }

    /**
     * Демонстрация автоупаковки/распаковки в выражениях
     */
    public void demonstrateBoxingInExpressions() {
        System.out.println("\n=== Boxing/Unboxing в выражениях ===");

        Integer a = 10;
        Integer b = 20;

        // Автоматическая распаковка для арифметических операций
        Integer sum = a + b;        // a и b распаковываются, результат упаковывается
        Integer product = a * b;    // Аналогично

        System.out.println("Integer a = 10, b = 20");
        System.out.println("a + b = " + sum);
        System.out.println("a * b = " + product);

        // Смешанные операции
        Integer intObj = 50;
        int primitive = 25;
        int result1 = intObj + primitive;    // intObj распаковывается
        Integer result2 = intObj + primitive; // результат упаковывается

        System.out.println("\nСмешанные операции:");
        System.out.println("Integer(50) + int(25) -> int: " + result1);
        System.out.println("Integer(50) + int(25) -> Integer: " + result2);

        // Сравнения
        Integer x = 100;
        Integer y = 100;
        int z = 100;

        System.out.println("\nСравнения:");
        System.out.println("Integer(100) == Integer(100): " + (x == y)); // true (кеш)
        System.out.println("Integer(100) == int(100): " + (x == z));     // true (распаковка)
        System.out.println("Integer(100).equals(100): " + x.equals(100)); // true
    }

    /**
     * Демонстрация работы с коллекциями (где boxing особенно важен)
     */
    public void demonstrateBoxingWithCollections() {
        System.out.println("\n=== Boxing/Unboxing с коллекциями ===");

        // Коллекции не могут хранить примитивы, только объекты
        List<Integer> numbers = new ArrayList<>();

        // Автоупаковка при добавлении в коллекцию
        numbers.add(10);      // int упаковывается в Integer
        numbers.add(20);      // int упаковывается в Integer
        numbers.add(30);      // int упаковывается в Integer

        System.out.println("Список чисел: " + numbers);

        // Автораспаковка при извлечении из коллекции
        int first = numbers.get(0);    // Integer распаковывается в int
        Integer second = numbers.get(1); // Остается Integer

        System.out.println("Первый элемент (int): " + first);
        System.out.println("Второй элемент (Integer): " + second);

        // Enhanced for loop с распаковкой
        System.out.println("Перебор с автораспаковкой:");
        for (int number : numbers) {   // Каждый Integer распаковывается в int
            System.out.println("Число: " + number);
        }

        // Подсчет с накоплением
        int sum = 0;
        for (Integer num : numbers) {  // num остается Integer
            sum += num;               // num распаковывается для сложения
        }
        System.out.println("Сумма: " + sum);
    }

    /**
     * Демонстрация потенциальных проблем с boxing/unboxing
     */
    public void demonstrateBoxingPitfalls() {
        System.out.println("\n=== Потенциальные проблемы ===");

        // Проблема 1: NullPointerException при автораспаковке null
        System.out.println("1. NullPointerException при распаковке null:");
        Integer nullInteger = null;
        try {
            int value = nullInteger;  // Попытка распаковать null -> NPE
            System.out.println("Значение: " + value);
        } catch (NullPointerException e) {
            System.out.println("   Исключение: " + e.getClass().getSimpleName());
        }

        // Проблема 2: Производительность при частых операциях
        System.out.println("\n2. Влияние на производительность:");
        long startTime = System.nanoTime();
        Integer sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;  // Многократная упаковка/распаковка
        }
        long endTime = System.nanoTime();
        System.out.println("   Время с Boxing: " + (endTime - startTime) + " наносекунд");

        startTime = System.nanoTime();
        int primitiveSum = 0;
        for (int i = 0; i < 100000; i++) {
            primitiveSum += i;  // Только примитивы
        }
        endTime = System.nanoTime();
        System.out.println("   Время с примитивами: " + (endTime - startTime) + " наносекунд");

        // Проблема 3: Неожиданное поведение при сравнении
        System.out.println("\n3. Проблемы сравнения больших чисел:");
        Integer big1 = 1000;
        Integer big2 = 1000;
        System.out.println("   Integer(1000) == Integer(1000): " + (big1 == big2)); // false
        System.out.println("   Правильное сравнение: " + big1.equals(big2));      // true
    }

    /**
     * Демонстрация полезных методов wrapper классов
     */
    public void demonstrateWrapperMethods() {
        System.out.println("\n=== Полезные методы wrapper классов ===");

        // Parsing методы
        int intFromString = Integer.parseInt("123");
        double doubleFromString = Double.parseDouble("45.67");
        boolean boolFromString = Boolean.parseBoolean("true");

        System.out.println("Парсинг строк:");
        System.out.println("\"123\" -> int: " + intFromString);
        System.out.println("\"45.67\" -> double: " + doubleFromString);
        System.out.println("\"true\" -> boolean: " + boolFromString);

        // valueOf методы (предпочтительнее конструкторов)
        Integer intObj = Integer.valueOf(456);
        Double doubleObj = Double.valueOf("78.9");

        System.out.println("\nvalueOf методы:");
        System.out.println("Integer.valueOf(456): " + intObj);
        System.out.println("Double.valueOf(\"78.9\"): " + doubleObj);

        // Константы и утилитарные методы
        System.out.println("\nКонстанты и утилиты:");
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Double.POSITIVE_INFINITY: " + Double.POSITIVE_INFINITY);
        System.out.println("Character.isDigit('5'): " + Character.isDigit('5'));
        System.out.println("Character.isLetter('A'): " + Character.isLetter('A'));
        System.out.println("Character.toUpperCase('a'): " + Character.toUpperCase('a'));

        // Преобразование между типами
        Long longValue = 12345L;
        System.out.println("\nПреобразования:");
        System.out.println("Long.intValue(): " + longValue.intValue());
        System.out.println("Long.doubleValue(): " + longValue.doubleValue());
        System.out.println("Long.toString(): " + longValue.toString());
    }

    /**
     * Главный метод для демонстрации всех аспектов boxing/unboxing
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация автоупаковки и распаковки ===");

        BoxingUnboxingDemo demo = new BoxingUnboxingDemo();

        demo.demonstrateBasicBoxingUnboxing();
        demo.demonstrateAllWrapperClasses();
        demo.demonstrateIntegerCaching();
        demo.demonstrateBoxingInExpressions();
        demo.demonstrateBoxingWithCollections();
        demo.demonstrateBoxingPitfalls();
        demo.demonstrateWrapperMethods();

        System.out.println("\n=== Рекомендации ===");
        System.out.println("1. Используйте примитивы для производительности");
        System.out.println("2. Используйте wrapper классы для коллекций и когда нужны null значения");
        System.out.println("3. Будьте осторожны с NullPointerException при автораспаковке");
        System.out.println("4. Используйте .equals() для сравнения wrapper объектов");
        System.out.println("5. Помните о кешировании Integer значений [-128, 127]");
    }
}
