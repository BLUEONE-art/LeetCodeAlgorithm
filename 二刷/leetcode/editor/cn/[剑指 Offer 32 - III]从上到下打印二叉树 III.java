//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 90 👎 0


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int oddOrEven = 0;
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            oddOrEven++;
            for (int i = q.size(); i > 0; i--) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            //奇数
            if (oddOrEven % 2 != 0) {
                res.add(tmp);
            } else {
                res.add(sort(tmp));
            }
        }
        return res;
    }
    public List<Integer> sort(List<Integer> tmp) {
        int left = 0, right = tmp.size() - 1;
        while (left <= right) {
            int tmp_value = tmp.get(left);
            tmp.set(left, tmp.get(right));
            tmp.set(right, tmp_value);
            left++;
            right--;
        }
        return tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
