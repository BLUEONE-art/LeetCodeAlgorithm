//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 
// 👍 191 👎 0


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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // base case1
        if (A == null || B == null) return false;
        // base case2
        if (A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right)) return true;
        return (isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    // recur()：用于判断树 A、B 中每个节点是否相同
    public boolean recur(TreeNode A, TreeNode B) {
        // B 为空了，说明 A.left == B.left && A.right == B.right 直到 B 为空都是正确的，B 一定要在前面
        if (B == null) return true;
        // base case：大的树 A 为空了，说明 A 还比 B 小，肯定不包括 B
        if (A == null) return false;
        if (A.val == B.val) {
            return recur(A.left, B.left) && recur(A.right, B.right);
        } else return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
