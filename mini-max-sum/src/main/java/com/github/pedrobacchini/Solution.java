package com.github.pedrobacchini;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long min = arr[0], max = arr[0], sum = 0;
        for (int value : arr) {
            sum += value;
            if (value < min) min = value;
            if (value > max) max = value;
        }
        System.out.println(String.format("%s %s", sum - max, sum - min));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

