package com.ru.oca.loops;

import java.util.Arrays;

/**
 * Демонстрация управляющих операторов break и continue в циклах.
 * Показывает использование break, continue и меток (labels) во вложенных циклах.
 */
public class LoopControlDemo {

    /**
     * Демонстрация оператора break
     */
    public void demonstrateBreakStatement() {
        System.out.println("=== Демонстрация оператора break ===");

        // Break в простом цикле for
        System.out.println("1. Break в простом for цикле:");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println("   Прерываем цикл на i = " + i);
                break; // Выход из цикла
            }
            System.out.println("   i = " + i);
        }
        System.out.println("   Цикл завершен");

        // Break в while цикле
        System.out.println("\n2. Break в while цикле:");
        int count = 0;
        while (true) { // Бесконечный цикл
            if (count >= 3) {
                System.out.println("   Достигли limit, выходим");
                break;
            }
            System.out.println("   Count = " + count);
            count++;
        }

        // Break в switch внутри цикла
        System.out.println("\n3. Break в switch внутри цикла:");
        for (int day = 1; day <= 7; day++) {
            System.out.print("   День " + day + ": ");
            switch (day) {
                case 1: case 2: case 3: case 4: case 5:
                    System.out.println("Рабочий день");
                    break; // Break только для switch!
                case 6:
                    System.out.println("Суббота - выходной");
                    if (day == 6) {
                        System.out.println("   Прерываем цикл на выходных");
                        break; // Break для цикла, не для switch!
                    }
                    break;
                case 7:
                    System.out.println("Воскресенье - выходной");
                    break;
                default:
                    System.out.println("Неизвестный день");
                    break;
            }
            if (day == 6) break; // Дополнительный break для выхода из цикла
        }

        // Break для поиска элемента
        System.out.println("\n4. Break для поиска элемента:");
        int[] numbers = {10, 25, 30, 45, 50, 75, 90};
        int target = 45;
        int foundIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("   Проверяем элемент " + numbers[i]);
            if (numbers[i] == target) {
                foundIndex = i;
                System.out.println("   Найден! Индекс: " + foundIndex);
                break; // Прерываем поиск после нахождения
            }
        }

        if (foundIndex == -1) {
            System.out.println("   Элемент не найден");
        }
    }

    /**
     * Демонстрация оператора continue
     */
    public void demonstrateContinueStatement() {
        System.out.println("\n=== Демонстрация оператора continue ===");

        // Continue в for цикле
        System.out.println("1. Continue в for цикле (пропускаем четные числа):");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                continue; // Пропускаем четные числа
            }
            System.out.println("   Нечетное число: " + i);
        }

        // Continue в while цикле
        System.out.println("\n2. Continue в while цикле:");
        int num = 0;
        while (num < 8) {
            num++;
            if (num == 3 || num == 6) {
                System.out.println("   Пропускаем число " + num);
                continue;
            }
            System.out.println("   Обрабатываем число: " + num);
        }

        // Continue для фильтрации данных
        System.out.println("\n3. Continue для фильтрации данных:");
        String[] words = {"Java", "", "Python", null, "JavaScript", "   ", "C++"};

        System.out.println("   Валидные слова:");
        for (String word : words) {
            // Пропускаем null, пустые и состоящие только из пробелов строки
            if (word == null || word.trim().isEmpty()) {
                continue;
            }
            System.out.println("   - " + word);
        }

        // Continue в do-while
        System.out.println("\n4. Continue в do-while цикле:");
        int value = 0;
        do {
            value++;
            if (value == 2 || value == 4) {
                continue; // Пропускаем 2 и 4
            }
            System.out.println("   Значение: " + value);
        } while (value < 6);
    }

    /**
     * Демонстрация вложенных циклов без меток
     */
    public void demonstrateNestedLoopsBasic() {
        System.out.println("\n=== Вложенные циклы без меток ===");

        // Простые вложенные циклы
        System.out.println("1. Таблица умножения 3x3:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        // Break во вложенном цикле (влияет только на внутренний)
        System.out.println("\n2. Break во вложенном цикле:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("   Внешний цикл i = " + i);
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    System.out.println("     Прерываем внутренний цикл на j = " + j);
                    break; // Только внутренний цикл прерывается
                }
                System.out.println("     Внутренний цикл j = " + j);
            }
        }

        // Continue во вложенном цикле
        System.out.println("\n3. Continue во вложенном цикле:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("   Строка " + i + ":");
            for (int j = 1; j <= 5; j++) {
                if (j == 3) {
                    continue; // Пропускаем только j=3
                }
                System.out.print("   " + j);
            }
            System.out.println();
        }
    }

    /**
     * Демонстрация меток (labels) и их использования
     */
    public void demonstrateLabelsAndBreak() {
        System.out.println("\n=== Демонстрация меток (labels) ===");

        // Базовое использование меток с break
        System.out.println("1. Break с меткой для выхода из внешнего цикла:");
        outer: // Метка для внешнего цикла
        for (int i = 1; i <= 3; i++) {
            System.out.println("   Внешний i = " + i);
            for (int j = 1; j <= 3; j++) {
                System.out.println("     Внутренний j = " + j);
                if (i == 2 && j == 2) {
                    System.out.println("     Break outer на i=" + i + ", j=" + j);
                    break outer; // Выходим из внешнего цикла
                }
            }
            System.out.println("   Конец внутреннего цикла для i = " + i);
        }
        System.out.println("   После внешнего цикла");

        // Continue с меткой
        System.out.println("\n2. Continue с меткой:");
        outerLoop:
        for (int i = 1; i <= 4; i++) {
            System.out.println("   Начало итерации i = " + i);
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("     Continue outer на i=" + i + ", j=" + j);
                    continue outerLoop; // Переход к следующей итерации внешнего цикла
                }
                System.out.println("     i=" + i + ", j=" + j);
            }
            System.out.println("   Конец внутреннего цикла для i = " + i);
        }

        // Трёхуровневые вложенные циклы с метками
        System.out.println("\n3. Трёхуровневые циклы с метками:");
        firstLevel:
        for (int i = 1; i <= 2; i++) {
            secondLevel:
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 2; k++) {
                    System.out.println("     i=" + i + ", j=" + j + ", k=" + k);

                    if (i == 1 && j == 2 && k == 1) {
                        System.out.println("     Continue firstLevel");
                        continue firstLevel;
                    }

                    if (i == 2 && j == 1 && k == 2) {
                        System.out.println("     Break secondLevel");
                        break secondLevel;
                    }
                }
            }
        }
    }

    /**
     * Практические примеры использования break и continue
     */
    public void demonstratePracticalExamples() {
        System.out.println("\n=== Практические примеры ===");

        // Поиск простых чисел с continue
        System.out.println("1. Поиск простых чисел от 2 до 20:");
        for (int num = 2; num <= 20; num++) {
            boolean isPrime = true;

            // Проверяем деление на числа от 2 до sqrt(num)
            for (int divisor = 2; divisor <= Math.sqrt(num); divisor++) {
                if (num % divisor == 0) {
                    isPrime = false;
                    break; // Нашли делитель - число не простое
                }
            }

            if (isPrime) {
                System.out.print("   " + num);
            }
        }
        System.out.println();

        // Поиск в двумерном массиве с метками
        System.out.println("\n2. Поиск элемента в двумерном массиве:");
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int searchValue = 7;
        boolean found = false;

        searchLoop:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == searchValue) {
                    System.out.println("   Найден " + searchValue + " в позиции [" + i + "][" + j + "]");
                    found = true;
                    break searchLoop; // Выходим из обоих циклов
                }
            }
        }

        if (!found) {
            System.out.println("   Элемент " + searchValue + " не найден");
        }

        // Валидация и обработка данных
        System.out.println("\n3. Обработка списка чисел (пропуск недопустимых):");
        int[] numbers = {10, -5, 0, 15, -3, 25, 8, -1, 30};
        int sum = 0;
        int count = 0;

        for (int number : numbers) {
            if (number < 0) {
                System.out.println("   Пропускаем отрицательное число: " + number);
                continue; // Пропускаем отрицательные числа
            }

            if (number == 0) {
                System.out.println("   Пропускаем ноль");
                continue; // Пропускаем ноль
            }

            sum += number;
            count++;
            System.out.println("   Добавляем: " + number);
        }

        if (count > 0) {
            System.out.printf("   Сумма положительных чисел: %d, среднее: %.2f%n",
                            sum, (double)sum / count);
        }

        // Игровой цикл с несколькими условиями выхода
        System.out.println("\n4. Игровой цикл с multiple exit conditions:");
        simulateGameWithMultipleExits();
    }

    /**
     * Симуляция игры с несколькими условиями выхода
     */
    private void simulateGameWithMultipleExits() {
        int health = 100;
        int turns = 0;
        int maxTurns = 10;
        boolean foundTreasure = false;

        // Симулируем события игры
        String[] events = {"fight", "treasure", "trap", "heal", "fight", "treasure", "fight"};
        int eventIndex = 0;

        gameLoop:
        while (true) {
            turns++;
            System.out.println("   Ход " + turns + ", здоровье: " + health);

            // Проверка условий выхода
            if (turns > maxTurns) {
                System.out.println("   Время истекло! Игра окончена.");
                break gameLoop;
            }

            if (health <= 0) {
                System.out.println("   Герой погиб! Игра окончена.");
                break gameLoop;
            }

            // Симуляция события
            String event = events[eventIndex % events.length];
            eventIndex++;

            switch (event) {
                case "fight":
                    int damage = (int)(Math.random() * 20) + 5;
                    health -= damage;
                    System.out.println("   Бой! Получен урон: " + damage);
                    if (health <= 0) {
                        continue gameLoop; // Проверим условие выхода в начале цикла
                    }
                    break;

                case "treasure":
                    System.out.println("   Найдено сокровище!");
                    foundTreasure = true;
                    break gameLoop; // Победа!

                case "trap":
                    if (Math.random() < 0.5) {
                        System.out.println("   Ловушка! Пропускаем ход.");
                        continue gameLoop; // Пропускаем остальную логику хода
                    } else {
                        System.out.println("   Ловушка обезврежена.");
                    }
                    break;

                case "heal":
                    int healing = (int)(Math.random() * 15) + 5;
                    health = Math.min(health + healing, 100);
                    System.out.println("   Найдено зелье! Восстановлено здоровья: " + healing);
                    break;
            }
        }

        // Результат игры
        if (foundTreasure) {
            System.out.println("   ПОБЕДА! Сокровище найдено за " + turns + " ходов!");
        } else if (health <= 0) {
            System.out.println("   ПОРАЖЕНИЕ! Герой погиб на " + turns + " ходу.");
        } else {
            System.out.println("   НИЧЬЯ! Время истекло, здоровье: " + health);
        }
    }

    /**
     * Демонстрация распространенных ошибок
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Распространенные ошибки ===");

        // Ошибка 1: Неправильное использование break в switch
        System.out.println("1. Правильное использование break в switch:");
        for (int i = 1; i <= 3; i++) {
            System.out.print("   i = " + i + ": ");
            switch (i) {
                case 1:
                    System.out.println("Один");
                    break; // Важно! Иначе провалится в case 2
                case 2:
                    System.out.println("Два");
                    break;
                case 3:
                    System.out.println("Три");
                    break;
                default:
                    System.out.println("Другое");
            }
        }

        // Ошибка 2: Бесконечные циклы из-за неправильного continue
        System.out.println("\n2. Осторожно с continue в while (избегаем бесконечного цикла):");
        int counter = 0;
        while (counter < 5) {
            counter++; // ВАЖНО: инкремент ДО continue
            if (counter == 3) {
                System.out.println("   Пропускаем " + counter);
                continue;
            }
            System.out.println("   Обрабатываем " + counter);
        }

        // Ошибка 3: Неправильное понимание области действия меток
        System.out.println("\n3. Метки действуют только на циклы:");
        testLabel: { // Это НЕ цикл - break testLabel не сработает в цикле
            System.out.println("   Начало блока с меткой");
            for (int i = 0; i < 3; i++) {
                if (i == 1) {
                    System.out.println("   Выходим из блока на i = " + i);
                    break testLabel; // Работает, потому что метка на блоке
                }
                System.out.println("   i = " + i);
            }
            System.out.println("   Конец блока (не выполнится)");
        }
        System.out.println("   После блока с меткой");
    }

    /**
     * Главный метод для демонстрации управляющих операторов
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация управляющих операторов циклов ===");

        LoopControlDemo demo = new LoopControlDemo();

        // Выполняем все демонстрации
        demo.demonstrateBreakStatement();
        demo.demonstrateContinueStatement();
        demo.demonstrateNestedLoopsBasic();
        demo.demonstrateLabelsAndBreak();
        demo.demonstratePracticalExamples();
        demo.demonstrateCommonMistakes();

        System.out.println("\n=== Резюме по управляющим операторам ===");
        System.out.println("1. break - немедленно завершает выполнение цикла");
        System.out.println("2. continue - пропускает оставшуюся часть текущей итерации");
        System.out.println("3. В for: continue переходит к части update");
        System.out.println("4. В while/do-while: continue переходит к проверке условия");
        System.out.println("5. Метки позволяют управлять внешними циклами");
        System.out.println("6. break/continue без меток влияют только на ближайший цикл");
        System.out.println("7. В switch внутри цикла break относится к switch, не к циклу");
        System.out.println("8. Осторожно с continue в while - можно создать бесконечный цикл");
    }
}
