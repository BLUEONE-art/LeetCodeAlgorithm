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
// 👍 73 👎 0


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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        // 判别奇偶数
        int count = 0;
        while (!queue.isEmpty()) {
            // 每循环一次，count + 1
            count++;
            // 存放每一层的结果
            List<Integer> levelRes = new ArrayList<>();
            // 根据每一层的节点数循环几次
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode cur = queue.poll();
                levelRes.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            // 当 count 为奇数的时候，从左到右，为偶数时，从右到左
            if (count % 2 != 0) {
                res.add(levelRes);
            } else {
                sort(levelRes);
                res.add(levelRes);
            }
        }
        return res;
    }
    public List<Integer> sort(List<Integer> levelRes) {
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
