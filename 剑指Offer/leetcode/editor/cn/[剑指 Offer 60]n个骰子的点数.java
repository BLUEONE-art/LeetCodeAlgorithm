//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double[] dicesProbability(int n) {
        // base case：一个色子 1,2，3，4，5，6 几个点数的出现的概率是 1/6
        double[] dp = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};
        // 状态选择：n 个色子各个点数的概率 = n - 1 色子各个点数的概率 * 点数为 1 的概率
        // n 等于 1 的情况就是 base case，所以 n 至少从 2 开始
        for (int i = 2; i <= n; i++) {
            // 当两颗以上的色子同时掷，点数为 1 的情况就不存在了
            double[] tmp = new double[5 * i + 1];
            // 选择点数为 n - 1 的情况，dp 数组中存放了所有点数出现的概率
            for (int x = 0; x < dp.length; x++) {
                // 点数为 1 的情况就是 1/6 不必再另设数组
                for (int y = 0; y < 6; y++) {
                    tmp[x + y] += dp[x]/6;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
