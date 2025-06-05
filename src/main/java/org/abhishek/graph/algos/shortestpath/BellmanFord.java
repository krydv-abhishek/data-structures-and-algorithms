package org.abhishek.graph.algos.shortestpath;

import java.util.*;

public class BellmanFord {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void printShortestPath(int[][] edges, int V) {

        int[] dist = new int[V]; // Minimum edge weight to reach node
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] =0;


        for(int i =0;i < V; i++) {
            for(int[] edge : edges) {
                if(dist[edge[0]]!=Integer.MAX_VALUE && dist[edge[0]] + edge[2] < dist[edge[1]]) {
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                    if(i == V-1) {
                        System.out.println("Negative cycle");
                        return;
                    }
                }
            }
        }

        System.out.println("Min edges with weight to reach from source");
        for (int i = 1; i < V; i++) {
            System.out.println(i + " - " + dist[i]);
        }


    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {{0, 1, 5}, {1, 2, -1}, {2, 0, 2}};

        List<List<Pair>> adjWithWeight = new ArrayList<>();
        for(int i=0 ;i < V;i ++) {
            adjWithWeight.add(new ArrayList<>());
        }

        for(int[] i : edges) {
            adjWithWeight.get(i[0]).add(new Pair(i[1], i[2]));
            adjWithWeight.get(i[1]).add(new Pair(i[0], i[2]));
        }

        printShortestPath(edges, V);

    }

}
