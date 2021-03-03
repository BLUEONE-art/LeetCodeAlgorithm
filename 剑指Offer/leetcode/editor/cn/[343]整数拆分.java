//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 453 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        // base case：必须要拆分，n > 1
        if (n <= 3) return n - 1;
        // 大于 3 的话，必须分成尽可能多的长度为 3 的小段
        int count = n / 3;
        int sub = n % 3;
        if (sub == 2) return (int)Math.pow(3, count) * 2;
        // 此时要分一个 3 和 1 组成 2 * 2
        if (sub == 1) return (int)Math.pow(3, count - 1) * 4;
        return (int)Math.pow(3, count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
