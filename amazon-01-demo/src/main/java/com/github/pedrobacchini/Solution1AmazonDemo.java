package com.github.pedrobacchini;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1AmazonDemo {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days) {
        //1 - active
        //0 - inactive
        // if neighbors active or inactive -> inactive
        // else -> active
        // WRITE YOUR CODE HERE
        for (int d = 0; d < days; d++) {
            List<Integer> statesCopy = Arrays
                    .stream(states).boxed().collect(Collectors.toList());
            for (int i = 0; i < statesCopy.size(); i++) {
                int previousState = (i - 1) == -1 ? 0 : statesCopy.get(i - 1);
                int nextState = (i + 1) > states.length - 1 ? 0 : statesCopy.get(i + 1);
                if (previousState == nextState) {
                    states[i] = 0;
                } else {
                    states[i] = 1;
                }
            }
        }
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        int[] states = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        int days = 1;
        List<Integer> integers = cellCompete(states, days);
        integers.forEach(System.out::print);

        System.out.println();

        states = new int[]{1, 1, 1, 0, 1, 1, 1, 1};
        days = 2;
        integers = cellCompete(states, days);
        integers.forEach(System.out::print);
    }
}
