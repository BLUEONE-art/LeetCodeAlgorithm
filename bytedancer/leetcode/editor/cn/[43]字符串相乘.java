//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int num1_i = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int num2_j = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + num1_i * num2_j);
                res[i + j + 1] = sum % 10;
                // 重点
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && i == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
