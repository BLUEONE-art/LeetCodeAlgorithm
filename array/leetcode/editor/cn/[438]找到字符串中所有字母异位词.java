//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        // 将 t 字串的每个字符放入 need 和 window，初始化各个字符的次数都为 0
        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();
        for (char c : p_arr) need.put(c, need.getOrDefault(c, 0) + 1);
        // 初始化左右指针，初始位置：[left, right) = [0, 0)
        int left = 0, right = 0;
        // 用 valid 变量表示窗口中满足 need 条件的字符个数
        int valid = 0;
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
            while (right - left >= p_arr.length) {
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
