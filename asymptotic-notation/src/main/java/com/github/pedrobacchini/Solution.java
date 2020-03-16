package com.github.pedrobacchini;

import java.util.Scanner;
import java.util.stream.LongStream;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int n = Integer.parseInt(scanner.nextLine());
            double logN = Math.log(n) / Math.log(2);
            System.out.println("n!: " + factorialUsingStreams(n));
            System.out.println("2^n: " + Math.pow(2, n));
            System.out.println("n^2: " + Math.pow(n, 2));
            System.out.println("n*log(n): " + n * logN);
            System.out.println("n: " + n);
            System.out.println("sqrt(n): " + Math.sqrt(n));
            System.out.println("log(n): " + logN);
            System.out.println("1: " + 1);
        }
    }

    public static long factorialUsingStreams(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);
    }
}

