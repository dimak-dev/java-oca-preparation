package com.ru.oca.inheritance;

/**
 * Демонстрация наследования в Java.
 * Показывает наследование классов, доступ к членам родительского класса,
 * переопределение методов и использование ключевого слова super.
 */
public class InheritanceDemo {

    /**
     * Демонстрация базового наследования
     */
    public void demonstrateBasicInheritance() {
        System.out.println("=== Базовое наследование ===");

        // Создание объектов базового и производного классов
        Animal animal = new Animal("Животное", 5);
        Dog dog = new Dog("Рекс", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Серый");

        System.out.println("Базовый класс:");
        animal.displayInfo();
        animal.makeSound();

        System.out.println("\nПроизводный класс Dog:");
        dog.displayInfo();
        dog.makeSound();
        dog.wagTail();

        System.out.println("\nПроизводный класс Cat:");
        cat.displayInfo();
        cat.makeSound();
        cat.purr();

        System.out.println();
    }

    /**
     * Демонстрация переопределения методов
     */
    public void demonstrateMethodOverriding() {
        System.out.println("=== Переопределение методов ===");

        Animal[] animals = {
            new Animal("Обычное животное", 1),
            new Dog("Бобик", 4, "Лабрадор"),
            new Cat("Васька", 3, "Рыжий")
        };

        for (Animal animal : animals) {
            System.out.print(animal.getName() + ": ");
            animal.makeSound(); // Полиморфное поведение
        }

        System.out.println();
    }

    /**
     * Демонстрация использования super
     */
    public void demonstrateSuperUsage() {
        System.out.println("=== Использование super ===");

        // Создание объекта, который демонстрирует вызов super в конструкторе и методах
        SuperDog superDog = new SuperDog("Супер-Пёс", 2, "Хаски", "Спасение");
        superDog.displayInfo();
        superDog.makeSound();
        superDog.performSpecialAction();

        System.out.println();
    }

    /**
     * Демонстрация доступа к полям и методам родительского класса
     */
    public void demonstrateAccessToParentMembers() {
        System.out.println("=== Доступ к членам родительского класса ===");

        AccessDemo demo = new AccessDemo();
        demo.demonstrateAccess();

        System.out.println();
    }

    /**
     * Демонстрация иерархии классов и множественного наследования
     */
    public void demonstrateClassHierarchy() {
        System.out.println("=== Иерархия классов ===");

        Vehicle vehicle = new Vehicle("Транспорт", 2020);
        Car car = new Car("Автомобиль", 2022, 4);
        ElectricCar eCar = new ElectricCar("Tesla", 2023, 4, 500);

        System.out.println("Иерархия: Vehicle -> Car -> ElectricCar");

        vehicle.displayInfo();
        car.displayInfo();
        eCar.displayInfo();

        // Демонстрация вызова методов по иерархии
        eCar.start(); // Переопределенный метод
        eCar.charge(); // Собственный метод

        System.out.println();
    }

    // Базовый класс Animal
    public static class Animal {
        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("Вызван конструктор Animal");
        }

        public void displayInfo() {
            System.out.println("Животное: " + name + ", возраст: " + age + " лет");
        }

        public void makeSound() {
            System.out.println("Животное издает звук");
        }

        public void move() {
            System.out.println(name + " передвигается");
        }

        // Геттеры
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Сеттеры
        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    // Производный класс Dog
    public static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age); // Вызов конструктора родительского класса
            this.breed = breed;
            System.out.println("Вызван конструктор Dog");
        }

        @Override
        public void displayInfo() {
            super.displayInfo(); // Вызов метода родительского класса
            System.out.println("Порода: " + breed);
        }

        @Override
        public void makeSound() {
            System.out.println("Гав-гав!");
        }

        @Override
        public void move() {
            System.out.println(name + " бегает и прыгает");
        }

        // Собственный метод
        public void wagTail() {
            System.out.println(name + " виляет хвостом");
        }

        public String getBreed() {
            return breed;
        }
    }

    // Производный класс Cat
    public static class Cat extends Animal {
        private String color;

        public Cat(String name, int age, String color) {
            super(name, age);
            this.color = color;
            System.out.println("Вызван конструктор Cat");
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Цвет: " + color);
        }

        @Override
        public void makeSound() {
            System.out.println("Мяу-мяу!");
        }

        @Override
        public void move() {
            System.out.println(name + " грациозно передвигается");
        }

        // Собственный метод
        public void purr() {
            System.out.println(name + " мурлычет");
        }

        public String getColor() {
            return color;
        }
    }

    // Дополнительный класс для демонстрации super
    public static class SuperDog extends Dog {
        private String specialAbility;

        public SuperDog(String name, int age, String breed, String specialAbility) {
            super(name, age, breed); // Вызов конструктора Dog
            this.specialAbility = specialAbility;
            System.out.println("Вызван конструктор SuperDog");
        }

        @Override
        public void makeSound() {
            System.out.print("Супер-звук: ");
            super.makeSound(); // Вызов метода родительского класса
            System.out.println("(с особой силой!)");
        }

        public void performSpecialAction() {
            System.out.println(name + " выполняет специальную способность: " + specialAbility);
        }
    }

    // Класс для демонстрации доступа к полям родительского класса
    public static class AccessDemo extends Animal {
        public AccessDemo() {
            super("Демо", 0);
        }

        public void demonstrateAccess() {
            System.out.println("Доступ к protected полям родительского класса:");
            System.out.println("name = " + name); // protected поле доступно
            System.out.println("age = " + age);   // protected поле доступно

            // Изменение protected полей
            name = "Измененное имя";
            age = 10;

            System.out.println("После изменения:");
            displayInfo(); // Вызов метода родительского класса

            System.out.println("Вызов собственного метода:");
            customMethod();
        }

        private void customMethod() {
            System.out.println("Это собственный метод дочернего класса");
        }
    }

    // Дополнительная иерархия для демонстрации
    public static class Vehicle {
        protected String name;
        protected int year;

        public Vehicle(String name, int year) {
            this.name = name;
            this.year = year;
        }

        public void displayInfo() {
            System.out.println("Транспорт: " + name + " (" + year + " год)");
        }

        public void start() {
            System.out.println(name + " запускается");
        }
    }

    public static class Car extends Vehicle {
        protected int wheels;

        public Car(String name, int year, int wheels) {
            super(name, year);
            this.wheels = wheels;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Количество колес: " + wheels);
        }

        @Override
        public void start() {
            System.out.println("Автомобиль " + name + " заводится с ключа");
        }
    }

    public static class ElectricCar extends Car {
        private int batteryCapacity;

        public ElectricCar(String name, int year, int wheels, int batteryCapacity) {
            super(name, year, wheels);
            this.batteryCapacity = batteryCapacity;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Емкость батареи: " + batteryCapacity + " км");
        }

        @Override
        public void start() {
            System.out.println("Электромобиль " + name + " включается бесшумно");
        }

        public void charge() {
            System.out.println(name + " заряжается");
        }
    }

    /**
     * Главный метод для демонстрации всех примеров
     */
    public static void main(String[] args) {
        InheritanceDemo demo = new InheritanceDemo();

        demo.demonstrateBasicInheritance();
        demo.demonstrateMethodOverriding();
        demo.demonstrateSuperUsage();
        demo.demonstrateAccessToParentMembers();
        demo.demonstrateClassHierarchy();
    }
}
