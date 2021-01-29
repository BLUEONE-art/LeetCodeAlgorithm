//给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。 
//
// 
//
// 示例 1: 
//输入: 
//
// "bbbab"
// 
//
// 输出: 
//
// 4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// "cbbd"
// 
//
// 输出: 
//
// 2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 只包含小写英文字母 
// 
// Related Topics 动态规划 
// 👍 373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 找到字符串最长回文子序列 */
    public int longestPalindromeSubseq(String s) {
        // dp[i][j] 定义：在子串 s[i,...,j] 中最长回文子序列的长度为 dp[i][j]
        // base case：如果只有一个字符串，则 dp[i][j] = 1 (i = j = 1)
        // 如果索引 i < j，明显字符串都为空，何况子序列
        // 初始化 dp 数组，全设置为 0
        int n = s.length();
        int[][] dp = new int[n][n];
//        Arrays.fill(dp, 0); 二维数组不适用
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        // 对角线上 i = j 时，均为 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 核心：状态转移，根据数学归纳法，只要考虑怎么由子问题 dp[i + 1][j - 1](i + 1 ~ j - 1 长度的字符串中的最长子序列) 得到 dp[i][j]
        // 为了状态最后正确转移到 dp[i][j]，选择倒着遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // ①当 s 中字符 s[i] = s[j] 时，如果知道子问题的最长回文子序列长度，直接 +2 即可
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // ②s[i] != s[j]，只能比较 s[i] 和 s[j] 分别加入子问题 dp[i + 1][j - 1] 中哪个组成的回文子序列更长了
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        // 最后遍历完结果放在 i = 0，j = n - 1 的位置
        return dp[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
