package homework._2025_07_06__interfaces__Geometry;

/**
 * Führen Sie den Begriff "Rechteck" in einem Projekt ein. Ein Rechteck hat Breite und Höhe.
 * <p>
 * Es soll auch Kreise geben können. Jeder Kreis soll ein Radius haben.
 * <p>
 * Mit einer Instanz-Methode "getFlaeche" soll die Fläche eines Rechteckes ermittelt werden können.
 * <p>
 * Mit einer Instanz-Methode "getFlaeche" soll die Fläche eines Kreises ermittelt werden können.
 * <p>
 * Erzeugen Sie 100 zufällige Figuren (Kreise oder Rechtecke zufällig) und speichern Sie alle in einem Array.
 * <p>
 * Erzeugen Sie eine statische Methode, an die das Array aus der vorherigen Aufgabe übergeben werden kann. Die Methode soll die Flächen aller Figuren aus dem Array berechnen und ausgeben.
 */
public class Main {
    public static void main(String[] args) {
        AreaCalculable[] figures = generateFigures(100);
        printArea(figures);
    }

    private static AreaCalculable[] generateFigures(int count) {
        AreaCalculable[] figures = new AreaCalculable[count];

        for (int i = 0; i < figures.length; i++) {
            if (Math.random() < 0.5) {
                figures[i] = new Circle(Math.random());
            } else {
                figures[i] = new Rectangle(Math.random(), Math.random());
            }
        }

        return figures;
    }

    private static void printArea(AreaCalculable[] figures) {
        for (AreaCalculable figure : figures) {
            System.out.println("Figure " + figure + " hat die Fläche: " + figure.getArea());
        }
    }
}
