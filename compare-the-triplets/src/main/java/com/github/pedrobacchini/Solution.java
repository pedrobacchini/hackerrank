package com.github.pedrobacchini;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int pointsAlice = 0, pointsBob = 0, temp;
        for (int i = 0; i < a.size(); i++) {
            if(!a.get(i).equals(b.get(i)))
                temp = (a.get(i) > b.get(i)) ? pointsAlice++ : pointsBob++;
        }
        return Arrays.asList(pointsAlice, pointsBob);
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

