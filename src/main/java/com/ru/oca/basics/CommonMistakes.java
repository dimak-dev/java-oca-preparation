package com.ru.oca.basics;

/**
 * Демонстрация типичных ошибок в основах Java.
 * Этот класс содержит исправленные версии распространенных ошибок
 * с комментариями о том, что делать неправильно.
 */
public class CommonMistakes {

    // ПРАВИЛЬНО: Имя класса совпадает с именем файла
    // НЕПРАВИЛЬНО было бы: class commonmistakes или class Common_Mistakes

    // ПРАВИЛЬНО: Поля объявлены с подходящими модификаторами
    private String name;  // private для инкапсуляции
    public int count;     // public если нужен внешний доступ

    // НЕПРАВИЛЬНО: Объявление нескольких переменных разных типов в одной строке
    // int a, String b;  // ЭТО НЕ КОМПИЛИРУЕТСЯ!

    // ПРАВИЛЬНО: Каждый тип объявляется отдельно
    int number1, number2;  // OK - одинаковый тип
    String text1;          // OK - отдельное объявление
    String text2;          // OK - отдельное объявление

    /**
     * ПРАВИЛЬНО: Конструктор имеет то же имя, что и класс
     */
    public CommonMistakes() {
        // ПРАВИЛЬНО: Инициализация полей в конструкторе
        this.name = "Default";
        this.count = 0;
    }

    /**
     * ПРАВИЛЬНО: Метод main имеет правильную сигнатуру
     */
    public static void main(String[] args) {
        System.out.println("Демонстрация исправленных ошибок");

        CommonMistakes example = new CommonMistakes();
        example.demonstrateVariableScope();
        example.demonstrateNamingConventions();
        example.demonstrateAccessModifiers();
    }

    /**
     * Демонстрация правильной работы с областью видимости переменных
     */
    public void demonstrateVariableScope() {
        System.out.println("\n=== Область видимости ===");

        // ПРАВИЛЬНО: Локальные переменные должны быть инициализированы перед использованием
        String localVar = "Инициализирована"; // ОБЯЗАТЕЛЬНАЯ инициализация!
        System.out.println(localVar);

        // НЕПРАВИЛЬНО было бы:
        // String uninitializedVar;
        // System.out.println(uninitializedVar); // ОШИБКА КОМПИЛЯЦИИ!

        // ПРАВИЛЬНО: Использование this для обращения к полям класса
        this.name = "Обновленное имя";
        System.out.println("Поле класса: " + this.name);

        // ПРАВИЛЬНО: Переменная в блоке
        {
            String blockVar = "Переменная блока";
            System.out.println(blockVar);
            // blockVar доступна только здесь
        }
        // blockVar здесь недоступна - это правильно!
    }

    /**
     * Демонстрация правильных соглашений об именовании
     */
    public void demonstrateNamingConventions() {
        System.out.println("\n=== Соглашения об именовании ===");

        // ПРАВИЛЬНО: camelCase для переменных и методов
        String firstName = "Иван";
        int studentAge = 20;
        boolean isActive = true;

        // НЕПРАВИЛЬНО было бы:
        // String FirstName;  // PascalCase для переменных - неправильно
        // int student_age;   // snake_case - не принято в Java
        // boolean IsActive;  // PascalCase для переменных - неправильно

        System.out.println("Имя: " + firstName);
        System.out.println("Возраст: " + studentAge);
        System.out.println("Активен: " + isActive);

        // ПРАВИЛЬНО: Константы в UPPER_SNAKE_CASE
        final int MAX_SIZE = 100;
        final String DEFAULT_MESSAGE = "По умолчанию";

        System.out.println("Максимальный размер: " + MAX_SIZE);
        System.out.println("Сообщение: " + DEFAULT_MESSAGE);
    }

    /**
     * Демонстрация правильного использования модификаторов доступа
     */
    public void demonstrateAccessModifiers() {
        System.out.println("\n=== Модификаторы доступа ===");

        // Вызов приватного метода из того же класса - ПРАВИЛЬНО
        String result = privateMethod();
        System.out.println("Результат приватного метода: " + result);

        // Вызов package-private метода - ПРАВИЛЬНО
        packagePrivateMethod();

        // НЕПРАВИЛЬНО было бы вызывать приватный метод из другого класса
        // Это привело бы к ошибке компиляции
    }

    // ПРАВИЛЬНО: private метод доступен только внутри класса
    private String privateMethod() {
        return "Приватный метод выполнен";
    }

    // ПРАВИЛЬНО: package-private метод (без модификатора)
    void packagePrivateMethod() {
        System.out.println("Package-private метод выполнен");
    }

    // ПРАВИЛЬНО: public метод доступен отовсюду
    public String publicMethod() {
        return "Публичный метод выполнен";
    }

    /**
     * Демонстрация правильной работы со строками и примитивами
     */
    public void demonstrateCorrectUsage() {
        // ПРАВИЛЬНО: Инициализация переменных
        int number = 42;
        String text = "Hello";

        // ПРАВИЛЬНО: Конкатенация строк
        String result = text + " World! Number: " + number;
        System.out.println(result);

        // ПРАВИЛЬНО: Сравнение строк
        String str1 = "Java";
        String str2 = "Java";
        if (str1.equals(str2)) {  // ПРАВИЛЬНО: используем equals()
            System.out.println("Строки равны");
        }

        // НЕПРАВИЛЬНО было бы:
        // if (str1 == str2)  // Сравнивает ссылки, не содержимое!
    }
}
