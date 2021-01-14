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
    public String longestPalindrome(String s) {

        // base case
        if (s == null || s.length() == 0) {
            return "";
        }
        // 用数组定义返回字符串的上下标索引
        int[] range = new int[2];
        // 将输入的字符串 s 进行遍历，依次查找以每个元素开始的最长子回文串
        // 回文串：中间部分元素相同，两端元素对称相等
        char[] str = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {

            // 定义函数 findLongest() 如果是偶数回文串返回 high + 1; 否则返回 high;
            // 在函数内部持续更新 range[0] 和 range[1] 的值
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1); // 左闭右开
    }

    public static int findLongest(char[] str, int low, int[] range) {

        // ①当 high < str.length - 1 时(因为如果 high == str.length，即 str 最后一个元素，不可能组成回文串)
        // 根据 low(字符串最左边元素的索引)，检查是否有中间元素相同的情况。若有，high ++;
        int high = low;
        while (high < str.length - 1 && str[low] == str[high + 1]) {
            high++;
        }

        // ②定位中间元素最后一位，下次即跳过这个索引开始查找回文串
        int ans = high;

        // ③以 low 和 high 为中心元素向两端查找，如果两端元素相同，则更新 range
        while (low > 0 && high < str.length - 1
                && str[low -1] == str[high + 1]) {
            low--;
            high++;
        }

        // ④判断 high - low ?> range[1] - range[0]
        // 是：有新的更长的回文串，更新range
        // 否：不更新
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
