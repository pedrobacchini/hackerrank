package com.github.pedrobacchini;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Model a node in the graph
 */
public class Node {

    @Setter @Getter
    private int distanceFromSource = Integer.MAX_VALUE;

    @Setter @Getter
    private boolean visited = false;

    private ArrayList<Edge> edges = new ArrayList<>();

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public Collection<Edge> getEdges() {
        return Collections.unmodifiableCollection(edges);
    }
}
