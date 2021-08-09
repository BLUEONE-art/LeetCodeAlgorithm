//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2286 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        // 表示s从下标i开始和p的下标j进行比较
        int i = 0;
        int j = 0;
        HashMap<String, Boolean> memo = new HashMap<>();
        return helper(s, p, i, j, memo);
    }

    public boolean helper(String s, String p, int i, int j, HashMap<String, Boolean> memo) {
        // 如果备忘录中有答案，直接返回
        if (memo.containsKey(i + "&" + j)) {
            return memo.get(i + "&" + j);
        }
        // 模式串都匹配完了，s还剩余的话，返回false，否则true
        if (j == p.length()) {
            return i == s.length();
        }
        boolean ans;
        // 处理'.'
        boolean first = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        // 假如后一位为'*'
        if (p.length() >= j + 2 && p.charAt(j + 1) == '*') {
            // 让*前面的字符出现0次(向右移动p两位) + 重复N次(向右移动s一位)
            ans = helper(s, p, i, j + 2, memo) || (first && helper(s, p, i + 1, j, memo));
        } else {
            ans = first && helper(s, p, i + 1, j + 1, memo);
        }
        memo.put(i + "&" + j, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
