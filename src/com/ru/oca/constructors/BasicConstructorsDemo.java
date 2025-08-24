package com.ru.oca.constructors;

/**
 * Демонстрация базовых конструкторов в Java.
 * Показывает различные типы конструкторов и их использование.
 */
public class BasicConstructorsDemo {

    // Поля класса
    private String name;
    private int age;
    private boolean isActive;

    // Конструктор по умолчанию
    // Если не определить никаких конструкторов, компилятор создаст такой автоматически
    public BasicConstructorsDemo() {
        this.name = "Unknown";
        this.age = 0;
        this.isActive = true;
        System.out.println("Вызван конструктор по умолчанию");
    }

    // Параметризованный конструктор с одним параметром
    public BasicConstructorsDemo(String name) {
        this.name = name;
        this.age = 0;
        this.isActive = true;
        System.out.println("Вызван конструктор с параметром name: " + name);
    }

    // Параметризованный конструктор с двумя параметрами
    public BasicConstructorsDemo(String name, int age) {
        this.name = name;
        this.age = age;
        this.isActive = true;
        System.out.println("Вызван конструктор с параметрами name: " + name + ", age: " + age);
    }

    // Полный конструктор со всеми параметрами
    public BasicConstructorsDemo(String name, int age, boolean isActive) {
        // Использование this для избежания конфликта имен
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        System.out.println("Вызван полный конструктор");
    }

    // Геттеры для демонстрации
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "BasicConstructorsDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }

    // Демонстрация использования различных конструкторов
    public static void main(String[] args) {
        System.out.println("=== Демонстрация базовых конструкторов ===");

        // Использование конструктора по умолчанию
        BasicConstructorsDemo demo1 = new BasicConstructorsDemo();
        System.out.println("demo1: " + demo1);

        // Использование конструктора с одним параметром
        BasicConstructorsDemo demo2 = new BasicConstructorsDemo("Алиса");
        System.out.println("demo2: " + demo2);

        // Использование конструктора с двумя параметрами
        BasicConstructorsDemo demo3 = new BasicConstructorsDemo("Боб", 25);
        System.out.println("demo3: " + demo3);

        // Использование полного конструктора
        BasicConstructorsDemo demo4 = new BasicConstructorsDemo("Чарли", 30, false);
        System.out.println("demo4: " + demo4);

        System.out.println("\n=== Важные моменты ===");
        System.out.println("1. Имя конструктора совпадает с именем класса");
        System.out.println("2. Конструкторы не имеют возвращаемого типа");
        System.out.println("3. Если не определить конструкторы, компилятор создаст конструктор по умолчанию");
        System.out.println("4. При создании параметризованного конструктора конструктор по умолчанию не создается автоматически");
    }
}
