package com.github.pedrobacchini;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FirstSolution {

    private int sum = 0;

    public FirstSolution(int[] values, int[] labels, int numWanted, int useLimit) {
        LinkedHashMap<Integer, List<Integer>> labelsMap = new LinkedHashMap<>();

        for (int i = 0; i < labels.length; i++) {
            int label = labels[i];
            if (labelsMap.get(label) == null) {
                labelsMap.put(label, new ArrayList<>());
            }
            labelsMap.get(label).add(values[i]);
        }

        for (int label : labelsMap.keySet()) {
            for (int i = 0; i < useLimit && i < labelsMap.get(label).size() && numWanted > 0; i++) {
                sum += labelsMap.get(label).get(i);
                numWanted--;
            }
        }
    }

    public int getSum() {
        return sum;
    }
}
