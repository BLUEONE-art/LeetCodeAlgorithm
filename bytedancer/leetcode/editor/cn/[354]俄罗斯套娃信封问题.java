//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 5000 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 104 
// 
// Related Topics 二分查找 动态规划 
// 👍 528 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 求高度H的最长递增子序列
        Arrays.sort(envelopes, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (height[i] > height[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int tmp : dp) {
            res = Math.max(res, tmp);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
