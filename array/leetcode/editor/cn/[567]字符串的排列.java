//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 223 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 找出 s2 中是否存在一个字串，包含 s1 中所有字符而不包括其他字符 */
    // 滑动窗口无敌哥，字串问题别得瑟
    // 左右指针滑窗口，齐头并进分前后
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // String to char[]
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        // 将所要找的元素和其出现的次数放入 need 中
        for (char c : s1_arr) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // 记录 window 中元素的个数
        int valid = 0;
        // 滑动 right
        while (right < s2_arr.length) {
            // c 是滑动的元素
            char c = s2_arr[right];
            right ++;
            // 更新 window 中的数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果 need 和 window 中 c 对应的 val 相同，说明完成了一个字符
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            // 再往右滑的过程中，如果找到一个可行解，判断要不要收缩
            // 只要大于等于字串的长度就应该移动，保证字串的长度就是窗口的长度
            while (right - left >= s1_arr.length) {
                if (valid == need.size()) {
                    return true;
                }
                // d 是 left 向右滑动要去掉的元素
                char d = s2_arr[left];
                left++;
                // 更新 window 中的数据
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
