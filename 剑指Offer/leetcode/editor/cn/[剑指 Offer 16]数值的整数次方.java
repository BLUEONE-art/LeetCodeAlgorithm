//实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数
//问题。 
//
// 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 118 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 快速幂(二分查找)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        // 因为 n 可能会超过 int 的最大范围
        long b = n;
        double res = 1.0;
        // 如果是负数幂，转换
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        // 求幂 --> 转换成按位操作
        while (b > 0) {
            // 只要二进制位数上有 1
            if ((b & 1) == 1) res = res * x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

//    // 暴力解法
//    public double myPow(double x, int n) {
//        double res = 1.000000;
//        if (n == 0) return 1.000000;
//        for (int i = 0; i < Math.abs(n); i++) {
//            res = res * x;
//        }
//        if (n < 0) {
//            return (1 / res);
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
