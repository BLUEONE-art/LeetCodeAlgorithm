//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 
// 👍 224 👎 0


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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> q = new LinkedList<>(); // 双端队列
        root.val = 0; // 目的是为了计算满顺序二叉树个节点的值，第一层root = 0，root.left = 2*root + 1 = 1， root.right = 2*root + 2 = 2，依此类推每一层都是顺序的
        int res = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            res = Math.max(res, q.getLast().val - q.getFirst().val + 1); // 顺序的慢二叉树最大宽度就是最后一层最左、右两个节点值之差+1
            while (levelSize > 0) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    cur.left.val = 2 * cur.val + 1;
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = 2 * cur.val + 2;
                    q.offer(cur.right);
                }
                levelSize--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
