package com.lists.examples.Hash;

import java.util.HashSet;

public class HashDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        set.add("!");

        System.out.println(set);
    }
}
