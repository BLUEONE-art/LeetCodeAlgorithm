//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 901 👎 0


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
    // lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)函数的定义：
    // 牢记定义：(即拿到递归结果要做的事)
    // ①当 p 和 q 都在以 root 为根节点的树中，返回 root 节点
    // ②当 p 和 q 中只有一个在以 root 为根节点的树中，返回该存在的节点
    // ③当 p 和 q 都不存在时，返回 null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        // ①假如 root 为 null，返回 null
        if (root == null) return null;
        // ②加入 p 和 q 本身就是 root 节点，直接返回 root
        if (root == p || root == q) return root;

        // 后续遍历位置
        // 如果没有返回值，就不需要接收，有返回值需要接收
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 后序遍历的代码：即拿到返回值每一次需要做什么？
        // 此时接收到的 left 和 right 都是lowestCommonAncestor函数返回的内容
        // 如果 left 和 right 不为空，则 left 和 right 一定分别为 p 和 q
        if (left == null && right == null) return null;

        // 此时必是最近公共节点，因为这是后序遍历，p 和 q 的上一个节点就是他们的公共节点
        if (left != null && right != null) return root;

        // 当树中只存在 p 或者 q 时，返回 p 或 q
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
