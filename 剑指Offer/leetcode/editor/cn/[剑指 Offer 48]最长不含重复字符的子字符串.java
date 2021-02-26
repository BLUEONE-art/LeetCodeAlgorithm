//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashMap<Character, Integer> charToFreq = new HashMap<>();
        int len = 0;
        while (right < s.length()) {
            // 让 right 先走
            char cur = s.charAt(right);
            charToFreq.put(cur, charToFreq.getOrDefault(cur, 0) + 1);
            right++;
            // 判断窗口元素是否重复
            while (charToFreq.get(cur) > 1) {
                char d = s.charAt(left);
                left++;
                charToFreq.put(d, charToFreq.getOrDefault(d, 0) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
