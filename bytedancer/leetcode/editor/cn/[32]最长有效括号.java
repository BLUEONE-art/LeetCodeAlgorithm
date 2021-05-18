//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len]; // 只有右括号')'对应的dp[i]是有可能不为0的
        int max = 0;
        // dp[0] = 0; // 只有一个括号，有效长度为0
        for (int i = 1; i < len; i++) { // i对应的字符为'('时，不论前面是什么括号，都凑不成有效括号
            if (s.charAt(i) == ')') { // 所以只考虑i对应的符号为')'的情况
                if (s.charAt(i - 1) == '(') { // 刚好凑成一对
                    if (i < 2) { // 如果len=2，只有'()'的情况
                        dp[i] = 2;
                    }
                    else { // len>2
                        dp[i] = dp[i - 2] + 2; // 有效值+2
                    }
                }
                else { // 假如是'))'的情况
                    if (dp[i - 1] > 0) { // 上一个存在有效括号
                        int i_left = i - dp[i - 1] - 1; // s.charAt(i) = ')'，找到其对应的左括号的位置
                        if (i_left >= 0 && s.charAt(i_left) == '(') { // 存在且为'('
                            dp[i] = dp[i - 1] + 2;
                            if (i_left - 1 > 0) { // 如果
                                dp[i] += dp[i_left - 1];
                            }
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
