//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 196 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        // 二叉搜索树的后序遍历特点：
        // 1、根节点 root 为数组最后一个元素
        // 2、左子树的范围应该是从数组起始位置到第一个大于根节点的元素之前
        // 3、右子树的范围是第一个大于根节点的元素到根节点之前的元素
        return isBST(postorder, 0, postorder.length - 1);
    }
    // isBST()：定义是根据后序遍历结果中的左子树范围和右子树范围判断该结果是不是二叉搜索树的后序遍历
    public boolean isBST(int[] postorder, int i, int j) {
        // base case：只剩下一个节点时，左子树和右子树元素均为 “无”
        if (i >= j) return true;
        // 求左子树范围：i ~ m - 1
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        // 右子树范围：m ~ j - 1
        for (int t = m; t < j; t++) {
            if (postorder[t] < postorder[j]) return false;
        }
        // 递归判断左子树和右子树中是否为二叉搜索树
        return isBST(postorder, i, m - 1) && isBST(postorder, m, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
