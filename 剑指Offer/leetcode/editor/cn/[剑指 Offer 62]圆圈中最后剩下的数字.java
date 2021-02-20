//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// 👍 295 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // i = 1 开始递推
    // 递推公式：f(i) = (f(i - 1) + m) % i
    public int lastRemaining(int n, int m) {
        // 相当于 dp[0] == 0，后面要求 dp[1]，dp[2]，dp[3]，dp[4]
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    public int lastRemaining(int n, int m) {
        // 迭代，动态规划
        int[] dp = new int[n];
        if (n == 1) dp[0] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i - 1] = (dp[i - 2] + m) % i;
        }
        return dp[n - 1];
    }

    // 递归公式：f(n) = (f(n - 1) + m) % n
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining(n - 1, m) + m) % n;
    }

    // 没有分支，其实没有降低时间复杂度
    public int lastRemaining(int n, int m) {
        // 备忘录
        ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(n + 1, -1));
        return dp(memo, n, m);
    }
    private int dp(ArrayList<Integer> memo, int n, int m) {
        // base case
        if (n == 1) return 0;
        // 如果备忘录中有，直接返回
        if (memo.get(n) >= 0) return memo.get(n);
        // 若没有，再计算
        memo.set(n, (dp(memo, n - 1, m) + m) % n);
        return memo.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
