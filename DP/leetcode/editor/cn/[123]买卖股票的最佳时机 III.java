//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 692 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 此时的 k 的取值最大只能为 2，直接套用框架会超时 --> 优化空间复杂度
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int n = prices.length;
        // base case：因为 k = 2，不是很大，可以列出所有的情况
        // ①dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        // ②dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][2 - 1][0] - prices[i]);
        // ③dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
        // ④dp[i][2][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1 - 1][0] - prices[i]) = Math.max(dp[i - 1][1][1], -prices[i]);
        int dp_i_2_0 = 0, dp_i_1_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE, dp_i_1_1 = Integer.MIN_VALUE;
        // 这里要遍历 i 所有的情况
        for (int i = 0; i < n; i++) {
            // 状态转移
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
            dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
        }
        return dp_i_2_0;
    }

    // 此时的 k 的取值最大只能为 2，直接套用框架会超时
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int n = prices.length;
        int dp[][][] = new int[n][max_k + 1][2];
        // 这里要遍历所有的情况，包括 k
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                // base case
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                // 状态转移
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
