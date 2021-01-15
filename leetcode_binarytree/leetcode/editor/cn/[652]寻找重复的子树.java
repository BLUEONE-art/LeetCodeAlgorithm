//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 211 👎 0


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
    // 创建一个 HashMap 记录每个子树及其出现的频次
    HashMap<String, Integer> memo = new HashMap<>();
    // 创建一个 LinkedList 记录每一个重复的子树
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        trverse(root); // 遍历二叉树
        return res;
    }

    public String trverse(TreeNode root) {

//        StringBuilder s = new StringBuilder("#");
        // base case
        if (root == null) return "#";

        // 后序遍历的位置
        String left = trverse(root.left);
        String right = trverse(root.right);

//        StringBuilder subTree = new StringBuilder();
        // 得到每一次递归的时候，每一个节点以自己为根节点时构成的子树 subTree
        String subTree = left + "," + right + "," + root.val;

        // 获取每一个子树出现的频次
        // 当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
        // 相当于每次递归都会生成一个 subTree，每次都会判断 memo 中该子树的频次
        int freq = memo.getOrDefault(subTree, 0);
        memo.put(subTree, freq + 1);

        // 将前节点构成的子树与其他节点构成的子树进行对比
        if (freq == 1) {
            res.add(root);
        }

        return subTree; // 返回最终递归完成的 subTree，即序列化完成的结果
    }
}
//leetcode submit region end(Prohibit modification and deletion)
