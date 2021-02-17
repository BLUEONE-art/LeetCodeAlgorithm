//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 在字符串 s 中找出第一个只出现一次的字符 */
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> charToFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charToFreq.put(s.charAt(i), charToFreq.getOrDefault(s.charAt(i), 0) + 1);
        }
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (charToFreq.get(s.charAt(i)) == 1) {
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
