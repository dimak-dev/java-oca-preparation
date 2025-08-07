package aufgaben._2025_07_06__interfaces__Geometry;

class Rectangle implements AreaCalculable, PartOfAreaCalculable {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public double getPartOfArea() {
        return AreaCalculable.super.getPartOfArea();
    }

    @Override
    public String toString() {
        return "Rechteck [" + this.hashCode() + "] mit Breite " + this.width + " und Höhe " + this.height;
    }
}
