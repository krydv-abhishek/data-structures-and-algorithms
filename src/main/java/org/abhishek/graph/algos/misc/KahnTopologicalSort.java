package org.abhishek.graph.algos.misc;

import java.util.*;

public class KahnTopologicalSort {

    public static List<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] inDegree = new int[V];
        List<Integer> res = new ArrayList<>();

        //get in-degree
        for (int i = 0; i < V; i++) {
            for (Integer neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        //get 0 in-degree node first
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (Integer neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (res.size() != V) {
            System.out.println("Contains cycle");
        }
        return res;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        int[][] edges = {{1, 0}, {2, 0}, {2, 1}, {2, 3}, {1, 3}};
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }
        List<Integer> res = topologicalSort(adj, V);

        System.out.println(res);
    }

}
