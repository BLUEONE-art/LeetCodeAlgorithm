//数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，
//等等。 
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 
// 👍 86 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        // 输入的是 0 1 2 3 4 5 6 7 8 9 | 10 11 12 ... 99 | 100 101 102 ... 混在一起的字符序列
        // 初始化确定是一个 几位数(个位数、十位数。。。)
        int digit = 1;
        // 这个 几位数 的初始值是什么
        long start = 1;
        // 这个 几位数 有多少个
        long count = 9;
        // 将第 n 位数转换成求 确定是几位数 的 第几位
        while (n > count) {
            // 更新
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        // 更新的 digit 数值就表示是几位数，转换成求这个 digit 位数的 第几位 --> 公式：goal = (n - 1) % digit
        long goalNum = start + (n - 1) / digit;
        // 实际上是目标位数的 ASCII 码和 '0' 的 ASCII 码相减
        return Long.toString(goalNum).charAt((n - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
