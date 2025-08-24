package com.ru.oca.basics;

/**
 * Демонстрация различных аспектов метода main в Java.
 * Показывает правильное объявление и использование точки входа в программу.
 */
public class MainMethodDemo {

    /**
     * Стандартный метод main - точка входа в Java приложение.
     * Обратите внимание на обязательные модификаторы и сигнатуру.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация метода main ===");

        // Проверяем наличие аргументов командной строки
        if (args.length > 0) {
            System.out.println("Получены аргументы командной строки:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("  args[" + i + "] = " + args[i]);
            }
        } else {
            System.out.println("Аргументы командной строки не переданы");
        }

        // Демонстрация вызова других методов из main
        MainMethodDemo demo = new MainMethodDemo();
        demo.demonstrateBasicSyntax();

        // Демонстрация статических методов (вызов без создания экземпляра)
        showStaticMethodCall();

        // Демонстрация области видимости
        demo.demonstrateScope();
    }

    /**
     * Демонстрация базового синтаксиса Java.
     */
    public void demonstrateBasicSyntax() {
        System.out.println("\n=== Базовый синтаксис ===");

        // Объявление и инициализация переменных
        int number = 42;
        String text = "Hello, Java!";
        boolean flag = true;

        // Вывод значений
        System.out.println("Число: " + number);
        System.out.println("Текст: " + text);
        System.out.println("Флаг: " + flag);

        // Условные конструкции
        if (number > 40) {
            System.out.println("Число больше 40");
        }

        // Циклы
        System.out.print("Счет: ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Статический метод - может быть вызван без создания экземпляра класса.
     */
    public static void showStaticMethodCall() {
        System.out.println("\n=== Статический метод ===");
        System.out.println("Этот метод вызван без создания экземпляра класса");
    }

    /**
     * Демонстрация различных областей видимости переменных.
     */
    public void demonstrateScope() {
        System.out.println("\n=== Область видимости ===");

        // Локальная переменная метода
        String methodVariable = "Переменная метода";
        System.out.println("Локальная переменная: " + methodVariable);

        // Блок кода с ограниченной областью видимости
        {
            String blockVariable = "Переменная блока";
            System.out.println("Переменная в блоке: " + blockVariable);
            // blockVariable доступна только в этом блоке
        }
        // blockVariable здесь уже недоступна

        // Вызов метода с параметрами
        processParameter("Параметр метода");
    }

    /**
     * Демонстрация параметров метода и их области видимости.
     *
     * @param parameter параметр метода (локальная область видимости)
     */
    private void processParameter(String parameter) {
        System.out.println("Обработка параметра: " + parameter);
        // parameter доступен только в этом методе
    }
}
