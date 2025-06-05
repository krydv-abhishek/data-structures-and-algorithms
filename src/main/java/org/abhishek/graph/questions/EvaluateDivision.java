package org.abhishek.graph.questions;

import java.util.*;
//dfs
public class EvaluateDivision {

    static class EdgeWithWeight {
        String dest;
        double weight;

        public EdgeWithWeight(String dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }


    public static double[] calcEquation(List<List<String>> equations,
                                        double[] values, List<List<String>> queries) {

        Map<String, List<EdgeWithWeight>> adjList = new HashMap<>();

        int i = 0;
        for (List<String> edge : equations) {
            String uKey = edge.get(0);
            String vKey = edge.get(1);

            List<EdgeWithWeight> uEdges = adjList.getOrDefault(uKey, getSelfEdge(uKey));
            List<EdgeWithWeight> vEdges = adjList.getOrDefault(vKey, getSelfEdge(vKey));

            uEdges.add(new EdgeWithWeight(vKey, values[i]));
            vEdges.add(new EdgeWithWeight(uKey, 1 / values[i]));

            adjList.putIfAbsent(uKey, uEdges);
            adjList.putIfAbsent(vKey, vEdges);
            i++;
        }

        double[] answers = new double[queries.size()];

        i = 0;
        for (List<String> edge : queries) {
            Set<String> visited = new HashSet<>();
            double[] result = new double[1];

            if (adjList.containsKey(edge.get(0)) && adjList.containsKey(edge.get(1))) {
                if (dfsUtil(adjList, edge.get(0), edge.get(1), visited, 1.0, result)) {
                    answers[i++] = result[0];
                } else {
                    answers[i++] = -1.0;
                }
            } else {
                answers[i++] = -1.0;
            }
        }

        return answers;
    }

    public static boolean dfsUtil(Map<String, List<EdgeWithWeight>> adjList, String source, String target
            , Set<String> visited, double current, double[] result) {

        if (Objects.equals(source, target)) {
            result[0] = current;
            return true;
        }

        visited.add(source);

        for (EdgeWithWeight uEdge : adjList.get(source)) {
            if (!visited.contains(uEdge.dest)) {
                if (dfsUtil(adjList, uEdge.dest, target, visited, current * uEdge.weight, result)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<EdgeWithWeight> getSelfEdge(String node) {
        List<EdgeWithWeight> edgeWithWeights = new ArrayList<>();
        edgeWithWeights.add(new EdgeWithWeight(node, 1.0));
        return edgeWithWeights;
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        equations.add(List.of("a", "b"));
        equations.add(List.of("b", "c"));

        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(List.of("a", "c"));
        queries.add(List.of("b", "a"));
        queries.add(List.of("a", "e"));


        System.out.println(Arrays.toString(
                calcEquation(equations, values, queries
                )));

    }
}
