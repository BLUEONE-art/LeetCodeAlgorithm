//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 663 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路：如果一个大的数组可以分成两个 “和” 相同的两个数组
    // 可以等价的看出大的数组中有没有一个子数组的和等于大数组所有元素和的一半
    // 进一步看成 0-1 背包问题：子数组中的元素个数看成背包中的物品个数，其对应值的和应该是大数组元素和的一半
    public boolean canPartition(int[] nums) {
        // dp[i][w]：表示从数组 nums[0,...i] 挑选几个正整数的组合，使之和为 w
        int N = nums.length;
        int W = 0;
        for (int num : nums) {
            W += num;
        }
        if (W % 2 != 0) return false;
        // 定义背包的容量 w
        int W_target = W / 2;
        boolean[][] dp = new boolean[N][W + 1];
        // base case：当背包中元素只有 nums[0] 时，满足 nums[0,...,i] 和为 w 的只有 dp[0][nums[0]]
        // 如果 nums[0] 还在背包的容纳范围内
        if (nums[0] < W) {
            dp[0][nums[0]] = true;
        }
        // 状态变化
        for (int i = 1; i < N; i++) {
            for (int w = 0; w <= W_target; w++) {
                if (w - nums[i] < 0) {
                    // ①背包容量不够了，不在背包中新增元素
                    // 这个情况背包容量 w 不变，即等于 dp[i - 1] 时的背包容量
                    // 并且此时 dp[i][w] 为真为假只取决于 dp[i - 1][w]
                    dp[i][w] = dp[i - 1][w];
                    // 如果背包容量 w 恰好等于 nums[i] 那么加上 nums[i] 后，至少有 nums[i] 这个组合的值等于 w，必为真
                } else if (w - nums[i] == 0) {
                    dp[i][w] = true;
                    continue;
                } else {
                    // ②容量够，可以塞也可以不塞东西
                    // 继续塞东西后可能就有子数组在索引 0 ~ i - 1 内的和等于 w - nums[i] 了，那再其基础上 + nums[i]，肯定有子数组的和等于 w
                    // 也有可能不塞东西就有子数组在索引 0 ~ i - 1 内的和等于 w，dp[i][w] 的真假就直接取决于此，并且两者是 “或” 的关系
                    dp[i][w] = dp[i - 1][w - nums[i]] || dp[i - 1][w];
                }
            }
        }
        // 返回 dp[N - 1][W]
        return dp[N - 1][W_target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
