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
// 👍 1036 👎 0


//leetcode submit region begin(Prohibit modification and deletion)ll
class Solution {
    /* 暴力解法 */
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }
    private int dp(int[] coins, int amount) {
        if (amount < 0) return -1;
        // base case：当 amount 为 0 时返回 0；
        if (amount == 0) return 0;
        // 求所需组合的最小值，初始化 res 为最大值
        int res = Integer.MAX_VALUE;
        // 暴力求解
        for (int coin : coins) {
            // 如果 subProblem == -1，表示无解，不用再比较最小值
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        return res;
    }

    /* 利用备忘录简化时间复杂度 */
    public int coinChange(int[] coins, int amount) {
        // 创建备忘录
        int[] memo = new int[amount + 1];
        return dp(memo, coins, amount);
    }
    /* 函数定义： 计算 amount 金额时需要的最小数量的零钱组合并将结果记录在 memo 中*/
    private int dp(int[] memo, int[] coins, int amount) {
        if (amount < 0) return -1;
        // base case：当 amount 为 0 时返回 0；
        if (amount == 0) return 0;
        // 求所需组合的最小值，初始化 res 为最大值
        int res = Integer.MAX_VALUE;
        // 如果备忘录里已经记下了 amount 的计算结果，直接返回
        if (memo[amount] != 0) return memo[amount];

        for (int coin : coins) {
            // 如果 subProblem == -1，表示无解，不用再比较最小值
            int subProblem = dp(memo, coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, 1 + subProblem);
        }
        if (res != Integer.MAX_VALUE) {
            memo[amount] = res;
        } else memo[amount] = -1;

        return memo[amount];
    }

    /* dp 数组的迭代解法 */
    public int coinChange(int[] coins, int amount) {
        // 创建 dp 数组
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(amount + 1, amount + 1));
        dp.set(0, 0);
        // 自底向上求 dp 表
        for (int i = 0; i < dp.size(); i++) {
            // 从 0 开始，向上求 dp[1]、dp[2]...
            for (int coin : coins) {
                // 如果 dp[i - coin < 0]，负数金额不存在的，直接跳过
                if (i - coin < 0) continue;
                dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - coin)));
            }
        }
        return dp.get(amount) == amount + 1 ? -1 : dp.get(amount);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
