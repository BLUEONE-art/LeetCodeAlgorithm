//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 
// 👍 335 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static String reorganizeString(String s) {
        // 找出出现次数最多的字母
        char[] chars = s.toCharArray();
        int len = s.length();
        int[] charsCount = new int[26];
        for (int i = 0; i < len; i++) {
            charsCount[chars[i] - 'a']++;
        }
        int max = 0;
        int maxNumCharIdx = 0;
        int threshold = (len + 1) >> 1;
        for (int i = 0; i < charsCount.length; i++) {
            if (charsCount[i] > max) {
                max = charsCount[i];
                maxNumCharIdx = i;
                if (max > threshold) {
                    return "";
                }
            }
        }
        // 构造结果
        char[] res = new char[len];
        int index = 0;
        for (int i = 0; i < max; i++) {
            res[index] = (char) (maxNumCharIdx + 'a');
            index += 2;
            charsCount[maxNumCharIdx]--;
        }
        // 再补充奇数位置的字母
        for (int i = 0; i < charsCount.length; i++) {
            while (charsCount[i] > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                charsCount[i]--;
            }
        }
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
