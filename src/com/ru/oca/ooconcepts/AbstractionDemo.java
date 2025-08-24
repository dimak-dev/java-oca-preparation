package com.ru.oca.ooconcepts;

/**
 * Демонстрация абстракции в Java через абстрактные классы и интерфейсы.
 * Показывает создание контрактов поведения и их реализацию.
 */
public class AbstractionDemo {

    // Интерфейс для объектов, которые могут двигаться
    public interface Movable {
        void move();
        double getSpeed();

        // Константы интерфейса (public static final по умолчанию)
        double MAX_SPEED = 1000.0;
        String MOVEMENT_TYPE = "Generic Movement";
    }

    // Интерфейс для объектов, которые могут издавать звуки
    public interface SoundMaker {
        void makeNoise();
        int getVolumeLevel(); // от 1 до 10
    }

    // Интерфейс для управляемых объектов
    public interface Controllable {
        void start();
        void stop();
        boolean isRunning();
    }

    // Абстрактный класс Vehicle - частичная реализация
    public static abstract class Vehicle implements Movable, Controllable {
        protected String model;
        protected int year;
        protected double currentSpeed;
        protected boolean isRunning;

        // Конструктор абстрактного класса
        public Vehicle(String model, int year) {
            this.model = model;
            this.year = year;
            this.currentSpeed = 0.0;
            this.isRunning = false;
        }

        // Конкретные методы, доступные всем наследникам
        @Override
        public void start() {
            if (!isRunning) {
                isRunning = true;
                System.out.println(model + " is starting up");
            } else {
                System.out.println(model + " is already running");
            }
        }

        @Override
        public void stop() {
            if (isRunning) {
                isRunning = false;
                currentSpeed = 0.0;
                System.out.println(model + " has stopped");
            } else {
                System.out.println(model + " is already stopped");
            }
        }

        @Override
        public boolean isRunning() {
            return isRunning;
        }

        @Override
        public double getSpeed() {
            return currentSpeed;
        }

        // Абстрактные методы - должны быть реализованы в наследниках
        public abstract void accelerate();
        public abstract void brake();
        public abstract String getVehicleType();

        // Конкретный метод с общей логикой
        public void displayInfo() {
            System.out.println(getVehicleType() + ": " + model + " (" + year + ")");
            System.out.println("Status: " + (isRunning ? "Running" : "Stopped"));
            System.out.println("Current speed: " + currentSpeed + " km/h");
        }
    }

    // Конкретный класс Car наследует от Vehicle и реализует SoundMaker
    public static class Car extends Vehicle implements SoundMaker {
        private int numberOfDoors;
        private String fuelType;

        public Car(String model, int year, int numberOfDoors, String fuelType) {
            super(model, year);
            this.numberOfDoors = numberOfDoors;
            this.fuelType = fuelType;
        }

        // Реализация абстрактного метода
        @Override
        public void accelerate() {
            if (isRunning) {
                currentSpeed = Math.min(currentSpeed + 20, 180); // Максимум 180 км/ч
                System.out.println(model + " accelerates to " + currentSpeed + " km/h");
            } else {
                System.out.println("Cannot accelerate - " + model + " is not running");
            }
        }

        @Override
        public void brake() {
            if (currentSpeed > 0) {
                currentSpeed = Math.max(currentSpeed - 15, 0);
                System.out.println(model + " slows down to " + currentSpeed + " km/h");
            } else {
                System.out.println(model + " is already at rest");
            }
        }

        @Override
        public String getVehicleType() {
            return "Car";
        }

        // Реализация интерфейса Movable
        @Override
        public void move() {
            if (isRunning && currentSpeed > 0) {
                System.out.println(model + " is driving on the road at " + currentSpeed + " km/h");
            } else {
                System.out.println(model + " is not moving");
            }
        }

        // Реализация интерфейса SoundMaker
        @Override
        public void makeNoise() {
            if (isRunning) {
                System.out.println(model + " engine roars: Vroom! Vroom!");
            } else {
                System.out.println(model + " is silent");
            }
        }

        @Override
        public int getVolumeLevel() {
            return isRunning ? (int)(currentSpeed / 20) + 2 : 1; // Громкость зависит от скорости
        }

        // Дополнительные методы
        public void honk() {
            System.out.println(model + " honks: Beep! Beep!");
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType);
        }
    }

    // Конкретный класс Motorcycle
    public static class Motorcycle extends Vehicle implements SoundMaker {
        private boolean hasSidecar;

        public Motorcycle(String model, int year, boolean hasSidecar) {
            super(model, year);
            this.hasSidecar = hasSidecar;
        }

        @Override
        public void accelerate() {
            if (isRunning) {
                currentSpeed = Math.min(currentSpeed + 30, 200); // Быстрее чем машина
                System.out.println(model + " motorcycle speeds up to " + currentSpeed + " km/h");
            } else {
                System.out.println("Cannot accelerate - " + model + " is not running");
            }
        }

        @Override
        public void brake() {
            if (currentSpeed > 0) {
                currentSpeed = Math.max(currentSpeed - 25, 0); // Тормозит быстрее
                System.out.println(model + " motorcycle slows to " + currentSpeed + " km/h");
            }
        }

        @Override
        public String getVehicleType() {
            return "Motorcycle";
        }

        @Override
        public void move() {
            if (isRunning && currentSpeed > 0) {
                System.out.println(model + " motorcycle cruises at " + currentSpeed + " km/h");
            } else {
                System.out.println(model + " motorcycle is stationary");
            }
        }

        @Override
        public void makeNoise() {
            if (isRunning) {
                System.out.println(model + " motorcycle roars: BRRRR! BRRRR!");
            } else {
                System.out.println(model + " motorcycle is quiet");
            }
        }

        @Override
        public int getVolumeLevel() {
            return isRunning ? (int)(currentSpeed / 15) + 3 : 1; // Мотоциклы громче
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Has sidecar: " + hasSidecar);
        }
    }

    // Класс, реализующий только интерфейсы без наследования от Vehicle
    public static class Drone implements Movable, SoundMaker, Controllable {
        private String model;
        private double altitude;
        private double speed;
        private boolean isFlying;

        public Drone(String model) {
            this.model = model;
            this.altitude = 0.0;
            this.speed = 0.0;
            this.isFlying = false;
        }

        @Override
        public void move() {
            if (isFlying) {
                System.out.println(model + " drone flies at " + speed + " km/h at altitude " + altitude + "m");
            } else {
                System.out.println(model + " drone is grounded");
            }
        }

        @Override
        public double getSpeed() {
            return speed;
        }

        @Override
        public void makeNoise() {
            if (isFlying) {
                System.out.println(model + " drone buzzes: Bzzzzz!");
            }
        }

        @Override
        public int getVolumeLevel() {
            return isFlying ? 4 : 1;
        }

        @Override
        public void start() {
            isFlying = true;
            altitude = 10.0;
            speed = 25.0;
            System.out.println(model + " drone takes off");
        }

        @Override
        public void stop() {
            isFlying = false;
            altitude = 0.0;
            speed = 0.0;
            System.out.println(model + " drone lands");
        }

        @Override
        public boolean isRunning() {
            return isFlying;
        }

        public void changeAltitude(double newAltitude) {
            if (isFlying && newAltitude >= 0) {
                altitude = newAltitude;
                System.out.println(model + " drone changes altitude to " + altitude + "m");
            }
        }
    }

    // Утилитарный класс для демонстрации полиморфизма с интерфейсами
    public static class TrafficController {

        public static void controlVehicle(Controllable vehicle) {
            System.out.println("\n--- Traffic Control ---");
            if (!vehicle.isRunning()) {
                vehicle.start();
            }

            if (vehicle instanceof Movable) {
                ((Movable) vehicle).move();
            }

            if (vehicle instanceof SoundMaker) {
                ((SoundMaker) vehicle).makeNoise();
                System.out.println("Volume level: " + ((SoundMaker) vehicle).getVolumeLevel());
            }

            vehicle.stop();
        }

        public static void makeAllNoise(SoundMaker[] noiseMakers) {
            System.out.println("\n=== Making noise ===");
            for (SoundMaker maker : noiseMakers) {
                maker.makeNoise();
            }
        }

        public static void moveAllVehicles(Movable[] vehicles) {
            System.out.println("\n=== Moving all vehicles ===");
            for (Movable vehicle : vehicles) {
                vehicle.move();
            }
        }
    }

    // Главный метод для демонстрации
    public static void main(String[] args) {
        System.out.println("=== Демонстрация абстракции и интерфейсов ===");

        // Создание объектов
        Car car = new Car("Toyota Camry", 2023, 4, "Gasoline");
        Motorcycle bike = new Motorcycle("Harley Davidson", 2022, false);
        Drone drone = new Drone("DJI Phantom");

        System.out.println("\n=== Демонстрация абстрактных классов ===");

        // Нельзя создать экземпляр абстрактного класса
        // Vehicle vehicle = new Vehicle("Generic", 2023); // ОШИБКА КОМПИЛЯЦИИ!

        // Но можно использовать ссылку на абстрактный класс
        Vehicle vehicle1 = car;
        Vehicle vehicle2 = bike;

        // Полиморфные вызовы через абстрактную ссылку
        vehicle1.start();
        vehicle1.accelerate(); // Вызывается реализация из Car
        vehicle1.displayInfo();

        vehicle2.start();
        vehicle2.accelerate(); // Вызывается реализация из Motorcycle
        vehicle2.displayInfo();

        System.out.println("\n=== Демонстрация множественной реализации интерфейсов ===");

        // Все объекты реализуют разные наборы интерфейсов
        car.start();
        car.accelerate();
        car.move();
        car.makeNoise();
        car.honk();

        bike.start();
        bike.accelerate();
        bike.move();
        bike.makeNoise();

        drone.start();
        drone.move();
        drone.makeNoise();
        drone.changeAltitude(50);

        System.out.println("\n=== Демонстрация полиморфизма через интерфейсы ===");

        // Массивы интерфейсных ссылок
        Controllable[] controllables = {car, bike, drone};
        SoundMaker[] soundMakers = {car, bike, drone};
        Movable[] movables = {car, bike, drone};

        // Полиморфная обработка
        for (Controllable ctrl : controllables) {
            TrafficController.controlVehicle(ctrl);
        }

        TrafficController.makeAllNoise(soundMakers);
        TrafficController.moveAllVehicles(movables);

        System.out.println("\n=== Демонстрация интерфейсных констант ===");
        System.out.println("MAX_SPEED: " + Movable.MAX_SPEED);
        System.out.println("MOVEMENT_TYPE: " + Movable.MOVEMENT_TYPE);

        System.out.println("\n=== Проверка типов и интерфейсов ===");

        Object someObject = car;

        System.out.println("car instanceof Vehicle: " + (someObject instanceof Vehicle));
        System.out.println("car instanceof Movable: " + (someObject instanceof Movable));
        System.out.println("car instanceof SoundMaker: " + (someObject instanceof SoundMaker));
        System.out.println("car instanceof Controllable: " + (someObject instanceof Controllable));
        System.out.println("car instanceof Drone: " + (someObject instanceof Drone));

        // Демонстрация приведения типов для доступа к специфичным методам
        if (someObject instanceof Car) {
            Car specificCar = (Car) someObject;
            specificCar.honk(); // Метод, специфичный для Car
        }

        System.out.println("\n=== Финальная остановка всех транспортных средств ===");
        for (Controllable ctrl : controllables) {
            if (ctrl.isRunning()) {
                ctrl.stop();
            }
        }
    }
}
