//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
// 
//
// 
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, TreeNode> keyMap = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findKeyMap(root);
        dfs(target, 0, null, k);
        return res;
    }

    public void findKeyMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            keyMap.put(root.left.val, root);
            findKeyMap(root.left);
        }
        if (root.right != null) {
            keyMap.put(root.right.val, root);
            findKeyMap(root.right);
        }
    }

    public void dfs(TreeNode tar, int dis, TreeNode from, int k) {
        if (tar == null) {
            return;
        }
        if (dis == k) {
            res.add(tar.val);
        }
        if (tar.left != from) {
            dfs(tar.left, dis + 1, tar, k);
        }
        if (tar.right != from) {
            dfs(tar.right, dis + 1, tar, k);
        }
        if (keyMap.get(tar.val) != from) {
            dfs(keyMap.get(tar.val), dis + 1, tar, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
