//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 80 👎 0


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
        // 中序遍历取树中每一层节点放入队列中，保证先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        // 先装入根节点
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            // 存放每层遍历的结果
            List<Integer> levelRes = new ArrayList<>();
            // 每次循环的次数就是每层不为 0 的元素个数
            for(int i = queue.size(); i > 0; i--) {
                // 取出队列中的值
                TreeNode cur = queue.poll();
                levelRes.add(cur.val);
                // 装入下一层的节点
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            // 每层的结果放入了 levelRes，再将其装入 res
            res.add(levelRes);
        }
        return res;
    }
}
//        int count = 0;
//        // 每次都会给 queue 装入二叉树中一层的节点
//        while (!queue.isEmpty()) {
//            // 定义数组装每层遍历的结果
//            List<Integer> levelRes = new ArrayList<>();
//            // 每次处理上一次装入队列的节点
//            TreeNode cur = queue.poll();
//            // 把它们节点的值装入数组
//            if (cur == null) {
//                continue;
//            }
//            levelRes.add(cur.val);
//            count++;
//            // 有条件加入数组
//            if (count == Math.pow(2, count - 1)) {
//                res.add(levelRes);
//                count = 0;
//            }
//
//            queue.offer(root.left);
//            queue.offer(root.right);
//        }
//        return res;
//leetcode submit region end(Prohibit modification and deletion)
