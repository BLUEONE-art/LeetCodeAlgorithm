//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 字符串 
// 👍 66 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 核心思路：双指针从字符串尾部开始遍历
    public String reverseWords(String s) {
        // 去除字符串 s 前后多余的空格
        s = s.trim();
        // 两个指针指向字符串末尾
        int right = s.length() - 1, left = right;
        StringBuilder res = new StringBuilder();
        while (left >= 0) {
            // 让 left 指针向字符串头部运动，直到遇到空格
            while (left >= 0 && s.charAt(left) != ' ') left--;
            // substring()：返回一个 [beginIndex, endIndex) 的字符串
            res.append(s.substring(left + 1, right + 1) + " ");
            // 让 left 指针向字符串头部运动，直到遇到字母
            while (left >= 0 && s.charAt(left) == ' ') left--;
            // 更新 right 找下一个单词
            right = left;
        }
        // 去除新的字符串末尾的空格
        return res.toString().trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
