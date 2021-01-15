//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下： 
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 树 
// 👍 232 👎 0


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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int low, int high) {
        // base case：如果数组 nums 为空，则返回 null
        if (high < low) return null;

        // 找到数组中最大的元素当作根节点
        // 在JDK中，整形类型是有范围的，最大值为Integer.MAX_VALUE，即2147483647，最小值为Integer.MIN_VALUE -2147483648。
        int index = -1,  maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal) {
                index = i;
                maxVal = nums[i];
            }
        }

        // 最大值找到后，以其作为根节点
        TreeNode root = new TreeNode(maxVal);

        // 递归找子区间的最大值构造根节点，以此类推
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
