//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 数学 
// 👍 130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 找 “1” 的个数和整体的 n 的关系
    public int countDigitOne(int n) {
        int high = n / 10, cur = n % 10, low = 0;
        // 标记当前是 “几位” (个位、十位还是百位。。。)
        int digit = 1;
        int res = 0;
        // 或:如果前一个条件为真，后面的条件就被短路了
        while (high != 0 || cur != 0) {
            // ①如果 cur == 0 公式为：high * digit
            if (cur == 0) {
                res += high * digit;
            }
            // 当 cur == 1 公式为：high * digit + low + 1
            else if (cur == 1) {
                res += high * digit + low + 1;
            }
            // cur == 2,3,4,...,9 公式为：(high + 1) * digit
            else {
                res += (high + 1) * digit;
            }
            // 更新
            low = cur * digit + low; // low += cur * digit
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
