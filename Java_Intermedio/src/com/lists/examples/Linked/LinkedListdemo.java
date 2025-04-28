package com.lists.examples.Linked;

import java.util.LinkedList;

public class LinkedListdemo
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }

        System.out.println(list);
    }
}
