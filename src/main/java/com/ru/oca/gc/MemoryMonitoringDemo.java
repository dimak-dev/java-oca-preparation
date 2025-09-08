package com.ru.oca.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация мониторинга памяти и работы с System.gc().
 * Показывает методы Runtime для отслеживания состояния памяти,
 * эффективность запросов сборки мусора и практические рекомендации.
 */
public class MemoryMonitoringDemo {

    // Коллекция для хранения объектов во время демонстрации
    private List<Object> objectStorage = new ArrayList<>();

    /**
     * Демонстрация базового мониторинга памяти
     */
    public void demonstrateBasicMemoryMonitoring() {
        System.out.println("=== Базовый мониторинг памяти ===");

        Runtime runtime = Runtime.getRuntime();

        // Показываем информацию о памяти до создания объектов
        displayMemoryInfo("До создания объектов", runtime);

        // Создаем множество объектов
        System.out.println("Создание 10000 строк...");
        for (int i = 0; i < 10000; i++) {
            objectStorage.add(new String("Object " + i));
        }

        displayMemoryInfo("После создания 10000 строк", runtime);

        // Обнуляем коллекцию - объекты становятся eligible для GC
        objectStorage.clear();
        System.out.println("Коллекция очищена - объекты eligible для GC");

        displayMemoryInfo("После очистки коллекции (до GC)", runtime);

        // Запрашиваем сборку мусора
        System.out.println("Запрос сборки мусора...");
        System.gc();

        // Даем время для сборки мусора
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        displayMemoryInfo("После запроса System.gc()", runtime);
        System.out.println();
    }

    /**
     * Демонстрация различий между totalMemory, freeMemory и maxMemory
     */
    public void demonstrateMemoryTypes() {
        System.out.println("=== Типы памяти ===");

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Объяснение типов памяти:");
        System.out.println("- totalMemory(): текущий размер кучи (может увеличиваться)");
        System.out.println("- freeMemory(): свободная память в текущей куче");
        System.out.println("- maxMemory(): максимально возможный размер кучи");
        System.out.println("- usedMemory(): totalMemory() - freeMemory()");

        long total = runtime.totalMemory();
        long free = runtime.freeMemory();
        long max = runtime.maxMemory();
        long used = total - free;
        long available = max - used;

        System.out.println("\nТекущее состояние памяти:");
        System.out.printf("Total Memory:     %,d bytes (%.2f MB)%n", total, total / 1024.0 / 1024.0);
        System.out.printf("Free Memory:      %,d bytes (%.2f MB)%n", free, free / 1024.0 / 1024.0);
        System.out.printf("Max Memory:       %,d bytes (%.2f MB)%n", max, max / 1024.0 / 1024.0);
        System.out.printf("Used Memory:      %,d bytes (%.2f MB)%n", used, used / 1024.0 / 1024.0);
        System.out.printf("Available Memory: %,d bytes (%.2f MB)%n", available, available / 1024.0 / 1024.0);

        double usagePercent = (double) used / max * 100;
        System.out.printf("Memory Usage:     %.2f%%%n", usagePercent);
        System.out.println();
    }

    /**
     * Демонстрация эффективности System.gc()
     */
    public void demonstrateGCEffectiveness() {
        System.out.println("=== Эффективность System.gc() ===");

        Runtime runtime = Runtime.getRuntime();

        // Создаем большое количество объектов
        List<byte[]> largeObjects = new ArrayList<>();
        System.out.println("Создание больших объектов (массивы по 1MB)...");

        for (int i = 0; i < 50; i++) {
            largeObjects.add(new byte[1024 * 1024]); // 1MB массивы
            if (i % 10 == 0) {
                displayMemoryInfo("После создания " + (i + 1) + " объектов", runtime);
            }
        }

        System.out.println("Создано 50 больших объектов");
        displayMemoryInfo("После создания всех объектов", runtime);

        // Освобождаем ссылки
        largeObjects.clear();
        System.out.println("Все ссылки освобождены - объекты eligible для GC");

        // Проверяем память до GC
        long usedBeforeGC = runtime.totalMemory() - runtime.freeMemory();
        displayMemoryInfo("До System.gc()", runtime);

        // Запрашиваем сборку мусора
        System.out.println("Вызов System.gc()...");
        long startTime = System.nanoTime();
        System.gc();
        long gcTime = System.nanoTime() - startTime;

        // Даем время для завершения
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Проверяем память после GC
        long usedAfterGC = runtime.totalMemory() - runtime.freeMemory();
        displayMemoryInfo("После System.gc()", runtime);

        // Рассчитываем эффективность
        long freedMemory = usedBeforeGC - usedAfterGC;
        double effectiveness = (double) freedMemory / usedBeforeGC * 100;

        System.out.printf("Время выполнения System.gc(): %.2f мс%n", gcTime / 1_000_000.0);
        System.out.printf("Освобождено памяти: %,d bytes (%.2f MB)%n", freedMemory, freedMemory / 1024.0 / 1024.0);
        System.out.printf("Эффективность GC: %.2f%%%n", effectiveness);
        System.out.println();
    }

    /**
     * Демонстрация мониторинга в режиме реального времени
     */
    public void demonstrateRealTimeMonitoring() {
        System.out.println("=== Мониторинг в режиме реального времени ===");

        Runtime runtime = Runtime.getRuntime();
        MemoryMonitor monitor = new MemoryMonitor(runtime);

        System.out.println("Запуск мониторинга памяти...");

        // Создаем и удаляем объекты в цикле
        for (int cycle = 1; cycle <= 5; cycle++) {
            System.out.println("\n--- Цикл " + cycle + " ---");
            List<String> tempObjects = new ArrayList<>();

            // Создаем объекты
            for (int i = 0; i < 5000; i++) {
                tempObjects.add(new String("Temp object " + i + " in cycle " + cycle));
                if (i % 1000 == 0) {
                    monitor.snapshot("Цикл " + cycle + ", создано " + (i + 1) + " объектов");
                }
            }

            // Небольшая пауза
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Освобождаем объекты
            tempObjects.clear();
            monitor.snapshot("Цикл " + cycle + ", объекты освобождены");

            // Периодический запрос GC
            if (cycle % 2 == 0) {
                System.gc();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                monitor.snapshot("Цикл " + cycle + ", после System.gc()");
            }
        }

        monitor.printSummary();
        System.out.println();
    }

    /**
     * Демонстрация влияния различных типов объектов на память
     */
    public void demonstrateObjectTypeImpact() {
        System.out.println("=== Влияние типов объектов на память ===");

        Runtime runtime = Runtime.getRuntime();

        // Тест 1: Примитивные обертки
        System.out.println("Тест 1: Создание Integer объектов");
        displayMemoryInfo("До создания Integer", runtime);

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            integers.add(i); // Автоупаковка
        }

        displayMemoryInfo("После создания 100000 Integer", runtime);
        integers.clear();
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        displayMemoryInfo("После освобождения Integer", runtime);

        // Тест 2: Строки
        System.out.println("\nТест 2: Создание String объектов");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            strings.add("String number " + i);
        }

        displayMemoryInfo("После создания 50000 String", runtime);
        strings.clear();
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        displayMemoryInfo("После освобождения String", runtime);

        // Тест 3: Массивы
        System.out.println("\nТест 3: Создание массивов");
        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrays.add(new int[1000]); // Массивы по 1000 int
        }

        displayMemoryInfo("После создания 1000 массивов", runtime);
        arrays.clear();
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        displayMemoryInfo("После освобождения массивов", runtime);
        System.out.println();
    }

    /**
     * Демонстрация рекомендаций по управлению памятью
     */
    public void demonstrateMemoryManagementBestPractices() {
        System.out.println("=== Лучшие практики управления памятью ===");

        System.out.println("1. Избегайте преждевременного вызова System.gc()");
        System.out.println("   - JVM оптимизирует сборку мусора лучше программиста");
        System.out.println("   - System.gc() может негативно влиять на производительность");

        System.out.println("\n2. Освобождайте ссылки на ненужные объекты");
        System.out.println("   - Обнуляйте коллекции: list = null");
        System.out.println("   - Используйте clear() для коллекций");
        System.out.println("   - Закрывайте ресурсы в finally или try-with-resources");

        System.out.println("\n3. Мониторьте потребление памяти");
        System.out.println("   - Используйте профилировщики для анализа");
        System.out.println("   - Отслеживайте утечки памяти");
        System.out.println("   - Настраивайте параметры JVM при необходимости");

        System.out.println("\n4. Оптимизируйте создание объектов");
        System.out.println("   - Переиспользуйте объекты где возможно");
        System.out.println("   - Используйте object pools для дорогих объектов");
        System.out.println("   - Избегайте создания объектов в циклах");

        // Практическая демонстрация
        System.out.println("\nПрактическая демонстрация:");
        demonstrateBadPractice();
        demonstrateGoodPractice();

        System.out.println();
    }

    /**
     * Демонстрация плохой практики
     */
    private void demonstrateBadPractice() {
        System.out.println("ПЛОХО: Создание объектов в цикле");
        Runtime runtime = Runtime.getRuntime();

        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        // Плохая практика - создание объектов в цикле
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += "Item " + i + " "; // Создается много промежуточных String объектов
        }

        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("  Время: %.2f мс, Память: +%,d bytes%n",
                         (endTime - startTime) / 1_000_000.0, endMemory - startMemory);
    }

    /**
     * Демонстрация хорошей практики
     */
    private void demonstrateGoodPractice() {
        System.out.println("ХОРОШО: Использование StringBuilder");
        Runtime runtime = Runtime.getRuntime();

        long startMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        // Хорошая практика - использование StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("Item ").append(i).append(" ");
        }
        String result = sb.toString();

        long endTime = System.nanoTime();
        long endMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.printf("  Время: %.2f мс, Память: +%,d bytes%n",
                         (endTime - startTime) / 1_000_000.0, endMemory - startMemory);
    }

    /**
     * Утилитарный метод для отображения информации о памяти
     */
    private void displayMemoryInfo(String label, Runtime runtime) {
        long total = runtime.totalMemory();
        long free = runtime.freeMemory();
        long used = total - free;
        long max = runtime.maxMemory();

        System.out.printf("%-35s: Used: %,d KB, Free: %,d KB, Total: %,d KB%n",
                         label, used / 1024, free / 1024, total / 1024);
    }

    /**
     * Вспомогательный класс для мониторинга памяти
     */
    static class MemoryMonitor {
        private final Runtime runtime;
        private final List<MemorySnapshot> snapshots = new ArrayList<>();

        public MemoryMonitor(Runtime runtime) {
            this.runtime = runtime;
        }

        public void snapshot(String description) {
            snapshots.add(new MemorySnapshot(description, runtime));
        }

        public void printSummary() {
            System.out.println("\n--- Сводка мониторинга памяти ---");
            for (int i = 0; i < snapshots.size(); i++) {
                MemorySnapshot snapshot = snapshots.get(i);
                System.out.printf("%2d. %-30s: %,d KB used%n",
                                 i + 1, snapshot.description, snapshot.usedMemory / 1024);
            }

            if (snapshots.size() > 1) {
                MemorySnapshot first = snapshots.get(0);
                MemorySnapshot last = snapshots.get(snapshots.size() - 1);
                long memoryDiff = last.usedMemory - first.usedMemory;
                System.out.printf("Общее изменение памяти: %+,d KB%n", memoryDiff / 1024);
            }
        }

        private static class MemorySnapshot {
            final String description;
            final long usedMemory;
            final long timestamp;

            MemorySnapshot(String description, Runtime runtime) {
                this.description = description;
                this.usedMemory = runtime.totalMemory() - runtime.freeMemory();
                this.timestamp = System.currentTimeMillis();
            }
        }
    }

    /**
     * Главный метод для демонстрации всех аспектов мониторинга памяти
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация мониторинга памяти и System.gc() ===\n");

        MemoryMonitoringDemo demo = new MemoryMonitoringDemo();

        // Выполняем все демонстрации
        demo.demonstrateMemoryTypes();
        demo.demonstrateBasicMemoryMonitoring();
        demo.demonstrateGCEffectiveness();
        demo.demonstrateRealTimeMonitoring();
        demo.demonstrateObjectTypeImpact();
        demo.demonstrateMemoryManagementBestPractices();

        System.out.println("=== Заключение ===");
        System.out.println("Ключевые моменты управления памятью:");
        System.out.println("1. Runtime предоставляет информацию о состоянии памяти");
        System.out.println("2. System.gc() - только запрос, не команда");
        System.out.println("3. Мониторинг памяти помогает выявлять проблемы");
        System.out.println("4. Правильное управление ссылками критично для производительности");
        System.out.println("5. JVM оптимизирует сборку мусора автоматически");

        System.out.println("\nВАЖНО:");
        System.out.println("- Не вызывайте System.gc() без крайней необходимости");
        System.out.println("- Используйте профилировщики для глубокого анализа");
        System.out.println("- Оптимизируйте алгоритмы, а не сборку мусора");
    }
}
