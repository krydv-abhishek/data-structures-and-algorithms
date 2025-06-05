package org.abhishek.graph.algos.dfs;

import org.abhishek.graph.algos.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllPathsBetweenTwo {

    public static void printAllPaths(Graph graph, int s, int d)
    {
        boolean[] isVisited = new boolean[graph.getVertex()];
        ArrayList<Integer> pathList = new ArrayList<>();
        printAllPathsUtil(s, d, isVisited, pathList, graph);
    }

    private static void printAllPathsUtil(Integer current, Integer dest,
                                   boolean[] isVisited, List<Integer> localPathList, Graph graph) {

        isVisited[current] = true;
        localPathList.add(current);

        if (Objects.equals(current, dest)) {
            System.out.println(new ArrayList<>(localPathList)); // Found a valid path
        } else {
            for (int neighbor : graph.getEdges().get(current)) {
                if (!isVisited[neighbor]) {
                    printAllPathsUtil(neighbor, dest, isVisited, localPathList, graph);
                }
            }
        }

        // Backtrack
        localPathList.remove(localPathList.size() - 1);
        isVisited[current] = false;
    }

    // Driver program
    public static void main(String[] args)
    {
        // Create a sample graph
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        // arbitrary source
        int s = 2;

        // arbitrary destination
        int d = 3;

        System.out.println(
                "Following are all different paths from "
                        + s + " to " + d);
        printAllPaths(g, s, d);
    }
}
