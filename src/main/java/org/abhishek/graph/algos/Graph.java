package org.abhishek.graph.algos;

import java.util.ArrayList;

public class Graph {

    private int vertex;

    private ArrayList<ArrayList<Integer>> edges;

    public Graph(int numberOfVertex) {
        this.vertex = numberOfVertex;
        this.edges = new ArrayList<>();
        for(int i=0;i< numberOfVertex; i++) {
            edges.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        this.edges.get(u).add(v);
        this.edges.get(v).add(u);
    }

    public int getVertex() {
        return this.vertex;
    }
    public ArrayList<ArrayList<Integer>> getEdges() {
        return this.edges;
    }

}
