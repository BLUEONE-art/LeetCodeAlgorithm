//输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。 
//
// 例如： 
//
// 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tre
//e/ 
// Related Topics 树 深度优先搜索 
// 👍 87 👎 0


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
    // 核心思路：层序遍历的层数就是数的深度
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) return 0;
        // 构建队列 queue 用于循环
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 构建队列(局部变量)存放每一层的节点
        Queue<TreeNode> tmp;
        int res = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            // tmp 记录每一层的节点
            for (TreeNode treeNode : queue) {
                if (treeNode.left != null) tmp.offer(treeNode.left);
                if (treeNode.right != null) tmp.offer(treeNode.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    // 函数定义：可以求解二叉树的最大深度
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
