//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 694 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i])
    // 考虑冷冻期一天，选择要入股时，必须间隔一天，因为刚卖完不能立即入股
    // dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 2][k - 1][0] - prices[i])
    // 此时没有买卖次数 k 的限制，所以可以忽略 k
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // base case
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        // dp[i - 2][0]，记录 dp[i - 1][0] 的前一个状态
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
