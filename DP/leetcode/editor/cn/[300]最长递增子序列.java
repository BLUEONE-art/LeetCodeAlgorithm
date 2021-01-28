//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 二分查找 动态规划 
// 👍 1292 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* 找到数组 nums 中最长的递增子序列 */
class Solution {
    // 动态规划解法：O(n^2)
    public int lengthOfLIS(int[] nums) {
        // dp[] 数组定义：假设 nums = [1,2,3,7,5]
        // dp[1] = 1; dp[2] = 2; ... dp[5] = 4
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
        int[] dp = new int[nums.length];
        // 因为最小的递增子序列为 1，所以 dp[] 初始化都为 1
        Arrays.fill(dp, 1);
        // 计算 i = 0 开始每一个 dp[i] 的值
        for (int i = 0; i < nums.length; i++) {
            // 相当于数学归纳法中，先知道了 dp[i -  1]，求 dp[i]
            for (int j = 0; j < i; j++) {
                // 求解 dp[i]，只要知道 nums[i] > nums[j]
                // dp[j] 的值 + 1，并且在所有的 dp[j] 中取最大的作为 dp[i] 的值
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 因为 dp[] 返回 nums[] 数组每个元素对应的最长递增序列的长度
        // 所以在 dp[] 数组中挑出最大值作为输出
        int max_res = 0;
        for (int i = 0; i < dp.length; i++) {
            max_res = Math.max(max_res, dp[i]);
        }
        return max_res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
