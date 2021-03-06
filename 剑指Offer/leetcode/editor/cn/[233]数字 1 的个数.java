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
// Related Topics 数学 
// 👍 200 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 规律1：当余数 cur 为 0 时，“1” 出现的个数 = 当前的进制位 digit * 除去余数的高位 high
    // 规律2：当余数 cur 为 1 时，“1” 出现的个数 = 当前的进制位 digit * 除去余数的高位 high + 除去高位和进制位的低位 low + 1
    // 规律3：当余数 cur 为 2~9 时，“1” 出现的个数 = 当前的进制位 digit * (除去余数的高位 high + 1)
    public int countDigitOne(int n) {
        int high = n / 10, digit = 1, low = 0, cur = n % 10, res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            }
            else if (cur == 1) {
                res += high * digit + low + 1;
            }
            else {
                res += (high + 1) * digit;
            }
            // 更新
            low = cur * digit + low;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
