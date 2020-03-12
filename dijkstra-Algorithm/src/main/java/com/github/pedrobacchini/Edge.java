package com.github.pedrobacchini;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Model a edge in the graph
 */
@Getter
@AllArgsConstructor
public class Edge {

    private int fromNodeIndex;
    private int toNodeIndex;
    private int length;

    //    Determine the neighbouring node of a supplied node, based on the two nodes connected by this edge
    public int getNeighbourIndex(int nodeIndex) {
        return fromNodeIndex == nodeIndex ? toNodeIndex : fromNodeIndex;
    }
}
