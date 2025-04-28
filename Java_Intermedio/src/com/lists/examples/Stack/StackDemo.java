package com.lists.examples.Stack;

import java.util.Stack;

public class StackDemo {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("!");

        System.out.println(stack);
    }
}
