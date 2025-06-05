package org.abhishek.binarytreegeneral;

public class CountCompleteBTNodes {

    public static int countNodes(TreeNode root) {


        if (root == null) return 0;

        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    private static int getHeight(TreeNode node, boolean left) {
        int height = 0;
        while (node != null) {
            height++;
            node = left ? node.left : node.right;
        }
        return height;
    }


    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 14, 15};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(countNodes(root));


    }

}
