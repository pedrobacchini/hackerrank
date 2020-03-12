package com.github.pedrobacchini;

/**
 * https://www.youtube.com/watch?v=gdmfOwyQlcI
 */
public class Solution {

    public static void main(String[] args) {

        Edge[] edges = new Edge[]{
                new Edge(0, 1, 4),
                new Edge(0, 2, 3),
                new Edge(0, 3, 7),
                new Edge(1, 2, 6),
                new Edge(1, 4, 5),
                new Edge(2, 4, 11),
                new Edge(2, 3, 8),
                new Edge(3, 4, 2),
                new Edge(3, 5, 5),
                new Edge(4, 5, 10),
                new Edge(4, 6, 2),
                new Edge(5, 6, 3)
        };

        Graph graph = new Graph(edges);

        graph.calculateShortestDistance();

        System.out.println(graph.toString());

    }
}
