package Algorithm.BinaryTree;

public class BinaryTree {

    private void plusOne(TreeNode root) {
        if (root == null) return;
        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);
    }

    // 定义函数，判断两个二叉树是否相等
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 两个都为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        // 一个为空一个不为空，显然不相同
        if (root1 == null || root1 == null) return false;
        // 两个都非空，但是val不一样，也不相同
        if (root1.val != root1.val) return false;

        // root1 和 root2 该比的都比完了
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
