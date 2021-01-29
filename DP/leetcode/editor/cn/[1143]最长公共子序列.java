//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 351 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 找到字符串 s1 和 s2 的最长公共子序列长度 */
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] 含义(下标从 1 开始)：表示 s1[1,...i] 与 s2[1,...j] 的最长公共子序列长度
        // 初始化考虑 base case：当 i = j = 0 时，字符串长度都为 0，则最长公共子序列必为 0
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1]; // 空出一行一列留给 base case
        // 先初始化为 0
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (m + 1); j++) {
                dp[i][j] = 0;
            }
        }
        // 核心：状态转移，dp[i][j] 由 dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j] 共同推导，选择正常遍历即可
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (m + 1); j++) {
                // 遍历的时候如果找到一个 s1、s2 公共的字符，即 s1[i] == s2[j]
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 直接将子问题长度 +1 即可
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果没找到，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，在 dp[i - 1][j - 1]，dp[i][j - 1] 和 dp[i - 1][j] 找到更大的即可
                    // 但实际上 dp[i - 1][j - 1] 是三者中最小的，没有比较的必要
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
