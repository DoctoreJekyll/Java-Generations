package com.lists.examples.Vector;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("World");
        vector.add("!");

        System.out.println(vector);
    }
}
