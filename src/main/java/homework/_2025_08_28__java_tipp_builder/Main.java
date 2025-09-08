package homework._2025_08_28__java_tipp_builder;

import homework._2025_08_28__java_tipp_builder.java_tipp.JavaTipp;
import homework._2025_08_28__java_tipp_builder.java_tipp.JavaTippBuilder;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        JavaTipp[] tipps = {
            JavaTippBuilder.builder()
                .withText("Mit dem Schlüsselwort 'implements' kann eine Klasse ein Interface realisieren.")
                .withTopic("Vererbung")
                .withTopic("Klassen")
                .withTopic("Interfaces")
                .build(),
            JavaTippBuilder.builder()
                .withText("Eine Klasse kann nur eine andere Klasse erweitern.")
                .withTopic("Vererbung")
                .withTopic("Klassen")
                .build(),
            JavaTippBuilder.builder()
                .withText("Statische Methoden werden mit dem Klassennamen aufgerufen.")
                .withTopic("Klassen")
                .withTopic("Methoden")
                .withTopic("static")
                .build(),
        };

        System.out.println("Result 1:");
        printFiltered(tipps, t -> t.getText().contains("Klasse"));

        System.out.println("Result 2:");
        printFiltered(tipps, t -> t.getTopics().contains("Klassen") && !t.getTopics().contains("Vererbung"));
    }

    static void printFiltered(JavaTipp[] tipps, Predicate<JavaTipp> filter) {
        for (JavaTipp tipp : tipps) {
            if (filter.test(tipp)) {
                System.err.println(tipp);
            }

        }
    }
}
