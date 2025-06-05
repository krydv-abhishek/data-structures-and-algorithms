package org.abhishek.graph.algos.bfs;

import java.util.*;

public class ShortestPathBetweenTwoVerticesBFS {

    public static ArrayList<List<Integer>> shortestPath(ArrayList<ArrayList<Integer>> adj, int s, int t) {

        boolean[] visited = new boolean[adj.size()];
        ArrayList<List<Integer>> res = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(s));
        while (!queue.isEmpty()) {
            List<Integer> pathList = queue.poll();
            Integer lastNode = pathList.get(pathList.size() - 1);
            List<Integer> edges = adj.get(lastNode);
            if (lastNode == t) {
                res.add(pathList);
            }
            edges.forEach(val -> {
                if (!visited[val]) {
                    List<Integer> addPath = new ArrayList<>(pathList);
                    addPath.add(val);
                    queue.add(addPath);
                }
            });
            if (lastNode != t) {
                visited[lastNode] = true;
            }
        }

        return res;
    }


    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 4}, {3, 4}, {4, 5}, {1, 5}};
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        ArrayList<List<Integer>> res = shortestPath(adj, 0, 5);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

}
