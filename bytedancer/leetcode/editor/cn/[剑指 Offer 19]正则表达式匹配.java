//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 递归 字符串 动态规划 
// 👍 265 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        HashMap<String, Boolean> memo = new HashMap<>();
        return helper(s, p, i, j, memo);
    }

    public boolean helper(String s, String p, int i, int j, HashMap<String, Boolean> memo) {
        if (memo.containsKey(i + "&" + j)) {
            return memo.get(i + "&" + j);
        }
        int sLen = s.length();
        int pLen = p.length();
        if (j == pLen) {
            return i == sLen;
        }
        boolean ans;
        boolean first = i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (pLen >= j + 2 && p.charAt(j + 1) == '*') {
            ans = helper(s, p, i, j + 2, memo) || (first && helper(s, p, i + 1, j, memo));
        } else {
            ans = first && helper(s, p, i + 1, j + 1, memo);
        }
        memo.put(i + "&" + j, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
