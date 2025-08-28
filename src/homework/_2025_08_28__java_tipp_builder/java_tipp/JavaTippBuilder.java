package homework._2025_08_28__java_tipp_builder.java_tipp;

public class JavaTippBuilder {
    private final JavaTipp javaTipp;

    private JavaTippBuilder() {
        javaTipp = new JavaTipp();
    }

    public static JavaTippBuilder builder() {
        return new JavaTippBuilder();
    }

    public JavaTippBuilder withText(String text) {
        javaTipp.text = text;
        return this;
    }

    public JavaTippBuilder withTopic(String topic) {
        javaTipp.topics.add(topic);
        return this;
    }

    public JavaTipp build() {
        return this.javaTipp;
    }
}
