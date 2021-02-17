//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 201 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 连续数组的最大和 */
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        // dp[i]：表示以 nums[i] 结尾的最大字序和为 dp[i]
        int[] dp = new int[size];
        // base case:
        dp[0] = nums[0];
        // 状态转移
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
