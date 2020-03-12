package com.github.pedrobacchini;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Model a node in the graph
 */
@Getter @Setter
public class Node {

    private int distanceFromSource = Integer.MAX_VALUE;

    private boolean visited = false;

    private ArrayList<Edge> edges = new ArrayList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
