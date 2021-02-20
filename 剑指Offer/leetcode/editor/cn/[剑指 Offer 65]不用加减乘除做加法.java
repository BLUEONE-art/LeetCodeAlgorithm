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
// 👍 119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        // 计算机中不管正数和负数都是以 “补码” 的形式存储的
        // 补码 = 数的反码 + 1
        // 反码 = 二进制数除了最高符号位，其余位全部取反
        // 好处：符号位与数值域统一处理
        // 加减法可以统一处理(CPU 只能处理加法)
        // 无需额外的硬件电路
        // 定义 c 为 a，b 按位加法的进位
        while (b != 0) {
            // 求进位 c：按位加法中进位相当于两个元素进行 “&” 操作后 左移(<<) 一位
            int c = (a & b) << 1;
            // 正常没有进位的情况下，按位加法相当于 异或(^) 操作
            a ^= b; // a = a^b
            // 再把进位 c 赋给 b，与 a 按位相加
            b = c;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
