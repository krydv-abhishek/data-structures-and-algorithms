package org.abhishek.graph.questions;

import java.util.*;

//dfs
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //Optimal solution
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        return cloneNode(node, nodeMap);
    }

    private Node cloneNode(Node node, Map<Node, Node> nodeMap) {
        if (nodeMap.containsKey(node))
            return nodeMap.get(node);

        Node clone = new Node(node.val);
        nodeMap.put(node, clone);

        for (Node neiNode: node.neighbors) {
            Node neiClone = cloneNode(neiNode, nodeMap);
            clone.neighbors.add(neiClone);
        }

        return clone;
    }

    public static Node dfs(Node node) {
        if(node==null){
            return node;
        }

        List<Integer>[] arrayOfLists = new ArrayList[101]; // array of 5 lists
        for (int i = 0; i < 101; i++) {
            arrayOfLists[i] = new ArrayList<>();
        }
        int[] visited = new int[101];
        int nodeCount = 0;
        visited[1] = 1;
        dfsUtil(node, visited, arrayOfLists);
        for (int n : visited) {
            if (n == 1) {
                nodeCount++;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= nodeCount; i++) {
            Node newNode = map.getOrDefault(i, new Node(i));
            map.putIfAbsent(i, newNode);
            List<Integer> neighbourNodes = arrayOfLists[i];
            for (int n : neighbourNodes) {
                Node neighbourNode = map.getOrDefault(n, new Node(n));
                map.putIfAbsent(n, neighbourNode);
                newNode.neighbors.add(neighbourNode);
            }
        }

        return map.get(1);

    }

    public static void dfsUtil(Node node, int[] visited, List<Integer>[] arrayOfLists) {
        List<Integer> neighbourNodeVals = new ArrayList<>();
        for (Node neighbour : node.neighbors) {
            neighbourNodeVals.add(neighbour.val);
            if (visited[neighbour.val] == 0) {
                visited[neighbour.val] = 1;
                dfsUtil(neighbour, visited, arrayOfLists);
            }
        }
        arrayOfLists[node.val] = neighbourNodeVals;
    }


//    public static Node cloneGraph(Node node) {
//        return Node;
//    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//
//        node1.neighbors.add(node6);
//        node1.neighbors.add(node2);
//
//        node2.neighbors.add(node1);
//        node2.neighbors.add(node5);
//        node2.neighbors.add(node3);
//        node2.neighbors.add(node4);
//
//
//        node3.neighbors.add(node6);
//        node3.neighbors.add(node2);
//        node3.neighbors.add(node4);
//
//        node4.neighbors.add(node2);
//        node4.neighbors.add(node3);
//        node4.neighbors.add(node5);
//
//        node5.neighbors.add(node2);
//        node5.neighbors.add(node4);
//
//        node6.neighbors.add(node1);
//        node6.neighbors.add(node3);

        Node newNodeHead = dfs(node1);
        Node newNodeHead1 = dfs(node1);

        //Node copyNode = cloneGraph(node1);


    }
}
