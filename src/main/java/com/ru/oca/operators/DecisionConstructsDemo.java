package com.ru.oca.operators;

/**
 * Демонстрация конструкций принятия решений в Java.
 * Показывает работу if-else, switch-case, тернарного оператора
 * и различные практические примеры их использования.
 */
public class DecisionConstructsDemo {

    /**
     * Демонстрация базовых конструкций if-else
     */
    public void demonstrateIfElseBasics() {
        System.out.println("=== Базовые конструкции if-else ===");

        int score = 85;
        System.out.println("Оценка: " + score);

        // Простой if
        if (score >= 90) {
            System.out.println("Отлично!");
        }

        // if-else
        if (score >= 60) {
            System.out.println("Зачет");
        } else {
            System.out.println("Незачет");
        }

        // Множественный if-else if
        if (score >= 90) {
            System.out.println("Оценка: A");
        } else if (score >= 80) {
            System.out.println("Оценка: B");
        } else if (score >= 70) {
            System.out.println("Оценка: C");
        } else if (score >= 60) {
            System.out.println("Оценка: D");
        } else {
            System.out.println("Оценка: F");
        }

        // Вложенные if
        if (score >= 60) {
            System.out.println("Студент прошел курс");
            if (score >= 90) {
                System.out.println("С отличием!");
            } else if (score >= 80) {
                System.out.println("С хорошим результатом");
            }
        } else {
            System.out.println("Студент не прошел курс");
        }

        System.out.println();
    }

    /**
     * Демонстрация особенностей синтаксиса if-else
     */
    public void demonstrateIfElseSyntax() {
        System.out.println("=== Особенности синтаксиса if-else ===");

        int x = 10;
        int y = 5;

        // if без фигурных скобок (только одна инструкция)
        if (x > y)
            System.out.println("x больше y");

        // if-else без фигурных скобок
        if (x < y)
            System.out.println("x меньше y");
        else
            System.out.println("x больше или равно y");

        // ОПАСНОСТЬ: без скобок только одна инструкция
        if (x > 0)
            System.out.println("x положительное");
            // System.out.println("Эта строка выполнится всегда!"); // Не в if!

        // Правильно с фигурными скобками
        if (x > 0) {
            System.out.println("x положительное");
            System.out.println("И эта строка тоже в блоке if");
        }

        // Пустой if (плохая практика)
        if (x > y) {
            // Ничего не делаем
        }

        // Лучше использовать отрицательное условие
        if (x <= y) {
            System.out.println("x не больше y");
        }

        System.out.println();
    }

    /**
     * Демонстрация базовых конструкций switch
     */
    public void demonstrateSwitchBasics() {
        System.out.println("=== Базовые конструкции switch ===");

        int dayOfWeek = 3;
        System.out.println("День недели (число): " + dayOfWeek);

        // Базовый switch
        switch (dayOfWeek) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Неверный день недели");
                break;
        }

        // Switch с группировкой случаев
        System.out.println("\n--- Группировка случаев ---");
        switch (dayOfWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Будний день");
                break;
            case 6:
            case 7:
                System.out.println("Выходной день");
                break;
            default:
                System.out.println("Неверный день");
                break;
        }

        System.out.println();
    }

    /**
     * Демонстрация fall-through в switch
     */
    public void demonstrateSwitchFallThrough() {
        System.out.println("=== Fall-through в switch ===");

        char grade = 'B';
        System.out.println("Оценка: " + grade);

        // Демонстрация fall-through (проваливание)
        System.out.println("Без break (fall-through):");
        switch (grade) {
            case 'A':
                System.out.println("Отлично!");
            case 'B':
                System.out.println("Хорошо!");
            case 'C':
                System.out.println("Удовлетворительно!");
            case 'D':
                System.out.println("Сдал");
                break;
            case 'F':
                System.out.println("Не сдал");
                break;
            default:
                System.out.println("Неизвестная оценка");
        }

        System.out.println("\nС правильными break:");
        switch (grade) {
            case 'A':
                System.out.println("Отлично!");
                break;
            case 'B':
                System.out.println("Хорошо!");
                break;
            case 'C':
                System.out.println("Удовлетворительно!");
                break;
            case 'D':
                System.out.println("Сдал");
                break;
            case 'F':
                System.out.println("Не сдал");
                break;
            default:
                System.out.println("Неизвестная оценка");
                break;
        }

        // Полезный fall-through
        System.out.println("\n--- Полезное использование fall-through ---");
        int month = 2;
        int days;

        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = 28; // Упрощенно, без учета високосного года
                break;
            default:
                days = 0;
                System.out.println("Неверный месяц");
        }

        if (days > 0) {
            System.out.println("В месяце " + month + " дней: " + days);
        }

        System.out.println();
    }

    /**
     * Демонстрация switch с различными типами данных
     */
    public void demonstrateSwitchDataTypes() {
        System.out.println("=== Switch с различными типами данных ===");

        // Switch с int
        System.out.println("--- int ---");
        int intValue = 2;
        switch (intValue) {
            case 1:
                System.out.println("Один");
                break;
            case 2:
                System.out.println("Два");
                break;
            default:
                System.out.println("Другое число");
        }

        // Switch с char
        System.out.println("\n--- char ---");
        char charValue = 'B';
        switch (charValue) {
            case 'A':
                System.out.println("Буква A");
                break;
            case 'B':
                System.out.println("Буква B");
                break;
            default:
                System.out.println("Другая буква");
        }

        // Switch с String (Java 7+)
        System.out.println("\n--- String (Java 7+) ---");
        String color = "RED";
        switch (color) {
            case "RED":
                System.out.println("Красный цвет");
                break;
            case "GREEN":
                System.out.println("Зеленый цвет");
                break;
            case "BLUE":
                System.out.println("Синий цвет");
                break;
            default:
                System.out.println("Неизвестный цвет");
        }

        // Switch с byte, short
        System.out.println("\n--- byte и short ---");
        byte byteValue = 10;
        switch (byteValue) {
            case 5:
                System.out.println("Пять");
                break;
            case 10:
                System.out.println("Десять");
                break;
            default:
                System.out.println("Другое значение");
        }

        // Switch НЕ работает с long, float, double, boolean
        System.out.println("\n--- Типы, НЕ поддерживаемые switch ---");
        System.out.println("Switch НЕ работает с: long, float, double, boolean");

        System.out.println();
    }

    /**
     * Демонстрация сравнения if-else vs switch
     */
    public void demonstrateIfVsSwitch() {
        System.out.println("=== Сравнение if-else vs switch ===");

        String operation = "ADD";
        int a = 10;
        int b = 5;
        int result = 0;

        // Используя if-else
        System.out.println("--- Используя if-else ---");
        if (operation.equals("ADD")) {
            result = a + b;
        } else if (operation.equals("SUBTRACT")) {
            result = a - b;
        } else if (operation.equals("MULTIPLY")) {
            result = a * b;
        } else if (operation.equals("DIVIDE")) {
            result = (b != 0) ? a / b : 0;
        } else {
            System.out.println("Неизвестная операция");
            result = 0;
        }
        System.out.println("Результат: " + result);

        // Используя switch
        System.out.println("\n--- Используя switch ---");
        switch (operation) {
            case "ADD":
                result = a + b;
                break;
            case "SUBTRACT":
                result = a - b;
                break;
            case "MULTIPLY":
                result = a * b;
                break;
            case "DIVIDE":
                result = (b != 0) ? a / b : 0;
                break;
            default:
                System.out.println("Неизвестная операция");
                result = 0;
        }
        System.out.println("Результат: " + result);

        // Когда использовать что
        System.out.println("\n--- Рекомендации ---");
        System.out.println("Используйте switch когда:");
        System.out.println("- Сравниваете одну переменную с константными значениями");
        System.out.println("- Много вариантов (> 3-4)");
        System.out.println("- Значения дискретные");
        System.out.println();
        System.out.println("Используйте if-else когда:");
        System.out.println("- Сложные условия с логическими операторами");
        System.out.println("- Сравнение диапазонов");
        System.out.println("- Различные переменные в условиях");

        System.out.println();
    }

    /**
     * Демонстрация вложенных конструкций
     */
    public void demonstrateNestedConstructs() {
        System.out.println("=== Вложенные конструкции ===");

        int userRole = 2; // 1-Admin, 2-User, 3-Guest
        String action = "READ";
        boolean hasPermission = false;

        // Вложенные if в switch
        switch (userRole) {
            case 1: // Admin
                System.out.println("Роль: Администратор");
                if (action.equals("READ") || action.equals("WRITE") || action.equals("DELETE")) {
                    hasPermission = true;
                }
                break;
            case 2: // User
                System.out.println("Роль: Пользователь");
                if (action.equals("READ") || action.equals("WRITE")) {
                    hasPermission = true;
                } else if (action.equals("DELETE")) {
                    System.out.println("Удаление разрешено только для собственных данных");
                    hasPermission = false; // Упрощенно
                }
                break;
            case 3: // Guest
                System.out.println("Роль: Гость");
                if (action.equals("READ")) {
                    hasPermission = true;
                }
                break;
            default:
                System.out.println("Неизвестная роль");
        }

        System.out.println("Действие: " + action);
        System.out.println("Разрешение: " + (hasPermission ? "РАЗРЕШЕНО" : "ЗАПРЕЩЕНО"));

        // Switch внутри if
        System.out.println("\n--- Switch внутри if ---");
        boolean isWeekend = false;
        int timeOfDay = 14; // 24-часовой формат

        if (!isWeekend) {
            System.out.println("Будний день");
            switch (timeOfDay) {
                case 9: case 10: case 11:
                    System.out.println("Утренние встречи");
                    break;
                case 12: case 13:
                    System.out.println("Обеденное время");
                    break;
                case 14: case 15: case 16: case 17:
                    System.out.println("Рабочее время");
                    break;
                default:
                    System.out.println("Нерабочее время");
            }
        } else {
            System.out.println("Выходной день - отдыхаем!");
        }

        System.out.println();
    }

    /**
     * Демонстрация практических примеров
     */
    public void demonstratePracticalExamples() {
        System.out.println("=== Практические примеры ===");

        // Пример 1: Калькулятор
        System.out.println("--- Пример 1: Простой калькулятор ---");
        double num1 = 15.0;
        double num2 = 4.0;
        char operator = '/';
        double calculatorResult;

        switch (operator) {
            case '+':
                calculatorResult = num1 + num2;
                break;
            case '-':
                calculatorResult = num1 - num2;
                break;
            case '*':
                calculatorResult = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    calculatorResult = num1 / num2;
                } else {
                    System.out.println("Ошибка: Деление на ноль!");
                    calculatorResult = Double.NaN;
                }
                break;
            default:
                System.out.println("Неизвестный оператор: " + operator);
                calculatorResult = Double.NaN;
        }

        if (!Double.isNaN(calculatorResult)) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + calculatorResult);
        }

        // Пример 2: Определение сезона
        System.out.println("\n--- Пример 2: Определение сезона ---");
        int month = 7;
        String season;

        if (month >= 3 && month <= 5) {
            season = "Весна";
        } else if (month >= 6 && month <= 8) {
            season = "Лето";
        } else if (month >= 9 && month <= 11) {
            season = "Осень";
        } else if (month == 12 || month == 1 || month == 2) {
            season = "Зима";
        } else {
            season = "Неверный месяц";
        }

        System.out.println("Месяц " + month + " - это " + season);

        // Пример 3: Система скидок
        System.out.println("\n--- Пример 3: Система скидок ---");
        String customerType = "PREMIUM";
        double purchaseAmount = 1000.0;
        double discount = 0.0;

        switch (customerType) {
            case "REGULAR":
                if (purchaseAmount >= 500) {
                    discount = 0.05; // 5%
                }
                break;
            case "PREMIUM":
                if (purchaseAmount >= 1000) {
                    discount = 0.15; // 15%
                } else if (purchaseAmount >= 500) {
                    discount = 0.10; // 10%
                } else {
                    discount = 0.05; // 5%
                }
                break;
            case "VIP":
                discount = 0.20; // 20% всегда
                break;
            default:
                discount = 0.0;
        }

        double finalAmount = purchaseAmount * (1 - discount);
        System.out.println("Тип клиента: " + customerType);
        System.out.println("Сумма покупки: $" + purchaseAmount);
        System.out.println("Скидка: " + (discount * 100) + "%");
        System.out.println("К оплате: $" + finalAmount);

        // Пример 4: Проверка валидности данных
        System.out.println("\n--- Пример 4: Валидация возраста ---");
        int age = 25;
        String category;
        boolean canVote, canDrink, canRetire;

        if (age < 0) {
            category = "Неверный возраст";
            canVote = canDrink = canRetire = false;
        } else if (age < 18) {
            category = "Несовершеннолетний";
            canVote = canDrink = canRetire = false;
        } else if (age < 21) {
            category = "Молодой взрослый";
            canVote = true;
            canDrink = false; // В США
            canRetire = false;
        } else if (age < 65) {
            category = "Взрослый";
            canVote = canDrink = true;
            canRetire = false;
        } else {
            category = "Пенсионер";
            canVote = canDrink = canRetire = true;
        }

        System.out.println("Возраст: " + age);
        System.out.println("Категория: " + category);
        System.out.println("Может голосовать: " + canVote);
        System.out.println("Может покупать алкоголь: " + canDrink);
        System.out.println("Может выйти на пенсию: " + canRetire);

        System.out.println();
    }

    /**
     * Демонстрация типичных ошибок
     */
    public void demonstrateCommonMistakes() {
        System.out.println("=== Типичные ошибки ===");

        // Ошибка 1: Забытый break в switch
        System.out.println("--- Ошибка 1: Забытый break ---");
        int value = 2;

        System.out.println("НЕПРАВИЛЬНО (без break):");
        switch (value) {
            case 1:
                System.out.println("Один");
                // Забыли break - упадет в следующий case!
            case 2:
                System.out.println("Два");
                break;
            case 3:
                System.out.println("Три");
                break;
        }

        // Ошибка 2: Неиспользование фигурных скобок
        System.out.println("\n--- Ошибка 2: Проблемы с фигурными скобками ---");
        boolean condition = true;

        if (condition)
            System.out.println("Условие истинно");
            System.out.println("Эта строка выполнится всегда!"); // НЕ в блоке if!

        // Правильно:
        if (condition) {
            System.out.println("ПРАВИЛЬНО: Условие истинно");
            System.out.println("ПРАВИЛЬНО: Эта строка тоже в блоке if");
        }

        // Ошибка 3: Использование = вместо ==
        System.out.println("\n--- Ошибка 3: Присваивание вместо сравнения ---");
        boolean flag = false;

        // НЕПРАВИЛЬНО: if (flag = true) - это присваивание!
        // Правильно:
        if (flag == true) { // Хотя лучше просто if (flag)
            System.out.println("Флаг установлен");
        } else {
            System.out.println("Флаг не установлен");
        }

        // Ошибка 4: Неправильные диапазоны
        System.out.println("\n--- Ошибка 4: Неправильная логика диапазонов ---");
        int score = 85;

        // НЕПРАВИЛЬНО: пересекающиеся условия
        System.out.println("НЕПРАВИЛЬНАЯ логика:");
        if (score >= 80) {
            System.out.println("Хорошо");
        } else if (score >= 70) { // Этот блок никогда не выполнится для score >= 80
            System.out.println("Удовлетворительно");
        }

        // ПРАВИЛЬНО: четкие диапазоны
        System.out.println("ПРАВИЛЬНАЯ логика:");
        if (score >= 90) {
            System.out.println("Отлично");
        } else if (score >= 80) {
            System.out.println("Хорошо");
        } else if (score >= 70) {
            System.out.println("Удовлетворительно");
        } else {
            System.out.println("Неудовлетворительно");
        }

        // Ошибка 5: Null String в switch
        System.out.println("\n--- Ошибка 5: Null в switch с String ---");
        String text = null;

        try {
            switch (text) { // NullPointerException!
                case "test":
                    System.out.println("Тест");
                    break;
                default:
                    System.out.println("Другое");
            }
        } catch (NullPointerException e) {
            System.out.println("ОШИБКА: NullPointerException при switch с null String");
        }

        // Правильно: проверка на null
        if (text != null) {
            switch (text) {
                case "test":
                    System.out.println("Тест");
                    break;
                default:
                    System.out.println("Другое");
            }
        } else {
            System.out.println("ПРАВИЛЬНО: String равен null");
        }

        System.out.println();
    }

    /**
     * Главный метод для демонстрации всех конструкций принятия решений
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация конструкций принятия решений ===\n");

        DecisionConstructsDemo demo = new DecisionConstructsDemo();

        // Выполняем все демонстрации
        demo.demonstrateIfElseBasics();
        demo.demonstrateIfElseSyntax();
        demo.demonstrateSwitchBasics();
        demo.demonstrateSwitchFallThrough();
        demo.demonstrateSwitchDataTypes();
        demo.demonstrateIfVsSwitch();
        demo.demonstrateNestedConstructs();
        demo.demonstratePracticalExamples();
        demo.demonstrateCommonMistakes();

        System.out.println("=== Ключевые моменты конструкций решений ===");
        System.out.println("1. if-else для сложных условий, switch для простых сравнений");
        System.out.println("2. Всегда используйте фигурные скобки для ясности");
        System.out.println("3. break обязателен в switch (кроме намеренного fall-through)");
        System.out.println("4. switch работает с int, char, String, byte, short, enum");
        System.out.println("5. switch НЕ работает с long, float, double, boolean");
        System.out.println("6. default в switch необязателен, но рекомендуется");
        System.out.println("7. Проверяйте String на null перед использованием в switch");
        System.out.println("8. == сравнивает значения, используйте equals() для объектов");
        System.out.println("9. Избегайте глубокой вложенности - выносите в методы");
        System.out.println("10. Тернарный оператор ?: для простых условных присваиваний");
    }
}
