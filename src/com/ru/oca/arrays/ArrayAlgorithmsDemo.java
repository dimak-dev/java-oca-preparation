package com.ru.oca.arrays;

/**
 * Демонстрация алгоритмов и операций с массивами в Java.
 * Показывает сортировку, поиск, копирование, сравнение и использование Arrays класса.
 */
public class ArrayAlgorithmsDemo {

    /**
     * Демонстрация сортировки массивов
     */
    public void demonstrateSorting() {
        System.out.println("=== Сортировка массивов ===");

        // Сортировка с использованием Arrays.sort()
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Исходный массив: " + java.util.Arrays.toString(numbers));

        java.util.Arrays.sort(numbers);
        System.out.println("После Arrays.sort(): " + java.util.Arrays.toString(numbers));

        // Сортировка строк
        String[] names = {"Зоя", "Анна", "Мария", "Борис", "Владимир"};
        System.out.println("\nИсходный массив строк: " + java.util.Arrays.toString(names));

        java.util.Arrays.sort(names);
        System.out.println("После сортировки: " + java.util.Arrays.toString(names));

        // Сортировка части массива
        int[] partialSort = {5, 2, 8, 1, 9, 3};
        System.out.println("\nИсходный массив: " + java.util.Arrays.toString(partialSort));

        java.util.Arrays.sort(partialSort, 1, 4); // Сортируем элементы с индекса 1 по 3
        System.out.println("После частичной сортировки [1,4): " + java.util.Arrays.toString(partialSort));

        // Ручная реализация сортировки пузырьком (для демонстрации)
        int[] bubbleArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nДемонстрация сортировки пузырьком:");
        System.out.println("До сортировки: " + java.util.Arrays.toString(bubbleArray));

        bubbleSort(bubbleArray);
        System.out.println("После сортировки пузырьком: " + java.util.Arrays.toString(bubbleArray));
    }

    /**
     * Реализация сортировки пузырьком
     */
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Обмен элементов
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Если не было обменов, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Демонстрация поиска в массивах
     */
    public void demonstrateSearching() {
        System.out.println("\n=== Поиск в массивах ===");

        // Линейный поиск в несортированном массиве
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        int target = 22;

        System.out.println("Несортированный массив: " + java.util.Arrays.toString(unsorted));
        System.out.println("Ищем элемент: " + target);

        int linearResult = linearSearch(unsorted, target);
        if (linearResult != -1) {
            System.out.println("Линейный поиск: найден на индексе " + linearResult);
        } else {
            System.out.println("Линейный поиск: элемент не найден");
        }

        // Бинарный поиск в отсортированном массиве
        int[] sorted = {11, 12, 22, 25, 34, 64, 90};
        System.out.println("\nОтсортированный массив: " + java.util.Arrays.toString(sorted));

        int binaryResult = java.util.Arrays.binarySearch(sorted, target);
        System.out.println("Arrays.binarySearch(" + target + "): " + binaryResult);

        // Поиск несуществующего элемента
        int missing = 50;
        int missingResult = java.util.Arrays.binarySearch(sorted, missing);
        System.out.println("Arrays.binarySearch(" + missing + "): " + missingResult);
        System.out.println("Отрицательный результат означает: -(точка вставки) - 1");

        if (missingResult < 0) {
            int insertionPoint = -(missingResult + 1);
            System.out.println("Элемент " + missing + " должен быть вставлен на позицию " + insertionPoint);
        }

        // Ручная реализация бинарного поиска
        int customBinaryResult = customBinarySearch(sorted, target);
        System.out.println("Собственный бинарный поиск(" + target + "): " + customBinaryResult);

        // Поиск в строковом массиве
        String[] sortedNames = {"Анна", "Борис", "Владимир", "Мария", "Зоя"};
        java.util.Arrays.sort(sortedNames); // Убедимся, что отсортирован

        System.out.println("\nСтроковый массив: " + java.util.Arrays.toString(sortedNames));
        String searchName = "Мария";
        int nameIndex = java.util.Arrays.binarySearch(sortedNames, searchName);
        System.out.println("Поиск '" + searchName + "': индекс " + nameIndex);
    }

    /**
     * Реализация линейного поиска
     */
    private int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Не найдено
    }

    /**
     * Собственная реализация бинарного поиска
     */
    private int customBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Найдено
            } else if (arr[mid] < target) {
                left = mid + 1; // Ищем в правой половине
            } else {
                right = mid - 1; // Ищем в левой половине
            }
        }

        return -1; // Не найдено
    }

    /**
     * Демонстрация копирования массивов
     */
    public void demonstrateArrayCopying() {
        System.out.println("\n=== Копирование массивов ===");

        int[] original = {1, 2, 3, 4, 5};
        System.out.println("Оригинальный массив: " + java.util.Arrays.toString(original));

        // Способ 1: clone()
        int[] cloned = original.clone();
        System.out.println("clone(): " + java.util.Arrays.toString(cloned));

        // Способ 2: Arrays.copyOf()
        int[] copyOf = java.util.Arrays.copyOf(original, original.length);
        System.out.println("Arrays.copyOf(): " + java.util.Arrays.toString(copyOf));

        // Копирование с изменением размера
        int[] extended = java.util.Arrays.copyOf(original, 8);
        System.out.println("copyOf с расширением до 8: " + java.util.Arrays.toString(extended));

        int[] truncated = java.util.Arrays.copyOf(original, 3);
        System.out.println("copyOf с обрезанием до 3: " + java.util.Arrays.toString(truncated));

        // Способ 3: Arrays.copyOfRange()
        int[] range = java.util.Arrays.copyOfRange(original, 1, 4);
        System.out.println("copyOfRange(1, 4): " + java.util.Arrays.toString(range));

        // Способ 4: System.arraycopy()
        int[] systemCopy = new int[original.length];
        System.arraycopy(original, 0, systemCopy, 0, original.length);
        System.out.println("System.arraycopy(): " + java.util.Arrays.toString(systemCopy));

        // Частичное копирование с System.arraycopy()
        int[] destination = new int[10];
        java.util.Arrays.fill(destination, -1); // Заполняем -1 для наглядности
        System.arraycopy(original, 1, destination, 3, 3); // Копируем элементы 1-3 в позицию 3

        System.out.println("Частичное копирование в массив: " + java.util.Arrays.toString(destination));

        // Демонстрация того, что копии независимы
        System.out.println("\n--- Проверка независимости копий ---");
        cloned[0] = 999;
        System.out.println("После изменения cloned[0] = 999:");
        System.out.println("Оригинал: " + java.util.Arrays.toString(original));
        System.out.println("Копия: " + java.util.Arrays.toString(cloned));
    }

    /**
     * Демонстрация сравнения массивов
     */
    public void demonstrateArrayComparison() {
        System.out.println("\n=== Сравнение массивов ===");

        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};
        int[] array4 = array1; // Та же ссылка

        System.out.println("array1: " + java.util.Arrays.toString(array1));
        System.out.println("array2: " + java.util.Arrays.toString(array2));
        System.out.println("array3: " + java.util.Arrays.toString(array3));
        System.out.println("array4 = array1 (та же ссылка)");

        // Сравнение ссылок (==)
        System.out.println("\n--- Сравнение ссылок (==) ---");
        System.out.println("array1 == array2: " + (array1 == array2)); // false - разные объекты
        System.out.println("array1 == array4: " + (array1 == array4)); // true - та же ссылка

        // Сравнение содержимого (Arrays.equals)
        System.out.println("\n--- Сравнение содержимого (Arrays.equals) ---");
        System.out.println("Arrays.equals(array1, array2): " + java.util.Arrays.equals(array1, array2)); // true
        System.out.println("Arrays.equals(array1, array3): " + java.util.Arrays.equals(array1, array3)); // false
        System.out.println("Arrays.equals(array1, array4): " + java.util.Arrays.equals(array1, array4)); // true

        // Сравнение строк
        String[] names1 = {"Анна", "Борис", "Владимир"};
        String[] names2 = {"Анна", "Борис", "Владимир"};
        String[] names3 = {"Анна", "Борис", "Вячеслав"};

        System.out.println("\n--- Сравнение строковых массивов ---");
        System.out.println("names1: " + java.util.Arrays.toString(names1));
        System.out.println("names2: " + java.util.Arrays.toString(names2));
        System.out.println("names3: " + java.util.Arrays.toString(names3));

        System.out.println("Arrays.equals(names1, names2): " + java.util.Arrays.equals(names1, names2));
        System.out.println("Arrays.equals(names1, names3): " + java.util.Arrays.equals(names1, names3));

        // Многомерные массивы требуют deepEquals
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};

        System.out.println("\n--- Многомерные массивы ---");
        System.out.println("Arrays.equals(matrix1, matrix2): " + java.util.Arrays.equals(matrix1, matrix2)); // false!
        System.out.println("Arrays.deepEquals(matrix1, matrix2): " + java.util.Arrays.deepEquals(matrix1, matrix2)); // true
    }

    /**
     * Демонстрация заполнения массивов
     */
    public void demonstrateArrayFilling() {
        System.out.println("\n=== Заполнение массивов ===");

        // Arrays.fill() - заполнение одним значением
        int[] filled = new int[8];
        java.util.Arrays.fill(filled, 42);
        System.out.println("Заполнен значением 42: " + java.util.Arrays.toString(filled));

        // Частичное заполнение
        java.util.Arrays.fill(filled, 2, 6, 99); // Заполняем индексы 2-5 значением 99
        System.out.println("Частично заполнен [2,6) значением 99: " + java.util.Arrays.toString(filled));

        // Заполнение массива строк
        String[] words = new String[5];
        java.util.Arrays.fill(words, "Java");
        System.out.println("Строковый массив: " + java.util.Arrays.toString(words));

        // Заполнение различными значениями в цикле
        int[] sequence = new int[10];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = i * i; // Квадраты чисел
        }
        System.out.println("Последовательность квадратов: " + java.util.Arrays.toString(sequence));

        // Заполнение случайными числами
        int[] random = new int[8];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < random.length; i++) {
            random[i] = rand.nextInt(100); // Случайное число от 0 до 99
        }
        System.out.println("Случайные числа: " + java.util.Arrays.toString(random));

        // Заполнение по формуле
        double[] formula = new double[10];
        for (int i = 0; i < formula.length; i++) {
            formula[i] = Math.sin(i * Math.PI / 4); // Синус
        }
        System.out.println("Значения синуса:");
        for (int i = 0; i < formula.length; i++) {
            System.out.printf("sin(%.2fπ) = %.3f%n", i / 4.0, formula[i]);
        }
    }

    /**
     * Демонстрация преобразования массивов в строки
     */
    public void demonstrateArrayToString() {
        System.out.println("\n=== Преобразование в строки ===");

        // Arrays.toString() для одномерных массивов
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Arrays.toString(numbers): " + java.util.Arrays.toString(numbers));

        String[] names = {"Анна", "Борис", "Владимир"};
        System.out.println("Arrays.toString(names): " + java.util.Arrays.toString(names));

        // Arrays.deepToString() для многомерных массивов
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Arrays.toString(matrix): " + java.util.Arrays.toString(matrix)); // Показывает ссылки
        System.out.println("Arrays.deepToString(matrix): " + java.util.Arrays.deepToString(matrix)); // Показывает содержимое

        // Трехмерный массив
        int[][][] cube = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        System.out.println("Arrays.deepToString(cube): " + java.util.Arrays.deepToString(cube));

        // Собственная реализация toString
        System.out.println("\n--- Собственная реализация toString ---");
        System.out.println("customToString(numbers): " + customArrayToString(numbers));
    }

    /**
     * Собственная реализация преобразования массива в строку
     */
    private String customArrayToString(int[] array) {
        if (array == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Демонстрация специализированных алгоритмов массивов
     */
    public void demonstrateSpecializedAlgorithms() {
        System.out.println("\n=== Специализированные алгоритмы ===");

        int[] array = {3, 7, 1, 9, 2, 8, 4};
        System.out.println("Исходный массив: " + java.util.Arrays.toString(array));

        // Поиск минимума и максимума
        int min = findMin(array);
        int max = findMax(array);
        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);

        // Сумма элементов
        int sum = calculateSum(array);
        System.out.println("Сумма элементов: " + sum);

        // Среднее арифметическое
        double average = calculateAverage(array);
        System.out.println("Среднее арифметическое: " + String.format("%.2f", average));

        // Реверс массива
        int[] originalForReverse = array.clone();
        reverse(array);
        System.out.println("Реверс массива: " + java.util.Arrays.toString(array));
        System.out.println("Оригинал остался: " + java.util.Arrays.toString(originalForReverse));

        // Проверка на сортированность
        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        int[] unsorted = {3, 1, 4, 1, 5, 9, 2};

        System.out.println("\nПроверка на сортированность:");
        System.out.println(java.util.Arrays.toString(sorted) + " отсортирован: " + isSorted(sorted));
        System.out.println(java.util.Arrays.toString(unsorted) + " отсортирован: " + isSorted(unsorted));

        // Удаление дубликатов (наивный подход)
        int[] withDuplicates = {1, 2, 2, 3, 3, 3, 4, 5, 5};
        int[] unique = removeDuplicates(withDuplicates);
        System.out.println("\nУдаление дубликатов:");
        System.out.println("С дубликатами: " + java.util.Arrays.toString(withDuplicates));
        System.out.println("Без дубликатов: " + java.util.Arrays.toString(unique));

        // Ротация массива
        int[] rotationArray = {1, 2, 3, 4, 5, 6, 7};
        int[] rotated = rotateLeft(rotationArray.clone(), 3);
        System.out.println("\nРотация массива влево на 3 позиции:");
        System.out.println("Исходный: " + java.util.Arrays.toString(rotationArray));
        System.out.println("Повернутый: " + java.util.Arrays.toString(rotated));
    }

    /**
     * Поиск минимального элемента
     */
    private int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Поиск максимального элемента
     */
    private int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Вычисление суммы элементов
     */
    private int calculateSum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    /**
     * Вычисление среднего арифметического
     */
    private double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0.0;
        }
        return (double) calculateSum(array) / array.length;
    }

    /**
     * Реверс массива на месте
     */
    private void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Обмен элементов
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Проверка на сортированность по возрастанию
     */
    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Удаление дубликатов (наивная реализация)
     */
    private int[] removeDuplicates(int[] array) {
        // Сначала подсчитаем уникальные элементы
        int uniqueCount = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueCount++;
            }
        }

        // Создаем массив без дубликатов
        int[] result = new int[uniqueCount];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[index++] = array[i];
            }
        }

        return result;
    }

    /**
     * Ротация массива влево на k позиций
     */
    private int[] rotateLeft(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return array;
        }

        k = k % array.length; // Обрабатываем случай, когда k больше длины массива

        // Создаем новый массив с повернутыми элементами
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int newIndex = (i + array.length - k) % array.length;
            result[newIndex] = array[i];
        }

        return result;
    }

    /**
     * Главный метод для демонстрации всех алгоритмов работы с массивами
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация алгоритмов и операций с массивами ===");

        ArrayAlgorithmsDemo demo = new ArrayAlgorithmsDemo();

        // Выполняем все демонстрации
        demo.demonstrateSorting();
        demo.demonstrateSearching();
        demo.demonstrateArrayCopying();
        demo.demonstrateArrayComparison();
        demo.demonstrateArrayFilling();
        demo.demonstrateArrayToString();
        demo.demonstrateSpecializedAlgorithms();

        System.out.println("\n=== Ключевые моменты алгоритмов с массивами ===");
        System.out.println("1. Arrays.sort() использует быструю и эффективную сортировку");
        System.out.println("2. Arrays.binarySearch() работает только с отсортированными массивами");
        System.out.println("3. Линейный поиск O(n), бинарный поиск O(log n)");
        System.out.println("4. clone() создает поверхностную копию массива");
        System.out.println("5. Arrays.copyOf() позволяет изменить размер при копировании");
        System.out.println("6. System.arraycopy() - самый быстрый способ копирования");
        System.out.println("7. Arrays.equals() для сравнения содержимого одномерных массивов");
        System.out.println("8. Arrays.deepEquals() для многомерных массивов");
        System.out.println("9. Arrays.toString() для вывода одномерных массивов");
        System.out.println("10. Arrays.deepToString() для многомерных массивов");
    }
}
