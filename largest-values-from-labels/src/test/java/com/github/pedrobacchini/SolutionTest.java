package com.github.pedrobacchini;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

class SolutionTest {

    @Test
    void test_example1() {
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 1, 2, 2, 3};
        int numWanted = 3;
        int useLimit = 1;
        FirstSolution firstSolution = new FirstSolution(values, labels, numWanted, useLimit);
        assumeTrue(firstSolution.getSum() == 9);
        SecondSolution secondSolution = new SecondSolution(values, labels, numWanted, useLimit);
        System.out.println(secondSolution.getSum());
        assumeTrue(secondSolution.getSum() == 9);
    }

    @Test
    void test_example2() {
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 3, 3, 3, 2};
        int numWanted = 3;
        int useLimit = 2;
        FirstSolution firstSolution = new FirstSolution(values, labels, numWanted, useLimit);
        assumeTrue(firstSolution.getSum() == 12);
        SecondSolution secondSolution = new SecondSolution(values, labels, numWanted, useLimit);
        assumeTrue(secondSolution.getSum() == 12);
    }

    @Test
    void test_example3() {
        int[] values = new int[]{9, 8, 8, 7, 6};
        int[] labels = new int[]{0, 0, 0, 1, 1};
        int numWanted = 3;
        int useLimit = 1;
        FirstSolution firstSolution = new FirstSolution(values, labels, numWanted, useLimit);
        assumeTrue(firstSolution.getSum() == 16);
        SecondSolution secondSolution = new SecondSolution(values, labels, numWanted, useLimit);
        assumeTrue(secondSolution.getSum() == 16);
    }

    @Test
    void test_example4() {
        int[] values = new int[]{9, 8, 8, 7, 6};
        int[] labels = new int[]{0, 0, 0, 1, 1};
        int numWanted = 3;
        int useLimit = 2;
        FirstSolution firstSolution = new FirstSolution(values, labels, numWanted, useLimit);
        assumeTrue(firstSolution.getSum() == 24);
        SecondSolution secondSolution = new SecondSolution(values, labels, numWanted, useLimit);
        assumeTrue(secondSolution.getSum() == 24);
    }
}