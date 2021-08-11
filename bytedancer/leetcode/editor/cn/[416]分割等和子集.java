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
            for (int i = tar; i - num >= 0; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[tar];
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        // dp[i][w]：从数组nums[0, 1, ..., i]中取一些数，其总和为w的真假
        boolean[][] dp = new boolean[len][w + 1];
        if (nums[0] < w) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= w; j++) {
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j - nums[i] == 0) {
                    dp[i][j] = true;
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][w];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
