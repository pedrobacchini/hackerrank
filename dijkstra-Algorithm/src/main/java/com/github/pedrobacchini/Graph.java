package com.github.pedrobacchini;

import lombok.Getter;

import java.util.ArrayList;

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

    //Dijkstra Algorithm
    public void calculateShortestDistance() {
        //node 0 as source
        this.nodes[0].setDistanceFromSource(0);
        int nextNode = 0;

//        for (int indexNode = 0; indexNode < nodes.length; indexNode++) {
            int indexNode = 0;
            Node node = nodes[indexNode];
            ArrayList<Edge> edges = node.getEdges();
            for (Edge edge : edges) {
                int neighbourIndex = edge.getNeighbourIndex(indexNode);
                if (!this.nodes[neighbourIndex].isVisited()) {
                    int tentative = this.nodes[nextNode].getDistanceFromSource() + edge.getLength();
                    System.out.println(neighbourIndex);
                    System.out.println(tentative);
                }
            }
//        }
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
