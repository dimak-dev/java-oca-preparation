package com.ru.oca.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Демонстрация основ работы с ArrayList в Java.
 * Показывает создание, инициализацию, добавление, удаление элементов и итерацию по ArrayList.
 */
public class BasicArrayListDemo {

    /**
     * Демонстрация создания ArrayList различными способами
     */
    public void demonstrateArrayListCreation() {
        System.out.println("=== Создание ArrayList ===");

        // Создание пустого ArrayList
        ArrayList<String> names = new ArrayList<>();
        System.out.println("Пустой ArrayList создан, размер: " + names.size());

        // Создание ArrayList с начальной емкостью
        ArrayList<Integer> numbers = new ArrayList<>(10);
        System.out.println("ArrayList с начальной емкостью 10 создан, размер: " + numbers.size());

        // Создание ArrayList из другой коллекции
        List<String> cities = Arrays.asList("Москва", "Санкт-Петербург", "Новосибирск");
        ArrayList<String> citiesList = new ArrayList<>(cities);
        System.out.println("ArrayList из коллекции: " + citiesList);

        // Использование интерфейса List (рекомендуемый подход)
        List<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Банан");
        System.out.println("ArrayList через интерфейс List: " + fruits);
    }

    /**
     * Демонстрация добавления элементов в ArrayList
     */
    public void demonstrateAddingElements() {
        System.out.println("\n=== Добавление элементов ===");

        List<String> colors = new ArrayList<>();

        // Добавление в конец списка
        colors.add("Красный");
        colors.add("Зеленый");
        colors.add("Синий");
        System.out.println("После добавления в конец: " + colors);

        // Добавление по индексу
        colors.add(1, "Желтый");
        System.out.println("После добавления по индексу 1: " + colors);

        // Добавление всех элементов из другой коллекции
        List<String> newColors = Arrays.asList("Фиолетовый", "Оранжевый");
        colors.addAll(newColors);
        System.out.println("После добавления коллекции: " + colors);

        // Добавление коллекции по определенному индексу
        colors.addAll(2, Arrays.asList("Розовый", "Серый"));
        System.out.println("После добавления коллекции по индексу 2: " + colors);
    }

    /**
     * Демонстрация доступа к элементам ArrayList
     */
    public void demonstrateElementAccess() {
        System.out.println("\n=== Доступ к элементам ===");

        List<String> animals = new ArrayList<>();
        animals.add("Кот");
        animals.add("Собака");
        animals.add("Птица");
        animals.add("Рыба");

        // Получение элемента по индексу
        String firstAnimal = animals.get(0);
        String lastAnimal = animals.get(animals.size() - 1);
        System.out.println("Первое животное: " + firstAnimal);
        System.out.println("Последнее животное: " + lastAnimal);

        // Изменение элемента по индексу
        String oldValue = animals.set(2, "Попугай");
        System.out.println("Заменили '" + oldValue + "' на '" + animals.get(2) + "'");
        System.out.println("Обновленный список: " + animals);

        // Проверка наличия элемента
        boolean hasCat = animals.contains("Кот");
        boolean hasMouse = animals.contains("Мышь");
        System.out.println("Содержит 'Кот': " + hasCat);
        System.out.println("Содержит 'Мышь': " + hasMouse);

        // Поиск индекса элемента
        int dogIndex = animals.indexOf("Собака");
        int mouseIndex = animals.indexOf("Мышь");
        System.out.println("Индекс 'Собака': " + dogIndex);
        System.out.println("Индекс 'Мышь': " + mouseIndex + " (-1 означает не найден)");
    }

    /**
     * Демонстрация удаления элементов из ArrayList
     */
    public void demonstrateElementRemoval() {
        System.out.println("\n=== Удаление элементов ===");

        List<String> foods = new ArrayList<>();
        foods.add("Хлеб");
        foods.add("Молоко");
        foods.add("Яйца");
        foods.add("Мясо");
        foods.add("Молоко"); // дубликат для демонстрации
        System.out.println("Исходный список: " + foods);

        // Удаление по индексу
        String removed = foods.remove(0);
        System.out.println("Удален элемент по индексу 0: " + removed);
        System.out.println("После удаления: " + foods);

        // Удаление по значению (удаляется первое найденное)
        boolean wasRemoved = foods.remove("Молоко");
        System.out.println("Удален 'Молоко': " + wasRemoved);
        System.out.println("После удаления: " + foods);

        // Удаление всех элементов из коллекции
        List<String> toRemove = Arrays.asList("Яйца", "Молоко");
        foods.removeAll(toRemove);
        System.out.println("После удаления коллекции: " + foods);

        // Очистка всего списка
        foods.clear();
        System.out.println("После очистки: " + foods + ", размер: " + foods.size());
        System.out.println("Список пуст: " + foods.isEmpty());
    }

    /**
     * Демонстрация итерации по ArrayList
     */
    public void demonstrateIteration() {
        System.out.println("\n=== Итерация по ArrayList ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Обычный цикл for
        System.out.println("Обычный for:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("  Индекс " + i + ": " + numbers.get(i));
        }

        // Расширенный цикл for (for-each)
        System.out.println("Расширенный for:");
        for (Integer number : numbers) {
            System.out.println("  Значение: " + number);
        }

        // Использование forEach с лямбдой (Java 8+)
        System.out.println("forEach с лямбдой:");
        numbers.forEach(number -> System.out.println("  Лямбда: " + number));
    }

    /**
     * Демонстрация размера и емкости ArrayList
     */
    public void demonstrateSizeAndCapacity() {
        System.out.println("\n=== Размер и емкость ===");

        List<String> items = new ArrayList<>();
        System.out.println("Начальный размер: " + items.size());

        // Добавление элементов
        for (int i = 1; i <= 5; i++) {
            items.add("Элемент " + i);
            System.out.println("Добавили элемент " + i + ", размер: " + items.size());
        }

        // Демонстрация того, что ArrayList автоматически увеличивается
        for (int i = 6; i <= 15; i++) {
            items.add("Элемент " + i);
        }
        System.out.println("После добавления 15 элементов, размер: " + items.size());
    }

    /**
     * Демонстрация работы с null значениями и дубликатами
     */
    public void demonstrateNullsAndDuplicates() {
        System.out.println("\n=== Null значения и дубликаты ===");

        List<String> values = new ArrayList<>();

        // ArrayList позволяет null значения
        values.add("Первый");
        values.add(null);
        values.add("Третий");
        values.add(null);
        System.out.println("Список с null: " + values);

        // ArrayList позволяет дубликаты
        values.add("Первый"); // дубликат
        System.out.println("Список с дубликатами: " + values);

        // Подсчет null значений
        long nullCount = values.stream().filter(v -> v == null).count();
        System.out.println("Количество null значений: " + nullCount);

        // Удаление всех null значений
        values.removeIf(v -> v == null);
        System.out.println("После удаления null: " + values);
    }

    /**
     * Демонстрация типичных ошибок при работе с ArrayList
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Ошибка 1: IndexOutOfBoundsException
        try {
            int value = numbers.get(5); // Индекс не существует
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка доступа по неверному индексу: " + e.getMessage());
        }

        // Ошибка 2: Проблема с удалением во время итерации
        System.out.println("Список перед удалением четных: " + numbers);
        List<Integer> numbersToRemove = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 20 == 0) { // четные числа, кратные 20
                numbersToRemove.add(num);
            }
        }
        numbers.removeAll(numbersToRemove);
        System.out.println("Список после безопасного удаления: " + numbers);

        // Ошибка 3: Попытка использовать примитивы напрямую с autoboxing
        List<Integer> autoboxing = new ArrayList<>();
        autoboxing.add(42); // автоупаковка int -> Integer
        int value = autoboxing.get(0); // автораспаковка Integer -> int
        System.out.println("Автоупаковка/распаковка работает: " + value);
    }

    /**
     * Главный метод для запуска всех демонстраций
     */
    public static void main(String[] args) {
        BasicArrayListDemo demo = new BasicArrayListDemo();

        demo.demonstrateArrayListCreation();
        demo.demonstrateAddingElements();
        demo.demonstrateElementAccess();
        demo.demonstrateElementRemoval();
        demo.demonstrateIteration();
        demo.demonstrateSizeAndCapacity();
        demo.demonstrateNullsAndDuplicates();
        demo.demonstrateCommonMistakes();
    }
}
