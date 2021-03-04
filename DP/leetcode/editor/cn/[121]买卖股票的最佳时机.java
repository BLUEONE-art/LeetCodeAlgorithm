//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1470 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 面试还是用这个
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            lowestPrice = Math.min(lowestPrice, price);
            profit = Math.max(profit, price - lowestPrice);
        }
        return profit;
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

    // 统一：动态规划解法
    // 大的前提：只能买卖一次，即 k == 1
    // 状态转移方程：
    // ①：dp[i][k][0]：第 i 天我没有持股，并且我只能买卖 k 次
    // ②：dp[i][k][1]：第 i 天我持股了，我能买卖 k 次
    public int maxProfit(int[] prices) {
        // 状态 [0] 表示卖出，[1] 表示持有
        // dp[i][0]：表示第 i 天，手上没有持有股票 ---> 若 i == n - 1：就是最后一天我把股票卖完了，也就是最后获得的利润
        // dp[i][1]：表示第 i 天，手上还持有股票
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // base case
            if (i - 1 == -1) {
                // 第一天没有持股，哪来的利润？
                dp[i][0] = 0;
                // 第一天就持股了，我的利润就是 -prices[i]
                dp[i][1] = -prices[i];
                continue;
            }
            // 根据选择更新状态，此时由于 k 只能等于 1
            // [0]：①可能前一天就没有持有股票 || ②前一天持有股票 ---> 选择：卖或者不卖，规定买入会消耗一次买卖机会(k - 1)，卖出不消耗
            // dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            // dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]) = Math.max(dp[i - 1][1][1], 0 - prices[i]);
            // --->因为此时 k = 1 不会对状态有影响，可以忽略
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
