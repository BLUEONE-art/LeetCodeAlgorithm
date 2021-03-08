//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。 
//
// 
//
// 注意：n 是正数且在 32 位整数范围内（n < 231）。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
// Related Topics 数学 
// 👍 145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 找出 n 所代表的数字是 几位数(个十百千) 的 第几位
    public int findNthDigit(int n) {
        long start = 1;
        long count = 9;
        int digit = 1;
        while (n > count) {
            // 更新
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        // 找到是 几位数 的 第几个 数字
        long goalNum = start + (n - 1) / digit;
        return Long.toString(goalNum).charAt((n - 1) % digit) - '0';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
