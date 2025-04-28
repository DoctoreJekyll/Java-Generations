package com.lists.examples.one;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.add(0);
        System.out.println(list);
    }
}
