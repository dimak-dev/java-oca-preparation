package aufgaben._2025_07_06__interfaces__Geometry;

interface AreaCalculable {
    double getArea();

    default double getPartOfArea() {
        return this.getArea() / 2;
    }
}
