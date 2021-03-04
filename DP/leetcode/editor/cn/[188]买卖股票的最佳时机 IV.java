//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 453 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 此时的 k 的取值最大只能为任意大
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 大体上跟 k = 2 没什么区别，但是从股票买入到卖出至少需要两天的时间，所以如果 k > n/2，这个约束实际上就和 k 可以取无穷大一样，失去了约束意义
        if (k > n / 2) {
            return maxProfit(prices);
        }
        int dp[][][] = new int[n][k + 1][2];
        // 这里要遍历所有的情况，包括 k
        for (int i = 0; i < n; i++) {
            for (int k1 = k; k1 >= 1; k1--) {
                // base case
                if (i - 1 == -1) {
                    dp[i][k1][0] = 0;
                    dp[i][k1][1] = -prices[i];
                    continue;
                }
                // 状态转移
                dp[i][k1][0] = Math.max(dp[i - 1][k1][0], dp[i - 1][k1][1] + prices[i]);
                dp[i][k1][1] = Math.max(dp[i - 1][k1][1], dp[i - 1][k1 - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    // 动态规划简化版
    public int maxProfit(int[] prices) {
        // 初始化第一天不持股的情况，利润为 0
        int dp_i_0 = 0;
        // 初始化第一天就持股的情况，利润为负值
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 根据状态方程优化空间复杂度
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
