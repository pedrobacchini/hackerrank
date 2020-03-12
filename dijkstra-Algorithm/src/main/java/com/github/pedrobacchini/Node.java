package com.github.pedrobacchini;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Model a node in the graph
 */
public class Node {

    @Getter @Setter
    private int distanceFromSource = Integer.MAX_VALUE;

    @Getter
    private boolean visited = false;

    @Getter @Setter
    private ArrayList<Edge> edges = new ArrayList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void visit() {
        visited = true;
    }
}
