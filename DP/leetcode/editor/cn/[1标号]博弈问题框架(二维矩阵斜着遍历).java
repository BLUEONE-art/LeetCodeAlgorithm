// 假设两个人都足够聪明，最后谁会获胜」这一类问题该如何用动态规划算法解决。
// 我们「石头游戏」改的更具有一般性：
//
//你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
//
//石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。比如有三堆石头 piles = [1,100,3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。
//
//假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。

class Solution {
    // 相当于 C++ 中 Pair 容器类
    class Pair {
        int fir, sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
    public int stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j].fir：其含义是面对 piles 数组中的 [i ... j] 位作先手选择时所能得到的得分，同理dp[i][j].sec
        Pair[][] dp = new Pair[n][n];
        // base case：当只有一堆石头时，先手的人就直接拿走了，后手的人得分就为 0，但是对应数组中是斜着的(对角线)
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // 状态选择(斜着遍历)
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n; i++) {
                int j = l + i - 1;
                // 选择拿最左边一堆石头有两种情况：①我是先手：我直接就拿了最左边；②我是后手：我拿了上一个人先手后剩下的石头堆中的最左边，这是选择左边的全部分数
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                // 当我知道拿最左边和拿最右边的全部分数后，我肯定选择拿分数大的一种选择，以求获得最大的分数
                if (left > right) {
                    dp[i][j].fir = left;
                    // 前一个人先手拿了最左边的石堆，轮到我，我就成了 piles[i + 1,..., j] 的先手情况
                    dp[i][j].sec = dp[i + 1][j].fir;
                }
                else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }
}