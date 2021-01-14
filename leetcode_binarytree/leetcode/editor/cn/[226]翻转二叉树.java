//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 729 👎 0


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
    // 反转二叉树的关键思路：只需要将二叉树上的每个节点的左右子节点互换即可
    public TreeNode invertTree(TreeNode root) {

        // base case
        if (root == null) return null;

        // 前序遍历的位置
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;    // base case + 前序遍历代码都是 root 节点要完成的事，剩下的交给递归

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
