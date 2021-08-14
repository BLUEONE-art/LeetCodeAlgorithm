// 给定一个字符串，找出至多包含k个不同字符的最长字串T
// 输入 s = "eceba", k = 2
// 输出 3，T = "ece"，所以长度为3

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len == 0 || k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char c = s.charAt(right);
            map.put(c, right);
            right++;
            while (map.size() > k) {
                // 说明此时有k+1个不同元素
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            max = Math.max(max, right - left);
        }
    }
}