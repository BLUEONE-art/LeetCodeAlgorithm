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
// 👍 3645 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int strLen = s.length();
        if (s == null || strLen == 0) return "";
        int left = 0, right = 0, maxStart = 0, maxLen = 0, len = 1;
        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            // 左扩散
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            // 右
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            // 两边
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                len += 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1; // 更新
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
