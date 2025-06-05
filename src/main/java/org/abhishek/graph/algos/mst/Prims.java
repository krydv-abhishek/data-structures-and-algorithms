package org.abhishek.graph.algos.mst;

import java.util.*;

public class Prims {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void findMST(List<List<Pair>> adjWithWeight, int V) {

        boolean[] visited = new boolean[V];
        int[] key = new int[V]; // Minimum edge weight to reach node
        int[] parent = new int[V]; // Store MST edges

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(pqNode -> pqNode.weight));
        pq.add(new Pair(0,0));

        key[0]=0;

        while(!pq.isEmpty()) {
            int uNode = pq.poll().node;
            visited[uNode] =true;

            for(Pair nPair : adjWithWeight.get(uNode)) {

                int vNode = nPair.node;
                int weight = nPair.weight;

                if(!visited[nPair.node] && weight < key[vNode])  {
                    key[vNode] = weight;
                    parent[vNode] = uNode;
                    pq.add(new Pair(vNode, weight));
                }
            }
        }

        int totalWeight = 0;
        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " (weight " + key[i] + ")");
            totalWeight += key[i];
        }
        System.out.println("Total weight of MST: " + totalWeight);


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

        findMST(adjWithWeight, V);

    }

}
