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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 暴力解法 */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        // base case：当 amount 为 0 时返回 0；
        if (amount == 0) return 0;
//        if (amount == 1) return 1;
        // 求所需组合的最小值，初始化 res 为最大值
        int res = Integer.MAX_VALUE;
        // 暴力求解
        for (int coin : coins) {
            res = Math.min(res, coinChange(coins, amount - coin));
        }
        return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
