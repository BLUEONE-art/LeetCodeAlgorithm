//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 哈希表 字符串 分治 滑动窗口 
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 记录每个字符出现频次
        int[] map = new int[26];
        for (int alphaNum = 1; alphaNum < 26; alphaNum++) {
            // 每次重新统计
            Arrays.fill(map, 0);
            int left = 0;
            int right = 0;
            // 所有字符的种类
            int total = 0;
            // 满足k个的字符种类数
            int valid = 0;
            while (right < len) {
                int cur = chars[right] - 'a';
                map[cur]++;
                if (map[cur] == 1) {
                    total++;
                }
                if (map[cur] == k) {
                    valid++;
                }
                // 当所有的种类数>当前枚举的字符种类数alphaNum，收缩窗口
                while (total > alphaNum) {
                    int leftNum = chars[left] - 'a';
                    left++;
                    map[leftNum]--;
                    if (map[leftNum] == 0) {
                        total--;
                    }
                    if (map[leftNum] == k - 1) {
                        valid--;
                    }
                }
                // 当前窗口内所有字符种类数=重复k次的元素种类数
                if (total == valid) {
                    ans = Math.max(ans, right - left + 1);
                }
                right++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
