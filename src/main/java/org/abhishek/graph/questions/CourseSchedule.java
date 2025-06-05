package org.abhishek.graph.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//topo sort
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int totalCoursePossible = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            totalCoursePossible++;
            for(int neighbour : adjList.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return  totalCoursePossible==numCourses;
    }

    public static void main(String[] args) {
        int[][] pre = {
                {0, 1},
                {1, 2},
                {2, 1}
        };

        System.out.println(canFinish(4, pre));
    }

}
