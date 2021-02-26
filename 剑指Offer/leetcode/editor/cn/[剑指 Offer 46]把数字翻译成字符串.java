//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 186 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 0 -> a 1 -> b ... 25 -> z, 26 以后的数字不翻译
    public int translateNum(int num) {
        String str = String.valueOf(num);
        // 定义 dp[i] 表示以数字 xi 结尾的数字的翻译方式种数
        // base case：当只有一个数字或者没有数字的时候是一种方式
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            String tmp = str.substring(i - 2, i);
            // 状态转移②：10 11 12 13 ... 25 这些数字有两种翻译方法：a0||l bb||m ...
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                // 状态转移①：01 02 03 ... 09 这些数字只有一种翻译的方法：ab ac ad ... ak
                dp[i] = dp[i - 1];
            }
        }
        return dp[str.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
