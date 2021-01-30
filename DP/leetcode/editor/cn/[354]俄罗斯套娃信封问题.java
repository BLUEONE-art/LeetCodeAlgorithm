//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 265 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 俄罗斯套娃信封问题 */
    public int maxEnvelopes(int[][] envelopes) {
        // 核心思想：对于二维的信封，有宽度 W 和高度 H
        // ①按宽度 W 进行升序排序：宽度越来越大才能进行嵌套
        // ②当宽度 W 相同的时候，高度 H 降序排序：因为宽度相同的信封不能嵌套，只能从中选择一封
        // ③求高度 H 的最长递增子序列就是可以嵌套的信封数量

        int n = envelopes.length; // 获得二维数组的行数，就相当每一列有多少个数
        Arrays.sort(envelopes, new Comparator<int[]>()
                // 注意compare 排序中默认升序
                // 返回 1 == true 代表降序，我想调整顺序
                // 返回 -1 代表升序
        {
            public int compare(int[] a, int[] b) {
                // 默认升序：a[0] - b[0] < 0 = -1，第 0 列按升序处理
                // b[1] - a[1] > 0 = 1，第 1 列按降序处理
                return a[0] == b[0] ?
                        b[1] - a[1] : a[0] - b[0];
            }
        });
        // 获得排序好的 envelope 数组的第 2 列
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        // 求 height 中的最长递增子序列
        int[] dp = new int[height.length];
        // base case
        Arrays.fill(dp, 1);
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    int tmp = dp[j] + 1; //找到一个升序的了，先让 dp[j] + 1
                    dp[i] = Math.max(dp[i], tmp); // 再比较
                }
            }
        }
        // dp 数组中的最大值即为所求
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
