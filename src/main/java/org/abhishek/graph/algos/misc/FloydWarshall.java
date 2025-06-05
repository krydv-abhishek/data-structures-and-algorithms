package org.abhishek.graph.algos.misc;

public class FloydWarshall {
    public static int INF = 100000000;

    public static void shortestPathFW(int[][] adjMatrix) {

        int V = adjMatrix.length;

        //add all vertices to set of intermediate vertices
        for (int k = 0; k < V; k++) {
            //source one by one
            for (int i = 0; i < adjMatrix.length; i++) {
                //destination one by one
                for (int j = 0; j < adjMatrix.length; j++) {
                    if(adjMatrix[i][k]!=INF && adjMatrix[k][j]!=INF) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
            //System.out.println(Arrays.deepToString(adjMatrix));
        }

    }

    public static void main(String[] args) {


        int[][] adjMatrix = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };

        shortestPathFW(adjMatrix);
        System.out.print("  ");
        for (int j = 0; j < adjMatrix.length; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j = 0; j < adjMatrix.length; j++) {
            System.out.print("--");
        }
        System.out.println("-");
        for (int i=0;i< adjMatrix.length; i++) {
            System.out.print(i + "-");
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
