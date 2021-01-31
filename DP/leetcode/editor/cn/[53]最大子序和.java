//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 最大子序和问题 */
    public int maxSubArray(int[] nums) {
        // dp[i] 数组：数组以 nums[i] 结尾的最大字序和
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case：数组第一位 nums[0] = dp[0]
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // dp[i] 表示 dp[i - 1] 如果跟 nums[i] 相加形成一个更大的子数组的话，就返回这个合并数组
            // 如果合并数组还没有自己本身 nums[i] 的数值大，直接返回 nums[i] 即可
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
