package com.ru.oca.loops;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Демонстрация основных конструкций циклов в Java.
 * Показывает for, while, do-while и enhanced for циклы с их особенностями.
 */
public class BasicLoopsDemo {

    /**
     * Демонстрация различных вариантов цикла for
     */
    public void demonstrateForLoops() {
        System.out.println("=== Демонстрация цикла for ===");

        // Стандартный цикл for
        System.out.println("Стандартный for цикл:");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Цикл for с декрементом
        System.out.println("\nFor с декрементом:");
        for (int i = 5; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Цикл for с шагом 2
        System.out.println("\nFor с шагом 2:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Множественные переменные в for
        System.out.println("\nFor с множественными переменными:");
        for (int i = 0, j = 10; i <= j; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }

        // Пустой for (все части опциональны)
        System.out.println("\nПустой for с внешним управлением:");
        int counter = 0;
        for (;;) {
            if (counter >= 3) break;
            System.out.println("Итерация " + counter);
            counter++;
        }

        // For без инициализации
        System.out.println("\nFor без инициализации:");
        int k = 0;
        for (; k < 3; k++) {
            System.out.print("k=" + k + " ");
        }
        System.out.println("\nПосле цикла k = " + k);

        // For без обновления
        System.out.println("\nFor без части обновления:");
        for (int m = 0; m < 5;) {
            System.out.print(m + " ");
            m++; // Обновление в теле цикла
        }
        System.out.println();
    }

    /**
     * Демонстрация цикла while
     */
    public void demonstrateWhileLoops() {
        System.out.println("\n=== Демонстрация цикла while ===");

        // Базовый while цикл
        System.out.println("Базовый while цикл:");
        int i = 0;
        while (i < 5) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        // While с более сложным условием
        System.out.println("\nWhile с составным условием:");
        int a = 1, b = 20;
        while (a < 10 && b > 15) {
            System.out.println("a = " + a + ", b = " + b);
            a += 2;
            b -= 3;
        }

        // While для поиска элемента в массиве
        System.out.println("\nWhile для поиска в массиве:");
        int[] numbers = {10, 25, 30, 45, 50};
        int target = 30;
        int index = 0;
        boolean found = false;

        while (index < numbers.length && !found) {
            if (numbers[index] == target) {
                found = true;
                System.out.println("Элемент " + target + " найден на позиции " + index);
            } else {
                index++;
            }
        }

        if (!found) {
            System.out.println("Элемент " + target + " не найден");
        }

        // While с условием, которое изначально false
        System.out.println("\nWhile с ложным условием:");
        int never = 10;
        while (never < 5) {
            System.out.println("Этот код никогда не выполнится");
        }
        System.out.println("While с ложным условием пропущен");

        // While для валидации ввода (симуляция)
        System.out.println("\nWhile для валидации (симуляция):");
        simulateInputValidation();
    }

    /**
     * Демонстрация цикла do-while
     */
    public void demonstrateDoWhileLoops() {
        System.out.println("\n=== Демонстрация цикла do-while ===");

        // Базовый do-while
        System.out.println("Базовый do-while цикл:");
        int i = 0;
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 5);
        System.out.println();

        // Do-while выполняется минимум один раз
        System.out.println("\nDo-while с ложным условием (выполнится один раз):");
        int j = 10;
        do {
            System.out.println("Выполнился один раз, j = " + j);
            j++;
        } while (j < 5); // Условие ложно, но тело выполнилось

        // Практический пример: меню
        System.out.println("\nПример do-while для меню:");
        simulateMenuLoop();

        // Do-while для игрового цикла
        System.out.println("\nПример игрового цикла:");
        simulateGameLoop();

        // Сравнение while и do-while
        System.out.println("\nСравнение while и do-while:");
        System.out.println("While с ложным условием:");
        int whileTest = 10;
        while (whileTest < 5) {
            System.out.println("While: этого не увидим");
        }

        System.out.println("Do-while с тем же ложным условием:");
        int doWhileTest = 10;
        do {
            System.out.println("Do-while: это выполнится один раз");
        } while (doWhileTest < 5);
    }

    /**
     * Демонстрация расширенного цикла for (enhanced for, for-each)
     */
    public void demonstrateEnhancedForLoops() {
        System.out.println("\n=== Демонстрация enhanced for (for-each) цикла ===");

        // Enhanced for с массивами
        System.out.println("Enhanced for с массивом:");
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.print("Элементы: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Enhanced for со строковым массивом
        System.out.println("\nEnhanced for со строковым массивом:");
        String[] names = {"Анна", "Борис", "Владимир", "Дмитрий"};
        for (String name : names) {
            System.out.println("Имя: " + name + " (длина: " + name.length() + ")");
        }

        // Enhanced for с ArrayList
        System.out.println("\nEnhanced for с ArrayList:");
        List<String> fruits = new ArrayList<>();
        fruits.add("Яблоко");
        fruits.add("Банан");
        fruits.add("Апельсин");
        fruits.add("Киви");

        for (String fruit : fruits) {
            System.out.println("Фрукт: " + fruit);
        }

        // Многомерные массивы с enhanced for
        System.out.println("\nEnhanced for с двумерным массивом:");
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Ограничения enhanced for
        System.out.println("\nОграничения enhanced for:");
        demonstrateEnhancedForLimitations();

        // Сравнение обычного for и enhanced for
        System.out.println("\nСравнение for и enhanced for:");
        compareForLoops();
    }

    /**
     * Демонстрация ограничений enhanced for
     */
    private void demonstrateEnhancedForLimitations() {
        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Оригинальный массив: " + Arrays.toString(numbers));

        // Enhanced for не может изменить элементы массива
        System.out.println("Попытка изменить элементы через enhanced for:");
        for (int num : numbers) {
            num = num * 2; // Изменяется только локальная переменная!
        }
        System.out.println("Массив после enhanced for: " + Arrays.toString(numbers));

        // Правильный способ изменения через обычный for
        System.out.println("Изменение через обычный for:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }
        System.out.println("Массив после обычного for: " + Arrays.toString(numbers));

        // Enhanced for не дает доступа к индексу
        System.out.println("\nОбычный for с доступом к индексу:");
        String[] words = {"Java", "Python", "JavaScript", "C++"};
        for (int i = 0; i < words.length; i++) {
            System.out.println("Индекс " + i + ": " + words[i]);
        }
    }

    /**
     * Сравнение обычного for и enhanced for
     */
    private void compareForLoops() {
        int[] data = {10, 20, 30, 40, 50};

        System.out.println("Обычный for цикл:");
        for (int i = 0; i < data.length; i++) {
            System.out.println("data[" + i + "] = " + data[i]);
        }

        System.out.println("\nEnhanced for цикл:");
        for (int value : data) {
            System.out.println("value = " + value);
        }

        // Производительность (концептуально одинакова)
        System.out.println("\nОба цикла имеют одинаковую производительность для массивов");
        System.out.println("Enhanced for более читаемый, обычный for более гибкий");
    }

    /**
     * Демонстрация практических применений циклов
     */
    public void demonstratePracticalExamples() {
        System.out.println("\n=== Практические примеры использования циклов ===");

        // Подсчет элементов
        System.out.println("1. Подсчет положительных чисел:");
        int[] numbers = {-3, 5, -1, 8, 0, -7, 12, 4};
        int positiveCount = 0;

        for (int num : numbers) {
            if (num > 0) {
                positiveCount++;
            }
        }
        System.out.println("Массив: " + Arrays.toString(numbers));
        System.out.println("Положительных чисел: " + positiveCount);

        // Поиск максимума
        System.out.println("\n2. Поиск максимального элемента:");
        int[] values = {23, 45, 12, 67, 34, 89, 15};
        int max = values[0]; // Начинаем с первого элемента

        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        System.out.println("Массив: " + Arrays.toString(values));
        System.out.println("Максимальный элемент: " + max);

        // Сумма и среднее
        System.out.println("\n3. Вычисление суммы и среднего:");
        double[] scores = {85.5, 92.3, 78.8, 95.1, 88.7};
        double sum = 0;

        for (double score : scores) {
            sum += score;
        }

        double average = sum / scores.length;
        System.out.printf("Оценки: %s%n", Arrays.toString(scores));
        System.out.printf("Сумма: %.2f%n", sum);
        System.out.printf("Среднее: %.2f%n", average);

        // Обращение строки
        System.out.println("\n4. Обращение строки:");
        String original = "Java Programming";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }
        System.out.println("Оригинал: " + original);
        System.out.println("Обращенная: " + reversed);

        // Таблица умножения
        System.out.println("\n5. Таблица умножения на 7:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("7 x " + i + " = " + (7 * i));
        }
    }

    /**
     * Симуляция валидации ввода пользователя
     */
    private void simulateInputValidation() {
        // Симулируем серию вводов пользователя
        String[] simulatedInputs = {"abc", "0", "-5", "15", "8"};
        int inputIndex = 0;

        System.out.println("Симуляция ввода числа от 1 до 10:");

        int number = 0;
        boolean validInput = false;

        while (!validInput && inputIndex < simulatedInputs.length) {
            String input = simulatedInputs[inputIndex++];
            System.out.println("Ввод: " + input);

            try {
                number = Integer.parseInt(input);
                if (number >= 1 && number <= 10) {
                    validInput = true;
                    System.out.println("Валидное число: " + number);
                } else {
                    System.out.println("Число должно быть от 1 до 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("Это не число, попробуйте еще раз");
            }
        }

        if (!validInput) {
            System.out.println("Не удалось получить валидный ввод");
        }
    }

    /**
     * Симуляция меню с do-while
     */
    private void simulateMenuLoop() {
        // Симулируем выборы пользователя
        int[] choices = {1, 3, 2, 4};
        int choiceIndex = 0;

        int choice;
        do {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Показать время");
            System.out.println("2. Показать дату");
            System.out.println("3. Показать версию");
            System.out.println("4. Выход");
            System.out.print("Выберите опцию: ");

            // Симулируем ввод пользователя
            choice = (choiceIndex < choices.length) ? choices[choiceIndex++] : 4;
            System.out.println(choice);

            switch (choice) {
                case 1:
                    System.out.println("Текущее время: 14:30:25");
                    break;
                case 2:
                    System.out.println("Текущая дата: 2024-08-24");
                    break;
                case 3:
                    System.out.println("Версия программы: 1.0.0");
                    break;
                case 4:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        } while (choice != 4);
    }

    /**
     * Симуляция игрового цикла
     */
    private void simulateGameLoop() {
        int playerHealth = 100;
        int enemyHealth = 80;
        int round = 1;

        System.out.println("Начало боя! Здоровье игрока: " + playerHealth + ", здоровье противника: " + enemyHealth);

        do {
            System.out.println("\n--- Раунд " + round + " ---");

            // Игрок атакует
            int playerDamage = (int)(Math.random() * 20) + 10; // 10-29 урона
            enemyHealth -= playerDamage;
            System.out.println("Игрок наносит " + playerDamage + " урона. Здоровье противника: " + Math.max(0, enemyHealth));

            if (enemyHealth <= 0) {
                System.out.println("Противник побежден! Победа игрока!");
                break;
            }

            // Противник атакует
            int enemyDamage = (int)(Math.random() * 15) + 5; // 5-19 урона
            playerHealth -= enemyDamage;
            System.out.println("Противник наносит " + enemyDamage + " урона. Здоровье игрока: " + Math.max(0, playerHealth));

            if (playerHealth <= 0) {
                System.out.println("Игрок побежден! Поражение!");
                break;
            }

            round++;

        } while (playerHealth > 0 && enemyHealth > 0);

        System.out.println("Бой завершен за " + (round - 1) + " раундов.");
    }

    /**
     * Главный метод для демонстрации всех типов циклов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация основных конструкций циклов ===");

        BasicLoopsDemo demo = new BasicLoopsDemo();

        // Выполняем все демонстрации
        demo.demonstrateForLoops();
        demo.demonstrateWhileLoops();
        demo.demonstrateDoWhileLoops();
        demo.demonstrateEnhancedForLoops();
        demo.demonstratePracticalExamples();

        System.out.println("\n=== Резюме по циклам ===");
        System.out.println("1. for - когда известно количество итераций");
        System.out.println("2. while - когда количество итераций зависит от условия");
        System.out.println("3. do-while - когда нужно выполнить тело минимум один раз");
        System.out.println("4. enhanced for - для простого перебора массивов и коллекций");
        System.out.println("5. Все циклы могут быть прерваны с помощью break");
        System.out.println("6. continue пропускает оставшуюся часть итерации");
        System.out.println("7. Избегайте бесконечных циклов - всегда обновляйте условие");
    }
}
