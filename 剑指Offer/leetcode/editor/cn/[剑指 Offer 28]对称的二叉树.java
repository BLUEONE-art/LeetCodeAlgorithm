//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 
// 👍 126 👎 0


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
//    String Null = "#";
    public boolean isSymmetric(TreeNode root) {
        // 如果 root 为 null
        if (root == null) {
            return true;
        } else {
            return recur(root.left, root.right);
        }
//        // 原始二叉树和其镜像对比
//        TreeNode mirror = root;
//        mirrorTree(mirror);
//        // 获得序列化的结果
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        middleEngodic(root, sb1);
//        middleEngodic(mirror, sb2);
//        String s1 = sb1.toString();
//        String s2 = sb2.toString();
//        int flag = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            if (s1.charAt(i) != s2.charAt(i)) {
//                flag++;
//                break;
//            }
//        }
//        return flag == 0;
    }
    // recur()：用来判断二叉树的两个左右子节点下的节点是否对称
    public boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }














//    public void mirrorTree(TreeNode root) {
//        if (root == null) return;
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//    }
//    // 中序遍历
//    public void middleEngodic(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append(Null);
//            return;
//        }
//        middleEngodic(root.left, sb);
//        sb.append(root.val);
//        middleEngodic(root.right, sb);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
