package org.abhishek.graph.algos.mst;

import java.util.*;

public class Kruskal {

    static class DSU {

        int[] parent;
        int[] rank;


        DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for(int i=0;i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(x==parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {

            int pX = find(x);
            int pY = find(y);

            if(pX!=pY) {

                if(rank[pX] > rank[pY]) {
                    parent[pY] = pX;
                } else if(rank[pX] < rank[pY]) {
                    parent[pX] = pY;
                } else {
                    parent[pY] = pX;
                    rank[pX] += 1;
                }
            }
        }

    }

    public static void findMST(int[][] edges, int V) {

        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

        DSU dsu = new DSU(V);

        int n=0;
        for (int[] edge : edges) {
            if (dsu.find(edge[0]) != dsu.find(edge[1])) {
                dsu.union(edge[0], edge[1]);
                System.out.println(Arrays.toString(edge));

                if (n == V - 1) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1, 5}, {0, 2, 50}, {0, 4, 10}, {1, 4, 15}, {1, 3, 30}, {1, 2, 40}, {3, 4, 20}};


        findMST(edges, V);

    }

}
