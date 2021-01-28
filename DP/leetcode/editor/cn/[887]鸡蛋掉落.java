//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划 
// 👍 557 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 动态规划：根据鸡蛋个数和楼层数求最坏情况下最少需要扔几次鸡蛋能确定楼层 F，F 从 0 开始计数 */
    public int superEggDrop(int K, int N) {
        // 暴力解法
        // base case1：当鸡蛋 K == 1 了，最坏情况下要扔 N(楼层数) 才能确定 F
        // base case2：当楼层数 F == 0，不需要扔即可确定 F == 0
        if (K == 1) return N;
        if (N == 0) return 0;

        // 定义结果 res
        int res = Integer.MAX_VALUE;

        // 原问题：拿着 K 个鸡蛋从 F 层高的楼扔
        // 子问题：min{ max(
        // ①当鸡蛋在第 i 层碎了，鸡蛋个数减一，第 i 层以上的楼层不用再试了：dp(K - 1, 1 ~ i - 1)
        // ②当鸡蛋仔第 i 层没碎，鸡蛋个数不变，第 i 层以下的楼层不用再试了：dp(K, i + 1 ~ N)
        // ) } + 1
        // 最后 + 1 表示在第 i 层做的一次尝试，要加上
        for (int i = 1; i <= N; i++) {
            // 递归分解子问题求解
            int subProblem = Math.max(superEggDrop(K - 1, i - 1), superEggDrop(K, N - i)) + 1;
            res = Math.min(res, subProblem);
        }
        return res;
    }

    /* 动态规划：根据鸡蛋个数和楼层数求最坏情况下最少需要扔几次鸡蛋能确定楼层 F，F 从 0 开始计数 */
    public int superEggDrop(int K, int N) {
        // 增加备忘录解法
        HashMap<String, Integer> memo = new HashMap<>();
        return dp(memo, K, N);
    }
    private int dp(HashMap<String, Integer> memo, int K, int N) {
        // base case1：当鸡蛋 K == 1 了，最坏情况下要扔 N(楼层数) 才能确定 F
        // base case2：当楼层数 F == 0，不需要扔即可确定 F == 0
        if (K == 1) return N;
        if (N == 0) return 0;

        // 如果备忘录里有结果，直接返回
        if (memo.containsKey(K + "&" + N)) return memo.get(K + "&" + N);

        // 定义结果 res
        int res = Integer.MAX_VALUE;

        // 原问题：拿着 K 个鸡蛋从 F 层高的楼扔
        // 子问题：min{ max(
        // ①当鸡蛋在第 i 层碎了，鸡蛋个数减一，第 i 层以上的楼层不用再试了：dp(K - 1, 1 ~ i - 1)
        // ②当鸡蛋仔第 i 层没碎，鸡蛋个数不变，第 i 层以下的楼层不用再试了：dp(K, i + 1 ~ N)
        // ) } + 1
        // 最后 + 1 表示在第 i 层做的一次尝试，要加上
        for (int i = 1; i <= N; i++) {
            // 递归分解子问题求解
            int subProblem = Math.max(dp(memo, K - 1, i - 1), dp(memo, K, N - i)) + 1;
            res = Math.min(res, subProblem);
        }
        // 备忘录增加结果
        memo.put(K + "&" + N, res);
        return res;
    }

    /* 动态规划：根据鸡蛋个数和楼层数求最坏情况下最少需要扔几次鸡蛋能确定楼层 F，F 从 0 开始计数 */
    public int superEggDrop(int K, int N) {
        // 原始思维
        int[][] dp = new int[K + 1][N + 1]; // 因为楼层从 0 ~ N
        for (int j = 0; j < dp[1].length; j++) {
            dp[1][j] = j;
        }
        // base case:
        // dp[0][..] = 0
        // dp[1][..] = N
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int res = Integer.MAX_VALUE;
        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                // 状态转移方程
                dp[k][n] = Math.max(dp[k][N - n], dp[k - 1][n - 1]) + 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (min > dp[i][j]) {
                    min = dp[i][j];
                }
            }
        }
        return min;
    }

    /* 动态规划：根据鸡蛋个数和楼层数求最坏情况下最少需要扔几次鸡蛋能确定楼层 F，F 从 0 开始计数 */
    public int superEggDrop(int K, int N) {
        // 思维改变 + 二维数组
        int[][] dp = new int[K + 1][N + 1]; // 因为楼层从 0 ~ N
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int m = 0;
        // 换思路：dp[K][m] = N
        while (dp[K][m] < N) { // 结束条件：当 m = N 时
            m++;
            for (int k = 1; k <= K; k++) {
                // 状态转移方程
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        // while 循环也可以写成：
//        for (int m = i; dp[K][m] < N; m++) {
//            for (int k = 1; k <= K; k++) {
//                // 状态转移方程
//                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
//            }
//        }
        return m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
