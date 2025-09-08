package com.ru.oca.arrays;

/**
 * Демонстрация основ работы с одномерными массивами в Java.
 * Показывает создание, инициализацию, доступ к элементам и итерацию по массивам.
 */
public class BasicArrayDemo {

    /**
     * Демонстрация различных способов объявления массивов
     */
    public void demonstrateArrayDeclaration() {
        System.out.println("=== Объявление массивов ===");

        // Способ 1: Рекомендуемый стиль - тип[] имя
        int[] numbers;
        String[] names;
        boolean[] flags;

        // Способ 2: C-стиль - тип имя[]
        double values[];
        char letters[];

        System.out.println("Массивы объявлены, но пока не инициализированы");
        System.out.println("Рекомендуемый стиль: int[] numbers");
        System.out.println("C-стиль: double values[]");
    }

    /**
     * Демонстрация создания и инициализации массивов
     */
    public void demonstrateArrayCreation() {
        System.out.println("\n=== Создание и инициализация массивов ===");

        // Создание массива с указанием размера
        int[] numbers = new int[5];  // Массив из 5 элементов
        String[] names = new String[3];  // Массив из 3 элементов

        System.out.println("Создан массив numbers размером: " + numbers.length);
        System.out.println("Создан массив names размером: " + names.length);

        // Инициализация при создании - краткая форма
        int[] scores = {85, 92, 78, 95, 88};
        String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск"};

        System.out.println("Массив scores инициализирован: " + java.util.Arrays.toString(scores));
        System.out.println("Массив cities инициализирован: " + java.util.Arrays.toString(cities));

        // Инициализация при создании - полная форма
        int[] grades = new int[]{100, 95, 87, 92};
        String[] colors = new String[]{"красный", "зеленый", "синий"};

        System.out.println("Массив grades (полная форма): " + java.util.Arrays.toString(grades));
        System.out.println("Массив colors (полная форма): " + java.util.Arrays.toString(colors));

        // Анонимная инициализация массива (полезно при передаче в методы)
        demonstrateArrayParameter(new int[]{1, 2, 3, 4, 5});
    }

    /**
     * Вспомогательный метод для демонстрации передачи анонимного массива
     */
    private void demonstrateArrayParameter(int[] array) {
        System.out.println("Получен анонимный массив: " + java.util.Arrays.toString(array));
    }

    /**
     * Демонстрация значений по умолчанию для различных типов массивов
     */
    public void demonstrateDefaultValues() {
        System.out.println("\n=== Значения по умолчанию ===");

        // Массивы примитивных типов
        int[] integers = new int[3];
        double[] doubles = new double[3];
        boolean[] booleans = new boolean[3];
        char[] chars = new char[3];

        // Массивы ссылочных типов
        String[] strings = new String[3];
        Object[] objects = new Object[3];

        System.out.println("int по умолчанию: " + java.util.Arrays.toString(integers));
        System.out.println("double по умолчанию: " + java.util.Arrays.toString(doubles));
        System.out.println("boolean по умолчанию: " + java.util.Arrays.toString(booleans));
        System.out.println("char по умолчанию: " + java.util.Arrays.toString(chars));
        System.out.println("String по умолчанию: " + java.util.Arrays.toString(strings));
        System.out.println("Object по умолчанию: " + java.util.Arrays.toString(objects));

        // Демонстрация проблемы с null значениями
        System.out.println("\n--- Осторожно с ссылочными типами ---");
        String[] names = new String[3];
        try {
            int length = names[0].length(); // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getClass().getSimpleName() +
                             " при попытке вызвать метод у null");
        }

        // Правильная инициализация
        names[0] = "Алиса";
        names[1] = "Боб";
        names[2] = "Чарли";
        System.out.println("После инициализации: " + java.util.Arrays.toString(names));
    }

    /**
     * Демонстрация доступа к элементам массива
     */
    public void demonstrateArrayAccess() {
        System.out.println("\n=== Доступ к элементам массива ===");

        int[] numbers = {10, 20, 30, 40, 50};

        // Чтение элементов
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        System.out.println("Первый элемент (индекс 0): " + numbers[0]);
        System.out.println("Третий элемент (индекс 2): " + numbers[2]);
        System.out.println("Последний элемент (индекс " + (numbers.length - 1) + "): "
                         + numbers[numbers.length - 1]);

        // Изменение элементов
        System.out.println("\n--- Изменение элементов ---");
        System.out.println("Изменяем numbers[2] с " + numbers[2] + " на 35");
        numbers[2] = 35;
        System.out.println("Массив после изменения: " + java.util.Arrays.toString(numbers));

        // Получение длины массива
        System.out.println("\n--- Длина массива ---");
        System.out.println("Длина массива: " + numbers.length);
        System.out.println("Обратите внимание: length - это свойство, а не метод!");

        // Демонстрация ошибки выхода за границы
        System.out.println("\n--- Выход за границы массива ---");
        try {
            int invalidAccess = numbers[5]; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getClass().getSimpleName() +
                             " при попытке доступа к индексу 5 в массиве размером " + numbers.length);
        }

        try {
            int negativeAccess = numbers[-1]; // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e.getClass().getSimpleName() +
                             " при попытке доступа к отрицательному индексу -1");
        }
    }

    /**
     * Демонстрация различных способов итерации по массиву
     */
    public void demonstrateArrayIteration() {
        System.out.println("\n=== Итерация по массивам ===");

        String[] fruits = {"яблоко", "банан", "апельсин", "груша", "виноград"};

        // Способ 1: Обычный for цикл
        System.out.println("--- Обычный for цикл ---");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Индекс " + i + ": " + fruits[i]);
        }

        // Способ 2: Enhanced for цикл (for-each)
        System.out.println("\n--- Enhanced for цикл (for-each) ---");
        for (String fruit : fruits) {
            System.out.println("Фрукт: " + fruit);
        }

        // Способ 3: While цикл
        System.out.println("\n--- While цикл ---");
        int index = 0;
        while (index < fruits.length) {
            System.out.println("While индекс " + index + ": " + fruits[index]);
            index++;
        }

        // Способ 4: Обратный порядок
        System.out.println("\n--- Обратный порядок ---");
        for (int i = fruits.length - 1; i >= 0; i--) {
            System.out.println("Обратный " + i + ": " + fruits[i]);
        }

        // Демонстрация различий между способами
        System.out.println("\n--- Когда использовать каждый способ ---");
        System.out.println("Обычный for: когда нужен индекс или особый порядок итерации");
        System.out.println("Enhanced for: когда нужны только значения, код более читаемый");
        System.out.println("While: когда условие окончания сложнее чем просто длина массива");
    }

    /**
     * Демонстрация операций поиска в массиве
     */
    public void demonstrateArraySearch() {
        System.out.println("\n=== Поиск в массивах ===");

        int[] numbers = {15, 42, 7, 23, 8, 16, 42, 9};
        int searchValue = 42;

        // Линейный поиск - поиск первого вхождения
        System.out.println("Массив: " + java.util.Arrays.toString(numbers));
        System.out.println("Ищем значение: " + searchValue);

        int foundIndex = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchValue) {
                foundIndex = i;
                break; // Найден первый элемент, прерываем поиск
            }
        }

        if (foundIndex != -1) {
            System.out.println("Первое вхождение найдено на индексе: " + foundIndex);
        } else {
            System.out.println("Значение не найдено");
        }

        // Поиск всех вхождений
        System.out.println("\n--- Поиск всех вхождений ---");
        System.out.print("Все индексы со значением " + searchValue + ": ");
        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchValue) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("не найдено");
        }
        System.out.println();

        // Поиск минимального и максимального элемента
        System.out.println("\n--- Поиск мин/макс ---");
        int min = numbers[0];
        int max = numbers[0];
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }

        System.out.println("Минимальное значение: " + min + " на индексе " + minIndex);
        System.out.println("Максимальное значение: " + max + " на индексе " + maxIndex);
    }

    /**
     * Демонстрация основных операций с массивами
     */
    public void demonstrateArrayOperations() {
        System.out.println("\n=== Операции с массивами ===");

        int[] original = {1, 2, 3, 4, 5};

        // Копирование массива - НЕПРАВИЛЬНО
        System.out.println("--- Копирование массивов ---");
        int[] wrongCopy = original; // Это копирует ссылку, а не массив!
        wrongCopy[0] = 999;

        System.out.println("Оригинальный: " + java.util.Arrays.toString(original));
        System.out.println("'Копия': " + java.util.Arrays.toString(wrongCopy));
        System.out.println("Проблема: изменения в 'копии' влияют на оригинал!");

        // Правильное копирование
        original[0] = 1; // Восстанавливаем значение

        // Способ 1: clone()
        int[] copy1 = original.clone();
        copy1[0] = 100;
        System.out.println("Оригинал: " + java.util.Arrays.toString(original));
        System.out.println("Clone(): " + java.util.Arrays.toString(copy1));

        // Способ 2: Arrays.copyOf()
        int[] copy2 = java.util.Arrays.copyOf(original, original.length);
        copy2[1] = 200;
        System.out.println("Arrays.copyOf(): " + java.util.Arrays.toString(copy2));

        // Способ 3: System.arraycopy()
        int[] copy3 = new int[original.length];
        System.arraycopy(original, 0, copy3, 0, original.length);
        copy3[2] = 300;
        System.out.println("System.arraycopy(): " + java.util.Arrays.toString(copy3));

        // Заполнение массива
        System.out.println("\n--- Заполнение массива ---");
        int[] filled = new int[5];
        java.util.Arrays.fill(filled, 42);
        System.out.println("Заполнен значением 42: " + java.util.Arrays.toString(filled));

        // Сравнение массивов
        System.out.println("\n--- Сравнение массивов ---");
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = array1;

        System.out.println("array1 == array2: " + (array1 == array2)); // false - разные объекты
        System.out.println("array1 == array3: " + (array1 == array3)); // true - одна ссылка
        System.out.println("Arrays.equals(array1, array2): " + java.util.Arrays.equals(array1, array2)); // true - одинаковое содержимое
    }

    /**
     * Демонстрация практических примеров использования массивов
     */
    public void demonstratePracticalExamples() {
        System.out.println("\n=== Практические примеры ===");

        // Пример 1: Подсчет статистики оценок
        System.out.println("--- Статистика оценок ---");
        int[] grades = {85, 92, 78, 95, 88, 73, 90, 87, 82, 96};

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        double average = (double) sum / grades.length;
        System.out.println("Оценки: " + java.util.Arrays.toString(grades));
        System.out.println("Сумма: " + sum);
        System.out.println("Средний балл: " + String.format("%.2f", average));

        // Подсчет оценок по категориям
        int excellent = 0, good = 0, satisfactory = 0;
        for (int grade : grades) {
            if (grade >= 90) excellent++;
            else if (grade >= 80) good++;
            else satisfactory++;
        }

        System.out.println("Отличных (90+): " + excellent);
        System.out.println("Хороших (80-89): " + good);
        System.out.println("Удовлетворительных (<80): " + satisfactory);

        // Пример 2: Инвентарь магазина
        System.out.println("\n--- Инвентарь магазина ---");
        String[] products = {"молоко", "хлеб", "яйца", "масло", "сыр"};
        int[] quantities = {15, 25, 48, 8, 12};
        double[] prices = {65.50, 35.00, 12.50, 120.00, 350.00};

        System.out.println("=== ИНВЕНТАРЬ ===");
        double totalValue = 0;

        for (int i = 0; i < products.length; i++) {
            double itemValue = quantities[i] * prices[i];
            totalValue += itemValue;

            System.out.printf("%-8s | Кол-во: %2d | Цена: %6.2f | Стоимость: %8.2f%n",
                            products[i], quantities[i], prices[i], itemValue);
        }

        System.out.println("----------------------------------------");
        System.out.printf("Общая стоимость инвентаря: %.2f руб.%n", totalValue);

        // Пример 3: Анализ температуры
        System.out.println("\n--- Анализ температуры за неделю ---");
        String[] days = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
        int[] temperatures = {22, 25, 18, 20, 24, 28, 26};

        int minTemp = temperatures[0];
        int maxTemp = temperatures[0];
        String coldestDay = days[0];
        String hottestDay = days[0];
        int tempSum = 0;

        for (int i = 0; i < temperatures.length; i++) {
            tempSum += temperatures[i];

            if (temperatures[i] < minTemp) {
                minTemp = temperatures[i];
                coldestDay = days[i];
            }

            if (temperatures[i] > maxTemp) {
                maxTemp = temperatures[i];
                hottestDay = days[i];
            }
        }

        System.out.println("Температуры по дням:");
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%s: %d°C%n", days[i], temperatures[i]);
        }

        System.out.printf("Самый холодный день: %s (%d°C)%n", coldestDay, minTemp);
        System.out.printf("Самый теплый день: %s (%d°C)%n", hottestDay, maxTemp);
        System.out.printf("Средняя температура: %.1f°C%n", (double) tempSum / temperatures.length);
    }

    /**
     * Главный метод для демонстрации всех аспектов работы с одномерными массивами
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация основ работы с одномерными массивами ===");

        BasicArrayDemo demo = new BasicArrayDemo();

        // Выполняем все демонстрации
        demo.demonstrateArrayDeclaration();
        demo.demonstrateArrayCreation();
        demo.demonstrateDefaultValues();
        demo.demonstrateArrayAccess();
        demo.demonstrateArrayIteration();
        demo.demonstrateArraySearch();
        demo.demonstrateArrayOperations();
        demo.demonstratePracticalExamples();

        System.out.println("\n=== Ключевые моменты работы с массивами ===");
        System.out.println("1. Массивы имеют фиксированный размер, определяемый при создании");
        System.out.println("2. Индексация начинается с 0, последний индекс = length - 1");
        System.out.println("3. length - это свойство, а не метод (без скобок!)");
        System.out.println("4. Элементы примитивных типов инициализируются значениями по умолчанию");
        System.out.println("5. Элементы ссылочных типов инициализируются null");
        System.out.println("6. Выход за границы массива вызывает ArrayIndexOutOfBoundsException");
        System.out.println("7. Присваивание массива копирует ссылку, а не содержимое");
        System.out.println("8. Для копирования содержимого используйте clone() или Arrays.copyOf()");
        System.out.println("9. Enhanced for удобен для чтения, обычный for - когда нужен индекс");
        System.out.println("10. Arrays.toString() полезен для отладки и вывода массивов");
    }
}
