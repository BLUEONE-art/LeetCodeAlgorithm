//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 439 👎 0


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            List<Integer> levelRes = new ArrayList<>();
            for(int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();
                levelRes.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            if (count % 2 != 0) {
                res.add(levelRes);
            }
            else {
                reverse(levelRes);
                res.add(levelRes);
            }
        }
        return res;
    }

    public List<Integer> reverse(List<Integer> levelRes) {
        int left = 0, right = levelRes.size() - 1;
        while (left < right) {
            int tmp = levelRes.get(left);
            levelRes.set(left, levelRes.get(right));
            levelRes.set(right, tmp);
            left++;
            right--;
        }
        return levelRes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
