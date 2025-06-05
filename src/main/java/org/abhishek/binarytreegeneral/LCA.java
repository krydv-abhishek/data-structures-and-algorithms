package org.abhishek.binarytreegeneral;

public class LCA {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {

        Integer[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13, 14, 15};
        TreeNode root = TreeNode.buildTreeLevelWise(elements);

        TreeNode.printTree(root);

        System.out.println(lowestCommonAncestor(root, root.left, root.left.left.right).val);

    }
}
