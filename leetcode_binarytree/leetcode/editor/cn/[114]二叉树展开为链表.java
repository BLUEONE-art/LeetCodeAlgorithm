//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 683 👎 0


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
    public void flatten(TreeNode root) {

        // base case
        if (root == null) return;

        // 后序遍历
        // 不需要管怎么才能把二叉树的左右子树拉直成一个链表，只需要递归调用这个函数即可
        flatten(root.left);
        flatten(root.right);

        // 执行完上述递归代码后，我们只需要知道此时二叉树的左右子树已经被拉直了
        // 考虑如何将 root 先拼接左子树，再在其基础上拼接右子树
        // 新定义两个 TreeNode 分别存放左子树和右子树
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 清零 root 原先的左子树
        root.left = null;
        // 让 root 的下一个节点指向左子树的头节点
        root.right = left;

        // 将右子树拼接到上述的结果中
        // 在此之前需要获得拼接完左子树后的 root 的最后一个节点
        // 定义一个 p 复制 root，用它来计算最后一个节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }

        // 再让 p 的指向右子树的头节点即可
        p.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
