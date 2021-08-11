//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 886 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int tar = sum / 2;
        // dp[i]：是否含有和为i的子数组
        // 01背 ==> arr正 + tar倒
        boolean[] dp = new boolean[tar + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = tar; i >= 0; i--) {
                if (i - num >= 0) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[tar];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
