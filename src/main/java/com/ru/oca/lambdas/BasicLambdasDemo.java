package com.ru.oca.lambdas;

import java.util.*;
import java.util.function.*;

/**
 * Демонстрация основ работы с лямбда-выражениями в Java 8.
 * Показывает синтаксис лямбда-выражений, функциональные интерфейсы и ссылки на методы.
 */
public class BasicLambdasDemo {

    /**
     * Демонстрация базового синтаксиса лямбда-выражений
     */
    public void demonstrateBasicLambdaSyntax() {
        System.out.println("=== Базовый синтаксис лямбда-выражений ===");

        // Традиционный подход с анонимным классом
        Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Выполняется с анонимным классом");
            }
        };
        traditionalRunnable.run();

        // Лямбда-выражение - краткая запись
        Runnable lambdaRunnable = () -> System.out.println("Выполняется с лямбдой");
        lambdaRunnable.run();

        // Лямбда с параметрами
        Comparator<String> traditionalComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        Comparator<String> lambdaComparator = (s1, s2) -> s1.compareTo(s2);

        String[] names = {"Боб", "Алиса", "Чарли"};
        Arrays.sort(names, lambdaComparator);
        System.out.println("Отсортированные имена: " + Arrays.toString(names));
    }

    /**
     * Демонстрация различных форм записи лямбда-выражений
     */
    public void demonstrateLambdaSyntaxVariations() {
        System.out.println("\n=== Вариации синтаксиса лямбда-выражений ===");

        List<String> words = Arrays.asList("Java", "Python", "JavaScript", "Go");

        // 1. Без параметров
        Runnable noParams = () -> System.out.println("Без параметров");

        // 2. Один параметр (скобки необязательны)
        Consumer<String> oneParam = s -> System.out.println("Обработка: " + s);
        Consumer<String> oneParamWithParens = (s) -> System.out.println("Обработка: " + s);

        // 3. Несколько параметров (скобки обязательны)
        BinaryOperator<Integer> twoParams = (a, b) -> a + b;

        // 4. Блок кода вместо выражения (фигурные скобки + return)
        Function<String, Integer> blockLambda = (String s) -> {
            System.out.println("Вычисляем длину для: " + s);
            return s.length();
        };

        // 5. Выражение без return (автоматический return)
        Function<String, Integer> expressionLambda = s -> s.length();

        // Демонстрация использования
        System.out.println("Примеры использования:");
        oneParam.accept("Тест");
        System.out.println("Сумма: " + twoParams.apply(5, 3));
        System.out.println("Длина (блок): " + blockLambda.apply("Привет"));
        System.out.println("Длина (выражение): " + expressionLambda.apply("Мир"));
    }

    /**
     * Демонстрация встроенных функциональных интерфейсов
     */
    public void demonstrateBuiltInFunctionalInterfaces() {
        System.out.println("\n=== Встроенные функциональные интерфейсы ===");

        // Predicate<T> - тест, возвращает boolean
        Predicate<String> isLongWord = s -> s.length() > 5;
        System.out.println("'Programming' длинное слово? " + isLongWord.test("Programming"));
        System.out.println("'Java' длинное слово? " + isLongWord.test("Java"));

        // Consumer<T> - принимает значение, ничего не возвращает
        Consumer<String> printer = s -> System.out.println("Вывод: " + s);
        printer.accept("Тестовое сообщение");

        // Function<T, R> - принимает T, возвращает R
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Длина 'Hello': " + stringLength.apply("Hello"));

        // Supplier<T> - не принимает параметры, возвращает T
        Supplier<String> randomGreeting = () -> {
            String[] greetings = {"Привет", "Здравствуйте", "Добро пожаловать"};
            return greetings[new Random().nextInt(greetings.length)];
        };
        System.out.println("Случайное приветствие: " + randomGreeting.get());

        // UnaryOperator<T> - принимает T, возвращает T
        UnaryOperator<String> upperCase = s -> s.toUpperCase();
        System.out.println("Верхний регистр: " + upperCase.apply("java"));

        // BinaryOperator<T> - принимает два T, возвращает T
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Произведение: " + multiply.apply(6, 7));
    }

    /**
     * Демонстрация создания собственных функциональных интерфейсов
     */
    public void demonstrateCustomFunctionalInterfaces() {
        System.out.println("\n=== Собственные функциональные интерфейсы ===");

        // Использование собственного функционального интерфейса
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> b != 0 ? a / b : 0;

        System.out.println("Сложение: " + performOperation(10, 5, addition));
        System.out.println("Вычитание: " + performOperation(10, 5, subtraction));
        System.out.println("Умножение: " + performOperation(10, 5, multiplication));
        System.out.println("Деление: " + performOperation(10, 5, division));

        // Использование интерфейса для валидации
        Validator<String> emailValidator = email -> email.contains("@") && email.contains(".");
        Validator<Integer> positiveValidator = number -> number > 0;

        System.out.println("Email валидный? " + emailValidator.isValid("test@example.com"));
        System.out.println("Email валидный? " + emailValidator.isValid("invalid-email"));
        System.out.println("Число положительное? " + positiveValidator.isValid(42));
        System.out.println("Число положительное? " + positiveValidator.isValid(-5));
    }

    /**
     * Вспомогательный метод для демонстрации использования MathOperation
     */
    private double performOperation(double a, double b, MathOperation operation) {
        return operation.operate(a, b);
    }

    /**
     * Демонстрация ссылок на методы (Method References)
     */
    public void demonstrateMethodReferences() {
        System.out.println("\n=== Ссылки на методы ===");

        List<String> names = Arrays.asList("Анна", "Борис", "Виктор", "Галина");

        System.out.println("Исходный список: " + names);

        // 1. Ссылка на статический метод
        // Лямбда: s -> String.valueOf(s)
        // Ссылка на метод: String::valueOf
        names.forEach(System.out::println); // ссылка на метод println

        // 2. Ссылка на метод экземпляра конкретного объекта
        String prefix = "Имя: ";
        Consumer<String> instanceMethodRef = prefix::concat;
        // Эквивалент лямбды: s -> prefix.concat(s)

        // 3. Ссылка на метод экземпляра произвольного объекта определенного типа
        List<String> upperCaseNames = new ArrayList<>();
        names.forEach(name -> upperCaseNames.add(name.toUpperCase()));

        // То же самое с ссылкой на метод:
        List<String> upperCaseNames2 = new ArrayList<>();
        names.stream()
             .map(String::toUpperCase) // ссылка на метод экземпляра
             .forEach(upperCaseNames2::add);

        System.out.println("Имена в верхнем регистре: " + upperCaseNames2);

        // 4. Ссылка на конструктор
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();
        System.out.println("Создан новый список: " + newList);

        // Демонстрация различных типов ссылок на методы
        demonstrateMethodReferenceTypes();
    }

    /**
     * Демонстрация различных типов ссылок на методы
     */
    private void demonstrateMethodReferenceTypes() {
        System.out.println("\nТипы ссылок на методы:");

        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5);

        // Статический метод
        numbers.stream()
               .map(Math::abs) // ссылка на статический метод Math.abs
               .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Метод экземпляра конкретного объекта
//        String template = "Число: ";
//        numbers.forEach(template::concat); // не очень практичный пример

        // Метод экземпляра произвольного объекта
        List<String> stringNumbers = Arrays.asList("1", "22", "333");
        stringNumbers.stream()
                     .mapToInt(String::length) // ссылка на метод length каждой строки
                     .forEach(length -> System.out.print(length + " "));
        System.out.println();

        // Конструктор
        Function<String, StringBuilder> sbConstructor = StringBuilder::new;
        StringBuilder sb = sbConstructor.apply("Начальный текст");
        System.out.println("StringBuilder: " + sb.toString());
    }

    /**
     * Демонстрация использования лямбда-выражений с коллекциями
     */
    public void demonstrateLambdasWithCollections() {
        System.out.println("\n=== Лямбды с коллекциями ===");

        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C++", "Go", "Rust");

        // Фильтрация с Predicate
        System.out.println("Языки с длиной больше 4 символов:");
        languages.stream()
                 .filter(lang -> lang.length() > 4)
                 .forEach(System.out::println);

        // Преобразование с Function
        System.out.println("\nДлины названий языков:");
        languages.stream()
                 .map(String::length)
                 .forEach(length -> System.out.print(length + " "));
        System.out.println();

        // Сортировка с Comparator
        System.out.println("\nЯзыки, отсортированные по длине:");
        languages.stream()
                 .sorted((l1, l2) -> Integer.compare(l1.length(), l2.length()))
                 .forEach(System.out::println);

        // Группировка
        Map<Integer, List<String>> groupedByLength = new HashMap<>();
        for (String lang : languages) {
            int length = lang.length();
            groupedByLength.computeIfAbsent(length, k -> new ArrayList<>()).add(lang);
        }
        System.out.println("\nГруппировка по длине: " + groupedByLength);
    }

    /**
     * Демонстрация типичных ошибок при работе с лямбда-выражениями
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки с лямбдами ===");

        // Ошибка 1: Попытка изменить локальную переменную
        int counter = 0;
        List<String> items = Arrays.asList("a", "b", "c");

        // Это НЕ компилируется:
        // items.forEach(item -> counter++); // Ошибка: переменная должна быть effectively final

        // Правильный подход - использование AtomicInteger или других способов
        final int[] finalCounter = {0}; // массив - effectively final
        items.forEach(item -> finalCounter[0]++);
        System.out.println("Количество обработанных элементов: " + finalCounter[0]);

        // Ошибка 2: Неправильное использование return в блочных лямбдах
//        Function<String, String> wrongLambda = s -> {
//            s.toUpperCase(); // Забыли return!
//        };
        // Результат будет null

        Function<String, String> correctLambda = s -> {
            return s.toUpperCase(); // Правильно с return
        };
        System.out.println("Правильная лямбда: " + correctLambda.apply("test"));

        // Ошибка 3: Слишком сложные лямбды (лучше вынести в отдельный метод)
        // Плохо:
        items.stream()
             .filter(item -> {
                 // Много сложной логики...
                 return item.length() > 0 &&
                        !item.isEmpty() &&
                        item.trim().length() > 0;
             })
             .forEach(System.out::println);

        // Лучше:
        items.stream()
             .filter(this::isValidItem)
             .forEach(System.out::println);
    }

    /**
     * Вспомогательный метод для демонстрации хорошей практики
     */
    private boolean isValidItem(String item) {
        return item != null && !item.trim().isEmpty();
    }

    /**
     * Главный метод для запуска всех демонстраций
     */
    public static void main(String[] args) {
        BasicLambdasDemo demo = new BasicLambdasDemo();

        demo.demonstrateBasicLambdaSyntax();
        demo.demonstrateLambdaSyntaxVariations();
        demo.demonstrateBuiltInFunctionalInterfaces();
        demo.demonstrateCustomFunctionalInterfaces();
        demo.demonstrateMethodReferences();
        demo.demonstrateLambdasWithCollections();
        demo.demonstrateCommonMistakes();
    }
}

/**
 * Собственный функциональный интерфейс для математических операций
 */
@FunctionalInterface
interface MathOperation {
    double operate(double a, double b);

    // Можно иметь default методы
    default String getDescription() {
        return "Математическая операция";
    }
}

/**
 * Функциональный интерфейс для валидации
 */
@FunctionalInterface
interface Validator<T> {
    boolean isValid(T value);
}
