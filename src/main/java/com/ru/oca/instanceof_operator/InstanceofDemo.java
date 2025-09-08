package com.ru.oca.instanceof_operator;

/**
 * Демонстрация оператора instanceof в Java.
 * Показывает проверку типов в иерархии наследования, особенности работы
 * со ссылками и возможные исключения при использовании instanceof.
 */
public class InstanceofDemo {

    /**
     * Демонстрация базового использования оператора instanceof
     */
    public void demonstrateBasicInstanceof() {
        System.out.println("=== Базовое использование instanceof ===");

        String str = "Hello World";
        Integer num = 42;
        Object obj = "Это тоже строка";

        // Проверка точного типа
        System.out.println("str instanceof String: " + (str instanceof String));         // true
        System.out.println("num instanceof Integer: " + (num instanceof Integer));      // true
        System.out.println("obj instanceof String: " + (obj instanceof String));       // true
        System.out.println("obj instanceof Object: " + (obj instanceof Object));       // true

        // Проверка неподходящих типов невозможна
//        System.out.println("str instanceof Integer: " + (str instanceof Integer));
//        System.out.println("num instanceof String: " + (num instanceof String));

        System.out.println();
    }

    /**
     * Демонстрация instanceof с иерархией наследования
     */
    public void demonstrateInheritanceInstanceof() {
        System.out.println("=== instanceof с наследованием ===");

        Animal animal = new Animal("Животное");
        Dog dog = new Dog("Рекс", "Овчарка");
        Cat cat = new Cat("Мурка", "Серый");

        // Прямые проверки типов
        System.out.println("animal instanceof Animal: " + (animal instanceof Animal));   // true
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));             // true
        System.out.println("cat instanceof Cat: " + (cat instanceof Cat));             // true

        // Проверки с родительским классом
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal));       // true
        System.out.println("cat instanceof Animal: " + (cat instanceof Animal));       // true

        // Проверки между "братскими" классами невозможна
//        System.out.println("dog instanceof Cat: " + (dog instanceof Cat));
//        System.out.println("cat instanceof Dog: " + (cat instanceof Dog));

        // Проверка с Object (все объекты наследуют от Object)
        System.out.println("animal instanceof Object: " + (animal instanceof Object)); // true
        System.out.println("dog instanceof Object: " + (dog instanceof Object));       // true

        System.out.println();
    }

    /**
     * Демонстрация instanceof с полиморфизмом
     */
    public void demonstratePolymorphicInstanceof() {
        System.out.println("=== instanceof с полиморфизмом ===");

        // Создание массива с полиморфными ссылками
        Animal[] animals = {
                new Animal("Обычное животное"),
                new Dog("Бобик", "Лабрадор"),
                new Cat("Васька", "Рыжий"),
                new Dog("Шарик", "Дворняжка")
        };

        System.out.println("Анализ массива животных:");
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];

            System.out.println("Элемент " + i + " (" + animal.getName() + "):");
            System.out.println("  instanceof Animal: " + (animal instanceof Animal));
            System.out.println("  instanceof Dog: " + (animal instanceof Dog));
            System.out.println("  instanceof Cat: " + (animal instanceof Cat));

            // Безопасное приведение типов с instanceof
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                System.out.println("  Порода собаки: " + dog.getBreed());
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                System.out.println("  Цвет кота: " + cat.getColor());
            }
            System.out.println();
        }
    }

    /**
     * Демонстрация instanceof с null
     */
    public void demonstrateInstanceofWithNull() {
        System.out.println("=== instanceof с null ===");

        String nullString = null;
        Object nullObject = null;
        Animal nullAnimal = null;

        // instanceof с null всегда возвращает false
        System.out.println("null instanceof String: " + (nullString instanceof String));     // false
        System.out.println("null instanceof Object: " + (nullObject instanceof Object));     // false
        System.out.println("null instanceof Animal: " + (nullAnimal instanceof Animal));     // false

        // Это безопасно - не вызывает NullPointerException
        System.out.println("nullString проверен без исключения");

        System.out.println();
    }

    /**
     * Демонстрация instanceof с интерфейсами
     */
    public void demonstrateInstanceofWithInterfaces() {
        System.out.println("=== instanceof с интерфейсами ===");

        FlyingBird bird = new FlyingBird("Воробей");
        SwimmingFish fish = new SwimmingFish("Карп");
        Amphibian frog = new Amphibian("Лягушка");

        System.out.println("Проверки с интерфейсами:");

        // Проверка реализации интерфейсов
        System.out.println("bird instanceof Flyable: " + (bird instanceof Flyable));       // true
        System.out.println("fish instanceof Swimmable: " + (fish instanceof Swimmable));   // true
        System.out.println("frog instanceof Flyable: " + (frog instanceof Flyable));       // true
        System.out.println("frog instanceof Swimmable: " + (frog instanceof Swimmable));   // true

        // Проверка класса и интерфейса одновременно
        System.out.println("bird instanceof Animal: " + (bird instanceof Animal));         // true
        System.out.println("fish instanceof Animal: " + (fish instanceof Animal));         // true

        System.out.println();
    }

    /**
     * Демонстрация практического использования instanceof
     */
    public void demonstratePracticalUsage() {
        System.out.println("=== Практическое использование instanceof ===");

        Object[] mixedArray = {
                "Строка",
                42,
                new Dog("Рекс", "Овчарка"),
                3.14,
                new Cat("Мурка", "Белый"),
                true
        };

        System.out.println("Анализ смешанного массива:");

        for (Object obj : mixedArray) {
            System.out.print("Объект: " + obj + " -> ");

            if (obj instanceof String) {
                String str = (String) obj;
                System.out.println("Строка длиной " + str.length());
            } else if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                System.out.println("Целое число: " + (num > 0 ? "положительное" : "отрицательное"));
            } else if (obj instanceof Double) {
                Double dbl = (Double) obj;
                System.out.println("Вещественное число: " + dbl);
            } else if (obj instanceof Dog) {
                Dog dog = (Dog) obj;
                System.out.println("Собака породы " + dog.getBreed());
            } else if (obj instanceof Cat) {
                Cat cat = (Cat) obj;
                System.out.println("Кот цвета " + cat.getColor());
            } else if (obj instanceof Boolean) {
                Boolean bool = (Boolean) obj;
                System.out.println("Логическое значение: " + bool);
            } else {
                System.out.println("Неизвестный тип: " + obj.getClass().getSimpleName());
            }
        }

        System.out.println();
    }

    /**
     * Демонстрация ошибок при неправильном использовании instanceof
     */
    public void demonstrateInstanceofPitfalls() {
        System.out.println("=== Потенциальные ошибки с instanceof ===");

        Object obj = "Это строка";

        // Правильное использование
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Корректное приведение: " + str.toUpperCase());
        }

        // Демонстрация того, что произойдет без проверки instanceof
        try {
            // Предположим, мы не проверили тип
            obj = 42; // Теперь obj содержит Integer
            String str = (String) obj; // ClassCastException!
            System.out.println("Этот код не выполнится");
        } catch (ClassCastException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
        }

        // Правильный способ с проверкой
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Безопасное приведение: " + str);
        } else {
            System.out.println("obj не является строкой, это " + obj.getClass().getSimpleName());
        }

        System.out.println();
    }

    // Базовый класс для демонстрации
    public static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void makeSound() {
            System.out.println(name + " издает звук");
        }
    }

    // Производные классы
    public static class Dog extends Animal {
        private String breed;

        public Dog(String name, String breed) {
            super(name);
            this.breed = breed;
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public void makeSound() {
            System.out.println(name + " лает: Гав-гав!");
        }
    }

    public static class Cat extends Animal {
        private String color;

        public Cat(String name, String color) {
            super(name);
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        @Override
        public void makeSound() {
            System.out.println(name + " мяукает: Мяу-мяу!");
        }
    }

    // Интерфейсы для демонстрации
    public interface Flyable {
        void fly();
    }

    public interface Swimmable {
        void swim();
    }

    // Классы, реализующие интерфейсы
    public static class FlyingBird extends Animal implements Flyable {
        public FlyingBird(String name) {
            super(name);
        }

        @Override
        public void fly() {
            System.out.println(name + " летает");
        }
    }

    public static class SwimmingFish extends Animal implements Swimmable {
        public SwimmingFish(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println(name + " плавает");
        }
    }

    public static class Amphibian extends Animal implements Flyable, Swimmable {
        public Amphibian(String name) {
            super(name);
        }

        @Override
        public void fly() {
            System.out.println(name + " прыгает (как будто летает)");
        }

        @Override
        public void swim() {
            System.out.println(name + " плавает");
        }
    }

    /**
     * Главный метод для демонстрации всех примеров
     */
    public static void main(String[] args) {
        InstanceofDemo demo = new InstanceofDemo();

        demo.demonstrateBasicInstanceof();
        demo.demonstrateInheritanceInstanceof();
        demo.demonstratePolymorphicInstanceof();
        demo.demonstrateInstanceofWithNull();
        demo.demonstrateInstanceofWithInterfaces();
        demo.demonstratePracticalUsage();
        demo.demonstrateInstanceofPitfalls();
    }
}
