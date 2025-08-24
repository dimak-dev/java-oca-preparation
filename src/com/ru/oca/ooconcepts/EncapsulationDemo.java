package com.ru.oca.ooconcepts;

/**
 * Демонстрация принципа инкапсуляции в Java.
 * Показывает сокрытие данных и контролируемый доступ через методы.
 */
public class EncapsulationDemo {

    // Private поля - скрыты от внешнего доступа
    private String accountNumber;
    private double balance;
    private String ownerName;
    private boolean isActive;

    // Конструктор для инициализации объекта
    public EncapsulationDemo(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance >= 0 ? initialBalance : 0; // Валидация
        this.isActive = true;
    }

    // Getter методы - контролируемый доступ для чтения
    public String getAccountNumber() {
        // Возвращаем только часть номера счета для безопасности
        if (accountNumber.length() > 4) {
            return "*****" + accountNumber.substring(accountNumber.length() - 4);
        }
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        // Баланс доступен только для активных счетов
        if (!isActive) {
            throw new IllegalStateException("Account is not active");
        }
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setter методы с валидацией - контролируемый доступ для записи
    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) {
            this.ownerName = ownerName.trim();
        } else {
            throw new IllegalArgumentException("Owner name cannot be null or empty");
        }
    }

    // Бизнес-методы с валидацией и логикой
    public boolean deposit(double amount) {
        if (!isActive) {
            System.out.println("Cannot deposit to inactive account");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return false;
        }

        balance += amount;
        System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("Cannot withdraw from inactive account");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
            return false;
        }

        balance -= amount;
        System.out.println("Withdrawn: $" + amount + ". New balance: $" + balance);
        return true;
    }

    public void deactivateAccount() {
        this.isActive = false;
        System.out.println("Account " + getAccountNumber() + " has been deactivated");
    }

    public void activateAccount() {
        this.isActive = true;
        System.out.println("Account " + getAccountNumber() + " has been activated");
    }

    // Private вспомогательный метод - скрыт от внешнего использования
    private boolean validateAmount(double amount) {
        return amount > 0 && amount <= 10000; // Максимальная сумма операции
    }

    public boolean transfer(EncapsulationDemo targetAccount, double amount) {
        if (!isActive || !targetAccount.isActive) {
            System.out.println("Both accounts must be active for transfer");
            return false;
        }

        if (!validateAmount(amount)) {
            System.out.println("Invalid transfer amount");
            return false;
        }

        if (this.balance < amount) {
            System.out.println("Insufficient funds for transfer");
            return false;
        }

        // Выполняем трансфер
        this.balance -= amount;
        targetAccount.balance += amount;

        System.out.println("Transferred $" + amount + " from " + this.getAccountNumber() +
                          " to " + targetAccount.getAccountNumber());
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + (isActive ? balance : "***INACTIVE***") +
                ", isActive=" + isActive +
                '}';
    }

    // Демонстрация работы инкапсуляции
    public static void main(String[] args) {
        System.out.println("=== Демонстрация инкапсуляции ===");

        // Создание счетов
        EncapsulationDemo account1 = new EncapsulationDemo("1234567890", "John Doe", 1000.0);
        EncapsulationDemo account2 = new EncapsulationDemo("0987654321", "Jane Smith", 500.0);

        System.out.println("Начальное состояние:");
        System.out.println(account1);
        System.out.println(account2);

        System.out.println("\n=== Операции со счетами ===");

        // Демонстрация инкапсулированных операций
        account1.deposit(200);
        account1.withdraw(150);
        account1.transfer(account2, 300);

        System.out.println("\nПопытки некорректных операций:");
        account1.withdraw(-50);    // Отрицательная сумма
        account1.withdraw(2000);   // Недостаточно средств

        System.out.println("\n=== Деактивация счета ===");
        account1.deactivateAccount();
        account1.deposit(100);     // Попытка внести деньги на неактивный счет

        try {
            double balance = account1.getBalance(); // Попытка получить баланс неактивного счета
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nФинальное состояние:");
        System.out.println(account1);
        System.out.println(account2);
    }
}
