//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1369 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 找到字符串 s1 和 s2 的最短编辑距离(长度) */
    public int minDistance(String word1, String word2) {
        /* 递归 */
        return dp(word1.length() - 1, word2.length() - 1, word1, word2);
    }
    /* 递归函数：返回 s1[0..index1] 和 s2[0..index2] 的最小编辑距离*/
    private int dp(int index1, int index2, String word1, String word2) {
        // base case：如果两个字符串遍历索引 i，j 有一个先遍历完了，直接返回另一个字符串剩下的长度
        if (index1 == -1) return index2 + 1;
        if (index2 == -1) return index1 + 1;
        // 分情况进行递归
        // 如果在两个字符串中两个索引对应的字符相等，那我直接跳过这个字符，判断下一个字符
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp(index1 - 1, index2 - 1, word1, word2);
        } else {
            // s1[index1]！=s2[index2] 插入、删除、替换操作最后得到的编辑距离最小，就选谁
            return Math.min(Math.min(dp(index1, index2 - 1, word1, word2) + 1, dp(index1 - 1, index2, word1, word2) + 1), dp(index1 - 1, index2 - 1, word1, word2) + 1);
        }
    }

    /* 找到字符串 s1 和 s2 的最短编辑距离(长度) */
    public int minDistance(String word1, String word2) {
        /* 递归 + 备忘录 */
        HashMap<String, Integer> memo = new HashMap<>();
        return dp(memo, word1.length() - 1, word2.length() - 1, word1, word2);
    }
    /* 递归函数：返回 s1[0..index1] 和 s2[0..index2] 的最小编辑距离*/
    private int dp(HashMap<String, Integer> memo, int index1, int index2, String word1, String word2) {
        // base case：如果两个字符串遍历索引 i，j 有一个先遍历完了，直接返回另一个字符串剩下的长度
        if (index1 == -1) return index2 + 1;
        if (index2 == -1) return index1 + 1;

        // 如果备忘录里有
        if (memo.containsKey(index1 + "&" + index2)) return memo.get(index1 + "&" + index2);

        // 分情况进行递归
        // 如果在两个字符串中两个索引对应的字符相等，那我直接跳过这个字符，判断下一个字符
        if (word1.charAt(index1) == word2.charAt(index2)) {
            memo.put(index1 + "&" + index2, dp(memo, index1 - 1, index2 - 1, word1, word2));
        } else {
            // s1[index1]！=s2[index2] 插入、删除、替换操作最后得到的编辑距离最小，就选谁
            memo.put(index1 + "&" + index2, Math.min(Math.min(dp(memo, index1, index2 - 1, word1, word2) + 1, dp(memo, index1 - 1, index2, word1, word2) + 1), dp(memo,index1 - 1, index2 - 1, word1, word2) + 1));
        }
        return memo.get(index1 + "&" + index2);
    }

    /* 找到字符串 s1 和 s2 的最短编辑距离(长度) */
    public int minDistance(String word1, String word2) {
        /* 动态规划 */
        // 创建 dp 表并初始化：当两个字符串 s1 为空时(i = 0)，想要变成 s2，都需要 s2.length 步。比如 0 --> ab 需要两步
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // s1 为 0 时的 base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // s2 为 0 时的 base case
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        // 核心状态转移：由已知状态推出未知状态的过程
        // 由 dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j] 推出 dp[i][j]，由左向右由上到下遍历即可
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果两个字符 word[i] = word[j]，直接跳过比较下一个
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // word[i] != word[j]，分别用插入、删除、替换来试一次，哪个得到的结果小取哪个
                    // ①插入：s2 取出字符 s2[j] 插入 s1 索引 i 之和，则 s2[j] 与 s1 新插入的字符 s1[i + 1] 匹配了，j - 1 继续向前判断
                    // ②删除：s1 删除字符 s1[i]，则向前取 s1[i - 1] 继续与 s2[j] 比较
                    // ③替换：s2 取出字符 s2[j] 替换 s1[i]，则双方都 - 1，继续比较 s1[i - 1] 和 s2[j - 1]
                    dp[i][j] = min(
                            dp[i][j - 1] + 1, // 别忘了 +1(本身的这次操作)
                            dp[i - 1][j] + 1, // 别忘了 +1(本身的这次操作)
                            dp[i - 1][j - 1] + 1 // 别忘了 +1(本身的这次操作)
                    );
                }
            }
        }
        return dp[m][n];
    }
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
