//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路：对于 coins[] 数组，找出总共有多少个子数组的组合方式，使之子数组的和等于 amount
    // ==> 背包容量为 amount，在 coins[0,...,i] 中选择若干个硬币，使得这些硬币的和恰好等于 amount
    public int change(int amount, int[] coins) {
        // dp[i][w] 定义：在 coins[0,...,i] 中选择若干个硬币，使得这些硬币的和恰好等于 amount 的组合方式总数为 dp[i][w] 种
        // ==> 原问题转换为求解 dp[coins.length, amount]
        int N = coins.length;
        int W = amount;
        int[][] dp = new int[N + 1][W + 1]; // 背包容量可以从 0 ~ W 之间变化
        // base case：如果 amount = 0 ==> dp[i][0] = 1，都只能一个硬币都不取，总的方式数就是 1;
        // 如果一枚硬币都不取，什么金额都凑不出 ==> dp[0][w] = 0
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        // dp[0][j] 已经为 0 了
//        for (int j = 0; j <= W; j++) {
//            dp[0][j] = 0;
//        }
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 因为 i 属于 [1, N]，coins 属于 [0, N -1]，所以索引要向前移一位
                if (w - coins[i - 1] < 0) {
                    // ①背包容量不够了，装不下更多的东西了
                    dp[i][w] = dp[i - 1][w];
                } else if (w - coins[i - 1] >= 0) {
                    // ②背包还能再放下 coins[i] 这枚硬币，有两种情况：
                    // i)选择不放;
                    // ii)选择再放一个硬币，dp[i][w] = dp[i][w - coins[i - 1]]：因为使用了这枚硬币，如果从 coins[0,...i] 中有 n 种方法可以凑成 mount = w - coins[i - 1]
                    // 并且 coins[i - 1] 这枚硬币数量无限制，那么在 dp[i][w - coins[i - 1]] 基础上再 + coins[i - 1] 即可
                    // 那 dp[i][w] 就应该是这两种情况的和
                    dp[i][w] = dp[i][w - coins[i - 1]] + dp[i - 1][w];
                }
            }
        }
        return dp[N][W];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
