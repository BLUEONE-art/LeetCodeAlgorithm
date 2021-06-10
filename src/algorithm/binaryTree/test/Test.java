package algorithm.binaryTree.test;

import algorithm.binaryTree.frame.TreeNode;

public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        StringBuilder sb = new StringBuilder();
        String res = inorderDfs(root, sb);
        System.out.println(res);
    }

    public static String inorderDfs(TreeNode root, StringBuilder sb) {
        if (root == null) return "";
        inorderDfs(root.left, sb);
        sb.append(root.val);
        inorderDfs(root.right, sb);

        return sb.toString();
    }
}
