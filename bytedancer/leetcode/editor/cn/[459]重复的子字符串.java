//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 字符串匹配 
// 👍 515 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(s == null || len < 1) {
            return false;
        }
        int dum = len;
        String str  = s;
        while(dum > 1){
            str = str.charAt(len - 1) + str.substring(0, len - 1);
            if(str.equals(s)) {
                return true;
            }
            dum--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
