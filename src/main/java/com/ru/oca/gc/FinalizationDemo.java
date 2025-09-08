package com.ru.oca.gc;

/**
 * Демонстрация работы с методом finalize() и его особенностями.
 * Показывает непредсказуемость финализации, возможность "воскрешения" объекта
 * и проблемы, связанные с использованием finalize().
 */
public class FinalizationDemo {

    // Статическая переменная для демонстрации "воскрешения" объекта
    private static FinalizableObject resurrectReference;

    /**
     * Демонстрация базовой работы с finalize()
     */
    public void demonstrateBasicFinalization() {
        System.out.println("=== Базовая финализация ===");

        // Создаем объект с переопределенным finalize()
        FinalizableObject obj = new FinalizableObject("BasicObject");
        System.out.println("Создан объект: " + obj);

        // Обнуляем ссылку - объект становится eligible для GC
        obj = null;
        System.out.println("Ссылка обнулена - объект eligible для finalization");

        // Запрашиваем сборку мусора
        System.out.println("Запрос сборки мусора...");
        System.gc();

        // Даем время для finalization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Finalization может произойти или не произойти\n");
    }

    /**
     * Демонстрация множественных объектов с финализацией
     */
    public void demonstrateMultipleFinalization() {
        System.out.println("=== Множественная финализация ===");

        // Создаем несколько объектов
        for (int i = 1; i <= 5; i++) {
            FinalizableObject obj = new FinalizableObject("Object" + i);
            System.out.println("Создан: " + obj);
            // obj выходит из области видимости в конце итерации
        }

        System.out.println("Все объекты созданы и вышли из области видимости");

        // Запрашиваем сборку мусора
        System.out.println("Запрос сборки мусора для множественных объектов...");
        System.gc();

        // Даем время для finalization
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Финализация может произойти в любом порядке или не произойти вовсе\n");
    }

    /**
     * Демонстрация "воскрешения" объекта в finalize()
     */
    public void demonstrateObjectResurrection() {
        System.out.println("=== Воскрешение объекта ===");

        // Создаем объект, который может "воскреснуть"
        ResurrectableObject obj = new ResurrectableObject("Phoenix");
        System.out.println("Создан воскрешаемый объект: " + obj);

        // Обнуляем ссылку
        obj = null;
        System.out.println("Ссылка обнулена - объект eligible для finalization");

        // Первая сборка мусора - объект "воскресает"
        System.out.println("Первый запрос сборки мусора...");
        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Проверяем, воскрес ли объект
        if (resurrectReference != null) {
            System.out.println("Объект воскрес! " + resurrectReference);

            // Снова обнуляем ссылку
            resurrectReference = null;
            System.out.println("Снова обнуляем ссылку...");

            // Второй запрос сборки мусора - finalize() уже не будет вызван
            System.out.println("Второй запрос сборки мусора...");
            System.gc();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Теперь объект действительно удален (finalize вызывается только один раз)");
        } else {
            System.out.println("Объект не воскрес (finalize может не вызываться)");
        }

        System.out.println();
    }

    /**
     * Демонстрация проблем с finalize()
     */
    public void demonstrateFinalizationProblems() {
        System.out.println("=== Проблемы с финализацией ===");

        // Проблема 1: Замедление сборки мусора
        System.out.println("Проблема 1: Замедление GC");
        long startTime = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            new SlowFinalizableObject("Slow" + i);
        }

        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long endTime = System.nanoTime();
        System.out.println("Время с finalize(): " + (endTime - startTime) / 1_000_000 + " мс");

        // Проблема 2: Непредсказуемость
        System.out.println("\nПроблема 2: Непредсказуемость вызова");
        for (int i = 0; i < 3; i++) {
            new UnpredictableObject("Unpredictable" + i);
        }

        System.out.println("Созданы объекты с finalize()");
        System.gc();
        System.out.println("Запрошена сборка мусора - finalize() может вызваться или нет");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
    }

    /**
     * Демонстрация альтернатив finalize()
     */
    public void demonstrateAlternatives() {
        System.out.println("=== Альтернативы finalize() ===");

        // Альтернатива 1: Explicit cleanup
        System.out.println("Альтернатива 1: Явная очистка");
        CleanableResource resource1 = new CleanableResource("ExplicitResource");
        System.out.println("Создан ресурс: " + resource1);

        // Явно вызываем очистку
        resource1.close();
        System.out.println("Ресурс явно закрыт");

        // Альтернатива 2: Try-with-resources
        System.out.println("\nАльтернатива 2: Try-with-resources");
        try (AutoCloseableResource resource2 = new AutoCloseableResource("AutoResource")) {
            System.out.println("Использование ресурса: " + resource2);
        } // Автоматически закрывается здесь

        System.out.println("Ресурс автоматически закрыт через try-with-resources");

        // Альтернатива 3: Explicit state management
        System.out.println("\nАльтернатива 3: Управление состоянием");
        StateManagableResource resource3 = new StateManagableResource("StatefulResource");
        System.out.println("Создан ресурс: " + resource3);

        resource3.cleanup();
        System.out.println("Ресурс очищен через управление состоянием");

        System.out.println();
    }

    /**
     * Базовый класс с финализацией
     */
    static class FinalizableObject {
        private String name;
        private static int finalizedCount = 0;

        public FinalizableObject(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                finalizedCount++;
                System.out.println("  [FINALIZE] " + name + " финализирован (всего: " + finalizedCount + ")");
            } finally {
                super.finalize();
            }
        }

        @Override
        public String toString() {
            return "FinalizableObject{name='" + name + "'}";
        }
    }

    /**
     * Класс, который может "воскреснуть" в finalize()
     */
    static class ResurrectableObject extends FinalizableObject {
        private boolean finalized = false;

        public ResurrectableObject(String name) {
            super(name);
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                if (!finalized) {
                    System.out.println("  [RESURRECT] Объект " + this + " воскрешается!");
                    resurrectReference = this; // "Воскрешаем" объект
                    finalized = true; // Помечаем, что finalize() уже был вызван
                } else {
                    System.out.println("  [FINALIZE] " + this + " окончательно финализирован");
                }
            } finally {
                super.finalize();
            }
        }
    }

    /**
     * Класс с медленной финализацией
     */
    static class SlowFinalizableObject {
        private String name;

        public SlowFinalizableObject(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                // Имитируем медленную очистку
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                super.finalize();
            }
        }
    }

    /**
     * Класс с непредсказуемой финализацией
     */
    static class UnpredictableObject {
        private String name;

        public UnpredictableObject(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            try {
                System.out.println("  [UNPREDICTABLE] " + name + " может финализироваться или нет");
            } finally {
                super.finalize();
            }
        }
    }

    /**
     * Класс с явной очисткой ресурсов
     */
    static class CleanableResource {
        private String name;
        private boolean closed = false;

        public CleanableResource(String name) {
            this.name = name;
        }

        public void close() {
            if (!closed) {
                System.out.println("  [EXPLICIT] Явная очистка ресурса " + name);
                closed = true;
            }
        }

        @Override
        public String toString() {
            return "CleanableResource{name='" + name + "', closed=" + closed + "}";
        }
    }

    /**
     * Класс с AutoCloseable для try-with-resources
     */
    static class AutoCloseableResource implements AutoCloseable {
        private String name;
        private boolean closed = false;

        public AutoCloseableResource(String name) {
            this.name = name;
        }

        @Override
        public void close() {
            if (!closed) {
                System.out.println("  [AUTO-CLOSE] Автоматическая очистка ресурса " + name);
                closed = true;
            }
        }

        @Override
        public String toString() {
            return "AutoCloseableResource{name='" + name + "', closed=" + closed + "}";
        }
    }

    /**
     * Класс с управлением состоянием
     */
    static class StateManagableResource {
        private String name;
        private boolean cleaned = false;

        public StateManagableResource(String name) {
            this.name = name;
        }

        public void cleanup() {
            if (!cleaned) {
                System.out.println("  [STATE] Очистка через управление состоянием " + name);
                cleaned = true;
            }
        }

        public boolean isCleaned() {
            return cleaned;
        }

        @Override
        public String toString() {
            return "StateManagableResource{name='" + name + "', cleaned=" + cleaned + "}";
        }
    }

    /**
     * Главный метод для демонстрации всех аспектов финализации
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация финализации объектов ===\n");

        FinalizationDemo demo = new FinalizationDemo();

        // Демонстрируем различные аспекты финализации
        demo.demonstrateBasicFinalization();
        demo.demonstrateMultipleFinalization();
        demo.demonstrateObjectResurrection();
        demo.demonstrateFinalizationProblems();
        demo.demonstrateAlternatives();

        System.out.println("=== Заключение о финализации ===");
        System.out.println("Проблемы с finalize():");
        System.out.println("1. Нет гарантии вызова - может никогда не выполниться");
        System.out.println("2. Непредсказуемое время вызова - может быть большая задержка");
        System.out.println("3. Замедляет сборку мусора - требует дополнительного цикла GC");
        System.out.println("4. Может вызываться только один раз для объекта");
        System.out.println("5. Объект может 'воскреснуть' в finalize()");
        System.out.println("6. Исключения в finalize() игнорируются");

        System.out.println("\nРекомендуемые альтернативы:");
        System.out.println("1. Explicit cleanup - явные методы очистки");
        System.out.println("2. Try-with-resources - автоматическая очистка");
        System.out.println("3. State management - управление состоянием объекта");
        System.out.println("4. Weak/Soft references - для cache и т.п.");

        System.out.println("\nВажно: finalize() deprecated начиная с Java 9!");
    }
}
