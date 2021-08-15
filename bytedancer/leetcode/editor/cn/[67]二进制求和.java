//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 654 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int c = 0;
        while (aIdx >= 0 || bIdx >= 0) {
            int n1 = aIdx >= 0 ? a.charAt(aIdx) - '0' : 0;
            int n2 = bIdx >= 0 ? b.charAt(bIdx) - '0' : 0;
            int sum = n1 + n2 + c;
            sb.append(sum % 2);
            c = sum / 2;
            aIdx--;
            bIdx--;
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
