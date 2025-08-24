package com.ru.oca.exceptions;

import java.io.IOException;
import java.util.Scanner;

/**
 * Демонстрация основ работы с исключениями в Java.
 * Показывает иерархию исключений, try-catch-finally блоки, checked и unchecked исключения.
 */
public class BasicExceptionsDemo {

    /**
     * Демонстрация базового try-catch блока
     */
    public void demonstrateBasicTryCatch() {
        System.out.println("=== Базовый try-catch ===");

        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Попытка доступа к элементу по индексу 5:");
            int value = numbers[5]; // ArrayIndexOutOfBoundsException
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
        }

        System.out.println("Программа продолжает работу после обработки исключения");
    }

    /**
     * Демонстрация множественных catch блоков
     */
    public void demonstrateMultipleCatch() {
        System.out.println("\n=== Множественные catch блоки ===");

        String[] data = {"10", "0", "abc", null};

        for (int i = 0; i < data.length + 1; i++) {
            try {
                System.out.println("Обработка элемента " + i + ":");
                String str = data[i]; // может быть ArrayIndexOutOfBoundsException
                int length = str.length(); // может быть NullPointerException
                int number = Integer.parseInt(str); // может быть NumberFormatException
                int result = 100 / number; // может быть ArithmeticException
                System.out.println("Результат: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("  Индекс вне границ массива");
            } catch (NullPointerException e) {
                System.out.println("  Null значение");
            } catch (NumberFormatException e) {
                System.out.println("  Неверный формат числа: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("  Арифметическая ошибка: " + e.getMessage());
            }
        }
    }

    /**
     * Демонстрация блока finally
     */
    public void demonstrateFinally() {
        System.out.println("\n=== Блок finally ===");

        Scanner scanner = null;
        try {
            System.out.println("Создаем Scanner...");
            scanner = new Scanner("123");
            int number = scanner.nextInt();
            System.out.println("Прочитано число: " + number);

            // Искусственно создаем исключение
            if (number > 100) {
                throw new RuntimeException("Число слишком большое!");
            }
        } catch (RuntimeException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполняется всегда");
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner закрыт в finally");
            }
        }
        System.out.println("После try-catch-finally блока");
    }

    /**
     * Демонстрация иерархии исключений и полиморфизма
     */
    public void demonstrateExceptionHierarchy() {
        System.out.println("\n=== Иерархия исключений ===");

        // Можем ловить родительским классом
        try {
            throwDifferentExceptions(1);
        } catch (RuntimeException e) { // Ловим RuntimeException и его наследников
            System.out.println("Поймано RuntimeException: " + e.getClass().getSimpleName());
        }

        try {
            throwDifferentExceptions(2);
        } catch (Exception e) { // Ловим Exception и его наследников
            System.out.println("Поймано Exception: " + e.getClass().getSimpleName());
        }

        // Демонстрация правильного порядка catch блоков
        try {
            throwDifferentExceptions(3);
        } catch (IllegalArgumentException e) { // Более специфичное исключение первым
            System.out.println("Поймано IllegalArgumentException");
        } catch (RuntimeException e) { // Более общее исключение вторым
            System.out.println("Поймано RuntimeException");
        } catch (Exception e) { // Самое общее исключение последним
            System.out.println("Поймано Exception");
        }
    }

    /**
     * Вспомогательный метод для демонстрации различных исключений
     */
    private void throwDifferentExceptions(int type) {
        switch (type) {
            case 1:
                throw new IllegalArgumentException("Неверный аргумент");
            case 2:
                throw new RuntimeException("Общее runtime исключение");
            case 3:
                throw new IllegalStateException("Неверное состояние");
            default:
                throw new UnsupportedOperationException("Неподдерживаемая операция");
        }
    }

    /**
     * Демонстрация checked исключений
     */
    public void demonstrateCheckedException() {
        System.out.println("\n=== Checked исключения ===");

        try {
            methodThatThrowsCheckedException();
        } catch (IOException e) {
            System.out.println("Поймано checked исключение: " + e.getMessage());
        }

        // Пример с автоматическим закрытием ресурсов (try-with-resources)
        try (Scanner scanner = new Scanner("test data")) {
            System.out.println("Работаем с Scanner в try-with-resources");
            if (scanner.hasNext()) {
                System.out.println("Данные: " + scanner.next());
            }
        } // Scanner автоматически закроется
    }

    /**
     * Метод, который бросает checked исключение
     */
    private void methodThatThrowsCheckedException() throws IOException {
        // Симуляция ситуации, когда может возникнуть IOException
        boolean errorCondition = true;
        if (errorCondition) {
            throw new IOException("Ошибка ввода-вывода");
        }
    }

    /**
     * Демонстрация создания и использования собственных исключений
     */
    public void demonstrateCustomExceptions() {
        System.out.println("\n=== Собственные исключения ===");

        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Поймано собственное исключение: " + e.getMessage());
            System.out.println("Код ошибки: " + e.getErrorCode());
        }

        try {
            processBusinessLogic("invalid");
        } catch (BusinessLogicException e) {
            System.out.println("Ошибка бизнес-логики: " + e.getMessage());
            System.out.println("Причина: " + e.getCause());
        }
    }

    /**
     * Метод для демонстрации собственного исключения
     */
    private void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Возраст не может быть отрицательным", "AGE_001");
        }
        if (age > 150) {
            throw new InvalidAgeException("Возраст слишком большой", "AGE_002");
        }
        System.out.println("Возраст корректный: " + age);
    }

    /**
     * Метод для демонстрации вложенного исключения
     */
    private void processBusinessLogic(String data) throws BusinessLogicException {
        try {
            // Симуляция обработки, которая может вызвать исключение
            Integer.parseInt(data);
        } catch (NumberFormatException e) {
            // Оборачиваем исключение в собственное
            throw new BusinessLogicException("Не удалось обработать данные: " + data, e);
        }
    }

    /**
     * Демонстрация правил обработки исключений
     */
    public void demonstrateExceptionRules() {
        System.out.println("\n=== Правила обработки исключений ===");

        // Правило 1: Более специфичные исключения должны быть перед более общими
        try {
            int[] arr = new int[0];
            arr[1] = 10;
        } catch (ArrayIndexOutOfBoundsException e) { // Специфичное
            System.out.println("Специфичное исключение: массив");
        } catch (RuntimeException e) { // Общее
            System.out.println("Общее runtime исключение");
        }

        // Правило 2: После catch может не быть finally, после finally может не быть catch
        try {
            System.out.println("Блок только с finally");
        } finally {
            System.out.println("Finally без catch");
        }

        // Правило 3: Нельзя иметь try без catch или finally
        // Это не компилируется:
        // try { System.out.println("test"); }
    }

    /**
     * Демонстрация типичных ошибок при работе с исключениями
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки ===");

        // Ошибка 1: Поглощение исключений
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // ПЛОХО: исключение "проглатывается"
            System.out.println("Исключение обработано, но информация потеряна");
        }

        // Лучший подход:
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ХОРОШО: Логируем исключение: " + e.getMessage());
            // Можно также re-throw исключение если нужно
        }

        // Ошибка 2: Слишком широкий catch
        try {
            String str = null;
            str.length();
        } catch (Exception e) { // Слишком широко!
            System.out.println("ПЛОХО: Ловим все исключения разом");
        }

        // Лучший подход - специфичные исключения:
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("ХОРОШО: Специфичная обработка NPE");
        }
    }

    /**
     * Главный метод для запуска всех демонстраций
     */
    public static void main(String[] args) {
        BasicExceptionsDemo demo = new BasicExceptionsDemo();

        demo.demonstrateBasicTryCatch();
        demo.demonstrateMultipleCatch();
        demo.demonstrateFinally();
        demo.demonstrateExceptionHierarchy();
        demo.demonstrateCheckedException();
        demo.demonstrateCustomExceptions();
        demo.demonstrateExceptionRules();
        demo.demonstrateCommonMistakes();
    }
}

/**
 * Собственное unchecked исключение
 */
class InvalidAgeException extends RuntimeException {
    private final String errorCode;

    public InvalidAgeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

/**
 * Собственное checked исключение
 */
class BusinessLogicException extends Exception {
    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
