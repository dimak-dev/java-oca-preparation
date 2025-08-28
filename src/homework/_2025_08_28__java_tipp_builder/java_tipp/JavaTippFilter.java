package homework._2025_08_28__java_tipp_builder.java_tipp;

@FunctionalInterface
public interface JavaTippFilter {
    boolean filter(JavaTipp javaTipp);
    // boolean filter(JavaTipp javaTipp, int index);
}
