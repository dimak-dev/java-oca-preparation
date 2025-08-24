package com.ru.oca.constructors;

/**
 * Демонстрация цепочки вызовов конструкторов с использованием this() и super().
 * Показывает правила использования вызовов конструкторов в иерархии классов.
 */
public class ConstructorChainingDemo {

    // Базовый класс для демонстрации наследования
    static class Vehicle {
        protected String brand;
        protected int year;

        // Конструктор по умолчанию
        public Vehicle() {
            System.out.println("Vehicle(): Конструктор по умолчанию Vehicle");
            this.brand = "Unknown";
            this.year = 0;
        }

        // Параметризованный конструктор
        public Vehicle(String brand, int year) {
            System.out.println("Vehicle(String, int): Параметризованный конструктор Vehicle");
            this.brand = brand;
            this.year = year;
        }

        public String getInfo() {
            return "Vehicle: " + brand + " (" + year + ")";
        }
    }

    // Дочерний класс для демонстрации super()
    static class Car extends Vehicle {
        private String model;
        private int doors;

        // Конструктор по умолчанию - неявно вызывает super()
        public Car() {
            // Неявный вызов super() здесь
            System.out.println("Car(): Конструктор по умолчанию Car");
            this.model = "Unknown";
            this.doors = 4;
        }

        // Конструктор с явным вызовом super()
        public Car(String brand, int year, String model) {
            super(brand, year); // Явный вызов конструктора родительского класса
            System.out.println("Car(String, int, String): Конструктор Car с super()");
            this.model = model;
            this.doors = 4;
        }

        // Конструктор с вызовом this()
        public Car(String brand, int year, String model, int doors) {
            this(brand, year, model); // Вызов другого конструктора этого же класса
            System.out.println("Car(String, int, String, int): Конструктор Car с this()");
            this.doors = doors;
        }

        @Override
        public String getInfo() {
            return "Car: " + brand + " " + model + " (" + year + "), doors: " + doors;
        }
    }

    // Класс для демонстрации цепочки this()
    static class Person {
        private String firstName;
        private String lastName;
        private int age;
        private String email;

        // Базовый конструктор
        public Person(String firstName, String lastName, int age, String email) {
            System.out.println("Person(4 параметра): Полный конструктор");
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
        }

        // Конструктор с 3 параметрами - использует this() для вызова полного конструктора
        public Person(String firstName, String lastName, int age) {
            this(firstName, lastName, age, "not specified"); // Вызов полного конструктора
            System.out.println("Person(3 параметра): Конструктор с this()");
        }

        // Конструктор с 2 параметрами - создает цепочку вызовов
        public Person(String firstName, String lastName) {
            this(firstName, lastName, 0); // Вызов конструктора с 3 параметрами
            System.out.println("Person(2 параметра): Конструктор с this()");
        }

        // Конструктор с 1 параметром - продолжает цепочку
        public Person(String firstName) {
            this(firstName, "Unknown"); // Вызов конструктора с 2 параметрами
            System.out.println("Person(1 параметр): Конструктор с this()");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация цепочки конструкторов ===\n");

        // Демонстрация super()
        System.out.println("1. Создание Car с конструктором по умолчанию:");
        Car car1 = new Car();
        System.out.println("Результат: " + car1.getInfo());
        System.out.println();

        System.out.println("2. Создание Car с явным super():");
        Car car2 = new Car("Toyota", 2020, "Camry");
        System.out.println("Результат: " + car2.getInfo());
        System.out.println();

        System.out.println("3. Создание Car с this():");
        Car car3 = new Car("Honda", 2021, "Civic", 2);
        System.out.println("Результат: " + car3.getInfo());
        System.out.println();

        // Демонстрация цепочки this()
        System.out.println("4. Создание Person с цепочкой this():");
        Person person = new Person("Иван");
        System.out.println("Результат: " + person);
        System.out.println();

        System.out.println("=== Важные правила ===");
        System.out.println("1. this() и super() должны быть первой строкой в конструкторе");
        System.out.println("2. Нельзя использовать одновременно this() и super() в одном конструкторе");
        System.out.println("3. Если super() не вызван явно, компилятор добавляет super() автоматически");
        System.out.println("4. Цепочка this() может быть любой длины, но должна завершиться вызовом super()");
    }
}
