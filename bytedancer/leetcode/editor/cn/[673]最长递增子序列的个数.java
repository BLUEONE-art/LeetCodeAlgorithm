//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 
// 👍 348 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        // 以nums[i]结尾的最长字序列的个数
        int[] counter = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    } else if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        counter[i] = counter[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                res += counter[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
