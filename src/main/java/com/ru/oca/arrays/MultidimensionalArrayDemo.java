package com.ru.oca.arrays;

/**
 * Демонстрация работы с многомерными массивами в Java.
 * Показывает двумерные и трехмерные массивы, прямоугольные и неровные массивы.
 */
public class MultidimensionalArrayDemo {

    /**
     * Демонстрация создания двумерных массивов
     */
    public void demonstrateTwoDimensionalArrays() {
        System.out.println("=== Двумерные массивы ===");

        // Способ 1: Создание прямоугольного массива с указанием размеров
        int[][] matrix = new int[3][4];  // 3 строки, 4 столбца

        System.out.println("Создан прямоугольный массив 3x4:");
        System.out.println("Количество строк: " + matrix.length);
        System.out.println("Количество столбцов в первой строке: " + matrix[0].length);

        // Заполняем массив значениями
        int value = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }

        System.out.println("Заполненный массив:");
        printMatrix(matrix);

        // Способ 2: Инициализация при объявлении
        int[][] numbers = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\nМассив, инициализированный при объявлении:");
        printMatrix(numbers);

        // Способ 3: Полная форма инициализации
        String[][] words = new String[][] {
            {"один", "два", "три"},
            {"четыре", "пять", "шесть"},
            {"семь", "восемь", "девять"}
        };

        System.out.println("\nСтроковый массив (полная форма):");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                System.out.printf("%-8s ", words[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Демонстрация неровных (jagged) массивов
     */
    public void demonstrateJaggedArrays() {
        System.out.println("\n=== Неровные (Jagged) массивы ===");

        // Создание неровного массива - сначала только первое измерение
        int[][] jaggedArray = new int[4][];

        // Создаем строки разной длины
        jaggedArray[0] = new int[2];    // Первая строка - 2 элемента
        jaggedArray[1] = new int[4];    // Вторая строка - 4 элемента
        jaggedArray[2] = new int[3];    // Третья строка - 3 элемента
        jaggedArray[3] = new int[1];    // Четвертая строка - 1 элемент

        // Заполняем значениями
        int counter = 1;
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = counter++;
            }
        }

        System.out.println("Неровный массив:");
        printJaggedMatrix(jaggedArray);

        // Инициализация неровного массива при объявлении
        int[][] triangle = {
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1}
        };

        System.out.println("\nТреугольник Паскаля:");
        printJaggedMatrix(triangle);

        // Демонстрация проблем с неровными массивами
        System.out.println("\n--- Особенности работы с неровными массивами ---");
        System.out.println("Нельзя использовать matrix[i].length для всех строк!");

        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Строка " + i + " содержит " + jaggedArray[i].length + " элементов");
        }
    }

    /**
     * Демонстрация трехмерных массивов
     */
    public void demonstrateThreeDimensionalArrays() {
        System.out.println("\n=== Трехмерные массивы ===");

        // Создание 3D массива: 2 блока, 3 строки, 4 столбца
        int[][][] cube = new int[2][3][4];

        System.out.println("Создан трехмерный массив 2x3x4:");
        System.out.println("Количество блоков: " + cube.length);
        System.out.println("Количество строк в блоке: " + cube[0].length);
        System.out.println("Количество столбцов в строке: " + cube[0][0].length);

        // Заполнение 3D массива
        int value = 1;
        for (int block = 0; block < cube.length; block++) {
            for (int row = 0; row < cube[block].length; row++) {
                for (int col = 0; col < cube[block][row].length; col++) {
                    cube[block][row][col] = value++;
                }
            }
        }

        // Вывод 3D массива
        System.out.println("\nСодержимое трехмерного массива:");
        for (int block = 0; block < cube.length; block++) {
            System.out.println("Блок " + block + ":");
            for (int row = 0; row < cube[block].length; row++) {
                for (int col = 0; col < cube[block][row].length; col++) {
                    System.out.printf("%3d ", cube[block][row][col]);
                }
                System.out.println();
            }
            System.out.println();
        }

        // Инициализация при объявлении
        int[][][] smallCube = {
            {
                {1, 2},
                {3, 4}
            },
            {
                {5, 6},
                {7, 8}
            }
        };

        System.out.println("Маленький куб (инициализация при объявлении):");
        for (int block = 0; block < smallCube.length; block++) {
            System.out.println("Блок " + block + ":");
            printMatrix(smallCube[block]);
            System.out.println();
        }
    }

    /**
     * Демонстрация итерации по многомерным массивам
     */
    public void demonstrateMultidimensionalIteration() {
        System.out.println("=== Итерация по многомерным массивам ===");

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Способ 1: Обычные вложенные for циклы
        System.out.println("--- Обычные for циклы ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }

        // Способ 2: Enhanced for циклы (for-each)
        System.out.println("\n--- Enhanced for циклы ---");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }

        // Способ 3: Смешанный подход
        System.out.println("\n--- Смешанный подход (индекс строки + for-each для элементов) ---");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Строка " + i + ": ");
            for (int element : matrix[i]) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }

        // Способ 4: Одномерная итерация (все элементы подряд)
        System.out.println("\n--- Одномерная итерация (все элементы) ---");
        System.out.print("Все элементы: ");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    /**
     * Демонстрация практических применений многомерных массивов
     */
    public void demonstratePracticalApplications() {
        System.out.println("\n=== Практические применения ===");

        // Пример 1: Таблица умножения
        System.out.println("--- Таблица умножения 10x10 ---");
        int[][] multiplicationTable = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }

        // Выводим часть таблицы (первые 5x5)
        System.out.println("Фрагмент таблицы (5x5):");
        System.out.print("   ");
        for (int j = 1; j <= 5; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.printf("%2d:", i + 1);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%4d", multiplicationTable[i][j]);
            }
            System.out.println();
        }

        // Пример 2: Система координат и игровое поле
        System.out.println("\n--- Игровое поле (крестики-нолики) ---");
        char[][] gameBoard = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'X', 'X', 'O'}
        };

        System.out.println("Состояние игры:");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < gameBoard[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < gameBoard.length - 1) {
                System.out.println("-+-+-");
            }
        }

        // Пример 3: Продажи по месяцам и регионам
        System.out.println("\n--- Продажи по регионам и месяцам ---");
        String[] regions = {"Север", "Юг", "Восток", "Запад"};
        String[] months = {"Янв", "Фев", "Мар", "Апр"};
        int[][] sales = {
            {120, 130, 110, 140},  // Север
            {200, 180, 220, 190},  // Юг
            {150, 160, 140, 170},  // Восток
            {90, 100, 85, 95}      // Запад
        };

        // Заголовок таблицы
        System.out.printf("%-8s", "Регион");
        for (String month : months) {
            System.out.printf("%6s", month);
        }
        System.out.printf("%8s%n", "Итого");

        // Данные по регионам
        int[] monthTotals = new int[months.length];
        for (int i = 0; i < regions.length; i++) {
            System.out.printf("%-8s", regions[i]);
            int regionTotal = 0;

            for (int j = 0; j < sales[i].length; j++) {
                System.out.printf("%6d", sales[i][j]);
                regionTotal += sales[i][j];
                monthTotals[j] += sales[i][j];
            }

            System.out.printf("%8d%n", regionTotal);
        }

        // Итоги по месяцам
        System.out.printf("%-8s", "Итого");
        int grandTotal = 0;
        for (int total : monthTotals) {
            System.out.printf("%6d", total);
            grandTotal += total;
        }
        System.out.printf("%8d%n", grandTotal);
    }

    /**
     * Демонстрация алгоритмов для работы с матрицами
     */
    public void demonstrateMatrixAlgorithms() {
        System.out.println("\n=== Алгоритмы для матриц ===");

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Поиск элемента в матрице
        int searchValue = 7;
        boolean found = false;
        int foundRow = -1, foundCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchValue) {
                    found = true;
                    foundRow = i;
                    foundCol = j;
                    break;
                }
            }
            if (found) break;
        }

        System.out.println("\n--- Поиск элемента " + searchValue + " ---");
        if (found) {
            System.out.println("Найден в позиции [" + foundRow + "][" + foundCol + "]");
        } else {
            System.out.println("Не найден");
        }

        // Транспонирование квадратной матрицы
        System.out.println("\n--- Транспонирование матрицы ---");
        int[][] square = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Исходная квадратная матрица:");
        printMatrix(square);

        int[][] transposed = transposeMatrix(square);
        System.out.println("Транспонированная матрица:");
        printMatrix(transposed);

        // Поиск максимального элемента и его позиции
        System.out.println("\n--- Поиск максимального элемента ---");
        int max = matrix[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Позиция: [" + maxRow + "][" + maxCol + "]");

        // Сумма элементов по диагоналям (для квадратной матрицы)
        System.out.println("\n--- Суммы диагоналей ---");
        int mainDiagonalSum = 0;    // главная диагональ
        int antiDiagonalSum = 0;    // побочная диагональ

        for (int i = 0; i < square.length; i++) {
            mainDiagonalSum += square[i][i];                           // главная диагональ
            antiDiagonalSum += square[i][square.length - 1 - i];      // побочная диагональ
        }

        System.out.println("Сумма главной диагонали: " + mainDiagonalSum);
        System.out.println("Сумма побочной диагонали: " + antiDiagonalSum);
    }

    /**
     * Вспомогательный метод для вывода двумерного массива
     */
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }

    /**
     * Вспомогательный метод для вывода неровного массива
     */
    private void printJaggedMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("Строка %d (%d элементов): ", i, matrix[i].length);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Вспомогательный метод для транспонирования матрицы
     */
    private int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }

    /**
     * Демонстрация типичных ошибок при работе с многомерными массивами
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки ===");

        // Ошибка 1: Путаница в порядке индексов
        System.out.println("--- Ошибка 1: Порядок индексов ---");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        System.out.println("Правильно: matrix[строка][столбец]");
        System.out.println("matrix[0][2] = " + matrix[0][2]); // Строка 0, столбец 2
        System.out.println("matrix[1][0] = " + matrix[1][0]); // Строка 1, столбец 0

        // Ошибка 2: Предположение о прямоугольности
        System.out.println("\n--- Ошибка 2: Предположение о прямоугольности ---");
        int[][] jagged = {{1, 2}, {3, 4, 5}, {6}};

        System.out.println("Неровный массив - строки разной длины:");
        for (int i = 0; i < jagged.length; i++) {
            System.out.print("Строка " + i + ": ");
            // ПРАВИЛЬНО: проверяем длину каждой строки
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println("(длина: " + jagged[i].length + ")");
        }

        // Ошибка 3: NullPointerException с несозданными строками
        System.out.println("\n--- Ошибка 3: Несозданные строки ---");
        int[][] incomplete = new int[3][];  // Создали только первое измерение
        incomplete[0] = new int[2];         // Создали только первую строку
        incomplete[0][0] = 10;
        incomplete[0][1] = 20;

        System.out.println("Создана только первая строка:");
        System.out.println("incomplete[0][0] = " + incomplete[0][0]);

        try {
            int value = incomplete[1][0];   // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getClass().getSimpleName() +
                             " при попытке доступа к несозданной строке");
        }

        // Ошибка 4: Неправильное копирование многомерных массивов
        System.out.println("\n--- Ошибка 4: Поверхностное копирование ---");
        int[][] original = {{1, 2}, {3, 4}};
        int[][] shallowCopy = original.clone();  // Поверхностное копирование

        shallowCopy[0][0] = 999;  // Изменяет и оригинал!

        System.out.println("После изменения 'копии':");
        System.out.print("Оригинал: ");
        System.out.println(java.util.Arrays.deepToString(original));
        System.out.print("'Копия': ");
        System.out.println(java.util.Arrays.deepToString(shallowCopy));
        System.out.println("Проблема: clone() делает поверхностное копирование!");

        // Правильное глубокое копирование
        int[][] deepCopy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            deepCopy[i] = original[i].clone();
        }

        original[0][0] = 1; // Восстанавливаем
        deepCopy[0][0] = 888;

        System.out.println("\nПравильное глубокое копирование:");
        System.out.print("Оригинал: ");
        System.out.println(java.util.Arrays.deepToString(original));
        System.out.print("Глубокая копия: ");
        System.out.println(java.util.Arrays.deepToString(deepCopy));
    }

    /**
     * Главный метод для демонстрации всех аспектов многомерных массивов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация работы с многомерными массивами ===");

        MultidimensionalArrayDemo demo = new MultidimensionalArrayDemo();

        // Выполняем все демонстрации
        demo.demonstrateTwoDimensionalArrays();
        demo.demonstrateJaggedArrays();
        demo.demonstrateThreeDimensionalArrays();
        demo.demonstrateMultidimensionalIteration();
        demo.demonstratePracticalApplications();
        demo.demonstrateMatrixAlgorithms();
        demo.demonstrateCommonMistakes();

        System.out.println("\n=== Ключевые моменты многомерных массивов ===");
        System.out.println("1. Многомерные массивы - это массивы массивов");
        System.out.println("2. Доступ: array[строка][столбец] для 2D массивов");
        System.out.println("3. Неровные массивы позволяют строки разной длины");
        System.out.println("4. Каждая строка может иметь свою длину: array[i].length");
        System.out.println("5. Enhanced for удобен для обхода всех элементов");
        System.out.println("6. Обычный for нужен, когда важны индексы");
        System.out.println("7. clone() делает только поверхностное копирование");
        System.out.println("8. Для глубокого копирования клонируйте каждую строку");
        System.out.println("9. Arrays.deepToString() для вывода многомерных массивов");
        System.out.println("10. Всегда проверяйте, что строки созданы перед использованием");
    }
}
