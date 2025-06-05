package org.abhishek.graph.questions;

import java.util.*;

//topo sort
public class CourseScheduleII {

    public static int[] canFinish(int numCourses, int[][] prerequisites) {

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

        List<Integer> courses = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            courses.add(node);
            for(int neighbour : adjList.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return courses.size()==numCourses? courses.stream().mapToInt(Integer::intValue).toArray(): new int[0];

    }

    public static void main(String[] args) {
        int[][] pre = {
                {0, 1},
                {1, 2},
                {2, 1}
        };

        System.out.println(Arrays.toString(canFinish(4, pre)));
    }

}
