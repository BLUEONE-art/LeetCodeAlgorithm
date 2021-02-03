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
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1832 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
    public boolean isMatch(String s, String p) {
        // 创建备忘录
        HashMap<String, Boolean> memo = new HashMap<>();
        int i = 0, j = 0;
        return dp(memo, s, p, i, j);
    }
    // dp 递归函数定义：返回两个字符串分别从索引 i 和索引 j 比较的结果(true or false)
    private boolean dp(HashMap<String, Boolean> memo, String s, String p, int i, int j) {
        // 如果子问题答案备忘录里有，直接取出
        if (memo.containsKey(i + "&" + j)) return memo.get(i + "&" + j);
        boolean ans;
        // base case 1：因为用 i 和 j 记录子问题中比较到了哪个字符串
        // 所以当 j 已经比较到了 p 的末尾，如果 i 没到末尾，说明不一样长，返回 false
        if (j == p.length()) return i == s.length();
        // 判断第一个字符是否匹配 + 检测 '.' 符号
        boolean first = (i < s.length() && (p.charAt(j) == s.charAt(i)
                || p.charAt(j) == '.'));
        // 检测 '*'：因为 '*' 可以让字母出现 0 次和 N 次
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') { // 递归的时候我们只考虑当下的字母，其他的给递归
            // ①假设 '*' 表示重复 0 次前面的字母，让 s 和跳过 '*' 字符的 p 比较，此时也会重新比较 first
            ans = dp(memo, s, p, i, j + 2) ||
                    // ②如果只考虑当下索引 i = 1 时，'*' 表示重复 1 次前面的字母，通过移动 s 来模拟 '*' 已经重复了前面的字母一次
                    (first && dp(memo, s, p, i + 1, j));
        } else {
            // 如果 '.' 和 '*' 都检测了，剩下就直接正常比较即可
            ans = first && dp(memo, s, p, i + 1, j + 1);
        }
        memo.put(i + "&" + j, ans);
        return ans;
    }

//    // 暴力递归
//    public boolean isMatch(String s, String p) {
//        // base case 1：如果有一个字符串为空，另一个不为空则 false
//        if (p.isEmpty()) return s.isEmpty();
//        // 判断第一个字符是否匹配 + 检测 '.' 符号
//        boolean first = (!p.isEmpty() && (p.charAt(0) == s.charAt(0)
//                || p.charAt(0) == '.'));
//        // 检测 '*'：因为 '*' 可以让字母出现 0 次和 N 次
//        if (p.length() >= 2 && p.charAt(1) == '*') { // 递归的时候我们只考虑当下的字母，其他的给递归
//            // ①假设 '*' 表示只重复 0 次前面的字母，让 s 和跳过 '*' 字符的 p 比较，此时也会重新比较 first
//            return isMatch(s, p.substring(2)) ||
//                    // ②如果只考虑当下索引 i = 1 时，'*' 只表示重复 1 次前面的字母
//                    (first && isMatch(s.substring(1), p));
//        } else {
//            // 如果 '.' 和 '*' 都检测了，剩下就直接正常比较即可
//            return first && isMatch(s.substring(1), p.substring(1));
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
