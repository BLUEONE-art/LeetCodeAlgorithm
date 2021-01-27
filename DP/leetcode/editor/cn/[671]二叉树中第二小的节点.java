//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 
// 👍 132 👎 0


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
    public int findSecondMinimumValue(TreeNode root) {
        // base case
        if (root == null) return -1;
        return helper(root, root.val); // 默认 root.val 是最小值
    }
    /* 函数定义：输入二叉树和当前最小值，找到二叉树的第二小的节点，返回该节点的值 */
    private int helper(TreeNode root, int min) {
        // base case 1
        if (root == null) return -1;
        // base case 2
        if (root.val > min) return root.val;

        int left = helper(root.left, min);
        int right = helper(root.right, min);

        // 后序遍历的代码
        // 如果 root.left || root.right 下无子树，返回另一半的结果
        // 根本没考虑题目，默认左右子树可以有一个为空，题目是要么是 0 节点，要么有两个子节点
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
