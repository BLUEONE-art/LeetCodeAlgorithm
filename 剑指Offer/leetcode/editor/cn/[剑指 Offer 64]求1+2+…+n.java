//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 273 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
        // n == 1 的情况下是 base case，"与" 运算前半部分如果为 false，则后边部分不会被执行。
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
