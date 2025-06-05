package org.abhishek.graph.algos.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StandardBFSFromSource {

    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer> > adj) {

        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    List<Integer> edges = adj.get(node);
                    res.add(node);
                    edges.forEach(val -> {
                        if(!visited[node]) {
                            visited[node] = true;
                            queue.add(val);
                        }
                    });
                }
            }
        }
        return res;
    }



    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void main(String[] args)
    {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        int[][] edges= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        // Perform DFS starting from vertex 0
        ArrayList<Integer> res = BFS(adj);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

}
