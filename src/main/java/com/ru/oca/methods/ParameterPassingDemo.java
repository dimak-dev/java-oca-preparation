package com.ru.oca.methods;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Демонстрация передачи параметров в методы Java.
 * Показывает различия между передачей примитивных типов и ссылок на объекты.
 */
public class ParameterPassingDemo {

    // Вспомогательный класс для демонстрации работы с объектами
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    // Демонстрация передачи примитивных типов по значению
    public static void modifyPrimitive(int number) {
        System.out.println("Внутри modifyPrimitive - исходное значение: " + number);
        number = 999; // Изменяется только локальная копия
        System.out.println("Внутри modifyPrimitive - измененное значение: " + number);
    }

    // Демонстрация передачи ссылки на объект
    public static void modifyObject(Person person) {
        System.out.println("Внутри modifyObject - исходный объект: " + person);
        person.setName("Измененное имя"); // Изменяется сам объект
        person.setAge(99);
        System.out.println("Внутри modifyObject - измененный объект: " + person);
    }

    // Демонстрация переприсваивания ссылки на объект
    public static void reassignObjectReference(Person person) {
        System.out.println("Внутри reassignObjectReference - исходный объект: " + person);
        person = new Person("Новый объект", 25); // Изменяется только локальная ссылка
        System.out.println("Внутри reassignObjectReference - новый объект: " + person);
    }

    // Демонстрация работы с массивами
    public static void modifyArray(int[] array) {
        System.out.println("Внутри modifyArray - исходный массив: " + Arrays.toString(array));
        array[0] = 999; // Изменяется элемент массива
        System.out.println("Внутри modifyArray - измененный массив: " + Arrays.toString(array));
    }

    // Демонстрация переприсваивания массива
    public static void reassignArray(int[] array) {
        System.out.println("Внутри reassignArray - исходный массив: " + Arrays.toString(array));
        array = new int[]{100, 200, 300}; // Изменяется только локальная ссылка
        System.out.println("Внутри reassignArray - новый массив: " + Arrays.toString(array));
    }

    // Демонстрация работы с коллекциями
    public static void modifyList(List<String> list) {
        System.out.println("Внутри modifyList - исходный список: " + list);
        list.add("Добавлено в методе"); // Изменяется сам объект списка
        if (!list.isEmpty()) {
            list.set(0, "Измененный элемент"); // Изменяется элемент списка
        }
        System.out.println("Внутри modifyList - измененный список: " + list);
    }

    // Демонстрация переприсваивания коллекции
    public static void reassignList(List<String> list) {
        System.out.println("Внутри reassignList - исходный список: " + list);
        list = new ArrayList<>(); // Изменяется только локальная ссылка
        list.add("Элемент нового списка");
        System.out.println("Внутри reassignList - новый список: " + list);
    }

    // Метод, возвращающий измененное значение примитива
    public static int incrementAndReturn(int number) {
        return number + 1;
    }

    // Метод, возвращающий новый объект
    public static Person createModifiedPerson(Person original) {
        return new Person(original.getName() + " (копия)", original.getAge() + 10);
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация передачи параметров ===\n");

        // 1. Передача примитивных типов
        System.out.println("1. Передача примитивных типов:");
        int originalNumber = 42;
        System.out.println("До вызова метода: " + originalNumber);
        modifyPrimitive(originalNumber);
        System.out.println("После вызова метода: " + originalNumber);
        System.out.println("Примитив НЕ изменился - Java передает по значению\n");

        // 2. Изменение примитива через возвращаемое значение
        System.out.println("2. Изменение через возвращаемое значение:");
        int number = 5;
        System.out.println("До: " + number);
        number = incrementAndReturn(number);
        System.out.println("После: " + number);
        System.out.println("Значение изменено через присвоение возвращаемого значения\n");

        // 3. Передача ссылки на объект и изменение объекта
        System.out.println("3. Изменение объекта через ссылку:");
        Person person = new Person("Иван", 30);
        System.out.println("До вызова метода: " + person);
        modifyObject(person);
        System.out.println("После вызова метода: " + person);
        System.out.println("Объект ИЗМЕНИЛСЯ - передается ссылка на объект\n");

        // 4. Переприсваивание ссылки на объект
        System.out.println("4. Переприсваивание ссылки на объект:");
        Person person2 = new Person("Мария", 25);
        System.out.println("До вызова метода: " + person2);
        reassignObjectReference(person2);
        System.out.println("После вызова метода: " + person2);
        System.out.println("Исходный объект НЕ изменился - переприсваивание влияет только на локальную ссылку\n");

        // 5. Создание нового объекта через возвращаемое значение
        System.out.println("5. Создание нового объекта:");
        Person original = new Person("Анна", 20);
        Person modified = createModifiedPerson(original);
        System.out.println("Исходный: " + original);
        System.out.println("Новый: " + modified);
        System.out.println("Созданы два разных объекта\n");

        // 6. Работа с массивами
        System.out.println("6. Изменение элементов массива:");
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("До вызова метода: " + Arrays.toString(originalArray));
        modifyArray(originalArray);
        System.out.println("После вызова метода: " + Arrays.toString(originalArray));
        System.out.println("Массив ИЗМЕНИЛСЯ - передается ссылка на массив\n");

        // 7. Переприсваивание массива
        System.out.println("7. Переприсваивание массива:");
        int[] array2 = {10, 20, 30};
        System.out.println("До вызова метода: " + Arrays.toString(array2));
        reassignArray(array2);
        System.out.println("После вызова метода: " + Arrays.toString(array2));
        System.out.println("Исходный массив НЕ изменился - переприсваивание влияет только на локальную ссылку\n");

        // 8. Работа с коллекциями
        System.out.println("8. Изменение коллекции:");
        List<String> originalList = new ArrayList<>();
        originalList.add("Элемент 1");
        originalList.add("Элемент 2");
        System.out.println("До вызова метода: " + originalList);
        modifyList(originalList);
        System.out.println("После вызова метода: " + originalList);
        System.out.println("Коллекция ИЗМЕНИЛАСЬ - передается ссылка на объект коллекции\n");

        // 9. Переприсваивание коллекции
        System.out.println("9. Переприсваивание коллекции:");
        List<String> list2 = new ArrayList<>();
        list2.add("Исходный элемент");
        System.out.println("До вызова метода: " + list2);
        reassignList(list2);
        System.out.println("После вызова метода: " + list2);
        System.out.println("Исходная коллекция НЕ изменилась - переприсваивание влияет только на локальную ссылку\n");

        System.out.println("=== Ключевые принципы ===");
        System.out.println("• Java ВСЕГДА передает параметры по значению");
        System.out.println("• Для примитивов передается копия значения");
        System.out.println("• Для объектов передается копия ссылки на объект");
        System.out.println("• Изменения объекта через ссылку видны снаружи");
        System.out.println("• Переприсваивание ссылки внутри метода не влияет на исходную переменную");
        System.out.println("• Для изменения примитивов используйте возвращаемые значения");
    }
}
