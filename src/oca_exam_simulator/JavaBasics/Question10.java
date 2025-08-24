package oca_exam_simulator.JavaBasics;

import java.lang.*;
import java.util.*; // List and ArrayList are part of java.utils, not java.lang

public class Question10 {
    public static void main(String[] args) {
        List<String> myPets = new ArrayList<>();

        myPets.add("Bokeh");
        myPets.add("Boi");
        myPets.add("Niki");
        myPets.add("Eyra");

        if (myPets.contains("Eyra")) {
            myPets.add("Kara");
        }

        if (myPets.contains("bokeh")) {
            myPets.add("Kara");
        }

        System.out.println(myPets.size());
    }
}
