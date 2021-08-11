//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1270 👎 0

// 递归
//     public int coinChange(int[] coins, int amount) {
//        if (amount < 0) return -1;
//        if (amount == 0) return 0;
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int subProblem = coinChange(coins, amount - coin);
//            if (subProblem == -1) continue;
//            res = Math.min(res, 1 + subProblem);
//        }
//        return res;
//    }

// 递归+备忘录
//     int[] memo;
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1]; // 存放 0 ~ amount 的最小硬币数
//        return dp(coins, amount);
//    }
//    public int dp(int[] coins, int amount) {
//        if (amount < 0) return -1;
//        if (amount == 0) return 0;
//        int res = Integer.MAX_VALUE;
//
//        if (memo[amount] != 0) return memo[amount]; // 取
//
//        for (int coin : coins) {
//            int subProblem = dp(coins, amount - coin);
//            if (subProblem == -1) continue;
//            res = Math.min(res, 1 + subProblem);
//        }
//
//        if (res != Integer.MAX_VALUE) {
//            memo[amount] = res;
//        } else {
//            memo[amount] = -1;
//        }
//
//        return memo[amount];
//    }

// 动态规划
//     public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1]; // 0 ~ amount 的最小硬币数
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = amount + 1;
//        }
//        dp[0] = 0;
//        for (int i = 0; i < dp.length; i++) {
//            for (int coin : coins) {
//                if (i - coin < 0) { // 金额 - coin
//                    continue;
//                }
//                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//            }
//        }
//        return dp[amount] == amount + 1 ? -1 : dp[amount];
//    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 不考虑顺序完背：arr顺 + tar顺
    public int coinChange(int[] coins, int amount) {
        // 和为i的硬币组合种数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
