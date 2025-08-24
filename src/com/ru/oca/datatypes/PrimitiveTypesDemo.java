package com.ru.oca.datatypes;

/**
 * Демонстрация работы с примитивными типами данных в Java.
 * Показывает все восемь примитивных типов, их диапазоны, особенности и переполнение.
 */
public class PrimitiveTypesDemo {

    /**
     * Демонстрация целочисленных типов и их диапазонов
     */
    public void demonstrateIntegerTypes() {
        System.out.println("=== Целочисленные типы ===");

        // byte - самый маленький целочисленный тип
        byte byteMin = Byte.MIN_VALUE;    // -128
        byte byteMax = Byte.MAX_VALUE;    // 127
        byte byteValue = 100;

        System.out.println("byte диапазон: " + byteMin + " до " + byteMax);
        System.out.println("byte значение: " + byteValue);
        System.out.println("byte размер: " + Byte.SIZE + " бит");

        // short - 16-битный целочисленный тип
        short shortMin = Short.MIN_VALUE;  // -32768
        short shortMax = Short.MAX_VALUE;  // 32767
        short shortValue = 25000;

        System.out.println("\nshort диапазон: " + shortMin + " до " + shortMax);
        System.out.println("short значение: " + shortValue);
        System.out.println("short размер: " + Short.SIZE + " бит");

        // int - стандартный целочисленный тип
        int intMin = Integer.MIN_VALUE;    // -2,147,483,648
        int intMax = Integer.MAX_VALUE;    // 2,147,483,647
        int intValue = 1_000_000;         // Подчеркивания для читаемости

        System.out.println("\nint диапазон: " + intMin + " до " + intMax);
        System.out.println("int значение: " + intValue);
        System.out.println("int размер: " + Integer.SIZE + " бит");

        // long - самый большой целочисленный тип
        long longMin = Long.MIN_VALUE;     // -9,223,372,036,854,775,808
        long longMax = Long.MAX_VALUE;     // 9,223,372,036,854,775,807
        long longValue = 5_000_000_000L;   // Суффикс L для long литералов

        System.out.println("\nlong диапазон: " + longMin + " до " + longMax);
        System.out.println("long значение: " + longValue);
        System.out.println("long размер: " + Long.SIZE + " бит");
    }

    /**
     * Демонстрация типов с плавающей точкой
     */
    public void demonstrateFloatingPointTypes() {
        System.out.println("\n=== Типы с плавающей точкой ===");

        // float - 32-битный тип с плавающей точкой
        float floatMin = Float.MIN_VALUE;      // Наименьшее положительное значение
        float floatMax = Float.MAX_VALUE;      // Наибольшее значение
        float floatValue = 3.14159f;           // Суффикс f для float литералов

        System.out.println("float мин. положительное: " + floatMin);
        System.out.println("float максимальное: " + floatMax);
        System.out.println("float значение: " + floatValue);
        System.out.println("float размер: " + Float.SIZE + " бит");

        // double - 64-битный тип с плавающей точкой (по умолчанию)
        double doubleMin = Double.MIN_VALUE;    // Наименьшее положительное значение
        double doubleMax = Double.MAX_VALUE;    // Наибольшее значение
        double doubleValue = 2.718281828;       // Не требует суффикса

        System.out.println("\ndouble мин. положительное: " + doubleMin);
        System.out.println("double максимальное: " + doubleMax);
        System.out.println("double значение: " + doubleValue);
        System.out.println("double размер: " + Double.SIZE + " бит");

        // Специальные значения для типов с плавающей точкой
        System.out.println("\n=== Специальные значения ===");
        System.out.println("Положительная бесконечность: " + Float.POSITIVE_INFINITY);
        System.out.println("Отрицательная бесконечность: " + Float.NEGATIVE_INFINITY);
        System.out.println("NaN (Not a Number): " + Float.NaN);

        // Демонстрация получения специальных значений
        double divisionByZero = 1.0 / 0.0;     // Положительная бесконечность
        double negDivisionByZero = -1.0 / 0.0; // Отрицательная бесконечность
        double nanValue = 0.0 / 0.0;           // NaN

        System.out.println("1.0 / 0.0 = " + divisionByZero);
        System.out.println("-1.0 / 0.0 = " + negDivisionByZero);
        System.out.println("0.0 / 0.0 = " + nanValue);
    }

    /**
     * Демонстрация типа char
     */
    public void demonstrateCharType() {
        System.out.println("\n=== Тип char ===");

        char charMin = Character.MIN_VALUE;    // '\u0000' (0)
        char charMax = Character.MAX_VALUE;    // '\uffff' (65535)

        System.out.println("char диапазон: " + (int)charMin + " до " + (int)charMax);
        System.out.println("char размер: " + Character.SIZE + " бит");

        // Различные способы создания char значений
        char letter = 'A';                     // Символьный литерал
        char unicode1 = '\u0041';              // Unicode код для 'A'
        char unicode2 = '\u03B1';              // Греческая буква альфа α
        char number = '5';                     // Символ цифры
        char digit = 53;                       // Числовое значение (ASCII код для '5')

        System.out.println("Символьный литерал 'A': " + letter);
        System.out.println("Unicode \\u0041: " + unicode1);
        System.out.println("Unicode \\u03B1: " + unicode2);
        System.out.println("Символ цифры '5': " + number);
        System.out.println("ASCII код 53: " + digit);

        // Арифметические операции с char
        char a = 'A';
        char b = (char)(a + 1);  // Требуется приведение типа
        System.out.println("'A' + 1 = '" + b + "'");

        // char может использоваться как число
        System.out.println("Числовое значение 'A': " + (int)a);
        System.out.println("Числовое значение 'Z': " + (int)'Z');
    }

    /**
     * Демонстрация типа boolean
     */
    public void demonstrateBooleanType() {
        System.out.println("\n=== Тип boolean ===");

        // boolean может принимать только два значения
        boolean trueValue = true;
        boolean falseValue = false;

        System.out.println("true значение: " + trueValue);
        System.out.println("false значение: " + falseValue);

        // boolean часто используется с условными операторами
        int age = 18;
        boolean isAdult = age >= 18;
        System.out.println("Возраст " + age + ", взрослый: " + isAdult);

        // Логические операции
        boolean a = true;
        boolean b = false;

        System.out.println("a && b (И): " + (a && b));      // false
        System.out.println("a || b (ИЛИ): " + (a || b));    // true
        System.out.println("!a (НЕ): " + (!a));             // false
        System.out.println("a ^ b (XOR): " + (a ^ b));      // true
    }

    /**
     * Демонстрация переполнения для целочисленных типов
     */
    public void demonstrateOverflow() {
        System.out.println("\n=== Переполнение типов ===");

        // Переполнение byte
        byte maxByte = Byte.MAX_VALUE;         // 127
        byte overflowByte = (byte)(maxByte + 1); // -128 (переполнение)

        System.out.println("byte MAX_VALUE: " + maxByte);
        System.out.println("MAX_VALUE + 1: " + overflowByte);

        // Переполнение int
        int maxInt = Integer.MAX_VALUE;        // 2,147,483,647
        int overflowInt = maxInt + 1;          // -2,147,483,648 (переполнение)

        System.out.println("\nint MAX_VALUE: " + maxInt);
        System.out.println("MAX_VALUE + 1: " + overflowInt);

        // Переполнение при умножении
        int big1 = 2_000_000_000;
        int big2 = 2;
        int result = big1 * big2;              // Переполнение!
        long correctResult = (long)big1 * big2; // Правильный результат

        System.out.println("\n2,000,000,000 * 2 (int): " + result);
        System.out.println("2,000,000,000 * 2 (long): " + correctResult);
    }

    /**
     * Демонстрация особенностей точности для типов с плавающей точкой
     */
    public void demonstrateFloatingPointPrecision() {
        System.out.println("\n=== Точность чисел с плавающей точкой ===");

        // Проблемы точности с float и double
        float f1 = 0.1f;
        float f2 = 0.2f;
        float f3 = f1 + f2;
        System.out.println("float: 0.1 + 0.2 = " + f3);
        System.out.println("Равно ли 0.3? " + (f3 == 0.3f));

        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 + d2;
        System.out.println("double: 0.1 + 0.2 = " + d3);
        System.out.println("Равно ли 0.3? " + (d3 == 0.3));

        // Правильное сравнение чисел с плавающей точкой
        double epsilon = 1e-10;
        boolean isEqual = Math.abs(d3 - 0.3) < epsilon;
        System.out.println("Правильное сравнение с epsilon: " + isEqual);

        // Различия между float и double в точности
        float floatPi = 3.14159265358979323846f;
        double doublePi = 3.14159265358979323846;

        System.out.println("\nПи как float:  " + floatPi);
        System.out.println("Пи как double: " + doublePi);
    }

    /**
     * Демонстрация значений по умолчанию для примитивных типов
     */
    public void demonstrateDefaultValues() {
        System.out.println("\n=== Значения по умолчанию ===");
        System.out.println("Примечание: Значения по умолчанию применяются только к полям класса,");
        System.out.println("локальные переменные должны быть инициализированы явно.");

        System.out.println("byte по умолчанию: " + (byte)0);
        System.out.println("short по умолчанию: " + (short)0);
        System.out.println("int по умолчанию: " + 0);
        System.out.println("long по умолчанию: " + 0L);
        System.out.println("float по умолчанию: " + 0.0f);
        System.out.println("double по умолчанию: " + 0.0);
        System.out.println("char по умолчанию: '" + '\u0000' + "' (null character)");
        System.out.println("boolean по умолчанию: " + false);
    }

    /**
     * Главный метод для демонстрации всех примитивных типов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация примитивных типов данных Java ===");

        PrimitiveTypesDemo demo = new PrimitiveTypesDemo();

        demo.demonstrateIntegerTypes();
        demo.demonstrateFloatingPointTypes();
        demo.demonstrateCharType();
        demo.demonstrateBooleanType();
        demo.demonstrateOverflow();
        demo.demonstrateFloatingPointPrecision();
        demo.demonstrateDefaultValues();

        System.out.println("\n=== Заключение ===");
        System.out.println("Понимание примитивных типов критически важно для:");
        System.out.println("1. Выбора подходящего типа для задачи");
        System.out.println("2. Избежания переполнения и потери точности");
        System.out.println("3. Эффективного использования памяти");
        System.out.println("4. Правильной работы с литералами и приведением типов");
    }
}
