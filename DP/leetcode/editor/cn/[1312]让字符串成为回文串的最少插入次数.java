//给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。 
//
// 请你返回让 s 成为回文串的 最少操作次数 。 
//
// 「回文串」是正读和反读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "zzazz"
//输出：0
//解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
// 
//
// 示例 2： 
//
// 
//输入：s = "mbadm"
//输出：2
//解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出：5
//解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
// 
//
// 示例 4： 
//
// 
//输入：s = "g"
//输出：0
// 
//
// 示例 5： 
//
// 
//输入：s = "no"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 中所有字符都是小写字母。 
// 
// Related Topics 动态规划 
// 👍 84 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minInsertions(String s) {
        // 定义 dp[i][j] 数组：表示字符串 s[i,...,j] 能转换成回文串的最小步数
        int n = s.length();
        // base case: dp[i][i] = 0，即当 i == j 时本身就是回文串，所以最小步数为 0
        int[][] dp = new int[n][n];
        // 遍历 + 状态选择 (可以斜着遍历 或 先从下到上 -> 从左到右)
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 如果 dp[i + 1][j - 1] 结果已知，推出 dp[i][j] 只要开开头和结尾的字符是否相等
                if (s.charAt(i) == s.charAt(j)) {
                    // 相等
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    // 不相等
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    // 从下到上 -> 从左到右 遍历
    public int minInsertions(String s) {
        // 定义 dp[i][j] 数组：表示字符串 s[i,...,j] 能转换成回文串的最小步数
        int n = s.length();
        // base case: dp[i][i] = 0，即当 i == j 时本身就是回文串，所以最小步数为 0
        int[][] dp = new int[n][n];
        // 遍历 + 状态选择 (可以斜着遍历 或 先从下到上 -> 从左到右)
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 如果 dp[i + 1][j - 1] 结果已知，推出 dp[i][j] 只要开开头和结尾的字符是否相等
                if (s.charAt(i) == s.charAt(j)) {
                    // 相等
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    // 不相等
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
