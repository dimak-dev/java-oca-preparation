package com.ru.oca.methodoverloading;

/**
 * Демонстрация перегрузки методов в Java.
 * Показывает различные способы перегрузки методов, правила выбора подходящего метода
 * компилятором и отличия от переопределения методов.
 */
public class MethodOverloadingDemo {

    /**
     * Демонстрация базовой перегрузки методов с различными типами параметров
     */
    public void demonstrateBasicOverloading() {
        System.out.println("=== Базовая перегрузка методов ===");

        // Вызов различных перегруженных версий метода print
        print(42);                    // int версия
        print(3.14);                  // double версия
        print("Hello World");         // String версия
        print(true);                  // boolean версия
        print('A');                   // char версия

        System.out.println();
    }

    // Перегруженные версии метода print с различными типами параметров
    public void print(int value) {
        System.out.println("int версия: " + value);
    }

    public void print(double value) {
        System.out.println("double версия: " + value);
    }

    public void print(String value) {
        System.out.println("String версия: " + value);
    }

    public void print(boolean value) {
        System.out.println("boolean версия: " + value);
    }

    public void print(char value) {
        System.out.println("char версия: " + value);
    }

    /**
     * Демонстрация перегрузки методов с различным количеством параметров
     */
    public void demonstrateParameterCountOverloading() {
        System.out.println("=== Перегрузка по количеству параметров ===");

        add(5, 3);                    // 2 параметра
        add(5, 3, 2);                 // 3 параметра
        add(5, 3, 2, 1);              // 4 параметра

        System.out.println();
    }

    // Перегруженные версии метода add с различным количеством параметров
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("Сумма двух чисел: " + a + " + " + b + " = " + result);
        return result;
    }

    public int add(int a, int b, int c) {
        int result = a + b + c;
        System.out.println("Сумма трех чисел: " + a + " + " + b + " + " + c + " = " + result);
        return result;
    }

    public int add(int a, int b, int c, int d) {
        int result = a + b + c + d;
        System.out.println("Сумма четырех чисел: " + a + " + " + b + " + " + c + " + " + d + " = " + result);
        return result;
    }

    /**
     * Демонстрация перегрузки методов с различным порядком параметров
     */
    public void demonstrateParameterOrderOverloading() {
        System.out.println("=== Перегрузка по порядку параметров ===");

        processData("John", 25);       // String, int
        processData(25, "John");       // int, String

        System.out.println();
    }

    // Перегруженные версии с различным порядком параметров
    public void processData(String name, int age) {
        System.out.println("Обработка данных (String, int): Имя = " + name + ", Возраст = " + age);
    }

    public void processData(int age, String name) {
        System.out.println("Обработка данных (int, String): Возраст = " + age + ", Имя = " + name);
    }

    /**
     * Демонстрация автоматического приведения типов при выборе перегруженного метода
     */
    public void demonstrateTypePromotionInOverloading() {
        System.out.println("=== Автоматическое приведение типов ===");

        byte b = 10;
        short s = 20;
        char c = 'A';

        // Будут вызваны методы с подходящими типами или с приведением типов
        processNumber(b);              // byte -> int (приведение)
        processNumber(s);              // short -> int (приведение)
        processNumber(c);              // char -> int (приведение)
        processNumber(30);             // точное совпадение int
        processNumber(40L);            // long версия
        processNumber(50.0f);          // float версия
        processNumber(60.0);           // double версия

        System.out.println();
    }

    // Перегруженные версии для демонстрации приведения типов
    public void processNumber(int number) {
        System.out.println("int версия: " + number + " (тип: int)");
    }

    public void processNumber(long number) {
        System.out.println("long версия: " + number + " (тип: long)");
    }

    public void processNumber(float number) {
        System.out.println("float версия: " + number + " (тип: float)");
    }

    public void processNumber(double number) {
        System.out.println("double версия: " + number + " (тип: double)");
    }

    /**
     * Демонстрация перегрузки с использованием varargs
     */
    public void demonstrateVarargsOverloading() {
        System.out.println("=== Перегрузка с varargs ===");

        calculateSum();                // varargs с 0 элементов
        calculateSum(1);               // может вызвать int версию или varargs
        calculateSum(1, 2);            // varargs
        calculateSum(1, 2, 3, 4, 5);   // varargs

        System.out.println();
    }

    // Перегруженные версии с varargs
    public int calculateSum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Varargs версия: Сумма " + numbers.length + " чисел = " + sum);
        return sum;
    }

    // Специальная версия для одного параметра (будет выбрана вместо varargs для одного аргумента)
    public int calculateSum(int number) {
        System.out.println("Специальная версия для одного числа: " + number);
        return number;
    }

    /**
     * Демонстрация перегрузки конструкторов
     */
    public void demonstrateConstructorOverloading() {
        System.out.println("=== Перегрузка конструкторов ===");

        // Создание объектов с использованием различных конструкторов
        Student student1 = new Student();
        Student student2 = new Student("Alice");
        Student student3 = new Student("Bob", 20);
        Student student4 = new Student("Charlie", 21, "Computer Science");

        System.out.println("Студент 1: " + student1);
        System.out.println("Студент 2: " + student2);
        System.out.println("Студент 3: " + student3);
        System.out.println("Студент 4: " + student4);

        System.out.println();
    }

    /**
     * Демонстрация неоднозначности при перегрузке методов
     */
    public void demonstrateAmbiguityInOverloading() {
        System.out.println("=== Неоднозначность в перегрузке ===");

        // Эти вызовы работают нормально
        processValues(1, 2.0);         // int, double
        processValues(1.0, 2);         // double, int

        // Следующий вызов был бы неоднозначным и не скомпилировался бы:
        // processValues(1, 2);        // Ошибка: неоднозначность между (int, double) и (double, int)

        System.out.println();
    }

    public void processValues(int a, double b) {
        System.out.println("Версия (int, double): " + a + ", " + b);
    }

    public void processValues(double a, int b) {
        System.out.println("Версия (double, int): " + a + ", " + b);
    }

    /**
     * Демонстрация отличий перегрузки от переопределения
     */
    public void demonstrateOverloadingVsOverriding() {
        System.out.println("=== Перегрузка vs Переопределение ===");

        System.out.println("Перегрузка происходит в одном классе:");
        System.out.println("- Различные параметры");
        System.out.println("- Один и тот же класс");
        System.out.println("- Определяется во время компиляции (статическое связывание)");

        System.out.println("\nПереопределение происходит в иерархии классов:");
        System.out.println("- Одинаковые параметры");
        System.out.println("- Родительский и дочерний классы");
        System.out.println("- Определяется во время выполнения (динамическое связывание)");

        System.out.println();
    }

    // Вспомогательный класс для демонстрации перегрузки конструкторов
    public static class Student {
        private String name;
        private int age;
        private String major;

        // Конструктор по умолчанию
        public Student() {
            this("Unknown", 0, "Undeclared");
            System.out.println("Вызван конструктор по умолчанию");
        }

        // Конструктор с именем
        public Student(String name) {
            this(name, 0, "Undeclared");
            System.out.println("Вызван конструктор с именем");
        }

        // Конструктор с именем и возрастом
        public Student(String name, int age) {
            this(name, age, "Undeclared");
            System.out.println("Вызван конструктор с именем и возрастом");
        }

        // Конструктор со всеми параметрами
        public Student(String name, int age, String major) {
            this.name = name;
            this.age = age;
            this.major = major;
            System.out.println("Вызван полный конструктор");
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", major='" + major + "'}";
        }
    }

    /**
     * Главный метод для демонстрации всех примеров
     */
    public static void main(String[] args) {
        MethodOverloadingDemo demo = new MethodOverloadingDemo();

        demo.demonstrateBasicOverloading();
        demo.demonstrateParameterCountOverloading();
        demo.demonstrateParameterOrderOverloading();
        demo.demonstrateTypePromotionInOverloading();
        demo.demonstrateVarargsOverloading();
        demo.demonstrateConstructorOverloading();
        demo.demonstrateAmbiguityInOverloading();
        demo.demonstrateOverloadingVsOverriding();
    }
}
