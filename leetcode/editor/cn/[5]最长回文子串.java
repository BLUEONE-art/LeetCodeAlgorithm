//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3086 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    @Test
    public String longestPalindrome(String s) {
        int l = 0;
        int r = 0;
        int size = s.length();
        if (size % 2 == 0) {
            l = (size / 2) - 1;
            r = (size / 2) + 1;
        }
        return longestPalindrome(s, l, r);
    }

    private String longestPalindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s[l] == s[r]) {
            // 向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r - l - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
