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
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 530 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int inorderRootIdx = -1;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inorderRootIdx = i;
                break;
            }
        }
        // 后序遍历中左右子树元素个数
        int rightSize = inEnd - inorderRootIdx;
        root.left = build(inorder, inStart, inorderRootIdx - 1, postorder, postStart, postEnd - rightSize - 1);
        root.right = build(inorder, inorderRootIdx + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
