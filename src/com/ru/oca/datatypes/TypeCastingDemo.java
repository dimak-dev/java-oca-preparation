package com.ru.oca.datatypes;

/**
 * Демонстрация приведения типов (type casting) в Java.
 * Показывает неявные и явные преобразования, потерю точности и переполнение.
 */
public class TypeCastingDemo {

    /**
     * Демонстрация неявного приведения типов (widening)
     */
    public void demonstrateImplicitCasting() {
        System.out.println("=== Неявное приведение типов (Widening) ===");

        // Последовательность расширяющих преобразований:
        // byte -> short -> int -> long -> float -> double
        // char -> int

        byte byteValue = 100;
        short shortValue = byteValue;    // byte -> short
        int intValue = shortValue;       // short -> int
        long longValue = intValue;       // int -> long
        float floatValue = longValue;    // long -> float
        double doubleValue = floatValue; // float -> double

        System.out.println("byte -> short: " + byteValue + " -> " + shortValue);
        System.out.println("short -> int: " + shortValue + " -> " + intValue);
        System.out.println("int -> long: " + intValue + " -> " + longValue);
        System.out.println("long -> float: " + longValue + " -> " + floatValue);
        System.out.println("float -> double: " + floatValue + " -> " + doubleValue);

        // char имеет особое поведение
        char charValue = 'A';
        int charToInt = charValue;       // char -> int

        System.out.println("\nchar -> int: '" + charValue + "' -> " + charToInt);

        // Неявное приведение в выражениях
        byte b1 = 10;
        byte b2 = 20;
        int result = b1 + b2;           // byte + byte -> int (результат всегда int или больше)

        System.out.println("byte + byte -> int: " + b1 + " + " + b2 + " = " + result);

        // Литералы и неявное приведение
        byte literalByte = 127;         // int литерал помещается в byte
        short literalShort = 32000;     // int литерал помещается в short
        // byte tooBig = 128;           // ОШИБКА! 128 не помещается в byte

        System.out.println("int литерал -> byte: " + literalByte);
        System.out.println("int литерал -> short: " + literalShort);
    }

    /**
     * Демонстрация явного приведения типов (narrowing)
     */
    public void demonstrateExplicitCasting() {
        System.out.println("\n=== Явное приведение типов (Narrowing) ===");

        // Сужающие преобразования требуют явного приведения:
        // double -> float -> long -> int -> short -> byte
        // int -> char

        double doubleValue = 123.456789;
        float floatValue = (float) doubleValue;  // Потеря точности
        long longValue = (long) floatValue;      // Потеря дробной части
        int intValue = (int) longValue;          // Потенциальная потеря данных
        short shortValue = (short) intValue;     // Потенциальное переполнение
        byte byteValue = (byte) shortValue;      // Потенциальное переполнение

        System.out.println("double -> float: " + doubleValue + " -> " + floatValue);
        System.out.println("float -> long: " + floatValue + " -> " + longValue);
        System.out.println("long -> int: " + longValue + " -> " + intValue);
        System.out.println("int -> short: " + intValue + " -> " + shortValue);
        System.out.println("short -> byte: " + shortValue + " -> " + byteValue);

        // Приведение int к char
        int asciiCode = 65;
        char character = (char) asciiCode;       // int -> char

        System.out.println("int -> char: " + asciiCode + " -> '" + character + "'");

        // Обратное приведение char к int не требует явного приведения
        int backToInt = character;               // char -> int (неявное)

        System.out.println("char -> int: '" + character + "' -> " + backToInt);
    }

    /**
     * Демонстрация потери точности при приведении типов
     */
    public void demonstratePrecisionLoss() {
        System.out.println("\n=== Потеря точности при приведении ===");

        // Потеря точности при double -> float
        double preciseDouble = 3.141592653589793238;
        float lessPreseFloat = (float) preciseDouble;

        System.out.println("double: " + preciseDouble);
        System.out.println("float:  " + lessPreseFloat);
        System.out.println("Потеря точности: " + (preciseDouble - lessPreseFloat));

        // Потеря дробной части при приведении к целому
        double doubleWithFraction = 123.789;
        int integerPart = (int) doubleWithFraction;

        System.out.println("\ndouble с дробной частью: " + doubleWithFraction);
        System.out.println("int (дробная часть отбрасывается): " + integerPart);

        // Большое число long не помещается в float без потери точности
        long bigLong = 9223372036854775807L;  // Long.MAX_VALUE
        float floatFromLong = (float) bigLong;
        long backToLong = (long) floatFromLong;

        System.out.println("\nОригинальный long: " + bigLong);
        System.out.println("Преобразованный в float: " + floatFromLong);
        System.out.println("Обратно в long: " + backToLong);
        System.out.println("Потеря данных: " + (bigLong != backToLong));
    }

    /**
     * Демонстрация переполнения при приведении типов
     */
    public void demonstrateOverflow() {
        System.out.println("\n=== Переполнение при приведении типов ===");

        // Переполнение при приведении int к byte
        int[] testValues = {127, 128, 129, 255, 256, -129};

        System.out.println("int -> byte приведения:");
        for (int value : testValues) {
            byte result = (byte) value;
            System.out.println("(byte)" + value + " = " + result);
        }

        // Объяснение переполнения byte
        System.out.println("\nОбъяснение переполнения byte:");
        System.out.println("byte диапазон: " + Byte.MIN_VALUE + " до " + Byte.MAX_VALUE);
        System.out.println("При переполнении используется модульная арифметика:");

        int overflow = 128;
        byte overflowResult = (byte) overflow;
        System.out.println("128 как byte: " + overflowResult + " (128 - 256 = -128)");

        overflow = 300;
        overflowResult = (byte) overflow;
        System.out.println("300 как byte: " + overflowResult + " (300 % 256 - 128 = 44 - 128 = -84)");

        // Переполнение при приведении int к short
        int bigInt = 100000;
        short shortResult = (short) bigInt;
        System.out.println("\nint " + bigInt + " -> short: " + shortResult);

        // Переполнение при приведении long к int
        long bigLong = 3000000000L;  // Больше Integer.MAX_VALUE
        int intResult = (int) bigLong;
        System.out.println("long " + bigLong + " -> int: " + intResult);
    }

    /**
     * Демонстрация особенностей приведения char
     */
    public void demonstrateCharCasting() {
        System.out.println("\n=== Особенности приведения char ===");

        // char - беззнаковый 16-битный тип (0 до 65535)
        System.out.println("char диапазон: 0 до " + (int)Character.MAX_VALUE);

        // Различные способы создания char
        char fromLiteral = 'A';
        char fromInt = (char) 65;
        char fromUnicode = '\u0041';

        System.out.println("Различные способы создания char 'A':");
        System.out.println("Литерал 'A': " + fromLiteral);
        System.out.println("(char)65: " + fromInt);
        System.out.println("\\u0041: " + fromUnicode);

        // Арифметические операции с char
        char a = 'A';
        char z = 'Z';

        System.out.println("\nАрифметические операции с char:");
        System.out.println("'A' как int: " + (int)a);
        System.out.println("'Z' как int: " + (int)z);
        System.out.println("'Z' - 'A': " + (z - a));  // Результат int

        // char может принимать значения больше максимального byte/short
        char bigChar = (char) 50000;  // Больше Short.MAX_VALUE
        System.out.println("char со значением 50000: '" + bigChar + "' (код: " + (int)bigChar + ")");

        // Приведение отрицательных чисел к char
        int negative = -1;
        char charFromNegative = (char) negative;
        System.out.println("(char)(-1): '" + charFromNegative + "' (код: " + (int)charFromNegative + ")");

        // char в выражениях автоматически расширяется до int
        char c1 = 'A';
        char c2 = 'B';
        // char result = c1 + c2;  // ОШИБКА! c1 + c2 возвращает int
        char result = (char)(c1 + c2);  // Требуется явное приведение

        System.out.println("'A' + 'B' = '" + result + "' (код: " + (int)result + ")");
    }

    /**
     * Демонстрация приведения с плавающей точкой
     */
    public void demonstrateFloatingPointCasting() {
        System.out.println("\n=== Приведение типов с плавающей точкой ===");

        // Специальные значения float/double
        double positiveInfinity = Double.POSITIVE_INFINITY;
        double negativeInfinity = Double.NEGATIVE_INFINITY;
        double notANumber = Double.NaN;

        System.out.println("Специальные значения:");
        System.out.println("Positive Infinity: " + positiveInfinity);
        System.out.println("Negative Infinity: " + negativeInfinity);
        System.out.println("NaN: " + notANumber);

        // Приведение специальных значений к целым
        int intFromPosInf = (int) positiveInfinity;
        int intFromNegInf = (int) negativeInfinity;
        int intFromNaN = (int) notANumber;

        System.out.println("\nПриведение специальных значений к int:");
        System.out.println("(int)POSITIVE_INFINITY: " + intFromPosInf);
        System.out.println("(int)NEGATIVE_INFINITY: " + intFromNegInf);
        System.out.println("(int)NaN: " + intFromNaN);

        // Большие числа с плавающей точкой
        double veryLarge = 1e20;  // 100,000,000,000,000,000,000
        long longFromDouble = (long) veryLarge;

        System.out.println("\nБольшие числа:");
        System.out.println("double: " + veryLarge);
        System.out.println("(long): " + longFromDouble);

        // Приведение float литералов
        float f1 = 3.14f;           // Суффикс f
        float f2 = (float) 3.14;    // Явное приведение double к float
        // float f3 = 3.14;         // ОШИБКА! double не может быть неявно приведен к float

        System.out.println("\nfloat литералы:");
        System.out.println("3.14f: " + f1);
        System.out.println("(float)3.14: " + f2);
    }

    /**
     * Демонстрация безопасных методов приведения
     */
    public void demonstrateSafeCasting() {
        System.out.println("\n=== Безопасное приведение типов ===");

        // Проверка диапазона перед приведением
        long longValue = 2000000000L;

        if (longValue <= Integer.MAX_VALUE && longValue >= Integer.MIN_VALUE) {
            int safeInt = (int) longValue;
            System.out.println("Безопасное приведение long -> int: " + safeInt);
        } else {
            System.out.println("Небезопасно приводить " + longValue + " к int");
        }

        // Использование методов wrapper классов для проверки
        String numberString = "12345";
        try {
            int parsed = Integer.parseInt(numberString);
            byte safeByte = (byte) parsed;

            if (parsed <= Byte.MAX_VALUE && parsed >= Byte.MIN_VALUE) {
                System.out.println("Безопасное приведение int -> byte: " + safeByte);
            } else {
                System.out.println("Значение " + parsed + " не помещается в byte");
            }
        } catch (NumberFormatException e) {
            System.out.println("Невозможно преобразовать строку в число: " + e.getMessage());
        }

        // Использование Math.min/max для ограничения диапазона
        double doubleValue = 300.5;
        int clampedInt = (int) Math.min(Math.max(doubleValue, Integer.MIN_VALUE), Integer.MAX_VALUE);
        byte clampedByte = (byte) Math.min(Math.max(doubleValue, Byte.MIN_VALUE), Byte.MAX_VALUE);

        System.out.println("Ограничение диапазона:");
        System.out.println("double " + doubleValue + " -> clamped int: " + clampedInt);
        System.out.println("double " + doubleValue + " -> clamped byte: " + clampedByte);
    }

    /**
     * Демонстрация приведения в сложных выражениях
     */
    public void demonstrateComplexExpressions() {
        System.out.println("\n=== Приведение в сложных выражениях ===");

        // Приоритет операций и автоматическое приведение
        byte b1 = 10;
        byte b2 = 20;
        short s1 = 100;

        // Все операции с byte/short автоматически приводятся к int
        int result1 = b1 + b2;           // byte + byte -> int
        int result2 = b1 * s1;           // byte * short -> int

        System.out.println("byte + byte: " + result1);
        System.out.println("byte * short: " + result2);

        // Для сохранения в меньший тип нужно явное приведение
        byte result3 = (byte)(b1 + b2);  // Требуется приведение!
        short result4 = (short)(b1 * s1); // Требуется приведение!

        System.out.println("(byte)(byte + byte): " + result3);
        System.out.println("(short)(byte * short): " + result4);

        // Смешанные операции с плавающей точкой
        int intVal = 10;
        double doubleVal = 3.5;

        double result5 = intVal + doubleVal;  // int автоматически приводится к double
        int result6 = (int)(intVal + doubleVal); // Результат нужно явно привести к int

        System.out.println("int + double: " + result5);
        System.out.println("(int)(int + double): " + result6);

        // Тернарный оператор и приведение типов
        boolean condition = true;
        byte byteVal = 10;
        short shortVal = 20;

        // Результат тернарного оператора имеет тип "общего предка"
        int ternaryResult = condition ? byteVal : shortVal;  // Результат int

        System.out.println("condition ? byte : short -> int: " + ternaryResult);
    }

    /**
     * Главный метод для демонстрации всех аспектов приведения типов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация приведения типов в Java ===");

        TypeCastingDemo demo = new TypeCastingDemo();

        demo.demonstrateImplicitCasting();
        demo.demonstrateExplicitCasting();
        demo.demonstratePrecisionLoss();
        demo.demonstrateOverflow();
        demo.demonstrateCharCasting();
        demo.demonstrateFloatingPointCasting();
        demo.demonstrateSafeCasting();
        demo.demonstrateComplexExpressions();

        System.out.println("\n=== Правила приведения типов ===");
        System.out.println("1. Неявное приведение (widening): byte->short->int->long->float->double");
        System.out.println("2. char может неявно приводиться к int, но не к byte/short");
        System.out.println("3. Явное приведение (narrowing) может привести к потере данных");
        System.out.println("4. Все арифметические операции с byte/short возвращают int");
        System.out.println("5. float литералы требуют суффикс 'f' или явное приведение");
        System.out.println("6. При переполнении используется модульная арифметика");
        System.out.println("7. Всегда проверяйте диапазоны для безопасного приведения");
    }
}
