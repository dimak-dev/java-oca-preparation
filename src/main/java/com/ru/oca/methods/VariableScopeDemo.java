package com.ru.oca.methods;

/**
 * Демонстрация области видимости переменных в методах Java.
 * Показывает различия между локальными переменными, параметрами методов и полями класса.
 */
public class VariableScopeDemo {

    // Поля класса (переменные экземпляра)
    private String instanceVariable = "Instance Variable";
    private int instanceNumber = 100;

    // Статические поля класса
    private static String staticVariable = "Static Variable";
    private static int staticNumber = 200;

    // Метод, демонстрирующий локальные переменные
    public void demonstrateLocalVariables() {
        System.out.println("=== Демонстрация локальных переменных ===");

        // Локальные переменные должны быть инициализированы перед использованием
        int localVariable; // Объявление без инициализации
        // System.out.println(localVariable); // ОШИБКА КОМПИЛЯЦИИ! Переменная не инициализирована

        localVariable = 42; // Инициализация
        System.out.println("Локальная переменная: " + localVariable);

        // Локальные переменные существуют только в пределах метода
        String methodScopedString = "Доступна только в этом методе";
        System.out.println("Локальная строка: " + methodScopedString);

        // Доступ к полям класса из метода экземпляра
        System.out.println("Поле экземпляра: " + instanceVariable);
        System.out.println("Статическое поле: " + staticVariable);
    }

    // Метод, демонстрирующий область видимости параметров
    public void demonstrateParameterScope(String parameter, int numberParameter) {
        System.out.println("=== Демонстрация области видимости параметров ===");

        // Параметры ведут себя как локальные переменные
        System.out.println("Параметр строка: " + parameter);
        System.out.println("Параметр число: " + numberParameter);

        // Параметры можно изменять (но это не влияет на исходные значения)
        parameter = "Измененный параметр";
        numberParameter = 999;
        System.out.println("Измененный параметр строка: " + parameter);
        System.out.println("Измененный параметр число: " + numberParameter);
    }

    // Метод с конфликтом имен между параметром и полем класса
    public void demonstrateNameConflict(String instanceVariable, int instanceNumber) {
        System.out.println("=== Демонстрация конфликта имен ===");

        // Без this - обращение к параметру
        System.out.println("Параметр instanceVariable: " + instanceVariable);
        System.out.println("Параметр instanceNumber: " + instanceNumber);

        // С this - обращение к полю класса
        System.out.println("Поле this.instanceVariable: " + this.instanceVariable);
        System.out.println("Поле this.instanceNumber: " + this.instanceNumber);
    }

    // Метод с блоками кода и локальными переменными
    public void demonstrateBlockScope() {
        System.out.println("=== Демонстрация области видимости блоков ===");

        int outerVariable = 10;
        System.out.println("Внешняя переменная: " + outerVariable);

        if (true) {
            // Переменная, объявленная в блоке
            int blockVariable = 20;
            System.out.println("Переменная блока: " + blockVariable);
            System.out.println("Доступ к внешней переменной из блока: " + outerVariable);

            // Можно изменять переменные из внешней области
            outerVariable = 15;
        }

        System.out.println("Внешняя переменная после блока: " + outerVariable);
        // System.out.println(blockVariable); // ОШИБКА! blockVariable недоступна вне блока

        // Цикл также создает свою область видимости
        for (int i = 0; i < 3; i++) {
            int loopVariable = i * 10;
            System.out.println("Переменная цикла " + i + ": " + loopVariable);
        }
        // System.out.println(i); // ОШИБКА! i недоступна вне цикла for
        // System.out.println(loopVariable); // ОШИБКА! loopVariable недоступна вне цикла
    }

    // Статический метод с ограниченным доступом
    public static void demonstrateStaticMethodScope() {
        System.out.println("=== Демонстрация области видимости в статическом методе ===");

        // Локальные переменные в статическом методе
        String localInStatic = "Локальная переменная в статическом методе";
        System.out.println(localInStatic);

        // Доступ к статическим полям
        System.out.println("Статическое поле: " + staticVariable);
        System.out.println("Статическое поле число: " + staticNumber);

        // НЕТ доступа к полям экземпляра без создания объекта
        // System.out.println(instanceVariable); // ОШИБКА!
        // System.out.println(this.instanceVariable); // ОШИБКА! this недоступен в статическом контексте

        // Доступ к полям экземпляра через объект
        VariableScopeDemo demo = new VariableScopeDemo();
        System.out.println("Поле экземпляра через объект: " + demo.instanceVariable);
    }

    // Метод, демонстрирующий переменные с одинаковыми именами в разных областях
    public void demonstrateShadowing() {
        System.out.println("=== Демонстрация затенения переменных ===");

        String message = "Внешняя переменная";
        System.out.println("1. " + message);

        {
            String message2 = "Переменная блока"; // Другое имя - нет конфликта
            System.out.println("2. " + message2);
            System.out.println("3. Доступ к внешней: " + message);

            // String message = "Затененная переменная"; // ОШИБКА! Нельзя затенять переменную из той же области
        }

        if (true) {
            String message3 = "Еще одна переменная блока";
            System.out.println("4. " + message3);
        }

        System.out.println("5. Внешняя переменная все еще доступна: " + message);
    }

    // Метод для демонстрации инициализации локальных переменных
    public void demonstrateLocalVariableInitialization() {
        System.out.println("=== Демонстрация инициализации локальных переменных ===");

        // Правильная инициализация
        int initialized = 42;
        String initializedString = "Инициализированная строка";

        System.out.println("Инициализированные переменные:");
        System.out.println("int: " + initialized);
        System.out.println("String: " + initializedString);

        // Условная инициализация
        int conditionallyInitialized;
        boolean condition = true;

        if (condition) {
            conditionallyInitialized = 100;
        } else {
            conditionallyInitialized = 200;
        }

        System.out.println("Условно инициализированная: " + conditionallyInitialized);

        // Демонстрация ошибок инициализации
        demonstrateInitializationErrors();
    }

    // Метод, показывающий типичные ошибки инициализации
    private void demonstrateInitializationErrors() {
        System.out.println("\nПримеры ошибок инициализации (закомментированы):");

        /*
        // ОШИБКА 1: Использование неинициализированной переменной
        int uninitialized;
        System.out.println(uninitialized); // ОШИБКА КОМПИЛЯЦИИ!

        // ОШИБКА 2: Возможно неинициализированная переменная
        int maybeUninitialized;
        if (Math.random() > 0.5) {
            maybeUninitialized = 42;
        }
        System.out.println(maybeUninitialized); // ОШИБКА КОМПИЛЯЦИИ!
        */

        System.out.println("• Локальные переменные не имеют значений по умолчанию");
        System.out.println("• Компилятор требует явной инициализации перед использованием");
        System.out.println("• Все возможные пути выполнения должны инициализировать переменную");
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация области видимости переменных ===\n");

        // Создание экземпляра для вызова методов
        VariableScopeDemo demo = new VariableScopeDemo();

        // Демонстрация различных аспектов области видимости
        demo.demonstrateLocalVariables();
        System.out.println();

        demo.demonstrateParameterScope("Тестовый параметр", 777);
        System.out.println();

        demo.demonstrateNameConflict("Параметр с конфликтным именем", 888);
        System.out.println();

        demo.demonstrateBlockScope();
        System.out.println();

        demonstrateStaticMethodScope();
        System.out.println();

        demo.demonstrateShadowing();
        System.out.println();

        demo.demonstrateLocalVariableInitialization();

        System.out.println("\n=== Ключевые правила области видимости ===");
        System.out.println("• Локальные переменные видны только в своем блоке/методе");
        System.out.println("• Параметры методов ведут себя как локальные переменные");
        System.out.println("• Поля класса доступны во всех методах экземпляра");
        System.out.println("• Статические поля доступны в статических методах");
        System.out.println("• Используйте 'this' для разрешения конфликтов имен");
        System.out.println("• Локальные переменные должны быть инициализированы перед использованием");
    }
}
