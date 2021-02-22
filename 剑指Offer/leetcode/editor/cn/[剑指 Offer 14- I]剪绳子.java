//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 158 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        // 根据数学推导，驻点 x = e 约等于 2.7，但是 x 要求是整数，所以取 3 是最优解，2 是次优解
        // 尽可能多分成长度为 3 的段
        // base case
        if (n <= 3) return n - 1;
        int count = 0, b = 0, res = 0;
        count = n / 3;
        b = n % 3;
        if (b == 0) res = (int)Math.pow(3, count);
        if (b == 1) res = (int)Math.pow(3, count - 1) * 4;
        if (b == 2) res = (int)Math.pow(3, count) * 2;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
