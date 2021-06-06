//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 591 👎 0


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
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) { // 前序遍历：中->左->右
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> tmp = new Stack<>();
        while (root != null || !tmp.isEmpty()) {
            if (root != null) {
                res.add(root.val);
                if (root.right != null) {
                    tmp.push(root.right);
                }
                root = root.left;
            }
            else {
                root = tmp.pop();
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) { // 后序遍历：左->右->中
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> tmp = new Stack<>();
        while (root != null || !tmp.isEmpty()) {
            if (root != null) {
                res.addFirst(root.val);
                if (root.left != null) {
                    tmp.push(root.left);
                }
                root = root.right;
            }
            else {
                root = tmp.pop();
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) { // 中序遍历：左->中->右
        LinkedList res = new LinkedList<>();
        Stack<TreeNode> tmp = new Stack<>();
        while (root != null || !tmp.isEmpty()) {
            if (root != null) {
                tmp.push(root);
                root = root.left;
            }
            else {
                root = tmp.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
