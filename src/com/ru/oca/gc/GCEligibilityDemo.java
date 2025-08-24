package com.ru.oca.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация различных способов, когда объекты становятся eligible для сборки мусора.
 * Показывает основные сценарии: nulling references, reassigning, out of scope, island of isolation.
 */
public class GCEligibilityDemo {

    // Поле класса для демонстрации
    private static Object globalReference;

    /**
     * Демонстрация nulling references - присваивание null ссылкам
     */
    public void demonstrateNullingReferences() {
        System.out.println("=== Nulling References ===");

        // Создаем объекты
        String str1 = new String("Hello");
        String str2 = new String("World");
        StringBuilder sb = new StringBuilder("Java");

        System.out.println("Созданы объекты: str1, str2, sb");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("sb: " + sb);

        // Присваиваем null - объекты становятся eligible для GC
        str1 = null;    // String "Hello" теперь eligible для GC
        str2 = null;    // String "World" теперь eligible для GC
        sb = null;      // StringBuilder "Java" теперь eligible для GC

        System.out.println("После присваивания null:");
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("sb: " + sb);
        System.out.println("Все объекты теперь eligible для GC\n");
    }

    /**
     * Демонстрация reassigning references - переназначение ссылок
     */
    public void demonstrateReassigningReferences() {
        System.out.println("=== Reassigning References ===");

        // Создаем первый объект
        StringBuilder sb = new StringBuilder("First Object");
        System.out.println("Создан первый объект: " + sb);

        // Переназначаем ссылку на новый объект
        sb = new StringBuilder("Second Object");  // Первый объект становится eligible для GC
        System.out.println("После переназначения: " + sb);
        System.out.println("Первый объект 'First Object' теперь eligible для GC");

        // Еще одно переназначение
        sb = new StringBuilder("Third Object");   // Второй объект становится eligible для GC
        System.out.println("После второго переназначения: " + sb);
        System.out.println("Второй объект 'Second Object' теперь eligible для GC\n");
    }

    /**
     * Демонстрация out of scope - переменные выходят из области видимости
     */
    public void demonstrateOutOfScope() {
        System.out.println("=== Out of Scope ===");

        System.out.println("Вход в блок кода...");
        {
            // Объекты создаются в ограниченной области видимости
            String blockString = new String("Block Scoped String");
            List<String> blockList = new ArrayList<>();
            blockList.add("Item 1");
            blockList.add("Item 2");

            System.out.println("Внутри блока:");
            System.out.println("blockString: " + blockString);
            System.out.println("blockList: " + blockList);

            // Переменные blockString и blockList доступны только здесь
        } // Конец блока - переменные выходят из области видимости

        System.out.println("Выход из блока - объекты стали eligible для GC");
        System.out.println("blockString и blockList больше недоступны\n");

        // Демонстрация с циклом
        System.out.println("Демонстрация в цикле:");
        for (int i = 0; i < 3; i++) {
            String loopString = new String("Loop iteration " + i);
            System.out.println("Создан: " + loopString);
            // loopString становится eligible для GC в конце каждой итерации
        }
        System.out.println("Все объекты из цикла теперь eligible для GC\n");
    }

    /**
     * Демонстрация island of isolation - циклические ссылки без внешних ссылок
     */
    public void demonstrateIslandOfIsolation() {
        System.out.println("=== Island of Isolation ===");

        // Создаем два объекта, которые ссылаются друг на друга
        Node nodeA = new Node("Node A");
        Node nodeB = new Node("Node B");

        // Устанавливаем циклические ссылки
        nodeA.setReference(nodeB);
        nodeB.setReference(nodeA);

        System.out.println("Созданы объекты с циклическими ссылками:");
        System.out.println("nodeA ссылается на: " + nodeA.getReference().getName());
        System.out.println("nodeB ссылается на: " + nodeB.getReference().getName());

        // Обнуляем внешние ссылки - создаем "остров изоляции"
        nodeA = null;
        nodeB = null;

        System.out.println("Внешние ссылки обнулены");
        System.out.println("Объекты Node A и Node B образуют 'остров изоляции'");
        System.out.println("Несмотря на взаимные ссылки, оба объекта eligible для GC\n");
    }

    /**
     * Демонстрация сохранения ссылок в статических переменных
     */
    public void demonstrateStaticReferences() {
        System.out.println("=== Static References (объект НЕ eligible) ===");

        String temporaryString = new String("Temporary String");
        System.out.println("Создан временный объект: " + temporaryString);

        // Сохраняем ссылку в статической переменной
        globalReference = temporaryString;
        System.out.println("Ссылка сохранена в статической переменной");

        // Обнуляем локальную ссылку
        temporaryString = null;
        System.out.println("Локальная ссылка обнулена");

        // Объект все еще доступен через статическую переменную
        System.out.println("Объект все еще доступен: " + globalReference);
        System.out.println("Объект НЕ eligible для GC из-за статической ссылки");

        // Чтобы сделать объект eligible, нужно обнулить статическую ссылку
        globalReference = null;
        System.out.println("Статическая ссылка обнулена - теперь объект eligible для GC\n");
    }

    /**
     * Комплексная демонстрация с массивами и коллекциями
     */
    public void demonstrateComplexScenarios() {
        System.out.println("=== Комплексные сценарии ===");

        // Создаем массив объектов
        String[] stringArray = new String[3];
        stringArray[0] = new String("Array Element 0");
        stringArray[1] = new String("Array Element 1");
        stringArray[2] = new String("Array Element 2");

        System.out.println("Создан массив с тремя строками");

        // Обнуляем элементы массива по одному
        stringArray[0] = null;  // "Array Element 0" eligible для GC
        System.out.println("Элемент [0] обнулен - объект eligible для GC");

        stringArray[1] = null;  // "Array Element 1" eligible для GC
        System.out.println("Элемент [1] обнулен - объект eligible для GC");

        // stringArray[2] все еще содержит ссылку
        System.out.println("Элемент [2] все еще доступен: " + stringArray[2]);

        // Обнуляем весь массив
        stringArray = null;     // Массив и оставшийся элемент [2] eligible для GC
        System.out.println("Массив обнулен - все оставшиеся объекты eligible для GC");

        // Демонстрация с коллекцией
        List<StringBuilder> builderList = new ArrayList<>();
        builderList.add(new StringBuilder("Builder 1"));
        builderList.add(new StringBuilder("Builder 2"));

        System.out.println("Создан список с двумя StringBuilder объектами");

        // Очищаем коллекцию
        builderList.clear();    // Объекты StringBuilder становятся eligible для GC
        System.out.println("Список очищен - StringBuilder объекты eligible для GC");

        builderList = null;     // Сама коллекция становится eligible для GC
        System.out.println("Ссылка на список обнулена - коллекция eligible для GC\n");
    }

    /**
     * Вспомогательный класс для демонстрации циклических ссылок
     */
    static class Node {
        private String name;
        private Node reference;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Node getReference() {
            return reference;
        }

        public void setReference(Node reference) {
            this.reference = reference;
        }

        @Override
        public String toString() {
            return "Node{name='" + name + "'}";
        }
    }

    /**
     * Метод для принудительного запроса сборки мусора и паузы
     */
    private void requestGCAndPause() {
        System.out.println("Запрос сборки мусора...");
        System.gc();

        try {
            Thread.sleep(100); // Небольшая пауза
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Главный метод для демонстрации всех сценариев
     */
    public static void main(String[] args) {
        System.out.println("=== Демонстрация Eligibility объектов для Garbage Collection ===\n");

        GCEligibilityDemo demo = new GCEligibilityDemo();

        // Демонстрируем различные сценарии
        demo.demonstrateNullingReferences();
        demo.requestGCAndPause();

        demo.demonstrateReassigningReferences();
        demo.requestGCAndPause();

        demo.demonstrateOutOfScope();
        demo.requestGCAndPause();

        demo.demonstrateIslandOfIsolation();
        demo.requestGCAndPause();

        demo.demonstrateStaticReferences();
        demo.requestGCAndPause();

        demo.demonstrateComplexScenarios();
        demo.requestGCAndPause();

        System.out.println("=== Заключение ===");
        System.out.println("Основные способы сделать объекты eligible для GC:");
        System.out.println("1. Nulling References - присвоить null всем ссылкам");
        System.out.println("2. Reassigning References - переназначить ссылки на другие объекты");
        System.out.println("3. Out of Scope - переменные выходят из области видимости");
        System.out.println("4. Island of Isolation - циклические ссылки без внешних ссылок");
        System.out.println("\nВажно помнить:");
        System.out.println("- GC автоматически обнаруживает недоступные объекты");
        System.out.println("- Циклические ссылки не препятствуют сборке мусора");
        System.out.println("- Статические ссылки предотвращают сборку мусора");
        System.out.println("- System.gc() только запрашивает, но не гарантирует сборку мусора");
    }
}
