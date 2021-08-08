//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 
// 👍 202 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            // 进位
            int c = (a & b) << 1;
            // 没进位加法相当于异或
            a ^= b;
            // 进位付给b，总会轮到进位c=(a & b) << 1为0的情况，这时可以跳出循环
            b = c;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
