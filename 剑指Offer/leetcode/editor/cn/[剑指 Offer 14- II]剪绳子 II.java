//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
//积是18。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
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
// 
//
// 提示： 
//
// 
// 2 <= n <= 1000 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        // 根据数学推导，驻点 x = e 约等于 2.7，但是 x 要求是整数，所以取 3 是最优解，2 是次优解
        // 尽可能多分成长度为 3 的段
        // base case
        if (n <= 3) return n - 1;
        int p = 1000000007;
        // 防止结果越界，在求每一轮结果的时候都对 p 取余
        int count = 0, b = 0;
        // 结果是 long 类型，因为当 n = 78 的时候，结果就是 2147483647 快达到 21 亿了
        long res = 1;
        count = n / 3; // 取余商部分
        b = n % 3; // 取余余数部分
        // b == 1 代表余数为 1 的时候，需要单独取出一个 3 出来凑成 2*2 达到最大值效果
        for (int i = 0; i < ((b == 1) ? count - 1 : count); i++) {
            res = (res * 3) % p;
        }
        if (b == 0) return (int)(res % p);
        if (b == 1) return (int)(res * 4 % p);
        return (int)(res * 2 % p);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
