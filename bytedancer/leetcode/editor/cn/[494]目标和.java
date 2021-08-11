//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 853 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // 正数和x，负数和y，数组和sum
        // x - y = target
        // x + y = sum
        // x = (target = sum) / 2
        // 找到和为target的组合数，还要考虑加减法 --> 找到和为x的子数组个数
        int newTar = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || ((target + sum) & 1) == 1) {
            return 0;
        }
        newTar = (target + sum) / 2;
        // nums[]数组中和为newTar的组合数
        int[] dp = new int[newTar + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = newTar; i >= 0; i--) {
                if (i - num >= 0) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[newTar];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
