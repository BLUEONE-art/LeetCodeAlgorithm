//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 371 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num1_idx = num1.length() - 1, num2_idx = num2.length() - 1, c = 0; // c：进位
        while (num1_idx >= 0 || num2_idx >= 0) {
            int n1 = num1_idx >= 0 ? num1.charAt(num1_idx) - '0' : 0;
            int n2 = num2_idx >= 0 ? num2.charAt(num2_idx) - '0' : 0;
            int sum = n1 + n2 + c;
            c = sum / 10;
            sb.append(sum % 10);
            num1_idx--;
            num2_idx--;
        }
        // 最后还有没有进位
        if (c != 0) sb.append(c);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
