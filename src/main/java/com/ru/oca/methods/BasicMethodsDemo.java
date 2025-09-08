package com.ru.oca.methods;

/**
 * Демонстрация основ работы с методами в Java.
 * Показывает различные способы объявления и вызова методов.
 */
public class BasicMethodsDemo {

    // Поле класса для демонстрации работы с методами экземпляра
    private String instanceField = "Instance Field";
    private static String staticField = "Static Field";

    // Статический метод без параметров
    public static void staticMethodNoParams() {
        System.out.println("Статический метод без параметров");
        System.out.println("Доступ к статическому полю: " + staticField);
        // System.out.println(instanceField); // ОШИБКА! Нет доступа к полям экземпляра
    }

    // Статический метод с параметрами и возвращаемым значением
    public static int staticMethodWithReturn(int a, int b) {
        System.out.println("Статический метод с параметрами: a=" + a + ", b=" + b);
        return a + b;
    }

    // Метод экземпляра без параметров
    public void instanceMethodNoParams() {
        System.out.println("Метод экземпляра без параметров");
        System.out.println("Доступ к полю экземпляра: " + instanceField);
        System.out.println("Доступ к статическому полю: " + staticField);
    }

    // Метод экземпляра с параметрами
    public String instanceMethodWithParams(String prefix, int number) {
        System.out.println("Метод экземпляра с параметрами: prefix=" + prefix + ", number=" + number);
        return prefix + ": " + number;
    }

    // Приватный метод (доступен только внутри класса)
    private void privateMethod() {
        System.out.println("Приватный метод - доступен только внутри класса");
    }

    // Метод, который вызывает приватный метод
    public void callPrivateMethod() {
        System.out.println("Вызов приватного метода из публичного:");
        privateMethod();
    }

    // Package-private метод (без модификатора доступа)
    void packagePrivateMethod() {
        System.out.println("Package-private метод - доступен в пределах пакета");
    }

    // Protected метод
    protected void protectedMethod() {
        System.out.println("Protected метод - доступен наследникам и в пределах пакета");
    }

    // Метод void с несколькими return
    public void methodWithMultipleReturns(int value) {
        if (value < 0) {
            System.out.println("Отрицательное значение");
            return; // Ранний выход
        }

        if (value == 0) {
            System.out.println("Нулевое значение");
            return; // Ранний выход
        }

        System.out.println("Положительное значение: " + value);
        // return; - необязательно в конце void метода
    }

    // Метод с возвращаемым значением и условной логикой
    public String getDescription(int code) {
        if (code == 1) {
            return "Код успеха";
        } else if (code == 2) {
            return "Код предупреждения";
        } else if (code == 3) {
            return "Код ошибки";
        } else {
            return "Неизвестный код"; // Все пути должны возвращать значение
        }
    }

    // Метод, демонстрирующий вызов других методов
    public void demonstrateMethodCalls() {
        System.out.println("=== Демонстрация вызовов методов ===");

        // Вызов методов текущего объекта
        instanceMethodNoParams();
        String result = instanceMethodWithParams("Результат", 42);
        System.out.println("Возвращенное значение: " + result);

        // Вызов через this (явно)
        this.callPrivateMethod();
        this.packagePrivateMethod();
        this.protectedMethod();

        // Вызов статических методов
        staticMethodNoParams();
        int sum = staticMethodWithReturn(10, 20);
        System.out.println("Сумма: " + sum);

        // Вызов методов с условной логикой
        methodWithMultipleReturns(-5);
        methodWithMultipleReturns(0);
        methodWithMultipleReturns(15);

        System.out.println("Описание кода 1: " + getDescription(1));
        System.out.println("Описание кода 99: " + getDescription(99));
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация основ методов ===\n");

        // Вызов статических методов (без создания объекта)
        System.out.println("1. Статические методы:");
        BasicMethodsDemo.staticMethodNoParams();
        int result = BasicMethodsDemo.staticMethodWithReturn(5, 3);
        System.out.println("Результат статического метода: " + result);

        System.out.println("\n2. Методы экземпляра:");
        // Создание объекта для вызова методов экземпляра
        BasicMethodsDemo demo = new BasicMethodsDemo();
        demo.instanceMethodNoParams();
        String instanceResult = demo.instanceMethodWithParams("Тест", 123);
        System.out.println("Результат метода экземпляра: " + instanceResult);

        System.out.println("\n3. Комплексная демонстрация:");
        demo.demonstrateMethodCalls();

        System.out.println("\n=== Важные принципы ===");
        System.out.println("• Статические методы вызываются через имя класса");
        System.out.println("• Методы экземпляра вызываются через объект");
        System.out.println("• Приватные методы доступны только внутри класса");
        System.out.println("• Все пути выполнения должны возвращать значение (для не-void методов)");
        System.out.println("• void методы могут содержать return для раннего выхода");
    }
}
