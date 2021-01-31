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
        // dp[i][w]：表示数组 nums[0,...i] 个元素，和为 w
        int N = nums.length;
        int W = 0;
        for (int i = 0; i < N; i++) {
            W += nums[i];
        }
        // 定义背包的容量 w
        W = W / 2;
        if (W % 2 != 0) return false;
        boolean[][] dp = new int[N + 1][W + 1];
        // base case：当背包中元素个数为 0 时，或者背包容量为 0 时，都不会有子数组满足条件的
        // 初始化 dp 数组全为 0

        // 状态变化
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w < W; w++) {
                if (w - nums[i] < 0) {
                    // ①背包容量不够了，不在背包中新增元素
                    dp[i][w] = dp[i - 1][w]; // 这个情况背包容量 w 不变
                } else if (w - nums[i] == 0) {
                    dp[i][j] = true;
                    continue;
                } else {
                    // ②容量够，可以塞也可以不塞东西
                    // 因为 i 从 1 开始，相对于 nums 就要 -1
                    dp[i][w] = dp[i - 1][w - nums[i - 1]] + nums[i] || dp[i - 1][w];
                }

            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
