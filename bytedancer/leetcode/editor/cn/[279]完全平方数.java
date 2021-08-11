//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 1036 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 从[1~sqrt(n)]数组中找到最小的组合数组成n
    public int numSquares(int n) {
        // dp[i]：数组中组成i的最少的组合数的组合
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 完背+不管顺序 ==> arr正序 + tar正序
        for (int num = 1; num <= Math.sqrt(n); num++) {
            for (int i = 0; i <= n; i++) {
                int bagElement = num * num;
                if (i - bagElement >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - bagElement] + 1);
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
