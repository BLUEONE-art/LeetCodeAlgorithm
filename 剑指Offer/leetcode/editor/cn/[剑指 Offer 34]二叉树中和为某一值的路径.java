//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 134 👎 0


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
    LinkedList<List<Integer>> res = new LinkedList<>();
    // 某单条可行的路径
    LinkedList<Integer> path = new LinkedList<>();
    // pathSum()：能找到树 root 中和为 Sum 的路径
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    public void recur(TreeNode root, int tar) {
        // base case
        if (root == null) return;
        // 前序遍历代码位置
        // 记录路径经过的节点值
        path.add(root.val);
        // 更新 tar 目标值
        tar -= root.val;
        // 如果找到了一条路径
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        // 前序遍历框架
        recur(root.left, tar);
        recur(root.right, tar);
        // 后序遍历代码位置
        // 每次执行到叶子节点，先到左叶子结点的路径，不管满不满足条件，都该换成右叶子节点试试了
        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
