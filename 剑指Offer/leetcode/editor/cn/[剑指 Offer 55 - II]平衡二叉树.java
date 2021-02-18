//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。 
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 114 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 核心思路：定义好递归函数
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    // 该递归函数的定义：
    // 1.当二叉树为平衡二叉树时：返回该二叉树的最大深度
    // 2.当二叉树不为平衡二叉树时(即左右子树深度相差超过 1)，返回 -1
    public int recur(TreeNode root) {
        // base case
        if (root == null) return 0;
        // 采用后序遍历
        int left = recur(root.left);
        // 如果左子树中都不平衡，那整棵树必不平衡，直接返回 -1，结束
        if (left == -1) return -1;
        // 右子树同理
        int right = recur(root.right);
        if (right == -1) return -1;
        // 后续遍历代码的位置
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
