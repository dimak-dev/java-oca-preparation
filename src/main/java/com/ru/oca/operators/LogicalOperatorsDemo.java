package com.ru.oca.operators;

/**
 * Демонстрация логических операторов и операторов сравнения в Java.
 * Показывает работу логических операторов, операторов сравнения,
 * короткого замыкания (short-circuit evaluation) и практические примеры.
 */
public class LogicalOperatorsDemo {

    /**
     * Демонстрация операторов сравнения
     */
    public void demonstrateComparisonOperators() {
        System.out.println("=== Операторы сравнения ===");

        int a = 10;
        int b = 5;
        int c = 10;

        System.out.println("Значения: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();

        // Равенство (==)
        boolean equal1 = (a == b);
        boolean equal2 = (a == c);
        System.out.println("a == b: " + equal1);
        System.out.println("a == c: " + equal2);

        // Неравенство (!=)
        boolean notEqual1 = (a != b);
        boolean notEqual2 = (a != c);
        System.out.println("a != b: " + notEqual1);
        System.out.println("a != c: " + notEqual2);

        // Больше (>)
        boolean greater = (a > b);
        System.out.println("a > b: " + greater);

        // Больше или равно (>=)
        boolean greaterEqual1 = (a >= b);
        boolean greaterEqual2 = (a >= c);
        System.out.println("a >= b: " + greaterEqual1);
        System.out.println("a >= c: " + greaterEqual2);

        // Меньше (<)
        boolean less = (b < a);
        System.out.println("b < a: " + less);

        // Меньше или равно (<=)
        boolean lessEqual1 = (b <= a);
        boolean lessEqual2 = (a <= c);
        System.out.println("b <= a: " + lessEqual1);
        System.out.println("a <= c: " + lessEqual2);

        System.out.println();
    }

    /**
     * Демонстрация особенностей сравнения различных типов данных
     */
    public void demonstrateComparisonSpecifics() {
        System.out.println("=== Особенности сравнения ===");

        // Сравнение примитивных типов
        System.out.println("--- Примитивные типы ---");
        int intValue = 42;
        long longValue = 42L;
        float floatValue = 42.0f;
        double doubleValue = 42.0;

        System.out.println("int vs long: " + (intValue == longValue)); // true - автоматическое приведение
        System.out.println("int vs float: " + (intValue == floatValue)); // true
        System.out.println("int vs double: " + (intValue == doubleValue)); // true

        // Сравнение с точностью float/double
        System.out.println("\n--- Проблемы точности float/double ---");
        float f1 = 0.1f;
        float f2 = 0.2f;
        float f3 = f1 + f2;
        System.out.println("0.1f + 0.2f = " + f3);
        System.out.println("0.1f + 0.2f == 0.3f: " + (f3 == 0.3f)); // false!

        // Правильное сравнение float/double с эпсилон
        double epsilon = 1e-10;
        double d1 = 0.1;
        double d2 = 0.2;
        double d3 = d1 + d2;
        boolean isEqual = Math.abs(d3 - 0.3) < epsilon;
        System.out.println("Правильное сравнение с epsilon: " + isEqual);

        // Сравнение char
        System.out.println("\n--- Сравнение char ---");
        char ch1 = 'A';
        char ch2 = 65; // ASCII код 'A'
        char ch3 = 'B';

        System.out.println("'A' == 65: " + (ch1 == ch2)); // true
        System.out.println("'A' < 'B': " + (ch1 < ch3)); // true - сравнение по ASCII кодам
        System.out.println("ASCII 'A': " + (int)ch1);
        System.out.println("ASCII 'B': " + (int)ch3);

        System.out.println();
    }

    /**
     * Демонстрация логических операторов
     */
    public void demonstrateLogicalOperators() {
        System.out.println("=== Логические операторы ===");

        boolean a = true;
        boolean b = false;

        System.out.println("Значения: a = " + a + ", b = " + b);
        System.out.println();

        // Логическое И (&&) - короткое замыкание
        boolean andResult = a && b;
        System.out.println("a && b: " + andResult);

        // Логическое ИЛИ (||) - короткое замыкание
        boolean orResult = a || b;
        System.out.println("a || b: " + orResult);

        // Логическое НЕ (!)
        boolean notA = !a;
        boolean notB = !b;
        System.out.println("!a: " + notA);
        System.out.println("!b: " + notB);

        // Исключающее ИЛИ (^)
        boolean xorResult = a ^ b;
        System.out.println("a ^ b (XOR): " + xorResult);

        // Побитовое И (&) - без короткого замыкания
        boolean bitwiseAndResult = a & b;
        System.out.println("a & b (побитовое И): " + bitwiseAndResult);

        // Побитовое ИЛИ (|) - без короткого замыкания
        boolean bitwiseOrResult = a | b;
        System.out.println("a | b (побитовое ИЛИ): " + bitwiseOrResult);

        System.out.println();
    }

    /**
     * Демонстрация короткого замыкания (short-circuit evaluation)
     */
    public void demonstrateShortCircuitEvaluation() {
        System.out.println("=== Короткое замыкание (Short-Circuit Evaluation) ===");

        System.out.println("--- Логическое И (&&) ---");

        // Первый операнд false - второй не вычисляется
        boolean result1 = false && expensiveOperation("Второй операнд И");
        System.out.println("false && expensiveOperation(): " + result1);
        System.out.println("Второй операнд НЕ вызывался!");

        System.out.println();

        // Первый операнд true - второй вычисляется
        boolean result2 = true && expensiveOperation("Второй операнд И");
        System.out.println("true && expensiveOperation(): " + result2);

        System.out.println("\n--- Логическое ИЛИ (||) ---");

        // Первый операнд true - второй не вычисляется
        boolean result3 = true || expensiveOperation("Второй операнд ИЛИ");
        System.out.println("true || expensiveOperation(): " + result3);
        System.out.println("Второй операнд НЕ вызывался!");

        System.out.println();

        // Первый операнд false - второй вычисляется
        boolean result4 = false || expensiveOperation("Второй операнд ИЛИ");
        System.out.println("false || expensiveOperation(): " + result4);

        System.out.println("\n--- Сравнение с побитовыми операторами ---");
        System.out.println("Побитовые операторы (&, |) ВСЕГДА вычисляют оба операнда:");

        // & всегда вычисляет оба операнда
        boolean result5 = false & expensiveOperation("Побитовое И");
        System.out.println("false & expensiveOperation(): " + result5);

        // | всегда вычисляет оба операнда
        boolean result6 = true | expensiveOperation("Побитовое ИЛИ");
        System.out.println("true | expensiveOperation(): " + result6);

        System.out.println();
    }

    /**
     * Вспомогательный метод для демонстрации короткого замыкания
     */
    private boolean expensiveOperation(String operand) {
        System.out.println("  -> Выполняется дорогая операция: " + operand);
        return false;
    }

    /**
     * Демонстрация приоритета логических операторов
     */
    public void demonstrateLogicalOperatorPrecedence() {
        System.out.println("=== Приоритет логических операторов ===");

        boolean a = true;
        boolean b = false;
        boolean c = true;

        System.out.println("Значения: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();

        // ! имеет высший приоритет
        boolean result1 = !a && b; // (!a) && b = false && false = false
        System.out.println("!a && b = " + result1);

        // && имеет больший приоритет чем ||
        boolean result2 = a || b && c; // a || (b && c) = true || false = true
        System.out.println("a || b && c = " + result2);

        // Сравнение со скобками
        boolean result3 = (a || b) && c; // (true || false) && true = true
        System.out.println("(a || b) && c = " + result3);

        // Комплексное выражение
        boolean result4 = !a || b && !c; // (!a) || (b && (!c)) = false || false = false
        System.out.println("!a || b && !c = " + result4);

        System.out.println("\n--- Порядок приоритета логических операторов ---");
        System.out.println("1. ! (НЕ) - высший приоритет");
        System.out.println("2. & (побитовое И)");
        System.out.println("3. ^ (исключающее ИЛИ)");
        System.out.println("4. | (побитовое ИЛИ)");
        System.out.println("5. && (логическое И)");
        System.out.println("6. || (логическое ИЛИ) - низший приоритет");

        System.out.println();
    }

    /**
     * Демонстрация сравнения объектов vs примитивов
     */
    public void demonstrateObjectComparison() {
        System.out.println("=== Сравнение объектов vs примитивов ===");

        // Примитивы - сравнение по значению
        int int1 = 100;
        int int2 = 100;
        System.out.println("Примитивы int1 == int2: " + (int1 == int2)); // true

        // Integer объекты - сравнение по ссылке
        Integer obj1 = new Integer(100); // Deprecated, но для демонстрации
        Integer obj2 = new Integer(100);
        System.out.println("new Integer(100) == new Integer(100): " + (obj1 == obj2)); // false
        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2)); // true

        // Автоупаковка и кеширование Integer
        Integer auto1 = 100; // Автоупаковка с кешированием
        Integer auto2 = 100;
        Integer auto3 = 200; // Не кешируется (> 127)
        Integer auto4 = 200;

        System.out.println("\n--- Кеширование Integer [-128, 127] ---");
        System.out.println("Integer(100) == Integer(100) (автоупаковка): " + (auto1 == auto2)); // true
        System.out.println("Integer(200) == Integer(200) (автоупаковка): " + (auto3 == auto4)); // false

        // Сравнение Integer с int
        System.out.println("\n--- Сравнение Integer с int ---");
        Integer integerValue = 100;
        int primitiveValue = 100;
        System.out.println("Integer(100) == int(100): " + (integerValue == primitiveValue)); // true - автораспаковка

        // String сравнение
        System.out.println("\n--- Сравнение String ---");
        String str1 = "Hello";
        String str2 = "Hello"; // Пул строк
        String str3 = new String("Hello"); // Новый объект

        System.out.println("\"Hello\" == \"Hello\" (пул): " + (str1 == str2)); // true
        System.out.println("\"Hello\" == new String(\"Hello\"): " + (str1 == str3)); // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

        System.out.println();
    }

    /**
     * Демонстрация тернарного оператора
     */
    public void demonstrateTernaryOperator() {
        System.out.println("=== Тернарный оператор (? :) ===");

        int a = 10;
        int b = 5;

        // Простое использование
        int max = (a > b) ? a : b;
        System.out.println("max(" + a + ", " + b + ") = " + max);

        String result = (a > b) ? "a больше" : "b больше или равно";
        System.out.println("Результат сравнения: " + result);

        // Вложенные тернарные операторы
        int c = 15;
        int maximum = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("max(" + a + ", " + b + ", " + c + ") = " + maximum);

        // Тернарный оператор с различными типами
        System.out.println("\n--- Приведение типов в тернарном операторе ---");
        boolean condition = true;
        Object ternaryResult = condition ? "Строка" : 42; // Результат Object
        System.out.println("Результат: " + ternaryResult + " (тип: " + ternaryResult.getClass().getSimpleName() + ")");

        // Тернарный с автоупаковкой
        Integer ternaryInt = condition ? 100 : null;
        System.out.println("Тернарный с Integer: " + ternaryInt);

        System.out.println();
    }

    /**
     * Демонстрация практических примеров использования логических операторов
     */
    public void demonstratePracticalExamples() {
        System.out.println("=== Практические примеры ===");

        // Пример 1: Проверка диапазона
        System.out.println("--- Пример 1: Проверка диапазона ---");
        int age = 25;
        boolean isAdult = age >= 18 && age <= 65;
        System.out.println("Возраст " + age + ", взрослый трудоспособный: " + isAdult);

        // Пример 2: Валидация данных
        System.out.println("\n--- Пример 2: Валидация пароля ---");
        String password = "Abc123!";
        boolean isValidLength = password.length() >= 6 && password.length() <= 20;
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasLower = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*].*");

        boolean isValidPassword = isValidLength && hasUpper && hasLower && hasDigit;

        System.out.println("Пароль: " + password);
        System.out.println("Длина OK: " + isValidLength);
        System.out.println("Есть заглавные: " + hasUpper);
        System.out.println("Есть строчные: " + hasLower);
        System.out.println("Есть цифры: " + hasDigit);
        System.out.println("Есть спецсимволы: " + hasSpecial);
        System.out.println("Пароль валидный: " + isValidPassword);

        // Пример 3: Логика игры
        System.out.println("\n--- Пример 3: Игровая логика ---");
        int playerHealth = 75;
        int playerMana = 30;
        boolean hasWeapon = true;
        boolean enemyNear = true;

        boolean canAttack = (playerHealth > 0) && (playerMana >= 10 || hasWeapon) && enemyNear;
        boolean shouldRetreat = playerHealth <= 20 || (!hasWeapon && playerMana < 10);

        System.out.println("Здоровье игрока: " + playerHealth);
        System.out.println("Мана игрока: " + playerMana);
        System.out.println("Есть оружие: " + hasWeapon);
        System.out.println("Враг рядом: " + enemyNear);
        System.out.println("Может атаковать: " + canAttack);
        System.out.println("Должен отступить: " + shouldRetreat);

        // Пример 4: Обработка граничных случаев
        System.out.println("\n--- Пример 4: Безопасная обработка null ---");
        String text = null;
        boolean isEmptyOrNull = (text == null) || text.isEmpty();
        System.out.println("Текст null или пустой: " + isEmptyOrNull);

        // Благодаря короткому замыканию text.isEmpty() не вызовется, если text == null
        text = "";
        isEmptyOrNull = (text == null) || text.isEmpty();
        System.out.println("Пустая строка null или пустая: " + isEmptyOrNull);

        System.out.println();
    }

    /**
     * Демонстрация типичных ошибок с логическими операторами
     */
    public void demonstrateCommonMistakes() {
        System.out.println("=== Типичные ошибки ===");

        // Ошибка 1: Путаница между = и ==
        System.out.println("--- Ошибка 1: Присваивание вместо сравнения ---");
        boolean flag = true;
        // if (flag = false) // ОШИБКА! Присваивание вместо сравнения
        if (flag == false) { // Правильно (хотя лучше !flag)
            System.out.println("Флаг false");
        } else {
            System.out.println("Флаг true");
        }

        // Ошибка 2: Сравнение float/double на точное равенство
        System.out.println("\n--- Ошибка 2: Неточное сравнение float ---");
        double result = 0.1 + 0.2;
        if (result == 0.3) { // ПЛОХО!
            System.out.println("Равно 0.3");
        } else {
            System.out.println("НЕ равно 0.3: " + result);
        }

        // Правильное сравнение
        double epsilon = 1e-10;
        if (Math.abs(result - 0.3) < epsilon) {
            System.out.println("Приблизительно равно 0.3");
        }

        // Ошибка 3: Неправильный порядок проверок
        System.out.println("\n--- Ошибка 3: Неправильный порядок null-проверки ---");
        String str = null;

        // ПЛОХО - может вызвать NullPointerException
        // boolean isEmpty = str.length() == 0 || str == null; // NPE!

        // ХОРОШО - сначала проверяем на null
        boolean isEmpty = str == null || str.length() == 0;
        System.out.println("Строка пустая или null: " + isEmpty);

        System.out.println();
    }

    /**
     * Главный метод для демонстрации всех логических операторов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация логических операторов и операторов сравнения ===\n");

        LogicalOperatorsDemo demo = new LogicalOperatorsDemo();

        // Выполняем все демонстрации
        demo.demonstrateComparisonOperators();
        demo.demonstrateComparisonSpecifics();
        demo.demonstrateLogicalOperators();
        demo.demonstrateShortCircuitEvaluation();
        demo.demonstrateLogicalOperatorPrecedence();
        demo.demonstrateObjectComparison();
        demo.demonstrateTernaryOperator();
        demo.demonstratePracticalExamples();
        demo.demonstrateCommonMistakes();

        System.out.println("=== Ключевые моменты логических операторов ===");
        System.out.println("1. == сравнивает значения примитивов, ссылки объектов");
        System.out.println("2. && и || используют короткое замыкание");
        System.out.println("3. & и | всегда вычисляют оба операнда");
        System.out.println("4. ! имеет высший приоритет среди логических операторов");
        System.out.println("5. float/double нельзя сравнивать на точное равенство");
        System.out.println("6. Integer кеширует значения от -128 до 127");
        System.out.println("7. String использует пул строк для литералов");
        System.out.println("8. Тернарный оператор ?: - краткая форма if-else");
        System.out.println("9. Всегда проверяйте null перед вызовом методов");
        System.out.println("10. Используйте equals() для сравнения содержимого объектов");
    }
}
