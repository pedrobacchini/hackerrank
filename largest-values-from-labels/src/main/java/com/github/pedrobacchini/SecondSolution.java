package com.github.pedrobacchini;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=84xibeO_lqk
 * LARGEST VALUES FROM LABELS
 */
public class SecondSolution {

    private int sum = 0;

    public SecondSolution(int[] values, int[] labels, int numWanted, int useLimit) {

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < labels.length; i++)
            items.add(new Item(values[i], labels[i]));

        PriorityQueue<Item> maxHeap = new PriorityQueue<>((Item a, Item b) -> Integer.compare(b.value, a.value));
        maxHeap.addAll(items);

        Map<Integer, Integer> labelCounts = new HashMap<>();
        while (!maxHeap.isEmpty() && numWanted > 0) {
            Item poll = maxHeap.poll();
            labelCounts.put(poll.label, labelCounts.getOrDefault(poll.label, 0) + 1);
            if (labelCounts.get(poll.label) <= useLimit) {
                sum += poll.value;
                numWanted--;
            }
        }
    }

    public int getSum() {
        return sum;
    }

    private static class Item {
        private int value;
        private int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public int getLabel() {
            return label;
        }
    }
}
