package com.ru.oca.ooconcepts;

/**
 * Демонстрация наследования и полиморфизма в Java.
 * Показывает иерархию классов, переопределение методов и полиморфное поведение.
 */
public class InheritanceDemo {

    // Базовый класс Animal
    public static class Animal {
        protected String name;
        protected int age;
        protected String species;

        // Конструктор базового класса
        public Animal(String name, int age, String species) {
            this.name = name;
            this.age = age;
            this.species = species;
        }

        // Метод, который будет переопределен в наследниках
        public void makeSound() {
            System.out.println(name + " makes a generic animal sound");
        }

        // Метод, который будет использоваться всеми наследниками
        public void eat() {
            System.out.println(name + " is eating");
        }

        public void sleep() {
            System.out.println(name + " is sleeping");
        }

        // Методы доступа
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSpecies() {
            return species;
        }

        // Общий метод для всех животных
        public void showInfo() {
            System.out.println("Name: " + name + ", Age: " + age + ", Species: " + species);
        }

        @Override
        public String toString() {
            return species + " named " + name + " (age " + age + ")";
        }
    }

    // Класс Dog наследует от Animal
    public static class Dog extends Animal {
        private String breed;
        private boolean isTrainedToFetch;

        // Конструктор использует super() для вызова конструктора родителя
        public Dog(String name, int age, String breed) {
            super(name, age, "Dog"); // Вызов конструктора родительского класса
            this.breed = breed;
            this.isTrainedToFetch = false;
        }

        // Переопределение метода родительского класса
        @Override
        public void makeSound() {
            System.out.println(name + " barks: Woof! Woof!");
        }

        // Переопределение с расширением функциональности
        @Override
        public void eat() {
            super.eat(); // Вызов метода родительского класса
            System.out.println(name + " wags tail while eating");
        }

        // Дополнительные методы, специфичные для Dog
        public void fetch() {
            if (isTrainedToFetch) {
                System.out.println(name + " fetches the ball!");
            } else {
                System.out.println(name + " doesn't know how to fetch yet");
            }
        }

        public void trainToFetch() {
            isTrainedToFetch = true;
            System.out.println(name + " has been trained to fetch!");
        }

        public String getBreed() {
            return breed;
        }

        @Override
        public void showInfo() {
            super.showInfo(); // Используем родительский метод
            System.out.println("Breed: " + breed + ", Trained to fetch: " + isTrainedToFetch);
        }
    }

    // Класс Cat наследует от Animal
    public static class Cat extends Animal {
        private boolean isIndoor;
        private int livesLeft;

        public Cat(String name, int age, boolean isIndoor) {
            super(name, age, "Cat");
            this.isIndoor = isIndoor;
            this.livesLeft = 9; // У кошек 9 жизней
        }

        @Override
        public void makeSound() {
            System.out.println(name + " meows: Meow! Meow!");
        }

        @Override
        public void eat() {
            super.eat();
            System.out.println(name + " purrs contentedly");
        }

        // Специфичные методы для кошки
        public void climb() {
            System.out.println(name + " climbs up high");
        }

        public void useLives() {
            if (livesLeft > 0) {
                livesLeft--;
                System.out.println(name + " used one life. Lives left: " + livesLeft);
            } else {
                System.out.println(name + " has no lives left!");
            }
        }

        @Override
        public void showInfo() {
            super.showInfo();
            System.out.println("Indoor: " + isIndoor + ", Lives left: " + livesLeft);
        }
    }

    // Класс Bird наследует от Animal
    public static class Bird extends Animal {
        private boolean canFly;
        private double wingSpan;

        public Bird(String name, int age, boolean canFly, double wingSpan) {
            super(name, age, "Bird");
            this.canFly = canFly;
            this.wingSpan = wingSpan;
        }

        @Override
        public void makeSound() {
            System.out.println(name + " chirps: Tweet! Tweet!");
        }

        public void fly() {
            if (canFly) {
                System.out.println(name + " soars through the sky with wingspan of " + wingSpan + " meters");
            } else {
                System.out.println(name + " cannot fly");
            }
        }

        @Override
        public void showInfo() {
            super.showInfo();
            System.out.println("Can fly: " + canFly + ", Wing span: " + wingSpan + "m");
        }
    }

    // Демонстрация полиморфизма через массив Animal
    public static void demonstratePolymorphism(Animal[] animals) {
        System.out.println("\n=== Демонстрация полиморфизма ===");

        for (Animal animal : animals) {
            System.out.println("\nProcessing: " + animal);

            // Полиморфный вызов - метод выбирается во время выполнения
            animal.makeSound();    // Вызывается переопределенный метод
            animal.eat();          // Может быть переопределен или использован базовый
            animal.showInfo();     // Показывает информацию в зависимости от типа объекта

            // Проверка типа и приведение для специфичных методов
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.fetch();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                cat.climb();
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                bird.fly();
            }

            System.out.println("---");
        }
    }

    // Демонстрация переопределения и вызова родительских методов
    public static void demonstrateMethodOverriding() {
        System.out.println("\n=== Демонстрация переопределения методов ===");

        Animal genericAnimal = new Animal("Generic", 5, "Unknown");
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");

        System.out.println("Базовый Animal:");
        genericAnimal.makeSound();
        genericAnimal.eat();

        System.out.println("\nPереопределенные методы в Dog:");
        dog.makeSound();  // Переопределенная версия
        dog.eat();        // Переопределенная версия с вызовом super.eat()
    }

    // Главный метод для демонстрации
    public static void main(String[] args) {
        System.out.println("=== Демонстрация наследования и полиморфизма ===");

        // Создание объектов разных классов
        Dog dog1 = new Dog("Max", 4, "German Shepherd");
        Dog dog2 = new Dog("Luna", 2, "Border Collie");
        Cat cat1 = new Cat("Whiskers", 6, true);
        Cat cat2 = new Cat("Shadow", 3, false);
        Bird bird1 = new Bird("Eagle", 8, true, 2.3);
        Bird bird2 = new Bird("Penguin", 5, false, 0.8);

        System.out.println("\n=== Демонстрация специфичных методов ===");

        // Демонстрация специфичных методов каждого класса
        dog1.trainToFetch();
        dog1.fetch();
        dog2.fetch(); // Не обучен

        cat1.useLives();
        cat1.climb();

        bird1.fly();
        bird2.fly(); // Не может летать

        // Демонстрация переопределения
        demonstrateMethodOverriding();

        // Создание массива для демонстрации полиморфизма
        Animal[] animals = {dog1, cat1, bird1, dog2, cat2, bird2};

        // Полиморфная обработка массива
        demonstratePolymorphism(animals);

        System.out.println("\n=== Демонстрация IS-A отношений ===");

        // Демонстрация instanceof
        Animal someAnimal = new Dog("Test", 1, "Test Breed");

        System.out.println("someAnimal instanceof Animal: " + (someAnimal instanceof Animal));
        System.out.println("someAnimal instanceof Dog: " + (someAnimal instanceof Dog));
        System.out.println("someAnimal instanceof Cat: " + (someAnimal instanceof Cat));

        // Полиморфное присваивание
        Animal animalRef1 = dog1;  // Dog IS-A Animal
        Animal animalRef2 = cat1;  // Cat IS-A Animal
        Animal animalRef3 = bird1; // Bird IS-A Animal

        System.out.println("\nПолиморфное поведение через базовую ссылку:");
        animalRef1.makeSound(); // Вызовет Dog.makeSound()
        animalRef2.makeSound(); // Вызовет Cat.makeSound()
        animalRef3.makeSound(); // Вызовет Bird.makeSound()
    }
}
