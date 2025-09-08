package com.ru.oca.constructors;

/**
 * Демонстрация порядка инициализации в Java.
 * Показывает последовательность выполнения различных видов инициализации
 * при создании объектов в иерархии наследования.
 */
public class InitializationOrderDemo {

    // Родительский класс для демонстрации порядка инициализации
    static class Parent {
        // Статическое поле родительского класса
        private static String staticParentField = initStaticParentField();

        // Поле экземпляра родительского класса
        private String instanceParentField = initInstanceParentField();

        // Статический блок инициализации родительского класса
        static {
            System.out.println("3. Статический блок Parent");
        }

        // Блок инициализации экземпляра родительского класса
        {
            System.out.println("6. Блок инициализации экземпляра Parent");
        }

        // Инициализация статического поля
        private static String initStaticParentField() {
            System.out.println("2. Инициализация статического поля Parent");
            return "Static Parent Field";
        }

        // Инициализация поля экземпляра
        private String initInstanceParentField() {
            System.out.println("5. Инициализация поля экземпляра Parent");
            return "Instance Parent Field";
        }

        // Конструктор родительского класса
        public Parent() {
            System.out.println("7. Конструктор Parent");
        }

        public Parent(String message) {
            System.out.println("7. Параметризованный конструктор Parent: " + message);
        }
    }

    // Дочерний класс для демонстрации порядка инициализации
    static class Child extends Parent {
        // Статическое поле дочернего класса
        private static String staticChildField = initStaticChildField();

        // Поле экземпляра дочернего класса
        private String instanceChildField = initInstanceChildField();

        // Статический блок инициализации дочернего класса
        static {
            System.out.println("9. Статический блок Child");
        }

        // Блок инициализации экземпляра дочернего класса
        {
            System.out.println("11. Блок инициализации экземпляра Child");
        }

        // Инициализация статического поля
        private static String initStaticChildField() {
            System.out.println("8. Инициализация статического поля Child");
            return "Static Child Field";
        }

        // Инициализация поля экземпляра
        private String initInstanceChildField() {
            System.out.println("10. Инициализация поля экземпляра Child");
            return "Instance Child Field";
        }

        // Конструктор дочернего класса
        public Child() {
            super("from Child"); // Явный вызов конструктора родительского класса
            System.out.println("12. Конструктор Child");
        }
    }

    // Класс для демонстрации множественных блоков инициализации
    static class MultipleBlocks {
        // Первое поле экземпляра
        private String field1 = initField("field1");

        // Первый блок инициализации
        {
            System.out.println("Первый блок инициализации");
        }

        // Второе поле экземпляра
        private String field2 = initField("field2");

        // Второй блок инициализации
        {
            System.out.println("Второй блок инициализации");
        }

        // Третье поле экземпляра
        private String field3 = initField("field3");

        private String initField(String fieldName) {
            System.out.println("Инициализация " + fieldName);
            return fieldName + " value";
        }

        public MultipleBlocks() {
            System.out.println("Конструктор MultipleBlocks");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Демонстрация порядка инициализации ===\n");

        System.out.println("1. Обращение к классу Child (загрузка класса):");
        System.out.println("1. Загрузка и инициализация класса Parent");

        // Создание первого объекта Child
        System.out.println("\n=== Создание первого объекта Child ===");
        Child child1 = new Child();

        // Создание второго объекта Child (статическая инициализация уже выполнена)
        System.out.println("\n=== Создание второго объекта Child ===");
        Child child2 = new Child();

        // Демонстрация множественных блоков инициализации
        System.out.println("\n=== Демонстрация множественных блоков инициализации ===");
        MultipleBlocks mb = new MultipleBlocks();

        System.out.println("\n=== Порядок инициализации ===");
        System.out.println("1. Статические поля и блоки родительского класса (при первом обращении)");
        System.out.println("2. Статические поля и блоки дочернего класса (при первом обращении)");
        System.out.println("3. Поля экземпляра родительского класса");
        System.out.println("4. Блоки инициализации экземпляра родительского класса");
        System.out.println("5. Конструктор родительского класса");
        System.out.println("6. Поля экземпляра дочернего класса");
        System.out.println("7. Блоки инициализации экземпляра дочернего класса");
        System.out.println("8. Конструктор дочернего класса");

        System.out.println("\n=== Важные особенности ===");
        System.out.println("• Поля и блоки инициализации выполняются в порядке объявления");
        System.out.println("• Статическая инициализация происходит только один раз");
        System.out.println("• Инициализация экземпляра происходит при каждом создании объекта");
        System.out.println("• super() всегда выполняется перед инициализацией текущего класса");
    }
}
