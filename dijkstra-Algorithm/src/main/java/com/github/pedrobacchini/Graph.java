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
        Node currentNode = nodes[0];
        currentNode.setDistanceFromSource(0);

        for (int indexNode = 0; indexNode < nodes.length; indexNode++) {
            ArrayList<Edge> edges = currentNode.getEdges();
            for (Edge edge : edges) {
                int neighbourIndex = edge.getNeighbourIndex(indexNode);
                if (!this.nodes[neighbourIndex].isVisited()) {
                    int tentative = currentNode.getDistanceFromSource() + edge.getLength();
                    if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
                        nodes[neighbourIndex].setDistanceFromSource(tentative);
                    }
                }
            }
            //all neighbours checked so node visited
            currentNode.visit();

            //next node must be with shortest distance
            currentNode = getNodeShortestDistance(nodes);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Number of node = ").append(nodes.length);
        sb.append("\nNumber of edges = ").append(edges.length);
        for (int i = 0; i < nodes.length; i++) {
            sb.append("\nThe Shortest distance from node 0 to node ")
                    .append(i)
                    .append(" is ")
                    .append(nodes[i].getDistanceFromSource());
        }
        return sb.toString();
    }

    private Node getNodeShortestDistance(Node[] nodes) {
        Node shortestNode = nodes[0];
        int shortestDist = Integer.MAX_VALUE;
        for (Node node : nodes) {
            if (!node.isVisited() && node.getDistanceFromSource() < shortestDist) {
                shortestDist = node.getDistanceFromSource();
                shortestNode = node;
            }
        }
        return shortestNode;
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
