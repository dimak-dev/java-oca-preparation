package com.ru.oca.basics;

/**
 * Демонстрация базовой структуры Java класса.
 * Показывает правильное объявление класса, полей и методов.
 */
public class BasicClassStructure {

    // Поле класса с модификатором доступа private
    private String message;

    // Поле класса с модификатором доступа public
    public int number;

    // Поле класса package-private (без модификатора)
    boolean isActive;

    // Конструктор по умолчанию
    public BasicClassStructure() {
        this.message = "Default message";
        this.number = 0;
        this.isActive = true;
    }

    // Конструктор с параметрами
    public BasicClassStructure(String message, int number) {
        this.message = message;
        this.number = number;
        this.isActive = false;
    }

    // Публичный метод для получения сообщения
    public String getMessage() {
        return message;
    }

    // Публичный метод для установки сообщения
    public void setMessage(String message) {
        this.message = message;
    }

    // Метод демонстрирующий локальные переменные
    public String processData() {
        // Локальная переменная - существует только в рамках этого метода
        String localVariable = "Processing: ";

        // Параметр метода также имеет локальную область видимости
        return localVariable + this.message + " (Number: " + this.number + ")";
    }

    // Private метод - доступен только внутри этого класса
    private boolean validateNumber(int num) {
        return num >= 0;
    }

    // Package-private метод
    void resetValues() {
        this.message = "Reset";
        this.number = 0;
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "BasicClassStructure{" +
                "message='" + message + '\'' +
                ", number=" + number +
                ", isActive=" + isActive +
                '}';
    }
}
