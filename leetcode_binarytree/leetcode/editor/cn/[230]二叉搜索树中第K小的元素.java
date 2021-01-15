//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 335 👎 0


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
    public int kthSmallest(TreeNode root, int k) {

        traverse(root, k);
        return res;
    }

    // 记录结果
    int res = 0;
    // 创建变量存放当前元素的排名
    int rank = 0;

    public void traverse(TreeNode root, int k) {

        // base case
        if (root == null) return;

        // 中序遍历
        traverse(root.left, k);

        /* 需要的操作 */
        // 因为时 BST 的中序遍历，所得的结果即是升序的结果
        // 所以每次递归，rank + 1
        rank ++;
        // 当 rank = K 时，即进行了 K 次递归，返回第 K 大的元素
        if (rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);

        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
