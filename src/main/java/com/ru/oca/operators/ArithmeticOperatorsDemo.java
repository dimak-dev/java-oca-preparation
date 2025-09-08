package com.ru.oca.operators;

/**
 * Демонстрация арифметических операторов в Java.
 * Показывает основные арифметические операции, их приоритет,
 * особенности работы с различными типами данных и потенциальные проблемы.
 */
public class ArithmeticOperatorsDemo {

    /**
     * Демонстрация основных арифметических операторов
     */
    public void demonstrateBasicArithmeticOperators() {
        System.out.println("=== Основные арифметические операторы ===");

        int a = 15;
        int b = 4;

        System.out.println("Операнды: a = " + a + ", b = " + b);
        System.out.println();

        // Сложение (+)
        int sum = a + b;
        System.out.println("Сложение (a + b): " + sum);

        // Вычитание (-)
        int difference = a - b;
        System.out.println("Вычитание (a - b): " + difference);

        // Умножение (*)
        int product = a * b;
        System.out.println("Умножение (a * b): " + product);

        // Деление (/)
        int quotient = a / b; // Целочисленное деление
        System.out.println("Деление целых чисел (a / b): " + quotient);

        // Остаток от деления (%)
        int remainder = a % b;
        System.out.println("Остаток от деления (a % b): " + remainder);

        System.out.println();
    }

    /**
     * Демонстрация особенностей деления
     */
    public void demonstrateDivisionSpecifics() {
        System.out.println("=== Особенности деления ===");

        // Целочисленное деление
        int intA = 15;
        int intB = 4;
        int intResult = intA / intB;
        System.out.println("Целочисленное деление: " + intA + " / " + intB + " = " + intResult);

        // Деление с плавающей точкой
        double doubleA = 15.0;
        double doubleB = 4.0;
        double doubleResult = doubleA / doubleB;
        System.out.println("Деление double: " + doubleA + " / " + doubleB + " = " + doubleResult);

        // Смешанное деление (int и double)
        double mixedResult1 = intA / doubleB; // int приводится к double
        double mixedResult2 = (double) intA / intB; // явное приведение
        System.out.println("Смешанное деление (int/double): " + intA + " / " + doubleB + " = " + mixedResult1);
        System.out.println("С приведением типа: (double)" + intA + " / " + intB + " = " + mixedResult2);

        // Деление на ноль
        System.out.println("\n--- Деление на ноль ---");

        try {
            int zeroResult = intA / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Деление int на 0: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        // Деление double на ноль не вызывает исключения
        double doubleZeroResult = doubleA / 0.0;
        System.out.println("Деление double на 0.0: " + doubleZeroResult);

        double negativeZeroResult = -doubleA / 0.0;
        System.out.println("Деление -double на 0.0: " + negativeZeroResult);

        double nanResult = 0.0 / 0.0;
        System.out.println("Деление 0.0 на 0.0: " + nanResult);

        System.out.println();
    }

    /**
     * Демонстрация оператора остатка от деления (модуль)
     */
    public void demonstrateModulusOperator() {
        System.out.println("=== Оператор остатка (%) ===");

        // Положительные числа
        System.out.println("15 % 4 = " + (15 % 4)); // 3
        System.out.println("20 % 6 = " + (20 % 6)); // 2
        System.out.println("7 % 3 = " + (7 % 3));   // 1
        System.out.println("8 % 4 = " + (8 % 4));   // 0

        // Отрицательные числа
        System.out.println("\n--- С отрицательными числами ---");
        System.out.println("-15 % 4 = " + (-15 % 4));   // -3
        System.out.println("15 % -4 = " + (15 % -4));   // 3
        System.out.println("-15 % -4 = " + (-15 % -4)); // -3

        // С числами с плавающей точкой
        System.out.println("\n--- С числами с плавающей точкой ---");
        System.out.println("15.5 % 4.0 = " + (15.5 % 4.0)); // 3.5
        System.out.println("10.7 % 3.2 = " + (10.7 % 3.2)); // 1.0999999999999996

        // Практическое применение
        System.out.println("\n--- Практическое применение ---");

        // Проверка на четность/нечетность
        int[] numbers = {10, 15, 22, 33, 44};
        for (int num : numbers) {
            String type = (num % 2 == 0) ? "четное" : "нечетное";
            System.out.println(num + " - " + type);
        }

        System.out.println();
    }

    /**
     * Демонстрация унарных арифметических операторов
     */
    public void demonstrateUnaryOperators() {
        System.out.println("=== Унарные арифметические операторы ===");

        int value = 10;
        System.out.println("Исходное значение: " + value);

        // Унарный плюс (+)
        int unaryPlus = +value;
        System.out.println("Унарный плюс (+value): " + unaryPlus);

        // Унарный минус (-)
        int unaryMinus = -value;
        System.out.println("Унарный минус (-value): " + unaryMinus);

        // Префиксный инкремент (++переменная)
        int prefixIncrement = ++value; // сначала увеличивает, потом возвращает
        System.out.println("После префиксного инкремента (++value): value = " + value + ", результат = " + prefixIncrement);

        // Постфиксный инкремент (переменная++)
        int postfixIncrement = value++; // сначала возвращает, потом увеличивает
        System.out.println("После постфиксного инкремента (value++): value = " + value + ", результат = " + postfixIncrement);

        // Префиксный декремент (--переменная)
        int prefixDecrement = --value; // сначала уменьшает, потом возвращает
        System.out.println("После префиксного декремента (--value): value = " + value + ", результат = " + prefixDecrement);

        // Постфиксный декремент (переменная--)
        int postfixDecrement = value--; // сначала возвращает, потом уменьшает
        System.out.println("После постфиксного декремента (value--): value = " + value + ", результат = " + postfixDecrement);

        System.out.println();
    }

    /**
     * Демонстрация приоритета арифметических операторов
     */
    public void demonstrateOperatorPrecedence() {
        System.out.println("=== Приоритет арифметических операторов ===");

        // Без скобок
        int result1 = 2 + 3 * 4; // Умножение имеет больший приоритет
        System.out.println("2 + 3 * 4 = " + result1); // 14, не 20

        // Со скобками
        int result2 = (2 + 3) * 4; // Скобки изменяют порядок
        System.out.println("(2 + 3) * 4 = " + result2); // 20

        // Сложное выражение
        int result3 = 10 - 6 / 2 + 3 * 4;
        System.out.println("10 - 6 / 2 + 3 * 4 = " + result3); // 10 - 3 + 12 = 19

        // С унарными операторами
        int a = 5;
        int result4 = -a + 3 * ++a; // Унарные операторы имеют высший приоритет
        System.out.println("Начальное a = 5");
        a = 5; // Сбрасываем для демонстрации
        result4 = -a + 3 * ++a; // -5 + 3 * 6 = -5 + 18 = 13
        System.out.println("-a + 3 * ++a = " + result4);
        System.out.println("Конечное a = " + a);

        // Таблица приоритетов (от высшего к низшему)
        System.out.println("\n--- Приоритет операторов (высший -> низший) ---");
        System.out.println("1. Унарные: +, -, ++, --");
        System.out.println("2. Умножение и деление: *, /, %");
        System.out.println("3. Сложение и вычитание: +, -");
        System.out.println("4. Скобки () изменяют порядок выполнения");

        System.out.println();
    }

    /**
     * Демонстрация переполнения и потери точности
     */
    public void demonstrateOverflowAndPrecision() {
        System.out.println("=== Переполнение и потеря точности ===");

        // Переполнение int
        System.out.println("--- Переполнение int ---");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE: " + maxInt);
        System.out.println("MAX_VALUE + 1: " + (maxInt + 1)); // Переполнение!

        int minInt = Integer.MIN_VALUE;
        System.out.println("Integer.MIN_VALUE: " + minInt);
        System.out.println("MIN_VALUE - 1: " + (minInt - 1)); // Переполнение!

        // Переполнение при умножении
        int big1 = 100000;
        int big2 = 30000;
        int overflowResult = big1 * big2; // Переполнение
        long correctResult = (long) big1 * big2; // Правильный результат
        System.out.println("\n--- Переполнение при умножении ---");
        System.out.println(big1 + " * " + big2 + " (int): " + overflowResult);
        System.out.println(big1 + " * " + big2 + " (long): " + correctResult);

        // Потеря точности с плавающей точкой
        System.out.println("\n--- Потеря точности float ---");
        float f1 = 0.1f;
        float f2 = 0.2f;
        float f3 = f1 + f2;
        System.out.println("0.1f + 0.2f = " + f3);
        System.out.println("Равно ли 0.3f? " + (f3 == 0.3f));

        // Потеря точности при больших числах
        System.out.println("\n--- Потеря точности при больших числах ---");
        float bigFloat = 16777216f; // 2^24
        float nextFloat = bigFloat + 1;
        System.out.println("bigFloat: " + bigFloat);
        System.out.println("bigFloat + 1: " + nextFloat);
        System.out.println("Равны ли? " + (bigFloat == nextFloat));

        System.out.println();
    }

    /**
     * Демонстрация автоматического приведения типов в арифметических операциях
     */
    public void demonstrateTypePromotion() {
        System.out.println("=== Автоматическое приведение типов ===");

        // Приведение byte и short к int
        byte b1 = 10;
        byte b2 = 20;
        // byte result = b1 + b2; // ОШИБКА! Результат int
        int byteResult = b1 + b2; // OK
        System.out.println("byte + byte -> int: " + b1 + " + " + b2 + " = " + byteResult);

        short s1 = 100;
        short s2 = 200;
        int shortResult = s1 + s2; // short + short -> int
        System.out.println("short + short -> int: " + s1 + " + " + s2 + " = " + shortResult);

        // Смешанные операции
        int intValue = 42;
        long longValue = 1000L;
        long mixedResult1 = intValue + longValue; // int -> long
        System.out.println("int + long -> long: " + intValue + " + " + longValue + " = " + mixedResult1);

        float floatValue = 3.14f;
        double doubleResult = intValue + floatValue; // int -> float -> double (в выражении)
        System.out.println("int + float -> double: " + intValue + " + " + floatValue + " = " + doubleResult);

        // Правила приведения типов
        System.out.println("\n--- Правила автоматического приведения ---");
        System.out.println("1. byte, short, char -> int (в арифметических операциях)");
        System.out.println("2. Если один операнд long, результат long");
        System.out.println("3. Если один операнд float, результат float");
        System.out.println("4. Если один операнд double, результат double");

        System.out.println();
    }

    /**
     * Демонстрация составных операторов присваивания
     */
    public void demonstrateCompoundAssignmentOperators() {
        System.out.println("=== Составные операторы присваивания ===");

        int value = 10;
        System.out.println("Начальное значение: " + value);

        // += (сложение с присваиванием)
        value += 5; // Эквивалентно: value = value + 5
        System.out.println("После value += 5: " + value);

        // -= (вычитание с присваиванием)
        value -= 3; // Эквивалентно: value = value - 3
        System.out.println("После value -= 3: " + value);

        // *= (умножение с присваиванием)
        value *= 2; // Эквивалентно: value = value * 2
        System.out.println("После value *= 2: " + value);

        // /= (деление с присваиванием)
        value /= 4; // Эквивалентно: value = value / 4
        System.out.println("После value /= 4: " + value);

        // %= (остаток с присваиванием)
        value %= 3; // Эквивалентно: value = value % 3
        System.out.println("После value %= 3: " + value);

        // Особенность с приведением типов
        System.out.println("\n--- Неявное приведение типов в составных операторах ---");
        byte byteValue = 100;
        System.out.println("Начальный byte: " + byteValue);

        byteValue += 50; // Компилируется! Неявное приведение (byte)(byteValue + 50)
        System.out.println("После byteValue += 50: " + byteValue);

        // Но это не скомпилируется:
        // byteValue = byteValue + 50; // ОШИБКА! Нужно явное приведение

        System.out.println();
    }

    /**
     * Демонстрация практических примеров использования арифметических операторов
     */
    public void demonstratePracticalExamples() {
        System.out.println("=== Практические примеры ===");

        // Пример 1: Вычисление среднего значения
        System.out.println("--- Пример 1: Среднее арифметическое ---");
        int[] numbers = {85, 92, 78, 95, 88};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length; // Важно приведение к double
        System.out.println("Оценки: 85, 92, 78, 95, 88");
        System.out.println("Сумма: " + sum);
        System.out.println("Среднее: " + average);

        // Пример 2: Перевод температуры
        System.out.println("\n--- Пример 2: Перевод Celsius в Fahrenheit ---");
        double celsius = 25.0;
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        // Пример 3: Вычисление площади круга
        System.out.println("\n--- Пример 3: Площадь круга ---");
        double radius = 5.0;
        double pi = 3.14159;
        double area = pi * radius * radius;
        System.out.println("Радиус: " + radius);
        System.out.println("Площадь: " + area);

        // Пример 4: Проценты и скидки
        System.out.println("\n--- Пример 4: Расчет скидки ---");
        double originalPrice = 150.0;
        double discountPercent = 20.0;
        double discountAmount = originalPrice * discountPercent / 100;
        double finalPrice = originalPrice - discountAmount;
        System.out.println("Первоначальная цена: $" + originalPrice);
        System.out.println("Скидка " + discountPercent + "%: $" + discountAmount);
        System.out.println("Итоговая цена: $" + finalPrice);

        System.out.println();
    }

    /**
     * Главный метод для демонстрации всех арифметических операторов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация арифметических операторов Java ===\n");

        ArithmeticOperatorsDemo demo = new ArithmeticOperatorsDemo();

        // Выполняем все демонстрации
        demo.demonstrateBasicArithmeticOperators();
        demo.demonstrateDivisionSpecifics();
        demo.demonstrateModulusOperator();
        demo.demonstrateUnaryOperators();
        demo.demonstrateOperatorPrecedence();
        demo.demonstrateOverflowAndPrecision();
        demo.demonstrateTypePromotion();
        demo.demonstrateCompoundAssignmentOperators();
        demo.demonstratePracticalExamples();

        System.out.println("=== Ключевые моменты арифметических операторов ===");
        System.out.println("1. Деление целых чисел отбрасывает дробную часть");
        System.out.println("2. Деление на ноль int вызывает ArithmeticException");
        System.out.println("3. Деление double на ноль дает Infinity или NaN");
        System.out.println("4. Унарные операторы имеют высший приоритет");
        System.out.println("5. ++/-- префиксные и постфиксные ведут себя по-разному");
        System.out.println("6. byte/short автоматически приводятся к int в арифметических операциях");
        System.out.println("7. Составные операторы выполняют неявное приведение типов");
        System.out.println("8. Переполнение происходит без исключений (wrap around)");
        System.out.println("9. float и double имеют ограниченную точность");
        System.out.println("10. Используйте скобки для явного указания порядка операций");
    }
}
