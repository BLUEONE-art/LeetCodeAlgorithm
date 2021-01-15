//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 826 👎 0


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    // 定义函数 build()：根据前序遍历和中序遍历的结果中的左子树和右子树的索引范围重构二叉树
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {

        // base case
        if (preEnd < preStart) return null;

        // ①根据前序遍历的结果可以得出原二叉树的 root 节点的值
        int rootVal = preorder[preStart];

        // ②根据 root 节点的值找到其在 inorder[] 数组中的索引
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
            }
        }

        // ③构造树
        TreeNode root = new TreeNode(rootVal);

        // ④计算leftSize(左子树元素个数)
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
