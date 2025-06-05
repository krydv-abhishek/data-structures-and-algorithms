package org.abhishek.graph.algos.shortestpath;

import java.util.*;

public class Dijkstra {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void printShortestPath(List<List<Pair>> adjWithWeight, int V) {

        int[] dist = new int[V]; // Minimum edge weight to reach node
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(pqNode -> pqNode.weight));
        pq.add(new Pair(0,0));
        dist[0] =0;

        while(!pq.isEmpty()) {
            Pair uPair = pq.poll();

            for(Pair nPair : adjWithWeight.get(uPair.node)) {
                int vNode = nPair.node;
                int weight = nPair.weight;

                if(dist[vNode] > dist[uPair.node] + weight) {
                    dist[vNode] = dist[uPair.node] + weight;
                    pq.add(new Pair(vNode, dist[vNode]));
                }
            }
        }

        System.out.println("Min edges with weight to reach from source");
        for (int i = 1; i < V; i++) {
            System.out.println(i + " - " + dist[i]);
        }


    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1, 5}, {0, 2, 50}, {0, 4, 10}, {1, 4, 15}, {1, 3, 30}, {1, 2, 40}, {3, 4, 20}};

        List<List<Pair>> adjWithWeight = new ArrayList<>();
        for(int i=0 ;i < V;i ++) {
            adjWithWeight.add(new ArrayList<>());
        }

        for(int[] i : edges) {
            adjWithWeight.get(i[0]).add(new Pair(i[1], i[2]));
            adjWithWeight.get(i[1]).add(new Pair(i[0], i[2]));
        }

        printShortestPath(adjWithWeight, V);

    }

}
