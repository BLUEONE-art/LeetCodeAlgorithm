package Algorithm.BinaryTree.BinarySearchTree;

import Algorithm.BinaryTree.TreeNode;

public class BinarySearchTree {

    // 定义方法判断一个二叉搜索树是否合法
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
