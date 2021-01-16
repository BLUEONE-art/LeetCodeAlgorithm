//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 375 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 删除BST节点
    public TreeNode deleteNode(TreeNode root, int key) {

        // base case
        if (root == null) return null;

        // 搭建框架
        if (root.val == key) {
            // ①如果这个节点刚刚好在二叉树的最末端，并且只有他一个，直接可以删了
            if (root.left == null && root.right == null) return null;

            // ②如果这个节点有右兄弟节点
            if (root.left == null) return root.right;

            // ③如果这个节点有左兄弟节点
            if (root.right == null) return root.left;

            // ④如果以上情况都不满足
            // 找到左子树中最大的节点或者右子树中最小的节点替代自己
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            // 删除这个minNode
            root.right = deleteNode(root.right, minNode.val); // 需要对递归的结果进行接收
        }

        if (key < root.val) root.left = deleteNode(root.left, key);
        if (key > root.val) root.right = deleteNode(root.right, key);

        return root;
    }

    public TreeNode getMin(TreeNode node) {

        // BST 右子树的最左边的节点就是最小的
        while (node.left != null) node = node.left;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
