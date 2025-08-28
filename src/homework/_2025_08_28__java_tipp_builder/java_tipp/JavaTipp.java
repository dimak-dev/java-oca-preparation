package homework._2025_08_28__java_tipp_builder.java_tipp;

import java.util.ArrayList;
import java.util.List;

public class JavaTipp {
    String text;
    List<String> topics;
    
    JavaTipp() {
        this.topics = new ArrayList<>();
    }

    public String getText() {
        return this.text;
    }

    public List<String> getTopics() {
        return this.topics;
    }

    @Override
    public String toString() {
        return "JavaTipp: Text: " + text + ".\nTopics: " + topics;
    }

    
}
