package com.github.pedrobacchini;

import java.util.*;

import static java.util.stream.Collectors.joining;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = Arrays.asList(0, 0);
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)>b.get(i))
                result.set(0, result.get(0)+1);
            else if(a.get(i)<b.get(i))
                result.set(1, result.get(1)+1);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(5, 6, 7);

        List<Integer> b = Arrays.asList(3, 6, 10);

        List<Integer> result = compareTriplets(a, b);

        String s = result.stream()
                .map(Object::toString)
                .collect(joining(" "))
                + "\n";

        System.out.println(s);
    }
}

