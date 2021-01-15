//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 435 👎 0


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
    public TreeNode buildTree(int[] inorder, int[] postorder)  {

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    // 定义函数 build()：根据前序遍历和中序遍历的结果中的左子树和右子树的索引范围重构二叉树
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {

        // base case
        if (inEnd < inStart) return null;

        // ①根据前序遍历的结果可以得出原二叉树的 root 节点的值
        int rootVal = postorder[postEnd];

        // ②根据 root 节点的值找到其在 inorder[] 数组中的索引
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // ③构造树
        TreeNode root = new TreeNode(rootVal);

        // ④计算leftSize(左子树元素个数)
        int leftSize = index - inStart;

        root.left = build(inorder, inStart, index - 1,
                postorder, postStart,postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize,postEnd - 1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
