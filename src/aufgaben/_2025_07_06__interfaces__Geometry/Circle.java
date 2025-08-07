package aufgaben._2025_07_06__interfaces__Geometry;

class Circle implements AreaCalculable {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Kreis [" + this.hashCode() + "] mit Radius " + radius;
    }
}
