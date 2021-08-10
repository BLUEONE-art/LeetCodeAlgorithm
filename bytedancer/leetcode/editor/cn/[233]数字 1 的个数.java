//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        int digit = 1;
        int count = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                // 2304 --> 0010 ~ 2219
                count += high * digit;
            } else if (cur == 1) {
                // 2314 --> 0010 ~ 2314
                count += high * digit + low + 1;
            } else {
                // 2324 --> 0010 ~ 2319
                count += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
