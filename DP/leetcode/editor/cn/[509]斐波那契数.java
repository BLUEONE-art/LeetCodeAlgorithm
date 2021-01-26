//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 数组 
// 👍 232 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    /* 递归求解，时间复杂度 O(2^n) */
//    public int fib(int n) {
//        // base case
//        if (n == 1 || n == 2) return 1;
//
//        return fib(n - 1) + fib(n - 2);
//    }

//    /* 构建备忘录进行计算，O(N) */
//    public int fib(int n) {
//        if (n < 1) return 0;
//        // 创建一个数组(备忘录)记录每个节点的计算结果，防止冗余计算
//        ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(n + 1, 0));
//        // 初始化 memo 全设置为 0
//        return helper(memo, n);
//    }
//
//    private int helper(ArrayList<Integer> memo, int n) {
//        // base case
//        if (n == 1 || n == 2) return 1;
//        // 如果已经计算过 n 节点的值，直接调用 memo[n]
//        if (memo.get(n) != 0) return memo.get(n);
//        // 不断计算 memo[n] 的值
//        memo.set(n, helper(memo, n -1) + helper(memo, n - 2));
//        return memo.get(n);
//    }

//    /* 根据 DP 表和状态方程解决 */
//    public int fib(int n) {
//        if (n < 1) return 0;
//        if (n == 1 || n == 2) return 1;
//        // 以数组形式创建 DP 表
//        ArrayList<Integer> DP = new ArrayList<>(Collections.nCopies(n + 1, 0));
//        // base case
//        DP.set(1, 1); DP.set(2, 1);
//        for (int i = 3; i <= n; i++) {
//            DP.set(i, DP.get(i - 1) + DP.get(i - 2));
//        }
//        return DP.get(n);
//    }

    /* 根据状态方程解决 --> 优化：只需要每次维护 DP[n - 1] 和 DP[n - 2] 即可 O(1)*/
    public int fib(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        // base case
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            // 更新 prev(DP[n - 1]) 和 curr(DP[n - 2])
            prev = curr; // 新的 prev 是以前的 curr
            curr = sum; // 新的 curr 就是以前的 sum
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
