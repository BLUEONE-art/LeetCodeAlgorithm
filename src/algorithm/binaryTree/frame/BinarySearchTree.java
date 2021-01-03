package algorithm.binaryTree.frame;

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

    // 定义方法在 BST 中插入一个数
    private TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空的位置插入新节点
        if (root == null) return new TreeNode(val);
        // 如果已经存在，则无需重复插入，直接返回
        if (root.val == val)
            return root;
        // 分两种情况进行递归调用
        // ① root 的 val 小，则新的 val 应插入到右子树中
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        // ② root 的 val da，则新的 val 应插入到左子树中
        if (root.val > val)
            root.left =  insertIntoBST(root.left, val);
        return root;
    }

    // 定义方法在 BST 中删除一个数
    private TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return null;
        if (root.val == key) {
            // 假设找到目标节点 A，删除这个节点的第一种情况：①A 恰好事末端节点，即两个子节点都为空，那么它可以当即退场
            if (root.left == null && null == root.right) return null;
            // ②A 只有一个非空子节点，那么要让它的孩子接替自己的位置
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // ③A 有两个子节点，为了不破坏 BST 的结构，A 必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来替代自己
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 找到右子树中最小的节点
    private TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }

    // 找到左子树中最大的节点
    private TreeNode getMax(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.right != null) node = node.right;
        return node;
    }
}
