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
// 👍 915 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 将 t 字串的每个字符放入 need 和 window，初始化各个字符的次数都为 0
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        for (char c : t_arr) need.put(c, need.getOrDefault(c, 0) + 1);
        // 初始化左右指针，初始位置：[left, right) = [0, 0)
        int left = 0, right = 0;
        // 用 valid 变量表示窗口中满足 need 条件的字符个数
        int valid = 0;
        // 记录覆盖最小字串的起始坐标和长度
        int start = 0, len = Integer.MAX_VALUE;
        // 循环遍历整个字符转 s
        while (right < s_arr.length) {
            // 先 left 不动，移动 right，直到找到一个可行解
            char c = s_arr[right];
            // 右移扩大窗口
            right++;
            // 更新窗口内的数据
            if (need.containsKey(c)) {
                // 如果 c 就是我们要找的字符之一，让 window 中对应的 key 的值 + 1
                // window.getOrDefault(c, 0)：如果 window 中没有 c，自动创建并设置默认值为 0
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果两个 map 中 c 对应的次数一致，即找到一个想要的字符
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 如果在扩大 right 的过程中找到了一个可行解，判断是否需要缩小 left 以获得最优解
            // 此 while 在上一个 while 中
            while (valid == need.size()) {
                // 更新最小覆盖字串
                // 初次比较肯定小于 len
                if (right - left < len) {
                    // 记录原始 left
                    start = left;
                    len = right - left;
                }
                // 逐步将窗口左边的元素移除窗口，看 valid == need.size() 还成立不？
                char d = s_arr[left];
                // 移动左边的窗口
                left++;
                // 更新窗口中的数据，如果 d 有用
                if (need.containsKey(d)) {
                    // 如果 d 在 need 和 window 中出现的次数相同，即为 1
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
