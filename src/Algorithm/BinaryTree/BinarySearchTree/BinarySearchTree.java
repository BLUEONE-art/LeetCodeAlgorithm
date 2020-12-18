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

    // 定义方法在 BST 中查找一个数是否存在
    private boolean isInBST(TreeNode root, int target) {
        // 只需先判断一个根节点的值是不是target，剩下的交给递归
        if (root == null) return false;
        if (root.val == target)
            return true;

        // 开始递归
//        return isInBST(root.left, target)
//                || isInBST(root.right, target);

        // 上述方法虽然可行，但是没有考虑到 BST 这个“左小右大”的特性
        if (root.val > target)
            return isInBST(root.left, target);
        return isInBST(root.right, target);
    }

}
