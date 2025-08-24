package com.ru.oca.string;

/**
 * Демонстрация работы с String и StringBuilder в Java.
 * Показывает различия между неизменяемыми строками и изменяемыми строковыми буферами.
 */
public class StringBuilderDemo {

    /**
     * Демонстрация неизменяемости строк (String Immutability)
     */
    public void demonstrateStringImmutability() {
        System.out.println("=== Неизменяемость строк ===");

        String str1 = "Hello";
        String str2 = str1; // str2 ссылается на тот же объект

        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1 == str2: " + (str1 == str2)); // true - одинаковые ссылки

        // "Изменение" str1 создает новый объект
        str1 = str1 + " World";

        System.out.println("После 'изменения' str1:");
        System.out.println("str1: " + str1); // "Hello World"
        System.out.println("str2: " + str2); // "Hello" - не изменился!
        System.out.println("str1 == str2: " + (str1 == str2)); // false - разные объекты

        // Демонстрация создания множества объектов
        String result = "Start";
        System.out.println("\nСоздание множества строковых объектов:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("До конкатенации: " + result.hashCode());
            result = result + " " + i; // каждый раз создается новый объект!
            System.out.println("После конкатенации: " + result + " (hashCode: " + result.hashCode() + ")");
        }
    }

    /**
     * Демонстрация основных методов String
     */
    public void demonstrateStringMethods() {
        System.out.println("\n=== Основные методы String ===");

        String text = "  Java Programming Language  ";
        System.out.println("Исходная строка: '" + text + "'");

        // Методы получения информации
        System.out.println("Длина: " + text.length());
        System.out.println("Пустая ли строка: " + text.isEmpty());
        System.out.println("Символ по индексу 2: " + text.charAt(2));

        // Методы поиска
        System.out.println("Индекс 'Java': " + text.indexOf("Java"));
        System.out.println("Последний индекс 'a': " + text.lastIndexOf('a'));
        System.out.println("Содержит 'Program': " + text.contains("Program"));
        System.out.println("Начинается с '  Ja': " + text.startsWith("  Ja"));
        System.out.println("Заканчивается на 'ge  ': " + text.endsWith("ge  "));

        // Методы преобразования (возвращают новые объекты!)
        System.out.println("Верхний регистр: " + text.toUpperCase());
        System.out.println("Нижний регистр: " + text.toLowerCase());
        System.out.println("Без пробелов: '" + text.trim() + "'");

        // Методы извлечения подстрок
        System.out.println("Подстрока с 2 до 6: '" + text.substring(2, 6) + "'");
        System.out.println("Подстрока с 7: '" + text.substring(7) + "'");

        // Методы замены (возвращают новые объекты!)
        System.out.println("Замена 'a' на '@': " + text.replace('a', '@'));
        System.out.println("Замена 'Java' на 'Python': " + text.replace("Java", "Python"));

        // Исходная строка остается неизменной!
        System.out.println("Исходная строка все еще: '" + text + "'");
    }

    /**
     * Демонстрация String Pool (пул строк)
     */
    public void demonstrateStringPool() {
        System.out.println("\n=== String Pool ===");

        // Литералы строк помещаются в пул
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Hel" + "lo"; // компилятор оптимизирует в "Hello"

        System.out.println("str1 == str2: " + (str1 == str2)); // true - из пула
        System.out.println("str1 == str3: " + (str1 == str3)); // true - оптимизация компилятора

        // new String() всегда создает новый объект
        String str4 = new String("Hello");
        System.out.println("str1 == str4: " + (str1 == str4)); // false - новый объект
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true - содержимое одинаковое

        // intern() помещает строку в пул
        String str5 = str4.intern();
        System.out.println("str1 == str5: " + (str1 == str5)); // true - теперь из пула

        // Динамически созданные строки не в пуле
        String dynamic = "Hel" + new String("lo");
        System.out.println("str1 == dynamic: " + (str1 == dynamic)); // false
        System.out.println("str1 == dynamic.intern(): " + (str1 == dynamic.intern())); // true
    }

    /**
     * Демонстрация основ StringBuilder
     */
    public void demonstrateStringBuilderBasics() {
        System.out.println("\n=== Основы StringBuilder ===");

        // Создание StringBuilder
        StringBuilder sb1 = new StringBuilder(); // пустой
        StringBuilder sb2 = new StringBuilder("Initial text"); // с начальным текстом
        StringBuilder sb3 = new StringBuilder(50); // с начальной емкостью

        System.out.println("sb1: '" + sb1 + "' (длина: " + sb1.length() + ")");
        System.out.println("sb2: '" + sb2 + "' (длина: " + sb2.length() + ")");
        System.out.println("sb3: '" + sb3 + "' (емкость: " + sb3.capacity() + ")");

        // Основные операции
        sb1.append("Hello"); // добавление в конец
        sb1.append(" ").append("World"); // цепочка вызовов
        System.out.println("После append: " + sb1);

        sb1.insert(5, " Beautiful"); // вставка по индексу
        System.out.println("После insert: " + sb1);

        sb1.replace(6, 15, "Amazing"); // замена части
        System.out.println("После replace: " + sb1);

        sb1.delete(5, 13); // удаление части
        System.out.println("После delete: " + sb1);

        sb1.reverse(); // переворот
        System.out.println("После reverse: " + sb1);
    }

    /**
     * Демонстрация методов StringBuilder
     */
    public void demonstrateStringBuilderMethods() {
        System.out.println("\n=== Методы StringBuilder ===");

        StringBuilder sb = new StringBuilder("Java Programming");

        // Информационные методы
        System.out.println("Исходный StringBuilder: " + sb);
        System.out.println("Длина: " + sb.length());
        System.out.println("Емкость: " + sb.capacity());
        System.out.println("Символ по индексу 5: " + sb.charAt(5));

        // Методы изменения
        sb.setCharAt(0, 'j'); // изменение символа
        System.out.println("После setCharAt(0, 'j'): " + sb);

        sb.deleteCharAt(4); // удаление символа по индексу
        System.out.println("После deleteCharAt(4): " + sb);

        // Получение подстроки (возвращает новый String!)
        String substring = sb.substring(0, 4);
        System.out.println("Подстрока (0, 4): " + substring);
        System.out.println("StringBuilder остался: " + sb);

        // Преобразование в String
        String result = sb.toString();
        System.out.println("Финальная строка: " + result);
        System.out.println("StringBuilder: " + sb + " (не изменился)");
    }

    /**
     * Демонстрация производительности String vs StringBuilder
     */
    public void demonstratePerformance() {
        System.out.println("\n=== Сравнение производительности ===");

        int iterations = 1000;

        // Тест производительности String (медленно)
        long startTime = System.currentTimeMillis();
        String stringResult = "";
        for (int i = 0; i < iterations; i++) {
            stringResult += "a"; // каждый раз создается новый объект!
        }
        long stringTime = System.currentTimeMillis() - startTime;

        // Тест производительности StringBuilder (быстро)
        startTime = System.currentTimeMillis();
        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbResult.append("a"); // изменяется существующий объект
        }
        String sbFinalResult = sbResult.toString();
        long sbTime = System.currentTimeMillis() - startTime;

        System.out.println("Результаты для " + iterations + " итераций:");
        System.out.println("String конкатенация: " + stringTime + " мс");
        System.out.println("StringBuilder: " + sbTime + " мс");
        System.out.println("StringBuilder в " + (stringTime > 0 ? stringTime/Math.max(sbTime, 1) : "много") + " раз быстрее");

        // Проверяем, что результаты одинаковые
        System.out.println("Результаты одинаковые: " + stringResult.equals(sbFinalResult));
        System.out.println("Длина результата: " + stringResult.length());
    }

    /**
     * Демонстрация емкости StringBuilder
     */
    public void demonstrateStringBuilderCapacity() {
        System.out.println("\n=== Емкость StringBuilder ===");

        StringBuilder sb = new StringBuilder();
        System.out.println("Начальная емкость: " + sb.capacity()); // обычно 16

        // Добавляем символы и смотрим на изменение емкости
        for (int i = 1; i <= 20; i++) {
            sb.append("x");
            if (i % 5 == 0 || i == 17) { // показываем когда емкость увеличивается
                System.out.println("После " + i + " символов - длина: " + sb.length() +
                                 ", емкость: " + sb.capacity());
            }
        }

        // Явное задание емкости
        sb.ensureCapacity(100);
        System.out.println("После ensureCapacity(100): " + sb.capacity());

        // Сжатие до текущей длины
        sb.trimToSize();
        System.out.println("После trimToSize(): " + sb.capacity());
    }

    /**
     * Демонстрация типичных ошибок при работе со строками
     */
    public void demonstrateCommonMistakes() {
        System.out.println("\n=== Типичные ошибки ===");

        // Ошибка 1: Использование == вместо equals()
        String str1 = new String("test");
        String str2 = new String("test");
        System.out.println("str1 == str2: " + (str1 == str2)); // false!
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true

        // Ошибка 2: NullPointerException при работе со строками
        String nullString = null;
        try {
            int length = nullString.length(); // NPE!
        } catch (NullPointerException e) {
            System.out.println("NPE при вызове метода у null строки");
        }

        // Правильная проверка на null
        if (nullString != null && nullString.length() > 0) {
            System.out.println("Строка не пустая");
        } else {
            System.out.println("Строка null или пустая");
        }

        // Ошибка 3: Неэффективная конкатенация в циклах
        System.out.println("\nПЛОХО - конкатенация String в цикле:");
        String inefficient = "";
        for (int i = 1; i <= 5; i++) {
            inefficient += i + " "; // создается новый объект на каждой итерации
        }
        System.out.println("Результат: " + inefficient);

        System.out.println("ХОРОШО - StringBuilder в цикле:");
        StringBuilder efficient = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            efficient.append(i).append(" "); // изменяется один объект
        }
        System.out.println("Результат: " + efficient.toString());

        // Ошибка 4: Забывание toString() для StringBuilder
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println("StringBuilder напрямую: " + sb); // работает, но не очевидно
        System.out.println("StringBuilder.toString(): " + sb.toString()); // явно и понятно
    }

    /**
     * Демонстрация работы с методом equals() и сравнением строк
     */
    public void demonstrateStringComparison() {
        System.out.println("\n=== Сравнение строк ===");

        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "Hello";
        String str4 = new String("Hello");

        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false - разный регистр
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2)); // true
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true
        System.out.println("str1.equals(str4): " + str1.equals(str4)); // true
        System.out.println("str1 == str3: " + (str1 == str3)); // true - из пула
        System.out.println("str1 == str4: " + (str1 == str4)); // false - новый объект

        // compareTo для сортировки
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); // отрицательное
        System.out.println("str2.compareTo(str1): " + str2.compareTo(str1)); // положительное
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); // 0

        // Сравнение с null
        try {
            str1.equals(null); // безопасно
            System.out.println("str1.equals(null): " + str1.equals(null)); // false
        } catch (Exception e) {
            System.out.println("Ошибка при сравнении с null: " + e.getMessage());
        }
    }

    /**
     * Главный метод для запуска всех демонстраций
     */
    public static void main(String[] args) {
        StringBuilderDemo demo = new StringBuilderDemo();

        demo.demonstrateStringImmutability();
        demo.demonstrateStringMethods();
        demo.demonstrateStringPool();
        demo.demonstrateStringBuilderBasics();
        demo.demonstrateStringBuilderMethods();
        demo.demonstratePerformance();
        demo.demonstrateStringBuilderCapacity();
        demo.demonstrateCommonMistakes();
        demo.demonstrateStringComparison();
    }
}
