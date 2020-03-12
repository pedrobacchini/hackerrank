package com.github.pedrobacchini;

import lombok.Getter;

/**
 * Model a graph
 */
@Getter
public class Graph {

    private Node[] nodes;
    private Edge[] edges;

    public Graph(Edge[] edges) {
        this.edges = edges;

        int noOfNodes = calculateNoOfNode(edges);
        System.out.println("num of nodes: " + noOfNodes);

        nodes = new Node[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            nodes[i] = new Node();
        }

        for (Edge edge : edges) {
            this.nodes[edge.getFromNodeIndex()].addEdge(edge);
            this.nodes[edge.getToNodeIndex()].addEdge(edge);
        }
    }

    private int calculateNoOfNode(Edge[] edges) {
        int noOfNodes = 0;
        for (Edge edge : edges) {
            if (edge.getFromNodeIndex() > noOfNodes)
                noOfNodes = edge.getFromNodeIndex();
            if (edge.getToNodeIndex() > noOfNodes)
                noOfNodes = edge.getToNodeIndex();
        }
        return ++noOfNodes;
    }
}
