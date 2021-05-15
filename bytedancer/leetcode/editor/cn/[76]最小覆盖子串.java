//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        char[] t_char = t.toCharArray();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t_char) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        char[] s_char = s.toCharArray();
        int left = 0, right = 0, len = Integer.MAX_VALUE, valid = 0, start = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s_char.length) {
            // 放元素到need
            char c = s_char[right];
            right++;
            // 判断是否有valid
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            // 判断valid == need.size(); 收缩窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s_char[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        //① public String substring(int beginIndex)
        //这个方法截取的字符串是从索引beginIndex开始的，到整个字符串的末尾，例如：字符串String s = "abcdef";
        //调用s.substring(2)表示从字符串的索引2开始截取到整个字符串结束，截取的字符串为cdef
        //② public String substring(int beginIndex, int endIndex)
        //这个方法截取的字符串从beginIndex开始，到字符串索引的endIndex - 1结束，即截取的字符串不包括endIndex这个索引对应的字符，所以endIndex的最大值为整个字符串的长度，所以使用这个方法的时候需要特别注意容易发生字符串截取越界的问题
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
