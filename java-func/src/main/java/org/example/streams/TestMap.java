package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMap {
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> collect = n.stream().
                map(i -> i * i)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
