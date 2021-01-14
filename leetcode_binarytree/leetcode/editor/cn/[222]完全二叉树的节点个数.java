//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 417 👎 0


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
    // 计算完全二叉树的节点个数
    // 完全二叉树要比普通的二叉树要特殊，但又没有满二叉树特殊(左右子树深度相同，没有空余节点)
    // 所以计算完全二叉树节点要结合普通二叉树和满二叉树(节点数为：2^h - 1，h 为满二叉树的深度)
    public int countNodes(TreeNode root) {

        // ①计算左右子树各自的深度
        TreeNode l = root, r = root;

        // 定义两个变量记录左右子树的深度
        int hl = 0, hr = 0;

        while (l != null) {
            l = l.left;
            hl++;
        }

        while (r != null) {
            r = r.left;
            hl++;
        }

        // ②分情况讨论计算节点数
        // i)当左右子树深度相同时，说明是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }

        // ii)当左右子树高度不相同时，只能按照普通二叉树节点计算
        // 但是时间复杂度会有所简化，因为只有一边的子树会真正递归
        // 因为完全二叉树必有一棵子树是满二叉树，会触发 hl == hr 条件直接返回
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
