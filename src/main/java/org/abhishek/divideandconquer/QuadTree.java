package org.abhishek.divideandconquer;


import java.util.LinkedList;
import java.util.Queue;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    public void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node1 = queue.poll();
                String val = node1.val ? "1" : "0";
                String leaf = node1.isLeaf ? "1" : "0";
                System.out.print(val + " " + leaf);
                System.out.print(", ");
                if (node1.topLeft != null) {
                    queue.add(node1.topLeft);
                }
                if (node1.topRight != null) {
                    queue.add(node1.topRight);
                }
                if (node1.bottomLeft != null) {
                    queue.add(node1.bottomLeft);
                }
                if (node1.bottomRight != null) {
                    queue.add(node1.bottomRight);
                }
            }
            System.out.println(" ");

        }

    }
}

class Solution {
    public Node construct(int[][] grid) {
        return constructHelper(grid, 0, 0, grid.length);
    }

    public Node constructHelper(int[][] grid, int r, int c, int n) {
        if (allSame(grid, r, c, n)) {
            return new Node(grid[r][c]==1, true);
        }

        int mid = n / 2;
        Node node = new Node(false, false);
        node.topLeft = constructHelper(grid, r, c, mid);
        node.topRight = constructHelper(grid, r, c+mid, mid);
        node.bottomLeft = constructHelper(grid, r+mid, c, mid);
        node.bottomRight = constructHelper(grid, r+mid, c+mid, mid);
        return node;
    }

    private boolean allSame(int[][] grid, int i, int j, int w) {
        for (int x = i; x < i + w; ++x)
            for (int y = j; y < j + w; ++y)
                if (grid[x][y] != grid[i][j])
                    return false;
        return true;
    }


}

public class QuadTree {

    public static void main(String[] args) {
        //int[][] grid = {{0, 1}, {1, 0}};
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };


        Solution solution = new Solution();
        Node node = solution.construct(grid);

        node.bfs();
    }

}

